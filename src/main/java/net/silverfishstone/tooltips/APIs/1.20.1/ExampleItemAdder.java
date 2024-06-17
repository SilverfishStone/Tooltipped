package net.silverfishstone.tooltips.api;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.silverfishstone.tooltips.Tooltiped;

import java.util.List;

//Replace "Tooltiped.MODID" with your mod id.
@Mod.EventBusSubscriber(modid = Tooltiped.MODID)
public class ExampleItemAdder {
    public static Item customItem;
    private static boolean configPlaceholder;
    //boolean configPlaceholder is a placeholder for an optional config setting. it is not required.

    @SubscribeEvent
    public static void holdItem (ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        List<Component> toolTip = event.getToolTip();
        itemExplainExample(stack, toolTip);
    }

    /**
     * If you wish to read config values or define special conditions, write a custom class.
     * Otherwise, put your item in {@linkplain data minecraft/tags/item/tootiped.json} and add a translation.
     * Vanilla and modded items are compatible.
     **/

    public static void itemExplainExample(ItemStack stack, List<Component> tooltip) {
        if (stack.is(customItem) && configPlaceholder) {
            //replace "customItem" with your block.
            TooltipsAdder.simplifiedTooltipItem(stack, stack.getItem().getDescriptionId() + ".howto", tooltip);
            //the translation string is formatted "item.examplemod.example_item.howto" by default. You can replace this with a string of your choice.
        }
    }

    //example without config.
    public static void altItemExplainExample(ItemStack stack, List<Component> tooltip) {
        if (stack.is(customItem)) {
            //replace "customItem" with your block.
            TooltipsAdder.customizeTooltipItem(stack, stack.getItem().getDescriptionId() + ".howto", ChatFormatting.BOLD /* Choose special formatting (italics, obfuscated, etc.) */, tooltip);
            //the translation string is formatted "item.examplemod.example_item.howto" by default. You can relace this with a string of your choice.
        }
    }
}