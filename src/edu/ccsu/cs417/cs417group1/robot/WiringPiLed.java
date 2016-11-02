package edu.ccsu.cs417.cs417group1.robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mattrusczyk on 11/1/16.
 */
public class WiringPiLed implements WiringPiAdaptee {
    private int pin;
    private boolean on; // might not actually need right now

    public WiringPiLed(int pin) {
        this.pin = pin;
    }

    public void turnOn() throws IOException {
        if (pin > 29 || pin < 0) {} //throw pin does not exist exception
        String pinN = "" + pin;
        List<String> command = new ArrayList();

        command.add("gpio");

        command.add("write");
        command.add(pinN);
        command.add("0");

        sendCommand(command);
    }

    public void turnOff() throws IOException {
        if (pin > 29 || pin < 0) {}
        String pinN = "" + pin;
        List<String> command = new ArrayList();
        command.add("gpio");
        command.add("write");
        command.add(pinN);
        command.add("1");

        sendCommand(command);
    }

    public void setPinOut() throws IOException {
        if (pin > 29 || pin < 0) {}
        String pinN = "" + pin;
        List<String> command = new ArrayList();
        command.add("gpio");
        command.add("mode");
        command.add(pinN);
        command.add("out");

        sendCommand(command);
    }

    public void setPinIn() throws IOException {
        if (pin > 29 || pin < 0) {}
        String pinN = "" + pin;
        List<String> command = new ArrayList();
        command.add("gpio");
        command.add("mode");
        command.add(pinN);
        command.add("in");
        sendCommand(command);
    }

    /**
     * sends a command to the linux shell
     * ProcessBuilder sends a command to the shell by taking each member of 'command'
     * and turning it into a command that any linux shell can understand
     * @param command the command to be executed
     * @throws IOException
     */
    public void sendCommand(List<String> command) throws IOException {
        ProcessBuilder pb = new ProcessBuilder(command);
        pb.redirectErrorStream(true);

        Process p = pb.start();

        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
    }

    public int getPin() {
        return pin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WiringPiLed that = (WiringPiLed) o;

        return getPin() == that.getPin();
    }

    @Override
    public int hashCode() {
        return getPin();
    }

}
