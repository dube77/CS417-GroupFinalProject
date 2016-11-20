package edu.ccsu.cs417.cs417group1.emotion;

// Decorator
public abstract class EmotionDecorator implements IEmotion
{
    final protected IEmotion instance;
    final protected double intensityModifier;
    
    /* Constructor
    * @param wrappedInstance - Emotion instance to be wrapped
    * @param intensity - multiplier to be used in intensity calculations 
    * @author Cameron Sonido
    */
    public EmotionDecorator(IEmotion wrappedInstance,double intensity){
        intensityModifier = intensity;
        instance = wrappedInstance;
    }
    
    
    /* Non-functional - to avoid deviating from the Decorator pattern, returns the wrapped instance
    * @param s - useless String
    * @author Cameron Sonido
    */
    @Override
    public IEmotion getChild(String s){
        return instance;
    }

    /* Passes method to wrapped instance
    * @author Cameron Sonido
    */
    //Developer note: depending on pi implementation we could perform express based on intensity modifier
    @Override
    public void express() {
        instance.express();
    }

    /* Passes method to wrapped instance
    * @param e - Emote to add to wrapped emotion
    * @author Cameron Sonido
    */
    @Override
    public void addComponent(IEmotion e) {
        instance.addComponent(e);
    }

    /* Passes method to wrapped instance
    * @param desc - desc to be passed to wrapped instance
    * @author Cameron Sonido
    */
    @Override
    public IEmotion removeComponent(String desc) {
        return instance.removeComponent(desc);
    }
    
    /* Returns the description of the instance, in addition to the modifier
     * @author Cameron Sonido
     */
    abstract public String getDescription();
    
    /* Returns the net intensity of all emotions composing this object 
    * @author Cameron Sonido
    */
    @Override
    abstract public double getIntensity();
}
