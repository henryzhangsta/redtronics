package com.pandemic.circuitsim;

import java.util.BitSet;

public class FixedBitSet extends BitSet
{
    int fixedLength;
    
    public FixedBitSet(int fixedLength)
    {
        super(fixedLength);
        this.fixedLength = fixedLength;
    }
    
    public FixedBitSet(char[] bitSequence)
    {
        this(bitSequence.length);
        for (int i = 0; i < bitSequence.length; ++i)
        {
            if (bitSequence[i] == '1')
            {
                set(i);
            }
        }
    }
    
    @Override
    public Object clone()
    {
        FixedBitSet clone = (FixedBitSet)super.clone();
        clone.fixedLength = fixedLength;
        return clone;
    }
    
    @Override
    public int length()
    {
        return fixedLength;
    }
    
    public String stringify()
    {
        char[] bits = new char[fixedLength];
        for (int i = 0; i < fixedLength; ++i)
        {
            bits[i] = get(i) ? '1' : '0';
        }
        
        return new String(bits);
    }
}
