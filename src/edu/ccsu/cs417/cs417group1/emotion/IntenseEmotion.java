package edu.ccsu.cs417.cs417group1.emotion;

public class IntenseEmotion extends EmotionDecorator
{
    final private String description = "Intense";
    public IntenseEmotion(IEmotion wrappedInstance,double intensity){
        super(wrappedInstance,intensity);
    }
    public double getIntensity(){
        return intensityModifier * instance.getIntensity();
    }
    public String getDescription(){
        return description+" "+instance.getDescription();
    }
}
