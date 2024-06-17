package net.silverfishstone.tooltips.util.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.silverfishstone.tooltips.util.TooltipTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class TooltipBlockTagGenerator extends BlockTagsProvider {
    public TooltipBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(TooltipTags.Blocks.TOOLTIPED)
                .add(Blocks.COMPOSTER,
                        Blocks.TRIAL_SPAWNER,
                        Blocks.VAULT,
                        Blocks.RESPAWN_ANCHOR);

        this.tag(TooltipTags.Blocks.SUS)
                .add(Blocks.SUSPICIOUS_GRAVEL,
                        Blocks.SUSPICIOUS_SAND);

        this.tag(TooltipTags.Blocks.COPPER_BULBS)
                .add(Blocks.COPPER_BULB,
                        Blocks.WAXED_COPPER_BULB,
                        Blocks.EXPOSED_COPPER_BULB,
                        Blocks.WAXED_EXPOSED_COPPER_BULB,
                        Blocks.WEATHERED_COPPER_BULB,
                        Blocks.WAXED_WEATHERED_COPPER_BULB,
                        Blocks.OXIDIZED_COPPER_BULB,
                        Blocks.WAXED_OXIDIZED_COPPER_BULB);
    }
}

