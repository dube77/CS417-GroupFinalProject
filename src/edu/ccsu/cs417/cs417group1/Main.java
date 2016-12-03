package edu.ccsu.cs417.cs417group1;

import edu.ccsu.cs417.cs417group1.camera.Camera;
import edu.ccsu.cs417.cs417group1.emotion.*;
import edu.ccsu.cs417.cs417group1.groveboard.robot.Button;
import edu.ccsu.cs417.cs417group1.groveboard.PinDNEException;
import edu.ccsu.cs417.cs417group1.picturedetection.Context;
import edu.ccsu.cs417.cs417group1.picturedetection.Detection;
import edu.ccsu.cs417.cs417group1.picturedetection.LabelDetection;
import edu.ccsu.cs417.cs417group1.picturedetection.LandmarkDetection;
import edu.ccsu.cs417.cs417group1.twitter.FeelingIntensity;
import edu.ccsu.cs417.cs417group1.twitter.Tweet;

import java.awt.*;
import java.io.IOException;

import static edu.ccsu.cs417.cs417group1.Properties.button;
import static edu.ccsu.cs417.cs417group1.Properties.landmark;
import static edu.ccsu.cs417.cs417group1.Properties.optimist;

/**
 * Created by mattrusczyk on 12/1/16.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        String pictureName;
        Button pushButton;
        Camera camera = new Camera();
        AbstractFactory emotionFactory;
        Tweet.TweetBuilder tweet;
        AbstractProduct feeling;
        Detection detection;
        Context googleAPI;
        String objectSeen;
        Color color;

        if (landmark)
            detection = new LandmarkDetection();
        else
            detection = new LabelDetection();

        try {
            pushButton = new Button(button);

            while(true) {
                if(pushButton.readInput()) {
                    pictureName = camera.takePicture();
                    googleAPI = new Context(detection);
                    objectSeen = googleAPI.getObject(pictureName);
                    color = googleAPI.getColorAvg(pictureName);

                    if (optimist)
                        emotionFactory = new OptimistFactory();

                    else
                        emotionFactory = new PessimistFactory();

                    feeling = emotionFactory.produceEmotion(color);

                    tweet = new Tweet.TweetBuilder(objectSeen,feeling.getDescription());
                    if (feeling.getIntensity() <= -50)
                        tweet.setFeelingIntensity(FeelingIntensity.ONE);
                    else if (feeling.getIntensity() < 0)
                        tweet.setFeelingIntensity(FeelingIntensity.TWO);
                    else if (feeling.getIntensity() == 0)
                        tweet.setFeelingIntensity(FeelingIntensity.THREE);
                    else if (feeling.getIntensity() <= 50)
                        tweet.setFeelingIntensity(FeelingIntensity.FOUR);
                    else
                        tweet.setFeelingIntensity(FeelingIntensity.FIVE);

                    tweet.buildTweet();
                }

            }
        }
        catch (PinDNEException e) {
            System.out.println("The requested pin does not exist");
        }

    }

    protected boolean gatherProps() {



        return false;
    }


}
