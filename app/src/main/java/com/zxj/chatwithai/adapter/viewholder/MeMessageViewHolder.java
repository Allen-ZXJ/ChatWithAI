package com.zxj.chatwithai.adapter.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zxj.chatwithai.R;

public class MeMessageViewHolder extends RecyclerView.ViewHolder {
   public TextView mTvME;
   public MeMessageViewHolder(@NonNull View itemView) {
      super(itemView);
      mTvME = itemView.findViewById(R.id.tv_me);
   }
}
