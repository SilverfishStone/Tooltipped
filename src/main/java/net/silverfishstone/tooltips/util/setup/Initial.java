package net.silverfishstone.tooltips.util.setup;

import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.silverfishstone.tooltips.Tooltiped;
import net.silverfishstone.tooltips.config.TooltipConfig;

public class Initial {
    public static void commonSetup(final FMLClientSetupEvent event) {
        if (TooltipConfig.block) {
            Tooltiped.showToolTipsB = true;
        } else {
            Tooltiped.showToolTipsB = false;
        }
        if (TooltipConfig.item) {
            Tooltiped.showToolTipsI = true;
        } else {
            Tooltiped.showToolTipsI = false;
        }
    }


    public static void onClientTick(ClientTickEvent.Post event) {
        if (TooltipConfig.block) {
            while (Tooltiped.SHOW_BLOCK.get().consumeClick()) {
                cycleBlock();
            }
        }
        if (TooltipConfig.item) {
            while (Tooltiped.SHOW_ITEM.get().consumeClick()) {
                cycleItem();
            }
        }
    }

    public static void cycleBlock() {
        if (Tooltiped.showToolTipsB) {
            Tooltiped.showToolTipsB = false;
        } else {
            Tooltiped.showToolTipsB = true;
        }
    }
    public static void cycleItem() {
        if (Tooltiped.showToolTipsI) {
            Tooltiped.showToolTipsI = false;
        } else {
            Tooltiped.showToolTipsI = true;
        }
    }
}
