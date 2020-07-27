package com.yzh.course.entity;

public class JsonMessage<D> {
    private static final long serialVersionUID = 1L;

    private String status;
    private D data;

    public JsonMessage() {
    }
    public JsonMessage(String status,D data) {
        this.status = status;
        this.data = data;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"status\":\"").append(status).append('\"');
        sb.append(",\"data\":").append(data);
        sb.append('}');
        return sb.toString();
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

}
