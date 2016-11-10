
public interface IEmotion
{
    public void express();
    public void addComponent(IEmotion e);
    public IEmotion removeComponent(String desc);
    public IEmotion getChild(String desc);
    public double getIntensity();
    public String getDescription();
}
