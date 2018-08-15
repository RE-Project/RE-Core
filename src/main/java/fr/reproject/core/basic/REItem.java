package fr.reproject.core.basic;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class REItem extends Item {

    public REItem(String name, String modid) {
        this.setUnlocalizedName(name);
        this.setRegistryName(new ResourceLocation(modid, name));
    }
}
