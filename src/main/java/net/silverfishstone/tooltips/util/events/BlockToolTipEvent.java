package net.silverfishstone.tooltips.util.events;

import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BrushItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.trialspawner.TrialSpawnerState;
import net.minecraft.world.level.block.entity.vault.VaultState;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.silverfishstone.tooltips.Tooltiped;
import net.silverfishstone.tooltips.api.TooltipsAdder;
import net.silverfishstone.tooltips.config.TooltipConfig;
import net.silverfishstone.tooltips.util.TooltipTags;

@EventBusSubscriber(modid = Tooltiped.MODID)
public class BlockToolTipEvent {

    @SubscribeEvent
    public static void playerRightClick (PlayerInteractEvent.RightClickBlock event) {
        BlockState state = event.getLevel().getBlockState(event.getPos());
        Player player = event.getEntity();
        blockexplain(player, state);
    }

    public static void blockexplain(Player player, BlockState state) {
        if (state.is(Blocks.VAULT) && !player.getMainHandItem().is(Items.TRIAL_KEY)) {
            //if player right clicks on a vault without a trial key, a message is displayed.
            if (state.getValue(VaultBlock.STATE).equals(VaultState.ACTIVE)) {
                if (state.getValue(VaultBlock.OMINOUS)) {
                    //if state is ominous.
                    if (TooltipConfig.scary_vault) {
                        //if the config is set to true
                        player.displayClientMessage(Component.translatable("block.minecraft.vault.ominous_howto"), true);
                    }
                } else {
                    //if state is normal
                    if (TooltipConfig.vault) {
                       //if the config is set to true
                        player.displayClientMessage(Component.translatable("block.minecraft.vault.howto"), true);
                    }
                }
            } else {
                if (TooltipConfig.vault_innate) {
                    if (state.getValue(VaultBlock.OMINOUS)) {
                        player.displayClientMessage(Component.translatable("block.minecraft.vault.ominous_howto_innate"), true);
                    } else {
                        player.displayClientMessage(Component.translatable("block.minecraft.vault.howto_innate"), true);
                    }
                }
            }
        } else if (state.is(Blocks.RESPAWN_ANCHOR) && !player.getMainHandItem().is(Items.GLOWSTONE)) {
            if (state.getValue(RespawnAnchorBlock.CHARGE) < 4) {
                player.displayClientMessage(Component.translatable("block.minecraft.respawn_anchor.howto"), true);
            }
        } else if (state.is(Blocks.TRIAL_SPAWNER)) {
            if (TooltipConfig.trialSpawner) {
                player.displayClientMessage(Component.translatable("block.minecraft.trial_spawner.howto"), true);
            } else {
                if (state.getValue(TrialSpawnerBlock.STATE).equals(TrialSpawnerState.ACTIVE)) {
                    player.displayClientMessage(Component.translatable("block.minecraft.trial_spawner.active"), true);
                }
                if (state.getValue(TrialSpawnerBlock.STATE).equals(TrialSpawnerState.INACTIVE)) {
                    player.displayClientMessage(Component.translatable("block.minecraft.trial_spawner.inactive"), true);
                }
                if (state.getValue(TrialSpawnerBlock.STATE).equals(TrialSpawnerState.COOLDOWN)) {
                        player.displayClientMessage(Component.translatable("block.minecraft.trial_spawner.oncooldown"), true);
                }
                if (state.getValue(TrialSpawnerBlock.STATE).equals(TrialSpawnerState.EJECTING_REWARD)) {
                        player.displayClientMessage(Component.translatable("block.minecraft.trial_spawner.ejecting_reward"), true);
                }
                if (state.getValue(TrialSpawnerBlock.STATE).equals(TrialSpawnerState.WAITING_FOR_REWARD_EJECTION)) {
                    TooltipsAdder.simplifyedMessage( player,"block.minecraft.trial_spawner.waiting_for_reward");
                }
            }
        } else if (state.is(Blocks.COMPOSTER) && !player.getMainHandItem().is(TooltipTags.Items.COMPOSABLE)) {
           TooltipsAdder.simplifyedMessage(player, "block.minecraft.composter.howto");
        } else if (state.is(BlockTags.CAMPFIRES) && !player.getMainHandItem().is(TooltipTags.Items.COOKABLE_FOOD)) {
            if (TooltipConfig.campfire) {
                TooltipsAdder.simplifyedMessage(player, "block.minecraft.campfire.howto");
            }
        } else if (state.is(Blocks.CAULDRON) && !player.getMainHandItem().is(TooltipTags.Items.BUCKETS)) {
            if (TooltipConfig.cauldron) {
                TooltipsAdder.simplifyedMessage(player, "block.minecraft.cauldron.howto");
            }
        } else if (state.is(TooltipTags.Blocks.SUS) && !(player.getMainHandItem().getItem() instanceof BrushItem)) {
            if (TooltipConfig.sus) {
                TooltipsAdder.simplifyedMessage(player, "block.minecraft.susblock.howto");
            }
        } else if (state.is(Blocks.REDSTONE_LAMP)) {
            if (TooltipConfig.redstoneLamp) {
                TooltipsAdder.simplifyedMessage(player, "block.minecraft.redstone_lamp.howto");
            }
        } else if (state.is(TooltipTags.Blocks.COPPER_BULBS)) {
            if (TooltipConfig.copperBulb) {
                TooltipsAdder.simplifyedMessage(player, "block.minecraft.copper_bulb.howto");
            }
        } else if (state.is(Blocks.LECTERN) && !player.getMainHandItem().is(ItemTags.LECTERN_BOOKS)) {
            if (TooltipConfig.lectern) {
                TooltipsAdder.simplifyedMessage(player, "block.minecraft.lectern.howto");
            }
        } else if (state.is(Blocks.LIGHTNING_ROD) && player.isCrouching()) {
            if (TooltipConfig.lightning) {
                TooltipsAdder.simplifyedMessage(player, "block.minecraft.lightning_rod.howto");
            }
        } else if (state.is(Blocks.PISTON)) {
            if (TooltipConfig.piston) {
                TooltipsAdder.simplifyedMessage(player, "block.minecraft.piston.howto");
            }
        } else if (state.is(Blocks.STICKY_PISTON)) {
            if (TooltipConfig.piston) {
                TooltipsAdder.simplifyedMessage(player, "block.minecraft.sticky_piston.howto");
            }
        } else if (state.is(Blocks.CHISELED_BOOKSHELF) && !(state.getValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_0_OCCUPIED) || state.getValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_1_OCCUPIED) || state.getValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_2_OCCUPIED) || state.getValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_3_OCCUPIED) || state.getValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_4_OCCUPIED) || state.getValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_5_OCCUPIED)) && !player.getMainHandItem().is(ItemTags.BOOKSHELF_BOOKS)) {
            if (TooltipConfig.chiseled) {
                TooltipsAdder.simplifyedMessage(player, "block.minecraft.chiseled_bookshelf.howto");
            }
        } else if (state.is(Blocks.DECORATED_POT)) {
            if (TooltipConfig.pot) {
                TooltipsAdder.simplifyedMessage(player, "block.minecraft.decorated_pot.howto");
            }
        } else if (state.is(Blocks.OBSERVER)) {
            if (TooltipConfig.observer) {
                TooltipsAdder.simplifyedMessage(player, "block.minecraft.observer.howto");
            }
        } else if (state.is(Blocks.END_PORTAL_FRAME)) {
            if (TooltipConfig.endPortal) {
                TooltipsAdder.simplifyedMessage(player, "block.minecraft.end_portal_frame.howto");
            }
        } else {
            TooltipsAdder.extraModBlock(state.getBlock(), player);
        }
    }
}
