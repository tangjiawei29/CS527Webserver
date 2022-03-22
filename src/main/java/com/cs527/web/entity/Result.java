package com.cs527.web.entity;

public class Result {
    private String data;
    private String status;
    private long elapsedTime;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(long elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
