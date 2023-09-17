package net.liqht.ktmy.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.liqht.ktmy.KTMY;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup KTMY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(KTMY.MOD_ID, "ktmy"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ktmy"))
                    .icon(() -> new ItemStack(ModItems.BUTCHERS_CLEAVER)).entries((displayContext, entries) -> {
                        entries.add(ModItems.BUTCHERS_CLEAVER);
                        entries.add(ModItems.SHARPENING_STONE);


                    }).build());


    public static void registerItemGroups() {
        KTMY.LOGGER.info("Registering Item Groups for " + KTMY.MOD_ID);
    }
}
