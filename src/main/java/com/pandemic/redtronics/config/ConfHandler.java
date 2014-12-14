package com.pandemic.redtronics.config;

import com.pandemic.redtronics.constants.ModInfo;
import com.pandemic.redtronics.utils.Logger;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;
import java.nio.file.Path;

public class ConfHandler
{
    public static Configuration conf;
    
    public ConfHandler(File confFolder)
    {
        Path confRoot = confFolder.toPath();
    
        Path mainConf = confRoot.resolve("redtronics").resolve("redtronics.conf");
        conf = new Configuration(mainConf.toFile());
        load();
    }
    
    @SubscribeEvent
    public void OnConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(ModInfo.MOD_ID))
        {
            load();
        }
    }
    
    private static void load()
    {
        try
        {
            conf.load();
        }
        catch (Exception e)
        {
            Logger.error(e);
        }
        finally
        {
            if (conf.hasChanged())
            {
                conf.save();
            }
        }
    }
}
