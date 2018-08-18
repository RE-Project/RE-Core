package fr.reproject.core;

public class REModList {

    public static int numberOfMod = 0;
    public static String[] MODID;
    public static String[] MODNAME;

    private static String modIDList = "recore";
    private static String modNameList = "RE: Core";

    public static int loadMod(String modID, String modNAME) {
        numberOfMod++;
        modIDList = modIDList + ":::" + modID;
        modNameList = modNameList + ":::" + modNAME;
        return numberOfMod;
    }

    public static void initLoadMod(int modID) {
        MODID = modIDList.split(":::");
        MODNAME = modNameList.split(":::");
        RECore.logger.info(MODID[modID] + " finished loading its mod in RE: Core you could load the rest of your mod");
    }
}