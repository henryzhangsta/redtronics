package com.pandemic.circuitsim.components.transistors;

import com.pandemic.circuitsim.FixedBitSet;
import com.pandemic.circuitsim.ICircuitPort;

import java.util.BitSet;
import java.util.Set;

public class NTransistor extends TransistorBase
{
    public NTransistor()
    {
        super("N Transistor");    
    }
    
    @Override
    public FixedBitSet resolvePort(ICircuitPort port, int tick, Set<ICircuitPort> seen)
    {
        this.inputs.get(INPUT_GATE).resolve(tick, seen);
        if (!this.inputs.get(INPUT_GATE).getValue().get(0))
        {
            this.inputs.get(INPUT_SOURCE).resolve(tick, seen);
            return this.inputs.get(INPUT_SOURCE).getValue();
        }
    
        return new FixedBitSet(1);
    }
}
