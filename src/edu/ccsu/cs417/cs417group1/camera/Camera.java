
package edu.ccsu.cs417.cs417group1.camera;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author phuphanmbp
 */
public class Camera
{
   // Path to the raspistill executable.
   private final String _raspistillPath = "/opt/vc/bin/raspistill";
   
   // Specify a picture name.
   private String name = "/home/pi/Desktop/surveillance.jpg";

   // Default  constructor.
   public void RaspiStill()
   {
   }
   
    private Color getColorAvg(String inputfile){
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

   public Color takePicture()
   {
        try
        {
            // Create a new string builder with the path to raspistill.
            StringBuilder sb = new StringBuilder(_raspistillPath);
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
   
   public void takePicture(String name)
   {
      this.name = name;
      takePicture();
   }

}