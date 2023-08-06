package com.zxj.chatwithai.bean;
import java.util.List;

/**
 *返回openai的返回结果中其中一个类型
 * @author zxj
 * @ 2023/8/6
 */
public class ChatResult {

   private String id;
   private String object;
   private long created;
   private String model;
   private List<Choices> choices;
   private Usage usage;
   public void setId(String id) {
      this.id = id;
   }
   public String getId() {
      return id;
   }

   public void setObject(String object) {
      this.object = object;
   }
   public String getObject() {
      return object;
   }

   public void setCreated(long created) {
      this.created = created;
   }
   public long getCreated() {
      return created;
   }

   public void setModel(String model) {
      this.model = model;
   }
   public String getModel() {
      return model;
   }

   public void setChoices(List<Choices> choices) {
      this.choices = choices;
   }
   public List<Choices> getChoices() {
      return choices;
   }

   public void setUsage(Usage usage) {
      this.usage = usage;
   }
   public Usage getUsage() {
      return usage;
   }

   @Override
   public String toString() {
      return "ChatResult{" +
              "id='" + id + '\'' +
              ", object='" + object + '\'' +
              ", created=" + created +
              ", model='" + model + '\'' +
              ", choices=" + choices +
              ", usage=" + usage +
              '}';
   }
}