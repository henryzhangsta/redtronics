package com.pandemic.circuitsim;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Set;

public interface ICircuitComponent
{
    public String getName();
    
    public ArrayList<IInput> getInputs();
    public ArrayList<ICircuitPort> getOutputs();
    
    public IInput getInput(int i);
    public ICircuitPort getOutput(int i);
    
    public FixedBitSet resolvePort(ICircuitPort port, int tick, Set<ICircuitPort> seen);
}
