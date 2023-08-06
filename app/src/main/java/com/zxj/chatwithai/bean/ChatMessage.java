package com.zxj.chatwithai.bean;
/**
 *返回openai的返回结果中其中一个类型
 * @author zxj
 * @ 2023/8/6
 */
public class ChatMessage {
    private String message;
    private int type;

    public ChatMessage(String message,int type){
        this.message = message;
        this.type = type;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "message='" + message + '\'' +
                ", type=" + type +
                '}';
    }
}
