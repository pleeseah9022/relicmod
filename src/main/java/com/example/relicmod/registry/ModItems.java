package com.example.relicmod.registry;

import com.example.relicmod.RelicMod;
import com.example.relicmod.item.GuardianHeartItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RelicMod.MODID);

    public static final RegistryObject<Item> GUARDIAN_HEART = ITEMS.register("guardian_heart",
            () -> new GuardianHeartItem(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> ANCIENT_GUARDIAN_SPAWN_EGG = ITEMS.register("ancient_guardian_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.ANCIENT_GUARDIAN, 0x6E6E6E, 0x33CCFF, new Item.Properties()));
}
