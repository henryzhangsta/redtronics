package com.pandemic.redtronics.circuit;

import com.pandemic.circuitsim.IClockable;
import com.pandemic.circuitsim.components.ComponentBase;

public abstract class IntegratedCircuit extends ComponentBase implements IClockable
{
    public IntegratedCircuit()
    {
        super("IC");
    }
}
