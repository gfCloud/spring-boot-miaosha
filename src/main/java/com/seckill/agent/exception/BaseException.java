package com.seckill.agent.exception;

/**
 * 通用异常类
 *
 * @author gaoFan
 * @version V1.0
 * @date 2020/10/20 16:23
 */


public class BaseException extends RuntimeException{

    private static final long serialVersionUID = 1631417040312856798L;
    private String message = "业务异常";
    private int status = 500;

    public BaseException(String message) {
        this.message = message;
    }

    public BaseException(int status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
