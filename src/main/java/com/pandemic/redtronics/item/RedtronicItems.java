package com.pandemic.redtronics.item;

import com.pandemic.redtronics.constants.ModInfo;
import com.pandemic.redtronics.constants.Names;
import com.pandemic.redtronics.item.items.ItemWrench;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(ModInfo.MOD_ID)
public class RedtronicItems
{
    public static final RedtronicItemBase wrench = new ItemWrench();
    
    public static void register()
    {
        GameRegistry.registerItem(wrench, Names.Items.WRENCH);
    }
}
