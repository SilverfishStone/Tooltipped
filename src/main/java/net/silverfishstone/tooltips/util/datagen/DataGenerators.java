package net.silverfishstone.tooltips.util.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.silverfishstone.tooltips.Tooltiped;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Tooltiped.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> LookupProvider = event.getLookupProvider();

        TooltipBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new TooltipBlockTagGenerator(packOutput, LookupProvider,  Tooltiped.MODID, existingFileHelper));
        generator.addProvider(event.includeServer(), new TooltipItemTagGenerator(packOutput, LookupProvider, blockTagGenerator.contentsGetter()));
    }
}
