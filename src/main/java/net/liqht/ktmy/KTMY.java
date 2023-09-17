package net.liqht.ktmy;

import net.fabricmc.api.ModInitializer;

import net.liqht.ktmy.item.ModItemGroups;
import net.liqht.ktmy.item.ModItems;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KTMY implements ModInitializer {
	public static final String MOD_ID = "ktmy";
    public static final Logger LOGGER = LoggerFactory.getLogger("ktmy");
	public static final Identifier BUTCHERS_CLEAVER_SOUND_ID = new Identifier("ktmy:butchers_cleaver");
	public static SoundEvent BUTCHERS_CLEAVER_SOUND_EVENT = SoundEvent.of(BUTCHERS_CLEAVER_SOUND_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();

		Registry.register(Registries.SOUND_EVENT, KTMY.BUTCHERS_CLEAVER_SOUND_ID, BUTCHERS_CLEAVER_SOUND_EVENT);
	}
}