package com.aether;

import com.aether.biome.AetherBiomes;
import com.aether.client.ClientProxy;
import com.aether.world.AetherDimensions;

import net.minecraft.item.Rarity;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Aether.MODID)
public class Aether {

	public static final String MODID = "aether";
	
	private static CommonProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);;
	
	public Aether() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.register(proxy);
		AetherDimensions.DIMENSIONS.register(modEventBus);
		AetherBiomes.BIOMES.register(modEventBus);		
	}
	
	public static final Rarity AETHER_LOOT = Rarity.create("AETHER_LOOT", TextFormatting.GREEN);
	
}
