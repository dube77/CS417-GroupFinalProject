/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.cs417.cs417group1.emotion;

import java.util.*;

/**
 * @param <T>
 * 
 * @author Simon
 */
public class EmotionCollection<T extends IEmotion>
{
    private List<T> emotions;
    
    public EmotionCollection()
    {
        emotions = new ArrayList<T>();
    }
    
    public void add(T x)
    {
        emotions.add(x);
    }
    
    public T remove(T x)
    {
        for(T e:emotions)
        {
            if(x.equals(e))
            {
                emotions.remove(x);
                return x;
            }
        }
        throw new NoSuchElementException("Emotion does not have an element that equals " + x.toString() + " to remove.");
    }
    
    @Override
    public String toString()
    {
        String temp = "";
        for(T e:emotions)
        {
            temp += e.toString();
        }
        return temp;
    }
    
    @Override
    public int hashCode()
    {
        int temp = 0;
        for(T e:emotions)
        {
            temp += e.hashCode();
        }
        return temp;
    }
}
