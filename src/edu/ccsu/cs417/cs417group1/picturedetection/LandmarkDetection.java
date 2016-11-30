package edu.ccsu.cs417group1.picturedetection;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LandmarkDetection implements Detection {
	 @Override
	 public String getObject(String imagepath) {
		String s = null;
		try {
			String command = "java -cp data/vision-landmark-detection-1.0-SNAPSHOT-jar-with-dependencies.jar com.google.cloud.vision.samples.landmarkdetection.DetectLandmark "+imagepath;
		    final Process proc = Runtime.getRuntime().exec(command);
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
