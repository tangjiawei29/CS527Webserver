package com.cs527.web.enums;

public enum InstanceType {
    RDS("rds", 1),
    Redshift("redshift", 2);

    private final String name;
    private final Integer code;
    InstanceType(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }

    public static InstanceType parse(String instance) {
        instance = instance.toLowerCase();
        switch (instance) {
            case "rds": return RDS;
            case "redshift": return Redshift;
            default:
                throw new NullPointerException(String.format("Instance {%s} does not exist!", instance));
        }
    }
}