package net.silverfishstone.tooltips.util.events;

import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BrushItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RespawnAnchorBlock;
import net.minecraft.world.level.block.TrialSpawnerBlock;
import net.minecraft.world.level.block.VaultBlock;
import net.minecraft.world.level.block.entity.trialspawner.TrialSpawnerState;
import net.minecraft.world.level.block.entity.vault.VaultState;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.silverfishstone.tooltips.Tooltiped;
import net.silverfishstone.tooltips.api.TooltipsAdder;
import net.silverfishstone.tooltips.config.TooltipConfig;
import net.silverfishstone.tooltips.util.TooltipTags;

@EventBusSubscriber(modid = Tooltiped.MODID)
public class PlayerEvents {
   public static boolean item = true;
   public static boolean block = true;

    @SubscribeEvent
    public static void playerRightClick (PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        keyTest(player);
    }

    public static void keyTest(Player player) {
        if (item != Tooltiped.showToolTipsI) {
            player.displayClientMessage(Component.translatable("chat.tooltips.item.toggle." + Tooltiped.showToolTipsI), true);
            item = Tooltiped.showToolTipsI;
        }
        if (block != Tooltiped.showToolTipsB) {
            player.displayClientMessage(Component.translatable("chat.tooltips.block.toggle." + Tooltiped.showToolTipsB), true);
            block = Tooltiped.showToolTipsB;
        }
    }
}
