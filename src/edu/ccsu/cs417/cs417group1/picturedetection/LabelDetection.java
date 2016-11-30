package edu.ccsu.cs417group1.picturedetection;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class LabelDetection implements Detection {
	 @Override
	 public String getObject(String imagepath) {
		String s = null;
		try {
		    final Process proc = Runtime.getRuntime().exec("java -cp data/vision-label-1.0-SNAPSHOT-jar-with-dependencies.jar com.google.cloud.vision.samples.label.LabelApp "+ imagepath);
	    	BufferedReader stdInput = new BufferedReader(new 
	    	     InputStreamReader(proc.getInputStream()));
	    	s = stdInput.readLine(); 
    	}
		catch(Throwable t)
		{
			t.printStackTrace();
       	}
    	return s;
	}
}
