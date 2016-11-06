package edu.ccsu.cs417.cs417group1.robot;

import java.io.IOException;
import java.util.List;

/**
 * Created by mattrusczyk on 11/1/16.
 */
public abstract class Led {
    private int pin;
    private boolean on;
    
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
}
