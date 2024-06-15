package net.silverfishstone.tooltips.config;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.silverfishstone.tooltips.Tooltiped;

@EventBusSubscriber(modid = Tooltiped.MODID, bus = EventBusSubscriber.Bus.MOD)
public class TooltipConfig
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.BooleanValue TRIAL_SPAWNER = BUILDER
            .comment("Whether to explain how a Trial Spawner works.")
            .define("trialSpawnerInfo", true);

    private static final ModConfigSpec.BooleanValue VAULT_BASIC = BUILDER
            .comment("Whether to explain how a normal Vault works.")
            .define("vaultInfo", true);
    private static final ModConfigSpec.BooleanValue OMINOUS_VAULT = BUILDER
            .comment("Whether to explain how a Ominous Vault works.")
            .define("ominousVaultInfo", true);
    private static final ModConfigSpec.BooleanValue VAULT_INNATE = BUILDER
            .comment("Whether to tell the player if a Vault is active.")
            .define("vaultInnateInfo", true);
    private static final ModConfigSpec.BooleanValue CAMPFIRE = BUILDER
            .comment("Whether to explain how campfires work.")
            .define("campfireInfo", true);
    private static final ModConfigSpec.BooleanValue RESPAWN_ANCHOR = BUILDER
            .comment("Whether to explain how a Respawn Anchor works.")
            .define("respawnAnchorInfo", true);
    private static final ModConfigSpec.BooleanValue CAULDRON = BUILDER
            .comment("Whether to explain how a Cauldron works.")
            .define("cauldronInfo", false);
    private static final ModConfigSpec.BooleanValue SUS = BUILDER
            .comment("Whether to explain how suspicious blocks work.")
            .define("susInfo", true);
    private static final ModConfigSpec.BooleanValue END_PORTAL = BUILDER
            .comment("Whether to explain how End Portal Frames work.")
            .define("endPortalInfo", true);
    private static final ModConfigSpec.BooleanValue REDSTONE_LAMP = BUILDER
            .comment("Whether to explain how a Redstone Lamp works.")
            .define("redstoneLampInfo", false);
    private static final ModConfigSpec.BooleanValue COPPER_LAMP = BUILDER
            .comment("Whether to explain how a Copper Bulb works.")
            .define("copperBulbInfo", false);
    private static final ModConfigSpec.BooleanValue LECTERN = BUILDER
            .comment("Whether to explain how a Lectern works.")
            .define("lecternInfo", true);
    private static final ModConfigSpec.BooleanValue LIGHTNING_ROD = BUILDER
            .comment("Whether to explain how a Lightning Rod works.")
            .define("lightningRodInfo", false);
    private static final ModConfigSpec.BooleanValue PISTON = BUILDER
            .comment("Whether to explain how a Piston works.")
            .define("pistonInfo", false);
    private static final ModConfigSpec.BooleanValue CHISELED_BOOKSHELF = BUILDER
            .comment("Whether to explain how a Chiseled Bookshelf works.")
            .define("chiseledInfo", true);
    private static final ModConfigSpec.BooleanValue DECORATED_POT = BUILDER
            .comment("Whether to explain how a Decorated Pot works.")
            .define("potInfo", false);
    private static final ModConfigSpec.BooleanValue OBSERVER = BUILDER
            .comment("Whether to explain how an Observer works.")
            .define("observerInfo", true);

    public static final ModConfigSpec SPEC = BUILDER.build();

    public static boolean trialSpawner;
    public static boolean endPortal;
    public static boolean cauldron;
    public static boolean sus;
    public static boolean respawnAnchor;
    public static boolean campfire;
    public static boolean vault;
    public static boolean vault_innate;
    public static boolean scary_vault;
    public static boolean redstoneLamp;
    public static boolean copperBulb;
    public static boolean lectern;
    public static boolean lightning;
    public static boolean piston;
    public static boolean chiseled;
    public static boolean pot;
    public static boolean observer;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        trialSpawner = TRIAL_SPAWNER.get();
        vault = VAULT_BASIC.get();
        scary_vault = OMINOUS_VAULT.get();
        vault_innate = VAULT_INNATE.get();
        campfire = CAMPFIRE.get();
        respawnAnchor = RESPAWN_ANCHOR.get();
        cauldron = CAULDRON.get();
        sus = SUS.get();
        endPortal = END_PORTAL.get();
        redstoneLamp = REDSTONE_LAMP.get();
        copperBulb = COPPER_LAMP.get();
        lectern = LECTERN.get();
        lightning = LIGHTNING_ROD.get();
        piston = PISTON.get();
        chiseled = CHISELED_BOOKSHELF.get();
        pot = DECORATED_POT.get();
        observer = OBSERVER.get();
    }
}