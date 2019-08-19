package org.eze.common.exception;

import org.eze.common.enums.ResultCode;
import org.eze.web.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Created by Ksdl
 * 2019-04-22 20:35
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleError(GlobalException e) {
        log.error("GlobalException自定义错误触发 {}", e.getMessage());
        return Result.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result MethodArgumentNotValidExceptionHandle(MethodArgumentNotValidException e) {
        log.warn("参数验证失败 {}", e.getMessage());
        if (e.getBindingResult() != null && !CollectionUtils.isEmpty(e.getBindingResult().getAllErrors())) {
            List<String> errorInfoList = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
            return Result.fail(StringUtils.join(errorInfoList, " | "));
        }
        return Result.fail(ResultCode.PARAM_VALID_ERROR.getMsg());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result ConstraintViolationExceptionHandle(ConstraintViolationException e) {
        log.warn("参数验证失败 {}", e.getMessage());
        List<String> errorInfoList = e.getConstraintViolations().stream().map(ConstraintViolation::getMessageTemplate).collect(Collectors.toList());

        return Result.fail(StringUtils.join(errorInfoList, " | "));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result HttpMessageNotReadableExceptionHandle(HttpMessageNotReadableException e) {
        log.error("能数不能析 {}", e.getMessage());
        return Result.fail(ResultCode.MSG_NOT_READABLE);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result MissingServletRequestParameterExceptionHandle(MissingServletRequestParameterException e) {
        log.error("缺少必要的请求参数 {}", e.getMessage());
        String message = String.format("缺少必要的请求参数: %s", e.getParameterName());
        return Result.fail(ResultCode.PARAM_MISS, message);
    }
}
