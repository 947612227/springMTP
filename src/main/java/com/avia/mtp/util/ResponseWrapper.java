package com.avia.mtp.util;

public class ResponseWrapper {
    private String status;
    private String message;
    private Object data;

    public ResponseWrapper() {
    }

    public ResponseWrapper(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResponseWrapper success(String message, Object data) {
        return new ResponseWrapper("success", message, data);
    }

    public static ResponseWrapper error(String message) {
        return new ResponseWrapper("error", message, null);
    }
}
