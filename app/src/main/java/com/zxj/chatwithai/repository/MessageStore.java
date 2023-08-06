package com.zxj.chatwithai.repository;

import com.zxj.chatwithai.bean.ChatMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * 存储聊天消息
 *
 * @author zxj
 * @2023/8/6
 */
public class MessageStore {

    public static List<ChatMessage> chatData = new ArrayList<>(); //后续维护要及时清理信息，否则会出现oom


    public static void addMessage(ChatMessage message){
        chatData.add(message);
    }

    public static void clearMessages(){
        while(!chatData.isEmpty()){
            chatData.remove(chatData.size()-1);
        }
    }
}
