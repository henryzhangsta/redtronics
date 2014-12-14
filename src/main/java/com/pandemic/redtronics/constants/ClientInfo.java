package com.pandemic.redtronics.constants;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class ClientInfo
{
    public static final CreativeTabs REDTRONICS_CREATIVE_TAB = new CreativeTabs(1, "general")
    {
        @Override
        public Item getTabIconItem()
        {
            return Items.redstone;
        }
    
        @Override
        public String getTabLabel()
        {
            return ModInfo.RESOURCE_ROOT + super.getTabLabel().substring(super.getTabLabel().indexOf('.') + 1);
        }
    };
}
