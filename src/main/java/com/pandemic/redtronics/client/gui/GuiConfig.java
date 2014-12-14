package com.pandemic.redtronics.client.gui;

import com.pandemic.redtronics.config.ConfHandler;
import com.pandemic.redtronics.constants.ModInfo;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

public class GuiConfig extends cpw.mods.fml.client.config.GuiConfig
{
    public GuiConfig(GuiScreen screen)
    {
        super(screen, new ConfigElement(ConfHandler.conf.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), ModInfo.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(ConfHandler.conf.toString()));
    }
}
