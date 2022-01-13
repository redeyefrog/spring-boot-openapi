package com.redeyefrog.enums;

public enum StatusCode {

    SUCCESS("0000", "Success"),

    INVALID("0001", "Field is Invalid"),

    UNKNOWN("9999", "Unknown Error Occur");

    private String code;

    private String desc;

    StatusCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
