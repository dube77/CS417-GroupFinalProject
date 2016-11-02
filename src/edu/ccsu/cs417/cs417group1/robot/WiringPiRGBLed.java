package edu.ccsu.cs417.cs417group1.robot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Creates an object that controls an RGB Led through the Raspberry Pi GPIO pins
 * Holds a list of {@link edu.ccsu.cs417.cs417group1} objects that make up the RGB Led
 * Created by mattrusczyk on 11/1/16.
 */
public class WiringPiRGBLed {
    List<WiringPiLed> leds = new ArrayList();

    /**
     * Creates a WiringPiRGBLed Object by linking

     * @param red
     * @param green
     * @param blue
     */
    public WiringPiRGBLed(WiringPiLed red, WiringPiLed green, WiringPiLed blue) {
        leds.add(red);
        leds.add(green);
        leds.add(blue);
    }

    /**
     * Turns on all leds to make a white light
     * @throws IOException
     */
    public void turnOn() throws IOException {
        for (WiringPiLed led: leds) {
            led.setPinOut();
            led.turnOn();
        }
    }

    /**
     * This method turns off all leds
     * @throws IOException
     */
    public void turnOff() throws IOException {
        for (WiringPiLed led: leds) {
            led.setPinIn(); //this is becasue some leds will still output light when set to 0 V
        }
    }

    /**
     * THis method turns off all leds and then turns on the red LED
     * @throws IOException
     */
    public void turnOnRed() throws IOException {
        turnOff();
        leds.get(0).setPinOut();
        leds.get(0).turnOn();
    }

    /**
     * This method turns off all leds and then turns on the green led
     * @throws IOException
     */
    public void turnOnGreen() throws IOException {
        turnOff();
        leds.get(1).setPinOut();
        leds.get(1).turnOn();
    }

    /**
     * This method turns off all leds and then turns on the blue led
     * @throws IOException
     */
    public void turnOnBlue() throws IOException {
        turnOff();
        leds.get(2).setPinOut();
        leds.get(2).turnOn();
    }

    /**
     * THis method turns off all leds and then makes yellow by turning on both red and green leds
     * @throws IOException
     */
    public void turnOnYellow() throws IOException {
        turnOff();
        leds.get(0).setPinOut();
        leds.get(0).turnOn();
        leds.get(1).setPinOut();
        leds.get(1).turnOn();
    }

    /**
     * This method turns off all leds and then makes cyan by turning on both green and blue leds
     * @throws IOException
     */
    public void turnOnCyan() throws IOException {
        turnOff();
        leds.get(1).setPinOut();
        leds.get(1).turnOn();
        leds.get(2).setPinOut();
        leds.get(2).turnOn();
    }


    /**
     * This method turns off all leds and then makes violet by turning on both red and blue leds
     * @throws IOException
     */
    public void turnOnViolet() throws IOException {
        turnOff();
        leds.get(0).setPinOut();
        leds.get(0).turnOn();
        leds.get(2).setPinOut();
        leds.get(2).turnOn();
    }

    public WiringPiLed getRed() {
        return leds.get(0);
    }

    public WiringPiLed getGreen() {
        return leds.get(1);

    }
    public WiringPiLed getBlue() {
        return leds.get(2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        boolean red, blue, green;

        WiringPiRGBLed that = (WiringPiRGBLed) o;
        red = that.getRed().equals(getRed());
        green = that.getGreen().equals(getGreen());
        blue = that.getBlue().equals(getBlue());

        return (red && green && blue);
    }

    @Override
    public int hashCode() {
        return leds != null ? leds.hashCode() : 0;
    }

}
