package net.silverfishstone.tooltips.util.events;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.silverfishstone.tooltips.Tooltiped;
import net.silverfishstone.tooltips.api.TooltipsAdder;
import net.silverfishstone.tooltips.config.TooltipConfig;
import net.silverfishstone.tooltips.util.TooltipTags;

@EventBusSubscriber(modid = Tooltiped.MODID)
public class ItemTooltipEvent {
    @SubscribeEvent
    public static void holdItem (net.neoforged.neoforge.event.entity.player.ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        itemExplain(stack);
    }

    public static void itemExplain (ItemStack stack) {
        if ((stack.is(Items.CARROT_ON_A_STICK) || stack.is(Items.WARPED_FUNGUS_ON_A_STICK)) && TooltipConfig.stick) {
            TooltipsAdder.simplifiedTooltipItem(stack, stack.getItem().getDescriptionId() + ".howto");
        } else if (stack.is(Items.TRIDENT) && TooltipConfig.trident) {
            TooltipsAdder.simplifiedTooltipItem(stack, stack.getItem().getDescriptionId() + ".howto");
        } else if (stack.is(Items.LEAD) && TooltipConfig.lead) {
            TooltipsAdder.simplifiedTooltipItem(stack, stack.getItem().getDescriptionId() + ".howto");
        } else if (stack.is(Items.MACE) && TooltipConfig.mace) {
            TooltipsAdder.simplifiedTooltipItem(stack, stack.getItem().getDescriptionId() + ".howto");
        } else if (stack.is(Items.TRIAL_KEY) && TooltipConfig.trialkey) {
            TooltipsAdder.simplifiedTooltipItem(stack, stack.getItem().getDescriptionId() + ".howto");
        } else if (stack.is(Items.GOAT_HORN) && TooltipConfig.horn) {
            TooltipsAdder.simplifiedTooltipItem(stack, stack.getItem().getDescriptionId() + ".howto");
        } else if (stack.is(Items.NAME_TAG) && TooltipConfig.nametag) {
            TooltipsAdder.simplifiedTooltipItem(stack, stack.getItem().getDescriptionId() + ".howto");
        } else if (stack.is(Items.BRUSH) && TooltipConfig.brush) {
            TooltipsAdder.simplifiedTooltipItem(stack, stack.getItem().getDescriptionId() + ".howto");
        } else if (stack.is(Items.CLOCK) && TooltipConfig.clock) {
            TooltipsAdder.simplifiedTooltipItem(stack, stack.getItem().getDescriptionId() + ".howto");
        } else if (stack.is(Items.SPYGLASS) && TooltipConfig.spyglass) {
            TooltipsAdder.simplifiedTooltipItem(stack, stack.getItem().getDescriptionId() + ".howto");
        } else if (stack.is(Items.OMINOUS_TRIAL_KEY) && TooltipConfig.otrialkey) {
            TooltipsAdder.simplifiedTooltipItem(stack, stack.getItem().getDescriptionId() + ".howto");
        } else if (stack.is(TooltipTags.Items.DISCS) && TooltipConfig.disc) {
            TooltipsAdder.simplifiedTooltipItem(stack, "item.minecraft.music_discs.howto");
        } else if (stack.is(Items.ENDER_EYE) && TooltipConfig.eye) {
            TooltipsAdder.simplifiedTooltipItem(stack, stack.getItem().getDescriptionId() + ".howto");
        } else if (stack.is(Items.SADDLE) && TooltipConfig.saddle) {
            TooltipsAdder.simplifiedTooltipItem(stack, stack.getItem().getDescriptionId() + ".howto");
        } else if (stack.is(Items.ELYTRA) && TooltipConfig.elytra) {
            TooltipsAdder.simplifiedTooltipItem(stack, stack.getItem().getDescriptionId() + ".howto");
        } else if (stack.is(Items.WIND_CHARGE) && TooltipConfig.wind) {
            TooltipsAdder.simplifiedTooltipItem(stack, stack.getItem().getDescriptionId() + ".howto");
        } else if (stack.is(Items.ENDER_PEARL) && TooltipConfig.pearl) {
            TooltipsAdder.simplifiedTooltipItem(stack, stack.getItem().getDescriptionId() + ".howto");
        } else if (stack.is(Items.MAP) && TooltipConfig.map) {
            TooltipsAdder.simplifiedTooltipItem(stack, stack.getItem().getDescriptionId() + ".howto");
        } else if (stack.is(Items.COMPASS) && TooltipConfig.compass) {
            TooltipsAdder.simplifiedTooltipItem(stack, stack.getItem().getDescriptionId() + ".howto");
        } else if (stack.is(Items.RECOVERY_COMPASS) && TooltipConfig.recoverycompass) {
            TooltipsAdder.simplifiedTooltipItem(stack, stack.getItem().getDescriptionId() + ".howto");
        } else if (stack.is(Items.TOTEM_OF_UNDYING) && TooltipConfig.totem) {
            TooltipsAdder.simplifiedTooltipItem(stack, stack.getItem().getDescriptionId() + ".howto");
        } else {
            TooltipsAdder.extraModItem(stack);
        }
    }
}
