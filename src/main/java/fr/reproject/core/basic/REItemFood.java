package fr.reproject.core.basic;

import net.minecraft.item.ItemFood;
import net.minecraft.util.ResourceLocation;

public class REItemFood extends ItemFood {

    public REItemFood(int amount, float saturation, boolean isWolfFood, String name, String modid) {
        super(amount, saturation, isWolfFood);
        this.setUnlocalizedName(name);
        this.setRegistryName(new ResourceLocation(modid, name));
    }
}
