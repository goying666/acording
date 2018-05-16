package com.renchaigao.domain.response;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum  RespCode {
    /**********************************
     * 业务：通用部分
     * 范围： -1、0
     ***********************************/
    NONE(-2, "查询失败"),
    WARN(-1, "网络异常，请稍后重试"),
    SUCCESS(0, "请求成功"),
    /**********************************
     * controller：
     * 业务：方言部分acording
     * 范围： 3、4
     ***********************************/
    ACORDING3(3, "方言已存在"),
    ACORDING4(4, "ACORDING4"),
    /**********************************
     * controller：
     * 业务：词条部分
     * 范围： 2、1
     ***********************************/
    CITIAONO(2, "词条有违规"),
    OHTER(1, "词条已存在")
    ;


    private int code;
    private String msg;

    RespCode(int code, String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}
