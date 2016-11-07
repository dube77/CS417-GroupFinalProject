package edu.ccsu.cs417.cs417group1.robot;

import java.io.IOException;
import java.util.List;

/**
 * abstract class that gives a framework to interface with the raspberry pi gpio pins through
 * the WiringPi command line interface
 * @author Matt Rusczyk
 */
public abstract class Led { // TODO gotta change these names so they are less confusing
    protected int pin;
    private boolean on, out;
    
    public Led(int p) throws PinDNEException
    {
        if (p >29 || p < 0)
            throw new PinDNEException();
        this.pin = p;
    }
    
    public abstract void setPinOut() throws IOException;
    public abstract void setPinIn() throws IOException;
    public abstract void turnOn() throws IOException;
    public abstract void turnOff() throws IOException;
    
    public int getPin()
    {
        return pin;
    }
    public boolean isOn() {
        return on;
    }
    public boolean isOut() {
        return out;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Led that = (Led) o;

        return getPin() == that.getPin();
    }
    
    @Override
    public int hashCode() {
        return getPin();
    }

    public String toString() {
        return "This component is attached to pin " + pin;
    }
}
