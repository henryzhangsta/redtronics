package com.pandemic.redtronics;

import com.pandemic.circuitsim.FixedBitSet;
import com.pandemic.circuitsim.ICircuitPort;
import com.pandemic.circuitsim.ports.ConstantPort;
import com.pandemic.circuitsim.components.gates.InclusiveOrGate;
import com.pandemic.redtronics.block.RedtronicBlocks;
import com.pandemic.redtronics.config.ConfHandler;
import com.pandemic.redtronics.constants.ModInfo;
import com.pandemic.redtronics.item.RedtronicItems;
import com.pandemic.redtronics.proxy.IProxy;
import com.pandemic.redtronics.utils.Logger;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import java.util.BitSet;
import java.util.HashSet;

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, version = ModInfo.MOD_VERSION, guiFactory = ModInfo.GUI_FACTORY_CLASS_NAME)
public class Redtronics
{
    @Mod.Instance("Redtronics")
    public static Redtronics instance;

    @SidedProxy(clientSide = ModInfo.CLIENT_PROXY_CLASS_NAME, serverSide = ModInfo.SERVER_PROXY_CLASS_NAME)
    public static IProxy proxy;
    
    @Mod.EventHandler
    public void PreInit(FMLPreInitializationEvent event)
    {
        FMLCommonHandler.instance().bus().register(new ConfHandler(event.getModConfigurationDirectory()));
    
        RedtronicItems.register();
        RedtronicBlocks.register();
    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event)
    {
        FixedBitSet a = new FixedBitSet(4);
        FixedBitSet b = new FixedBitSet(4);
        a.set(0, 2, true);
        b.set(1, 3, true);
    
        ConstantPort c_a = new ConstantPort(a);
        ConstantPort c_b = new ConstantPort(b);
        
        InclusiveOrGate or = new InclusiveOrGate(2, 4);
        or.getInput(0).dependsOn(c_a);
        or.getInput(1).dependsOn(c_b);
        or.getOutput(0).resolve(0, new HashSet<ICircuitPort>());
        Logger.warn((or.getOutput(0).getValue().stringify()));
    }

    @Mod.EventHandler
    public void PostInit(FMLPostInitializationEvent event)
    {
    
    }
}
