package fr.reproject.core;

import fr.reproject.core.utils.Register;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = RECore.MODID, name = RECore.NAME, version = RECore.VERSION)
public class RECore {

    public static int modid;
    public static final String MODID = "recore";
    public static final String NAME = "RE: Core";
    public static final String VERSION = "1.0.3.4";

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        modid = REModList.loadMod(MODID, NAME);
        REModList.initLoadMod(modid);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("Hello World!");
    }

    @EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        event.registerServerCommand(new REModCommand());
    }

    public static class Utils extends Register {
    }
}
