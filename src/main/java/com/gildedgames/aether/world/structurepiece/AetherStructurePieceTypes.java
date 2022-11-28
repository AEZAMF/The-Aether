package com.gildedgames.aether.world.structurepiece;

import com.gildedgames.aether.Aether;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Locale;

public class AetherStructurePieceTypes {
    public static final DeferredRegister<StructurePieceType> STRUCTURE_PIECE_TYPES = DeferredRegister.create(Registry.STRUCTURE_PIECE_REGISTRY, Aether.MODID);

    public static RegistryObject<StructurePieceType> LARGE_AERCLOUD = register("ALC", LargeAercloudPiece::new);
    public static final RegistryObject<StructurePieceType> BRONZE_BOSS_ROOM = register("BBossRoom", BronzeDungeonPieces.BossRoom::new);
    public static final RegistryObject<StructurePieceType> BRONZE_DUNGEON_ROOM = register("BDungeonRoom", BronzeDungeonPieces.DungeonRoom::new);
    public static final RegistryObject<StructurePieceType> BRONZE_TUNNEL = register("BTunnel", BronzeDungeonPieces.HolystoneTunnel::new);
    public static final RegistryObject<StructurePieceType> SILVER_DUNGEON_PIECE = register("SDungeonPiece", SilverDungeonPieces.TemplePiece::new);
    public static final RegistryObject<StructurePieceType> SILVER_BOSS_ROOM = register("SBossRoom", SilverDungeonPieces.BossRoom::new);
    public static final RegistryObject<StructurePieceType> LEGACY_CLOUD_BED = register("LegacyCloudBed", SilverDungeonPieces.LegacyCloudBed::new);
    public static final RegistryObject<StructurePieceType> GOLD_BOSS_ROOM = register("GBossRoom", GoldDungeonPieces.BossRoom::new);
    public static final RegistryObject<StructurePieceType> GOLD_ISLAND = register("GIsland", GoldDungeonPieces.Island::new);

    private static RegistryObject<StructurePieceType> register(String name, StructurePieceType structurePieceType) {
        return STRUCTURE_PIECE_TYPES.register(name.toLowerCase(Locale.ROOT), () -> structurePieceType);
    }
}
