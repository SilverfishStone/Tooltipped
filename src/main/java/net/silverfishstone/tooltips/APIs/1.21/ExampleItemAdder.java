package net.silverfishstone.tooltips.api;

import net.minecraft.ChatFormatting;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.silverfishstone.tooltips.Tooltiped;
import net.silverfishstone.tooltips.config.TooltipConfig;

//Replace "Tooltiped.MODID" with your mod id.
@EventBusSubscriber(modid = Tooltiped.MODID)
public class ExampleItemAdder {
    public static Item customItem;
    private static boolean configPlaceholder;
    //boolean configPlaceholder is a placeholder for an optional config setting. it is not required.

    @SubscribeEvent
    public static void holdItem (net.neoforged.neoforge.event.entity.player.ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        itemExplainExample(stack);
    }

    /**
     * If you wish to read config values or define special conditions, write a custom class.
     * Otherwise, put your item in {@linkplain data minecraft/tags/item/tootiped.json} and add a translation.
     * Vanilla and modded items are compatible.
     **/

    public static void itemExplainExample(ItemStack stack) {
        if (stack.is(customItem) && configPlaceholder) {
            //replace "customItem" with your block.
            TooltipsAdder.simplifiedTooltipItem(stack, stack.getItem().getDescriptionId() + ".howto");
            //the translation string is formatted "item.examplemod.example_item.howto" by default. You can replace this with a string of your choice.
        }
    }

    //example without config.
    public static void altItemExplainExample(ItemStack stack) {
        if (stack.is(customItem)) {
            //replace "customItem" with your block.
            TooltipsAdder.customizeTooltipItem(stack, stack.getItem().getDescriptionId() + ".howto", 16777215 /* default white color */ , ChatFormatting.BOLD /* Choose special formatting (italics, obfuscated, etc.) */);
            //the translation string is formatted "item.examplemod.example_item.howto" by default. You can replace this with a string of your choice.
        }
    }
}