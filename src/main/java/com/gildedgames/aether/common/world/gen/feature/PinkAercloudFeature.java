package com.gildedgames.aether.common.world.gen.feature;

import com.gildedgames.aether.common.block.state.properties.AetherBlockStateProperties;
import com.gildedgames.aether.common.registry.AetherBlocks;
import com.gildedgames.aether.core.AetherConfig;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.Random;

public class PinkAercloudFeature extends Feature<NoneFeatureConfiguration>
{
    public PinkAercloudFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        BlockPos pos = context.origin();
        WorldGenLevel reader = context.level();
        Random rand = context.random();
        if (AetherConfig.COMMON.generate_pink_aerclouds.get()) {
            BlockPos origin = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
            BlockPos position = new BlockPos(origin.getX() + 8, origin.getY(), origin.getZ() + 8);

            for (int amount = 0; amount < 1; ++amount) {
                int xOffset = rand.nextInt(2);
                int yOffset = (rand.nextBoolean() ? rand.nextInt(3) - 1 : 0);
                int zOffset = rand.nextInt(2);

                position = position.offset(xOffset, yOffset, zOffset);

                for (int x = position.getX(); x < position.getX() + rand.nextInt(2) + 3; ++x) {
                    for (int y = position.getY(); y < position.getY() + rand.nextInt(1) + 2; ++y) {
                        for (int z = position.getZ(); z < position.getZ() + rand.nextInt(2) + 3; ++z) {
                            BlockPos newPosition = new BlockPos(x, y, z);

                            if (reader.isEmptyBlock(newPosition)) {
                                if (Math.abs(x - position.getX()) + Math.abs(y - position.getY()) + Math.abs(z - position.getZ()) < 4 + rand.nextInt(2)) {
                                    this.setBlock(reader, newPosition, AetherBlocks.PINK_AERCLOUD.get().defaultBlockState().setValue(AetherBlockStateProperties.DOUBLE_DROPS, true));
                                }
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
