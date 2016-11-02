package edu.ccsu.cs417.cs417group1.robot;

import java.io.IOException;
import java.util.List;

/**
 * Created by mattrusczyk on 11/1/16.
 */
public interface WiringPiAdaptee {
    public void setPinOut() throws IOException;
    public void setPinIn() throws IOException;
    public void turnOn() throws IOException;
    public void turnOff() throws IOException;
    public void sendCommand(List<String> command) throws IOException;
}
