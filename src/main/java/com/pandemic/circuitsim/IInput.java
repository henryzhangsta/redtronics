package com.pandemic.circuitsim;

public interface IInput extends ICircuitPort
{
    public void dependsOn(ICircuitPort peer);
}
