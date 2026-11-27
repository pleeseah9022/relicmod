package com.example.relicmod.registry;

import com.example.relicmod.RelicMod;
import com.example.relicmod.entity.AncientGuardian;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(net.minecraftforge.registries.ForgeRegistries.ENTITY_TYPES, RelicMod.MODID);

    public static final RegistryObject<EntityType<AncientGuardian>> ANCIENT_GUARDIAN =
            ENTITIES.register("ancient_guardian", () ->
                    EntityType.Builder.of(AncientGuardian::new, MobCategory.MONSTER)
                            .sized(0.6f, 1.95f)
                            .clientTrackingRange(8)
                            .build("ancient_guardian"));
}
