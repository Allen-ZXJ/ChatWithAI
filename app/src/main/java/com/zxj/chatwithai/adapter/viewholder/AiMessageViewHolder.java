package com.zxj.chatwithai.adapter.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zxj.chatwithai.R;

public class AiMessageViewHolder extends RecyclerView.ViewHolder {
   public TextView mTvGPT;
   public AiMessageViewHolder(@NonNull View itemView) {
      super(itemView);
      mTvGPT = itemView.findViewById(R.id.tv_gpt);
   }
}
