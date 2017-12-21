package com.yuin.smalltools.common.result;

/**
 * Created by geely
 */
public enum ResultEnum {

    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR");
    private final int code;
    private final String desc;


    ResultEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }

}
