package org.eze.common.utils;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
 *  Created by Ksdl
 *  2019-05-02 21:39
 */
@Slf4j
public class ResponseOutUtil {
    public static void ok(ServletResponse response, Map<String, Object> data) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            out.write(JSON.toJSONString(data));
        } catch (IOException e) {
            log.error("输出JSON出错 {}", e.toString());
        }
    }

    public static Map<String, Object> result(boolean flag, Integer code, String msg) {
        return resultMap(flag, code, msg);
    }

    public static Map<String, Object> result(boolean flag, Integer code, String msg, Object data) {
        Map<String, Object> map = resultMap(flag, code, msg);
        map.put("data", data);
        return map;
    }

    private static Map<String, Object> resultMap(boolean flag, Integer code, String msg) {
        Map<String, Object> map = new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        map.put("success", flag);
        map.put("message", msg);
        map.put("code", code);
        map.put("timestamp", simpleDateFormat.format(new Date()));
        return map;
    }
}


