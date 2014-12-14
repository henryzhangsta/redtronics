package com.pandemic.redtronics.block.blocks;

import com.pandemic.redtronics.block.RedtronicBlockBase;
import com.pandemic.redtronics.constants.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

public class BlockICTile extends RedtronicBlockBase
{
    public BlockICTile()
    {
        super(Blocks.unpowered_repeater.getMaterial());
        this.setBlockName(Names.Blocks.INTEGRATED_CIRCUIT);
    }
    
    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    @Override
    public void onNeighborBlockChange(World world, int i, int j, int k, Block changedBlock)
    {
        if (changedBlock.canProvidePower())
        {
            boolean flag = world.isBlockIndirectlyGettingPowered(i, j, k) || world.isBlockIndirectlyGettingPowered(i, j + 1, k);
            if (flag)
            {
                world.scheduleBlockUpdate(i, j, k, this, tickRate(world));
            }
        }
    }
    
    @Override
    public void updateTick(World world, int i, int j, int k, Random random)
    {
        
    }
}
