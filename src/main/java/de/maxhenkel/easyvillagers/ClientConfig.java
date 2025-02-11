package de.maxhenkel.easyvillagers;

import de.maxhenkel.corelib.config.ConfigBase;
import net.minecraftforge.common.ForgeConfigSpec;

public class ClientConfig extends ConfigBase {

    public final ForgeConfigSpec.BooleanValue enableRightClickPickup;
    public final ForgeConfigSpec.DoubleValue villagerVolume;
    public final ForgeConfigSpec.EnumValue<CycleTradesButtonLocation> cycleTradesButtonLocation;
    public final ForgeConfigSpec.BooleanValue renderBlockContents;
    public final ForgeConfigSpec.IntValue blockRenderDistance;

    public ClientConfig(ForgeConfigSpec.Builder builder) {
        super(builder);

        enableRightClickPickup = builder
                .comment("If villagers should be able to be picked up by sneaking and right-clicking")
                .define("villager.sneak_pick_up", true);
        villagerVolume = builder
                .comment("The volume of every villager related sound in this mod")
                .defineInRange("villager.volume", 1D, 0D, 1D);
        cycleTradesButtonLocation = builder
                .comment("The location of the cycle trades button")
                .defineEnum("villager.cycle_trades_button_location", CycleTradesButtonLocation.TOP_LEFT);
        renderBlockContents = builder
                .comment("Disables rendering any contents of the villager blocks when set to false", "Set to false if you have performance issues with the mod")
                .worldRestart()
                .define("villager.render_block_contents", true);
        blockRenderDistance = builder
                .comment("The distance in blocks at which the block contents are rendered", "This has no effect if 'render_block_contents' is disabled")
                .defineInRange("villager.block_render_distance", 32, 1, 256);
    }

    public enum CycleTradesButtonLocation {
        TOP_LEFT, TOP_RIGHT, NONE
    }

}
