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


    private static final ModConfigSpec.BooleanValue TRIDENT = BUILDER
            .comment("Whether to explain how a Trident works.")
            .define("tridentInfo", false);
    private static final ModConfigSpec.BooleanValue MACE = BUILDER
            .comment("Whether to explain how a Mace works.")
            .define("maceInfo", true);
    private static final ModConfigSpec.BooleanValue ONASTICK = BUILDER
            .comment("Whether to explain how Items on a Stick (Carrot, Warped Fungus) work.")
            .define("stickInfo", false);
    private static final ModConfigSpec.BooleanValue TRIAL_KEY = BUILDER
            .comment("Whether to explain how a Trial Key works.")
            .define("trialKeyInfo", true);
    private static final ModConfigSpec.BooleanValue OMINOUS_TRIAL_KEY = BUILDER
            .comment("Whether to explain how an Ominous Trial Key works.")
            .define("ominousTrialKeyInfo", true);
    private static final ModConfigSpec.BooleanValue GOAT_HORN = BUILDER
            .comment("Whether to explain how a Goat Horn works.")
            .define("goatHornInfo", false);
    private static final ModConfigSpec.BooleanValue NAME_TAG = BUILDER
            .comment("Whether to explain how a Name Tag works.")
            .define("nameTagInfo", false);
    private static final ModConfigSpec.BooleanValue BRUSH = BUILDER
            .comment("Whether to explain how a Brush works.")
            .define("brushInfo", true);
    private static final ModConfigSpec.BooleanValue CLOCK = BUILDER
            .comment("Whether to explain how a Clock works.")
            .define("clockInfo", true);
    private static final ModConfigSpec.BooleanValue SPYGLASS = BUILDER
            .comment("Whether to explain how a Spyglass works.")
            .define("spyglassInfo", false);
    private static final ModConfigSpec.BooleanValue MUSIC_DISC = BUILDER
            .comment("Whether to explain how Music Discs work.")
            .define("discInfo", true);
    private static final ModConfigSpec.BooleanValue EYE_OF_ENDER = BUILDER
            .comment("Whether to explain how an Eye of Ender works.")
            .define("eyeInfo", true);
    private static final ModConfigSpec.BooleanValue SADDLE = BUILDER
            .comment("Whether to explain how a Saddle works.")
            .define("saddleInfo", false);
    private static final ModConfigSpec.BooleanValue ELYTRA = BUILDER
            .comment("Whether to explain how an Elytra works.")
            .define("elytraInfo", false);
    private static final ModConfigSpec.BooleanValue WIND_CHARGE = BUILDER
            .comment("Whether to explain how Wind Charges work.")
            .define("windInfo", true);
    private static final ModConfigSpec.BooleanValue ENDER_PEARL = BUILDER
            .comment("Whether to explain how Ender Pearls work.")
            .define("pearlInfo", false);
    private static final ModConfigSpec.BooleanValue MAP = BUILDER
            .comment("Whether to explain how a Map works.")
            .define("mapInfo", false);
    private static final ModConfigSpec.BooleanValue COMPASS = BUILDER
            .comment("Whether to explain how a Compass works.")
            .define("compassInfo", true);
    private static final ModConfigSpec.BooleanValue RECOVERY_COMPASS = BUILDER
            .comment("Whether to explain how a Recovery Compass works.")
            .define("recoveryCompassInfo", true);
    private static final ModConfigSpec.BooleanValue LEAD = BUILDER
            .comment("Whether to explain how a Lead works.")
            .define("leadInfo", false);
    private static final ModConfigSpec.BooleanValue TOTEM = BUILDER
            .comment("Whether to explain how a Totem of Undying works.")
            .define("totemInfo", true);


    private static final ModConfigSpec.BooleanValue SHOW_BLOCKS = BUILDER
            .comment("Whether to show block tooltips.")
            .define("blockTooltip", true);
    private static final ModConfigSpec.BooleanValue SHOW_ITEMS = BUILDER
            .comment("Whether to show item tooltips.")
            .define("itemTooltip", true);


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

    public static boolean stick;
    public static boolean trident;
    public static boolean mace;
    public static boolean trialkey;
    public static boolean horn;
    public static boolean nametag;
    public static boolean brush;
    public static boolean clock;
    public static boolean spyglass;
    public static boolean otrialkey;
    public static boolean disc;
    public static boolean eye;
    public static boolean saddle;
    public static boolean elytra;
    public static boolean wind;
    public static boolean pearl;
    public static boolean map;
    public static boolean compass;
    public static boolean recoverycompass;
    public static boolean lead;
    public static boolean totem;

    public static boolean block;
    public static boolean item;

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

        trident = TRIDENT.get();
        mace = MACE.get();
        stick = ONASTICK.get();
        trialkey = TRIAL_KEY.get();
        otrialkey = OMINOUS_TRIAL_KEY.get();
        horn = GOAT_HORN.get();
        nametag = NAME_TAG.get();
        brush = BRUSH.get();
        clock = CLOCK.get();
        spyglass = SPYGLASS.get();
        disc = MUSIC_DISC.get();
        eye = EYE_OF_ENDER.get();
        saddle = SADDLE.get();
        elytra = ELYTRA.get();
        wind = WIND_CHARGE.get();
        pearl = ENDER_PEARL.get();
        map = MAP.get();
        compass = COMPASS.get();
        recoverycompass = RECOVERY_COMPASS.get();
        lead = LEAD.get();
        totem = TOTEM.get();

        block = SHOW_BLOCKS.get();
        item = SHOW_ITEMS.get();
    }
}