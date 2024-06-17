package net.silverfishstone.tooltips.api;

import com.google.common.collect.Lists;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.*;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.silverfishstone.tooltips.Tooltiped;
import net.silverfishstone.tooltips.util.TooltipTags;
import net.silverfishstone.tooltips.util.events.BlockToolTipEvent;

import javax.swing.text.Style;
import java.text.NumberFormat;
import java.util.List;

public class TooltipsAdder {

    public static void extraModBlock (Block block, Player player) {
        BlockState state = block.defaultBlockState();
        if (state.is(TooltipTags.Blocks.TOOLTIPED)) {
            simplifyedMessage(player, (block.getDescriptionId() + ".howto"));
        }
    }
    /**
     * This is the base class that reads custom tooltips.
     * See {@link ExampleBlockAdder} or {@link ExampleItemAdder} for an example on how this class can be used in another mod.
     * See {@link BlockToolTipEvent} for more use examples.
     */
    public static void simplifyedMessage (Player player, String string) {
        if (Tooltiped.showToolTipsB /* if show block tooltips is on */) {
            //You will this method a majority of the time.
            player.displayClientMessage(Component.translatable(string).withColor(16777215), /* actionbar? */ true);
        }
    }

    public static void customizableMessage (Player player, String string, int color, boolean actionBar, ChatFormatting format) {
        if (Tooltiped.showToolTipsB /* if show block tooltips is on */) {
        player.displayClientMessage(Component.translatable(string).withColor(color).withStyle(format), actionBar);
        }
    }


    /**
     * Above are the methods for adding tooltips to blocks
     *=======
     * Below are the methods for adding tooltips to items
     */


    public static void extraModItem (ItemStack stack) {
        if (stack.is(TooltipTags.Items.TOOLTIPED)) {
            simplifiedTooltipItem(stack, (stack.getItem().getDescriptionId() + ".howto"));
        }
    }

    public static void simplifiedTooltipItem (ItemStack stack, String translate) {
        List<Component> list = Lists.newArrayList();
        if (Tooltiped.showToolTipsI /* if show item tooltips is on */) {
            //Most of the time this method is preferable for items.
            list.add(Component.translatable(translate).withColor(16777215));
        } else {
            list.remove(Component.translatable(translate).withColor(16777215));
        }
        stack.update(DataComponents.LORE, ItemLore.EMPTY, lore -> new ItemLore(list));
    }

    public static void customizeTooltipItem (ItemStack stack, String string, int color, ChatFormatting format) {
        List<Component> list = Lists.newArrayList();
        if (Tooltiped.showToolTipsI /* if show item tooltips is on */) {
            list.add(Component.translatable(string).withColor(color).withStyle(format));
        } else {
            list.remove(Component.translatable(string).withColor(color).withStyle(format));
        }
        stack.update(DataComponents.LORE, ItemLore.EMPTY, lore -> new ItemLore(list));
    }
}
