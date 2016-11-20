package edu.ccsu.cs417.cs417group1.emotion;

public abstract class Emotion implements IEmotion
{
    double intensity;
    String description;
    @Override
    abstract public void express();
    @Override
    abstract public void addComponent(IEmotion e);
    @Override
    abstract public IEmotion removeComponent(String desc);
    @Override
    abstract public IEmotion getChild(String desc);
    @Override
    public double getIntensity(){
        return intensity;
    }
    @Override
    abstract public String getDescription();
}
