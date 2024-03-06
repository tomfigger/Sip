package com.example.linphonesample.event;

public class CallStateEvent {
    private int code;
    private String message;

    public CallStateEvent() {
    }

    public CallStateEvent(int code, String message) {
        this.code = code;
        this.message = message;
    }
     public int getCode(){
        return code;
     }
     public String getMessage(){
        return message;
     }
}
