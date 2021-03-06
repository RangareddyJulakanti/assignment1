package com.ranga.demo.orderservice.exception;

public class ExceptionMessage {
    private String property;
    private String bean;
    private String message;

    public ExceptionMessage(String property, String bean, String message) {
        this.property = property;
        this.bean = bean;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ExceptionMessage{" +
                "property='" + property + '\'' +
                ", bean='" + bean + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
