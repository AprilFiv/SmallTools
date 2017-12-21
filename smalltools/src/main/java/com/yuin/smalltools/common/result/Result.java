package com.yuin.smalltools.common.result;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/30.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> implements Serializable{

    private Integer returnCode;

    private String returnMsg;

    private T content;

    public Result() {
    }

    public Result(Integer returnCode, T content) {

        this.returnCode = returnCode;
        this.content = content;
    }

    public Result(Integer returnCode, String returnMsg) {

        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
    }

    public Result(Integer returnCode, String returnMsg, T content) {

        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
        this.content = content;
    }

    public Result(Integer returnCode) {

        this.returnCode = returnCode;
    }

    public Integer getReturnCode() {

        return returnCode;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
