package com.zxj.chatwithai.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zxj.chatwithai.R;
import com.zxj.chatwithai.adapter.viewholder.AiMessageViewHolder;
import com.zxj.chatwithai.adapter.viewholder.MeMessageViewHolder;
import com.zxj.chatwithai.bean.ChatMessage;
import com.zxj.chatwithai.constrains.TypeConstrain;
import com.zxj.chatwithai.repository.MessageStore;

import java.util.ArrayList;

/**
 * 消息类型的adapter
 * @author zxj
 * @ 2023/8/6
 */
public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;


    public ChatAdapter(Context context){
        mContext = context;
    }

    @Override
    public int getItemViewType(int position) {
        return MessageStore.chatData.get(position).getType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == TypeConstrain.TYPE_AI_CHAT){
            return new AiMessageViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_message_ai,parent,false));
        }else{
            return new MeMessageViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_message_me,parent,false));
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ChatMessage message = MessageStore.chatData.get(position);
        if(message.getType() == TypeConstrain.TYPE_AI_CHAT){
            ((AiMessageViewHolder)holder).mTvGPT.setText(message.getMessage());
        }else{
            ((MeMessageViewHolder)(holder)).mTvME.setText(message.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return MessageStore.chatData.size();
    }
}
