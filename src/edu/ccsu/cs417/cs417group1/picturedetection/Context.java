package edu.ccsu.cs417group1.picturedetection;
public class Context {
   private Detection detection;

   public Context(Detection detection){
      this.detection = detection;
   }

   public String executeStrategy(String imgpath){
      return detection.getObject(imgpath);
   }
}