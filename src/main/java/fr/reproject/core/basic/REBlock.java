package fr.reproject.core.basic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class REBlock extends Block {

    public REBlock(Material blockMaterial, String name, String modid) {
        super(blockMaterial);
        this.setUnlocalizedName(name);
        this.setRegistryName(new ResourceLocation(modid, name));
    }
}
