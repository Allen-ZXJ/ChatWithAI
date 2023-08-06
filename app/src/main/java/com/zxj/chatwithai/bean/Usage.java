package com.zxj.chatwithai.bean;

/**
 * 返回openai的返回结果中其中一个类型
 *
 * @author zxj
 * @ 2023/8/6
 */
public class Usage {

   private int prompt_tokens;
   private int completion_tokens;
   private int total_tokens;
   public void setPrompt_tokens(int prompt_tokens) {
      this.prompt_tokens = prompt_tokens;
   }
   public int getPrompt_tokens() {
      return prompt_tokens;
   }

   public void setCompletion_tokens(int completion_tokens) {
      this.completion_tokens = completion_tokens;
   }
   public int getCompletion_tokens() {
      return completion_tokens;
   }

   public void setTotal_tokens(int total_tokens) {
      this.total_tokens = total_tokens;
   }
   public int getTotal_tokens() {
      return total_tokens;
   }

   @Override
   public String toString() {
      return "Usage{" +
              "prompt_tokens=" + prompt_tokens +
              ", completion_tokens=" + completion_tokens +
              ", total_tokens=" + total_tokens +
              '}';
   }
}