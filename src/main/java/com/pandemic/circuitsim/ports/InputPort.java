package com.pandemic.circuitsim.ports;

import com.pandemic.circuitsim.FixedBitSet;
import com.pandemic.circuitsim.ICircuitComponent;
import com.pandemic.circuitsim.ICircuitPort;
import com.pandemic.circuitsim.IInput;

import java.util.BitSet;
import java.util.Set;

public class InputPort extends PortBase implements IInput
{
    private final int width;
    private final String name;
    
    private ICircuitPort peer;
    
    public InputPort(String name, int width)
    {
        super(name, width);
        
        this.width = width;
        this.name = name;
    }
    
    @Override
    public FixedBitSet getValue()
    {
        return peer.getValue();
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
    
        if (peer != null)
        {
            peer.resolve(tick, seen);
            this.resolvedValue = peer.getValue();
        }
        else
        {
            this.resolvedValue = new FixedBitSet(width);
        }
        
        this.resolvedTick = tick;
    }
    
    @Override
    public void dependsOn(ICircuitPort peer)
    {
        this.peer = peer;   
    }
}
