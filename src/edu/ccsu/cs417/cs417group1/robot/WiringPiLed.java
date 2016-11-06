package edu.ccsu.cs417.cs417group1.robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mattrusczyk on 11/1/16.
 */
public class WiringPiLed extends Led {
    private int pin;
    private boolean on; // might not actually need right now
    private ProcessBuilder pb;

    public WiringPiLed(int p) throws PinDNEException
    {
        super(p);
    }
   
    @Override
   public void setPinOut() throws IOException {
        String pinN = "" + pin;
        List<String> command = new ArrayList();
        command.add("gpio");
        command.add("mode");
        command.add(pinN);
        command.add("out");

        sendCommand(command);
    }

   @Override
    public void setPinIn() throws IOException {
        String pinN = "" + pin;
        List<String> command = new ArrayList();
        command.add("gpio");
        command.add("mode");
        command.add(pinN);
        command.add("in");
        sendCommand(command);
    }
    
    @Override
    public void turnOn() throws IOException{
        String pinN = "" + pin;
        List<String> command = new ArrayList();

        command.add("gpio");

        command.add("write");
        command.add(pinN);
        command.add("0");

        sendCommand(command);
    }

    @Override
    public void turnOff() throws IOException{
        if (pin > 29 || pin < 0) {}
        String pinN = "" + pin;
        List<String> command = new ArrayList();
        command.add("gpio");
        command.add("write");
        command.add(pinN);
        command.add("1");

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
        pb = new ProcessBuilder(command);
        pb.redirectErrorStream(true);

        Process p = pb.start();

        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
    }
}
