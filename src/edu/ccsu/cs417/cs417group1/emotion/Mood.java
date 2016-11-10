//Abstract Composite
import java.util.*;
import java.util.NoSuchElementException;

public abstract class Mood extends Emotion
{
    protected List<IEmotion> emotes; 
    protected String description;

    /* Perform express on all children of composite object
     * @author Cameron Sonido
     */
    @Override
    public void express(){
        for (IEmotion e: emotes){
            e.express();
        }
    }

    public Mood(){
        emotes = new ArrayList<IEmotion>();
    }

    /* Adds an emotion to the composite Emotion
     * @param e - The emotion to be appended
     * @author Cameron Sonido
     */
    @Override
    public void addComponent(IEmotion e){
        emotes.add(e);
    }

    /*  Removes an emotion from the composite Emotion
     * @param desc - Description of the emotion desired to be removed
     * from the composite
     * @author Cameron Sonido
     */
    @Override
    public IEmotion removeComponent(String desc){
        for (IEmotion e:emotes){
            if(e.toString().equals(desc)){
                emotes.remove(e);
                return e; //equivalent to a break statement
            }
        }
        throw new NoSuchElementException("Emotion does not have an element to remove with desc="+desc);
    } 

    /*  Gets an emotion from the composite Emotion by its description.
     * Returns null if no such element.
     * @param i - Index of child to be retrieved
     * from the composite
     * @author Cameron Sonido
     */
    @Override
    public IEmotion getChild(String desc){
        for (IEmotion e:emotes){
            if(e.toString().equals(desc)){
                return e;
            }
        }
        return null;
    } 

    /* Returns the net intensity of all emotions composing this object 
     * @author Cameron Sonido
     */
    @Override
    public double getIntensity(){
        double totalIntensity=0;
        if (emotes.size()>0) {
            for (IEmotion e: emotes){
                totalIntensity+=e.getIntensity();
            }
        }
        return totalIntensity;
    }

    /* Returns the description of this object, appended to the descriptions of its children
    * @author Cameron Sonido
    */  
    @Override
    public String getDescription(){
        String s;
        if (emotes.size()>0){
            s = description+"- affected by: ";
            for (IEmotion e: emotes){
                s+=e.getDescription()+",";
            }
        }
        else{
            s = description;
        }
        return s;
    }
}
