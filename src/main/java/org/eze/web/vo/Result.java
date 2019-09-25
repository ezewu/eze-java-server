package org.eze.web.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.eze.common.enums.ResultCode;
import lombok.Data;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/*
 * Created by Ksdl
 * 2019-04-18 19:24
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL) //排除NULL
public  class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean success;
    private String message;
    private Integer code;
    private long timestamp = System.currentTimeMillis();

    private T data;

    private Result(ResultCode resultCode) {
        this(resultCode, resultCode.getMsg(), null);
    }

    private Result(ResultCode resultCode, String msg) {
        this(resultCode, msg, null);
    }

    private Result(ResultCode resultCode, String msg, T data) {
        this(resultCode.getCode(), msg, data);
    }

    private Result(int code, String msg, T data) {
        this.code = code;
        this.data = data;
        this.message = msg;
        this.success = ResultCode.SUCCESS.code == code;
    }

    public static <T> Result<T> data(T data) {
        return data(ResultCode.SUCCESS.getMsg(), data);
    }

    public static <T> Result<T> data(String msg, T data) {
        return data(HttpServletResponse.SC_OK, msg, data);
    }

    public static <T> Result<T> data(int code, String msg, T data) {
        return new Result<>(code, msg, data);
    }

    public static <T> Result<T> success(String msg) {
        return new Result<>(ResultCode.SUCCESS, msg);
    }

    public static <T> Result<T> success(ResultCode code) {
        return new Result<>(code);
    }

    public static <T> Result<T> success(ResultCode code, String msg) {
        return new Result<>(code, msg);
    }

    public static <T> Result<T> fail(ResultCode code) {
        return new Result<>(code);
    }

    public static <T> Result<T> fail(String msg) {
        return new Result<>(ResultCode.FAILURE, msg);
    }

    public static <T> Result<T> fail(int code, String msg) {
        return new Result<>(code, msg, null);
    }

    public static <T> Result<T> fail(ResultCode code, String msg) {
        return new Result<>(code, msg);
    }

    public static <T> Result<T> status(boolean flag) {
        return flag ? success(ResultCode.SUCCESS) : fail(ResultCode.FAILURE);
    }

}
