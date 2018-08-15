package fr.reproject.core;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = RECore.MODID, name = RECore.NAME, version = RECore.VERSION)
public class RECore {

    public static final String MODID = "recore";
    public static final String NAME = "§dRE: Core";
    public static final String VERSION = "1.0.1";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("Hello World!");
    }
}
