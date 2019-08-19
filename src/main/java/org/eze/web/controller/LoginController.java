package org.eze.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.eze.web.vo.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/*
 *  Created by Ksdl
 *  2019-08-30 21:55
 */
@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    /**
     * 用户登录
     */
    @PostMapping
    public Result login() {
        return Result.data("HPXqMPiGDAWxIf4jBB48c2vwUPn9rOBl");
    }
}
