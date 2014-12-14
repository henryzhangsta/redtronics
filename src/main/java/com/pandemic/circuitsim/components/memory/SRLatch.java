package com.pandemic.circuitsim.components.memory;

import com.pandemic.circuitsim.FixedBitSet;
import com.pandemic.circuitsim.ICircuitPort;
import com.pandemic.circuitsim.IClockable;
import com.pandemic.circuitsim.components.ComponentBase;
import com.pandemic.circuitsim.ports.InputPort;
import com.pandemic.circuitsim.ports.OutputPort;

import java.util.Set;

public class SRLatch extends ComponentBase implements IClockable
{
    protected FixedBitSet state;
    
    protected InputPort Set;
    protected InputPort Reset;
    protected OutputPort Output;
    
    public SRLatch()
    {
        super("SR Latch");
    
        this.Set = new InputPort("Set", 1);
        this.Reset = new InputPort("Reset", 1);
        this.Output = new OutputPort(this, "Output", 1);
        
        this.inputs.add(Set);
        this.inputs.add(Reset);
        this.outputs.add(Output);
        
        this.state = new FixedBitSet(1);
    }
    
    @Override
    public void clock(int tick, Set<ICircuitPort> seen)
    {
        Set.resolve(tick, seen);
        Reset.resolve(tick, seen);
        
        if (Set.getValue().get(0))
        {
            this.state.set(0);
        }
        else if (Reset.getValue().get(1))
        {
            this.state.clear(0);
        }
    }
    
    @Override
    public FixedBitSet resolvePort(ICircuitPort port, int tick, Set<ICircuitPort> seen)
    {
        if (port == Output)
        {
            return this.state;
        }
        
        throw new RuntimeException("Invalid Port.");
    }
}
