package com.pandemic.circuitsim;

import java.util.Set;

public interface IResolvable
{
    public void resolve(int tick, Set<ICircuitPort> seen);
}
