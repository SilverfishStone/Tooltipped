package net.silverfishstone.tooltips.api;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.silverfishstone.tooltips.util.TooltipTags;
import net.silverfishstone.tooltips.util.events.ToolTipShowEvent;

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
}
