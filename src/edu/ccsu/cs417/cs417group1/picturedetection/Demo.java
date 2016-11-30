package edu.ccsu.cs417group1.picturedetection;

public class Demo {
	public static void main(String[] args) {
	      Context context = new Context(new LabelDetection());
        System.out.println(context.executeStrategy("data/towerwithcats.jpeg"));
	      
	      context = new Context(new LandmarkDetection());	 System.out.println(context.executeStrategy("data/towerwithcats.jpeg"));
	   }
}
