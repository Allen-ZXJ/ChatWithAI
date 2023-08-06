package com.zxj.chatwithai.bean;

/**
 *
 * 返回openai的返回结果中其中一个类型
 * @author zxj
 * @ 2023/8/6
 *
 * */
public class Choices {

   private String text;
   private int index;
   private String logprobs;
   private String finish_reason;
   public void setText(String text) {
      this.text = text;
   }
   public String getText() {
      return text;
   }

   public void setIndex(int index) {
      this.index = index;
   }
   public int getIndex() {
      return index;
   }

   public void setLogprobs(String logprobs) {
      this.logprobs = logprobs;
   }
   public String getLogprobs() {
      return logprobs;
   }

   public void setFinish_reason(String finish_reason) {
      this.finish_reason = finish_reason;
   }
   public String getFinish_reason() {
      return finish_reason;
   }

   @Override
   public String toString() {
      return "Choices{" +
              "text='" + text + '\'' +
              ", index=" + index +
              ", logprobs='" + logprobs + '\'' +
              ", finish_reason='" + finish_reason + '\'' +
              '}';
   }
}