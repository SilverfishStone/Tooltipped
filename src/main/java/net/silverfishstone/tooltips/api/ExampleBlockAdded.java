package net.silverfishstone.tooltips.api;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.silverfishstone.tooltips.Tooltiped;

//Replace "Tooltiped.MODID" with your mod id.
@EventBusSubscriber(modid = Tooltiped.MODID)
public class ExampleBlockAdded {
    public static Block customBlock;
    private static boolean configPlaceholder;
    //boolean configPlaceholder is a placeholder for an optional config setting. it is not required.

    @SubscribeEvent
    public static void playerRightClick (PlayerInteractEvent.RightClickBlock event) {
        BlockState state = event.getLevel().getBlockState(event.getPos());
        Player player = event.getEntity();
        blockExplainExample(player, state);
    }

    /**
     * Tags cannot distinguish between states.
     * If you wish to distinguish between multiple states, read config values, or define special conditions, write a custom class.
     * Otherwise, put your block in {@linkplain data minecraft/tags/block/tootiped.json} and add a translation.
     **/
    public static void blockExplainExample(Player player, BlockState state) {
        if (configPlaceholder /* optional */) {
            //if config is set to true
            if (state.is(customBlock)) {
                //replace "customBlock" with your block.
                TooltipsAdder.customizableMessage(player, "block.examplemod.exampleblock.examplestring", 16777215 /* default white */ ,true /* actionbar? */ );
                //change the translatable string into a translation string of your choice and create a translation in your lang files. (i.e. en_us.json)
            }
        }
    }
    //example without config.
    public static void altBlockExplainExample(Player player, BlockState state) {
        if (state.is(customBlock)) {
            //replace "customBlock" with your block.
            TooltipsAdder.simplifyedMessage(player, "block.examplemod.exampleblock.examplestring");
            //change the translatable string into a translation string of your choice and create a translation in your lang files. (i.e. en_us.json)
        }
    }
}
