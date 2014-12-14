package com.pandemic.circuitsim.ports;

import com.pandemic.circuitsim.FixedBitSet;
import com.pandemic.circuitsim.ICircuitPort;

import java.util.BitSet;
import java.util.Set;

public abstract class PortBase implements ICircuitPort
{
    private final int width;
    private final String name;
    
    protected int resolvedTick = -1;
    protected FixedBitSet resolvedValue;
    
    public PortBase(String name, int width)
    {
        this.width = width;
        this.name = name;
    
        this.resolvedValue = null;
    }
    
    @Override
    public int getWidth()
    {
        return width;
    }
    
    @Override
    public String getName()
    {
        return name;
    }
    
    @Override
    public void resolve(int tick, Set<ICircuitPort> seen)
    {
        
    }
}
