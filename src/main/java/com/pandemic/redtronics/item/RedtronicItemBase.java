package com.pandemic.redtronics.item;

import com.pandemic.redtronics.constants.ClientInfo;
import com.pandemic.redtronics.constants.ModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RedtronicItemBase extends Item
{
    public RedtronicItemBase()
    {
        super();
        this.setMaxStackSize(1);
        this.setCreativeTab(ClientInfo.REDTRONICS_CREATIVE_TAB);
        this.setNoRepair();
    }
    
    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", ModInfo.RESOURCE_ROOT, super.getUnlocalizedName().substring(super.getUnlocalizedName().indexOf('.') + 1));
    }
    
    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return this.getUnlocalizedName();
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf('.') + 1));
    }
}
