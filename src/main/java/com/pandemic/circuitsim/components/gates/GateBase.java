package com.pandemic.circuitsim.components.gates;

import com.pandemic.circuitsim.components.ComponentBase;
import com.pandemic.circuitsim.ports.InputPort;
import com.pandemic.circuitsim.ports.OutputPort;

public abstract class GateBase extends ComponentBase
{
    public GateBase(String name, int inputs, int bits)
    {
        super(name);
        
        for (int i = 0; i < inputs; ++i)
        {
            this.inputs.add(new InputPort(String.format("Input %d", i), bits));
        }
        this.outputs.add(new OutputPort(this, "Output", bits));
    }
}
