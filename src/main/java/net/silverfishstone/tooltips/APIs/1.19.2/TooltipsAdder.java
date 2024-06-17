package net.silverfishstone.tooltips.api;

import com.google.common.collect.Lists;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.silverfishstone.tooltips.Tooltiped;
import net.silverfishstone.tooltips.util.TooltipTags;
import net.silverfishstone.tooltips.util.events.ToolTipShowEvent;

import java.util.List;

public class TooltipsAdder {
    public static void extraModBlock (Block block, Player player) {
        BlockState state = block.defaultBlockState();
        if (state.is(TooltipTags.Blocks.TOOLTIPED)) {
            simplifyedMessage(player, (block.getDescriptionId() + ".howto"));
        }
    }
    /**
     * This is the base class that reads block tooltips.
     * See {@link ExampleBlockAdded} for an example on how this class can be used in another mod.
     * See {@link ToolTipShowEvent} for more use examples.
     */
    public static void simplifyedMessage (Player player, String string) {
        player.displayClientMessage(Component.translatable(string), /* actionbar? */ true);
    }
    //You will use the above method a majority of the time.

    public static void customizableMessage (Player player, String string, boolean actionBar) {
        player.displayClientMessage(Component.translatable(string), actionBar);
    }


    /**
     * Above are the methods for adding tooltips to blocks
     *=======
     * Below are the methods for adding tooltips to items
     */


    public static void extraModItem (ItemStack stack, List<Component> tooltip) {
        if (stack.is(TooltipTags.Items.TOOLTIPED)) {
            simplifiedTooltipItem(stack, (stack.getItem().getDescriptionId() + ".howto"), tooltip);
        }
    }

    public static void simplifiedTooltipItem (ItemStack stack, String translate, List<Component> tooltip) {
        List<Component> list = Lists.newArrayList();
        if (Tooltiped.showToolTipsI /* if show item tooltips is on */) {
            //Most of the time this method is preferable for items.
            tooltip.add(Component.translatable(translate));
        } else {
            tooltip.remove(Component.translatable(translate));
        }
    }

    public static void customizeTooltipItem (ItemStack stack, String string, ChatFormatting format, List<Component> tooltip) {
        if (Tooltiped.showToolTipsI /* if show item tooltips is on */) {
            tooltip.add(Component.translatable(string).withStyle(format));
        } else {
            tooltip.remove(Component.translatable(string).withStyle(format));
        }
    }
}

