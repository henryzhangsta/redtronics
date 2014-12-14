package com.pandemic.circuitsim.components.memory;

import com.pandemic.circuitsim.FixedBitSet;
import com.pandemic.circuitsim.ICircuitPort;
import com.pandemic.circuitsim.IClockable;
import com.pandemic.circuitsim.components.ComponentBase;
import com.pandemic.circuitsim.ports.ClockPort;
import com.pandemic.circuitsim.ports.InputPort;
import com.pandemic.circuitsim.ports.OutputPort;

import java.util.Set;

public class DFlipFlop extends ComponentBase implements IClockable
{
    protected FixedBitSet state;
    
    protected InputPort Data;
    protected InputPort Set;
    protected InputPort Reset;
    protected ClockPort Clock;
    protected OutputPort Output;
    
    public DFlipFlop()
    {
        super("D FlipFlop");
        
        this.Data = new InputPort("Data", 1);
        this.Set = new InputPort("Set", 1);
        this.Reset = new InputPort("Reset", 1);
        this.Clock = new ClockPort();
        this.Output = new OutputPort(this, "Output", 1);
        
        this.inputs.add(Data);
        this.inputs.add(Set);
        this.inputs.add(Reset);
        this.inputs.add(Clock);
        this.outputs.add(Output);
        
        this.state = new FixedBitSet(1);
    }
    
    @Override
    public void clock(int tick, Set<ICircuitPort> seen)
    {
        if (Clock.checkClock(tick, seen))
        {
            Data.resolve(tick, seen);
            this.state = Data.getValue();
        }
    }
    
    @Override
    public FixedBitSet resolvePort(ICircuitPort port, int tick, Set<ICircuitPort> seen)
    {
        Set.resolve(tick, seen);
        Reset.resolve(tick, seen);
        if (port == Output)
        {
            if (inputs.get(0).getValue().get(0))
            {
                this.state.set(0);
            }
            else if (inputs.get(1).getValue().get(1))
            {
                this.state.clear(0);
            }
            
            return this.state;
        }
        
        throw new RuntimeException("Invalid Port.");
    }
}
