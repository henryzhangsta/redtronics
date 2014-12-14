package com.pandemic.circuitsim;

import java.util.Set;

public interface IClockable
{
    public void clock(int tick, Set<ICircuitPort> seen);
}
