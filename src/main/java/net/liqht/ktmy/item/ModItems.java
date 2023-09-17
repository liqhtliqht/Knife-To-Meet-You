package net.liqht.ktmy.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.liqht.ktmy.KTMY;
import net.liqht.ktmy.item.custom.ButchersCleaver;
import net.liqht.ktmy.item.custom.SharpeningStone;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item BUTCHERS_CLEAVER = registerItem("butchers_cleaver", new ButchersCleaver(new FabricItemSettings().maxCount(1)));
    public static final Item SHARPENING_STONE = registerItem("sharpening_stone", new SharpeningStone(new FabricItemSettings().maxCount(16)
            .maxDamage(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(KTMY.MOD_ID, name), item);
    }

    public static void registerModItems() {
        KTMY.LOGGER.info("Registering Mod Items for " + KTMY.MOD_ID);
    }
}
