package com.pandemic.circuitsim.ports;

import com.pandemic.circuitsim.FixedBitSet;
import com.pandemic.circuitsim.ICircuitPort;

import java.util.Set;

public class ConstantPort extends PortBase
{
    private FixedBitSet value;
    
    public ConstantPort(FixedBitSet value)
    {
        super("Constant", value.length());
        this.value = (FixedBitSet)value.clone();
    }
    
    @Override
    public FixedBitSet getValue()
    {
        return value;
    }
}
