package com.pandemic.circuitsim.components.transistors;

import com.pandemic.circuitsim.components.ComponentBase;
import com.pandemic.circuitsim.ports.InputPort;
import com.pandemic.circuitsim.ports.OutputPort;

public abstract class TransistorBase extends ComponentBase
{
    protected static int INPUT_SOURCE = 0;
    protected static int INPUT_GATE = 1;
    
    public TransistorBase(String name)
    {
        super(name);
        this.inputs.add(new InputPort("Source", 1));
        this.inputs.add(new InputPort("Gate", 1));
        this.outputs.add(new OutputPort(this, "Drain", 1));
    }
}
