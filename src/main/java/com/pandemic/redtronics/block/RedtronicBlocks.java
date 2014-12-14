package com.pandemic.redtronics.block;

import com.pandemic.redtronics.block.blocks.BlockICTile;
import com.pandemic.redtronics.block.blocks.BlockWorktable;
import com.pandemic.redtronics.constants.ModInfo;
import com.pandemic.redtronics.constants.Names;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(ModInfo.MOD_ID)
public class RedtronicBlocks
{
    public static final RedtronicBlockBase worktable = new BlockWorktable();
    public static final RedtronicBlockBase integratedCircuit = new BlockICTile();
    
    public static void register()
    {
        GameRegistry.registerBlock(worktable, Names.Blocks.WORKTABLE);
        GameRegistry.registerBlock(integratedCircuit, Names.Blocks.INTEGRATED_CIRCUIT);
    }
}

