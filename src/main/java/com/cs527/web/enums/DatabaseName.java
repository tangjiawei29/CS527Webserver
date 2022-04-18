package com.cs527.web.enums;

public enum DatabaseName {
    Instacart("instacart", 1),
    ABCRetail("ABC_retail", 2);

    private final String name;
    private final Integer code;
    DatabaseName(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }

    public static DatabaseName parse(String database) throws NullPointerException {
        database = database.toLowerCase();
        switch (database) {
            case "instacart": return Instacart;
            case "abc": return ABCRetail;
            default:
                throw new NullPointerException(String.format("Database {%s} does not exist!", database));
        }
    }
}
