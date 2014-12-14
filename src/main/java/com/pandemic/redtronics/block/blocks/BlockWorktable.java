package com.pandemic.redtronics.block.blocks;

import com.pandemic.redtronics.block.RedtronicBlockBase;
import com.pandemic.redtronics.constants.Names;
import net.minecraft.block.material.Material;

public class BlockWorktable extends RedtronicBlockBase
{
    public BlockWorktable()
    {
        super(Material.iron);
        this.setBlockName(Names.Blocks.WORKTABLE);
    }
}
