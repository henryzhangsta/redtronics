package com.pandemic.circuitsim;

import java.util.BitSet;

public interface ICircuitPort extends IResolvable
{
    public FixedBitSet getValue();
    public int getWidth();
    public String getName();
}
