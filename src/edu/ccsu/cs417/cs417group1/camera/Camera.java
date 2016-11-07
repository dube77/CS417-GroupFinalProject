
package edu.ccsu.cs417.cs417group1.camera;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author phuphanmbp
 * Create a object type camera that can take a image and calculate the average color of a image
 */
public class Camera implements CameraInterface
{
   // Path to the raspistill executable.
   private final String RASPISTILL_PATH = "/opt/vc/bin/raspistill";
   
   // Specify a picture name.
   private String name = "/home/pi/Desktop/surveillance.jpg";

   // Default  constructor.
   public void Camera()
   {
   }
   
    /**
     * Get average color of a image file
     * @param inputfile the path of the image file path 
     * @return average color of the image file
     */
   @Override
    public Color getColorAvg(String inputfile){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(inputfile));
        } 
        catch (IOException e) { }
        
        int red = 0, green = 0, blue = 0;
        int pixelCount = 0;
        
        for (int y = 0; y < img.getHeight(); y++)
        {
            for (int x = 0; x < img.getWidth(); x++)
                {
                    int pixel = img.getRGB(x, y);
                    pixelCount++;
                    red += pixel>>16&0xFF;
                    green += pixel>>8&0xFF;
                    blue += pixel&0xFF;
                }
        }
        System.out.println("Did return color");
        return new Color(red / pixelCount, green / pixelCount, blue / pixelCount);
    }
    /**
     * This method gets camera to take an image and save it by the name /home/pi/Desktop/surveillance.jpg
     * @return Average color of the image taken
     */
   @Override
   public Color takePicture()
   {
        try
        {
            // Create a new string builder with the path to raspistill.
            StringBuilder sb = new StringBuilder(RASPISTILL_PATH);
            sb.append(" -o " + name);
            // Take the photo.
            Runtime.getRuntime().exec(sb.toString());
        }
        catch (Exception e)
        {
            // Exit the application with the exception's hash code.
            System.exit(e.hashCode());
        }
        return getColorAvg(name);
   }
   
   public Color takePicture(String name)
   {
      this.name = name;
      return takePicture();
   }
   
   @Override
   public boolean equals(Object o)
   {
       if(this == o)
           return true;
       if((o == null) || (this.getClass() != o.getClass()))
           return false;
       
       return this.name.equals(((Camera)o).name);
   }
   
   @Override
   public int hashCode()
   {
       return (this.name.hashCode());
   }
    
   @Override
   public String toString()
   {
       return ("This camera saves to the file " + this.name);
   }

}