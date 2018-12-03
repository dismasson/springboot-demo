package com.sxli.springbootdemo.exception;

import java.io.Serializable;

public class MyException extends RuntimeException implements Serializable {
    // 异常编码
    private String errCode;
    // 异常信息
    private String errMsg;

    public MyException(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
