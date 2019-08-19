package org.eze.common.exception;

import org.eze.common.enums.ResultCode;
import lombok.Getter;

/*
 * Created by Ksdl
 * 2019-04-23 19:03
 */
public class GlobalException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    @Getter
    private ResultCode code;

    public GlobalException(String msg) {
        super(msg);
    }

    public GlobalException(ResultCode code) {
        super(code.getMsg());
        this.code = code;
    }

    public GlobalException(ResultCode code, String msg) {
        super(msg);
        this.code = code;
    }
}
