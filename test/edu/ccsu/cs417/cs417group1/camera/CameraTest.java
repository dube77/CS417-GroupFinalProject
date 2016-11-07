/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ccsu.cs417.cs417group1.camera;
import edu.ccsu.cs417.cs417group1.camera.Camera;
import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author phuphanmbp
 */
public class CameraTest
{
	Camera cam;
	//Use @Before to setup variable and elements used in each @Test
	//It will run setup() before every test
	@Before 
	public void setup() {
		cam = new Camera();
	}
	
	//Use @Test to run certain methods to test functionality
	@Test
	public void takePictureTest() {
		
	}
  
//	@Test
//	public void methodNameTest() {
//		
//	}
//	
//	Re-code what you have below this to the format above
//	public static void main(String[] args) {
//    try
//    {
//        // Create a new RaspiStill object.
//        Camera camera = new Camera();
//        // Take a picture.
//        Color avg = camera.takePicture();
//    }
//    catch (Exception e)
//    {
//      System.exit(e.hashCode());
//    }
//  }
}
