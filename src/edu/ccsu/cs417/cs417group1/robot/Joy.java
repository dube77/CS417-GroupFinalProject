public class Joy extends Emotion
{
    private final String description = "Joy";
    private final double intensity = 5;
    
    @Override
    public void express(){
        //Do something related to the LED
    }

    /* Returns the intensity of the current emotion
     * @author Cameron Sonido
     */
    @Override
    public double getIntensity(){
        return intensity;
    }
    
    /* The following 3 functions lack implementation to safely execute the decorator pattern 
     * @author Cameron Sonido
     */
    @Override
    public void addComponent(IEmotion e){
    }
    @Override
    public IEmotion removeComponent(String desc){
        return null;
    }
    @Override
    public IEmotion getChild(String desc){
        return null;
    }

    
    /* Returns the leaf's description
     *  @author Cameron Sonido
     */
    public String getDescription(){
        return description;
    }
}
