/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.cs417.cs417group1.camera;

import java.awt.Color;

/**
 *
 * @author phuphanmbp
 * This interface defines a camera that can take a picture and calculate the average color
 */
public interface CameraInterface {
   /**
    * This method calculates average color of the input image
    * @param inputfile the path of the image to be calculated
    * @return the average color of the image taken
    */
   public Color getColorAvg(String inputfile);
    /**
    * This method take a picture
    * @return the average color type Color
    */
   public Color takePicture();
}
