/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ccsu.cs417.cs417group1.camera;
import edu.ccsu.cs417.cs417group1.camera.Camera;
import java.awt.Color;

/**
 *
 * @author phuphanmbp
 */
public class CameraTest
{
  public static void main(String[] args)
  {
    try
    {
        // Create a new RaspiStill object.
        Camera camera = new Camera();
        // Take a picture.
        Color avg = camera.takePicture();
    }
    catch (Exception e)
    {
      System.exit(e.hashCode());
    }
  }
}
