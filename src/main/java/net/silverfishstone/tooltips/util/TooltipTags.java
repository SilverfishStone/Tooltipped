package net.silverfishstone.tooltips.util;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class TooltipTags {
    public static class Blocks {

        public static final TagKey<Block> TOOLTIPED = tag("tooltiped");
        public static final TagKey<Block> SUS = tag("suspicious_blocks");
        public static final TagKey<Block> COPPER_BULBS = tag("copper_bulbs");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(ResourceLocation.parse(name));
        }
    }

    public static class Items {

        public static final TagKey<Item> COMPOSABLE = tag("compostable");
        public static final TagKey<Item> COOKABLE_FOOD = tag("cookeable_food");
        public static final TagKey<Item> BUCKETS = tag("buckets");
        public static final TagKey<Item> ENDER_EYE = tag("ender_eye");
        public static final TagKey<Item> TOOLTIPED = tag("tooltiped");
        public static final TagKey<Item> DISCS = tag("discs");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(ResourceLocation.parse(name));
        }
    }

    public static class Effects {


        private static TagKey<MobEffect> tag(String name) {
            return TooltipTags.createEffect(ResourceLocation.parse(name));
        }
    }
    public static TagKey<MobEffect> createEffect(final ResourceLocation name) {
        return TagKey.create(Registries.MOB_EFFECT, name);
    }

    public static class EntityTypes {

    }
    private static TagKey<EntityType<?>> create(String pName) {
        return TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse(pName));
    }
}
