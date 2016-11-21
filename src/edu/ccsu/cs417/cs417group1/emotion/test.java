package edu.ccsu.cs417.cs417group1.emotion;

import java.util.*;
public class test
{
    public static void main(String[] args){
        System.out.println("Creating a new person with a set of moods");
        List<IEmotion> moods = new ArrayList<IEmotion>();
        
        moods.add(new Comfort());
        moods.add(new Happiness());
        IEmotion hap = moods.get(1);
        IEmotion com = moods.get(0);
        System.out.println("Current status: "+moods);
        
        hap.addComponent(new Anxiety());
        hap.addComponent(new IntenseEmotion(new Joy(),2.5));
        
        System.out.println(hap.getDescription());
        System.out.println("Net Mood: "+hap.getIntensity());
        
        com.addComponent(new Joy());
        com.addComponent(new WeakEmotion(new Anxiety(),2));
        
        System.out.println(com.getDescription());
        System.out.println("Net Mood: "+com.getIntensity());
    }
}
