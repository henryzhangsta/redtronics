package com.pandemic.circuitsim.components;

import com.pandemic.circuitsim.FixedBitSet;
import com.pandemic.circuitsim.ICircuitComponent;
import com.pandemic.circuitsim.ICircuitPort;
import com.pandemic.circuitsim.IInput;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Set;

public abstract class ComponentBase implements ICircuitComponent
{
    protected String name;
    
    protected ArrayList<IInput> inputs = new ArrayList<IInput>();
    protected ArrayList<ICircuitPort> outputs = new ArrayList<ICircuitPort>();
    
    public ComponentBase(String name)
    {
        this.name = name;
    }
    
    @Override
    public String getName()
    {
        return name;
    }
    
    @Override
    public ArrayList<IInput> getInputs()
    {
        return inputs;
    }
    
    @Override
    public ArrayList<ICircuitPort> getOutputs()
    {
        return outputs;
    }
    
    @Override
    public IInput getInput(int i)
    {
        return inputs.get(i);
    }
    
    @Override
    public ICircuitPort getOutput(int i)
    {
        return outputs.get(i);
    }
    
    @Override
    public FixedBitSet resolvePort(ICircuitPort port, int tick, Set<ICircuitPort> seen)
    {
        throw new NotImplementedException();
    }
}
