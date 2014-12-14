package com.pandemic.circuitsim.ports;

import com.pandemic.circuitsim.FixedBitSet;
import com.pandemic.circuitsim.ICircuitComponent;
import com.pandemic.circuitsim.ICircuitPort;

import java.util.BitSet;
import java.util.Set;

public class OutputPort extends PortBase
{
    private ICircuitComponent parent;
    
    public OutputPort(ICircuitComponent parent, String name, int width)
    {
        super(name, width);
    
        this.parent = parent;
    }
    
    @Override
    public FixedBitSet getValue()
    {
        return this.resolvedValue;
    }
    
    @Override
    public void resolve(int tick, Set<ICircuitPort> seen)
    {
        if (tick == this.resolvedTick)
        {
            return;
        }
        
        if (seen.contains(this))
        {
            throw new RuntimeException("Dependency loop detected");
        }
        seen.add(this);
        
        this.resolvedValue = parent.resolvePort(this, tick, seen);
        
        this.resolvedTick = tick;
    }
}
