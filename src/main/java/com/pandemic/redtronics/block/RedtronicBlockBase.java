package com.pandemic.redtronics.block;

import com.pandemic.redtronics.constants.ClientInfo;
import com.pandemic.redtronics.constants.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;

public class RedtronicBlockBase extends Block
{
    public RedtronicBlockBase(Material material)
    {
        super(material);
        this.setCreativeTab(ClientInfo.REDTRONICS_CREATIVE_TAB);
        this.setStepSound(Blocks.iron_block.stepSound);
    }
    
    public RedtronicBlockBase()
    {
        this(Material.rock);
        this.setStepSound(Blocks.stone.stepSound);
    }
    
    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", ModInfo.RESOURCE_ROOT, super.getUnlocalizedName().substring(super.getUnlocalizedName().indexOf('.') + 1));
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf('.') + 1));
    }
}
