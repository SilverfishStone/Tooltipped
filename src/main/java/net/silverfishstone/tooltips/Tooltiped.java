package net.silverfishstone.tooltips;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.silverfishstone.tooltips.config.TooltipConfig;
import org.slf4j.Logger;

@Mod(Tooltiped.MODID)
public class Tooltiped {
public static final String MODID = "tooltips";
private static final Logger LOGGER = LogUtils.getLogger();
public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

public Tooltiped(IEventBus modEventBus, ModContainer modContainer)
{
    modEventBus.addListener(this::commonSetup);
    BLOCKS.register(modEventBus);
    ITEMS.register(modEventBus);
    CREATIVE_MODE_TABS.register(modEventBus);
    NeoForge.EVENT_BUS.register(this);

    modContainer.registerConfig(ModConfig.Type.CLIENT, TooltipConfig.SPEC);
}

private void commonSetup(final FMLCommonSetupEvent event)
{

}

@SubscribeEvent
public void onServerStarting(ServerStartingEvent event)
{
    LOGGER.info("HELLO from server starting");
}

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public static class ClientModEvents
{
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event)
    {
        LOGGER.info("HELLO FROM CLIENT SETUP");
        LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }
}
}