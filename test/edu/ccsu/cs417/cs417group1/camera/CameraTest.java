/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ccsu.cs417.cs417group1.camera;
import edu.ccsu.cs417.cs417group1.camera.Camera;
import java.awt.Color;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author phuphanmbp
 * Test Class written for Camera.java
 */
public class CameraTest
{
	Camera cam;
    //Setting up the object for testing
	@Before 
	public void setup() {
		cam = new Camera();
	}
	
	//Test if the method is actually returning something isn't null and of class Color
	@Test
	public void takePictureTest() {
        assertNotNull(cam.takePicture());
        assertThat(cam.takePicture(), instanceOf(Color.class));
	}
}
