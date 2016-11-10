//@author Cameron Sonido
public class WeakEmotion extends EmotionDecorator
{
    final private String description = "Weak";
    public WeakEmotion(IEmotion wrappedInstance,double intensity){
        super(wrappedInstance,intensity);
    }
    
    /* Returns a double representing the intensity of the wrapped object divided by the modifier
     * @author Cameron Sonido
     */
    public double getIntensity(){
        return instance.getIntensity() / intensityModifier;
    }
    
    /* Returns the decorator's description appended to the description of the wrapped instance
     *  @author Cameron Sonido
     */
    public String getDescription(){
        return description+" "+instance.getDescription();
    }
}
