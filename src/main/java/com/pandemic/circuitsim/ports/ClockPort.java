package com.pandemic.circuitsim.ports;

import com.pandemic.circuitsim.ICircuitPort;

import java.util.Set;

public class ClockPort extends InputPort
{
    protected boolean trigger;
    protected boolean clocked;
    
    public ClockPort()
    {
        this(true);   
    }
    
    public ClockPort(boolean trigger)
    {
        super("Clock", 1);
        this.trigger = trigger;
        this.clocked = false;
    }
    
    public boolean checkClock(int tick, Set<ICircuitPort> seen)
    {
        resolve(tick, seen);
        if (getValue().get(0) == trigger && !clocked)
        {
            this.clocked = true;
            return true;
        }
        else if (getValue().get(0) != trigger)
        {
            this.clocked = false;
        }
        
        return false;
    }
}
