package fr.reproject.core.utils;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Logger;

public class Register {

    public static void registerItem(Item item, CreativeTabs creativeTabs, Logger logger) {
        item.setCreativeTab(creativeTabs);
        GameRegistry.findRegistry(Item.class).register(item);
        logger.info("Registered Item: " + item.getUnlocalizedName().substring(5));
    }

    public static void registerRender(Item item, String modid, Logger logger) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(modid, item.getUnlocalizedName().substring(5)), "inventory"));
        logger.info("Registered render for " + item.getUnlocalizedName().substring(5));
    }

    public static void registerBlock(Block block, CreativeTabs creativeTabs, Logger logger) {
        block.setCreativeTab(creativeTabs);
        GameRegistry.findRegistry(Block.class).register(block);
        GameRegistry.findRegistry(Item.class).register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
        logger.info("Registered block: " + block.getUnlocalizedName().substring(5));
    }

    public static void registerRender(Block block, String modid, Logger logger) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(modid, block.getUnlocalizedName().substring(5)), "inventory"));
        logger.info("Registered render for " + block.getUnlocalizedName().substring(5));
    }
}
