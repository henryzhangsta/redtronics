package com.pandemic.circuitsim.components.gates;

import com.pandemic.circuitsim.FixedBitSet;
import com.pandemic.circuitsim.ICircuitPort;
import com.pandemic.circuitsim.IInput;

import java.util.Set;

public class AndGate extends GateBase
{
    protected int width;
    
    public AndGate(int inputs, int bits)
    {
        super("AND Gate", inputs, bits);
        this.width = bits;
    }
    
    @Override
    public FixedBitSet resolvePort(ICircuitPort port, int tick, Set<ICircuitPort> seen)
    {
        if (port == this.getOutput(0))
        {
            FixedBitSet value = new FixedBitSet(width);
            
            for (IInput i : this.inputs)
            {
                i.resolve(tick, seen);
                value.and(i.getValue());
            }
            
            return value;
        }
        throw new RuntimeException("Invalid port to resolve.");
    }
}
