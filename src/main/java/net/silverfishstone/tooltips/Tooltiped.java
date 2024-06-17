package net.silverfishstone.tooltips;

import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.logging.LogUtils;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.jarjar.nio.util.Lazy;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.silverfishstone.tooltips.config.TooltipConfig;
import net.silverfishstone.tooltips.util.setup.Initial;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;

@Mod(Tooltiped.MODID)
public class Tooltiped {
public static final String MODID = "tooltips";
public static boolean showToolTipsB = true;
public static boolean showToolTipsI = true;
private static final Logger LOGGER = LogUtils.getLogger();

public Tooltiped(IEventBus modEventBus, ModContainer modContainer)
{
    NeoForge.EVENT_BUS.register(this);
    NeoForge.EVENT_BUS.addListener(Initial::onClientTick);
    modEventBus.addListener(Initial::commonSetup);

    modContainer.registerConfig(ModConfig.Type.CLIENT, TooltipConfig.SPEC);
}

@SubscribeEvent
public void onServerStarting(ServerStartingEvent event) {
    LOGGER.info("HELLO from server starting");
}
public static final Lazy<KeyMapping> SHOW_BLOCK = Lazy.of(() -> new KeyMapping(
        "key.tooltips.showblocktooltips",
        KeyConflictContext.UNIVERSAL,
        InputConstants.Type.KEYSYM,
        GLFW.GLFW_KEY_B,
        "key.categories.tooltips.tooltipcategory"
));
public static final Lazy<KeyMapping> SHOW_ITEM = Lazy.of(() -> new KeyMapping(
        "key.tooltips.showitemtooltips",
        KeyConflictContext.UNIVERSAL,
        InputConstants.Type.KEYSYM, // Default mapping is on the keyboard
        GLFW.GLFW_KEY_I, // Default key is I
        "key.categories.tooltips.tooltipcategory"
));

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public static class ClientModEvents
{
    @SubscribeEvent
    public static void registerBindings(RegisterKeyMappingsEvent event) {
        event.register(SHOW_BLOCK.get());
        event.register(SHOW_ITEM.get());
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event)
    {
        LOGGER.info("HELLO FROM CLIENT SETUP");
        LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }
}
}