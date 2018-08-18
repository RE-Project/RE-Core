package fr.reproject.core;


public class REModList {

    public static int numberOfMod = 0;
    public static String[] MODID = new String[255];
    public static String[] MODNAME = new String[255];

    public static int loadMod(String modID, String modNAME) {
        MODID[numberOfMod] = modID;
        MODNAME[numberOfMod] = modNAME;
        numberOfMod++;
        return numberOfMod;
    }

    public static void initLoadMod(int modID) {
        RECore.logger.info(MODID[modID] + " finished loading its mod in RE: Core you could load the rest of your mod");
    }
}