package com.example.relicmod;

import com.example.relicmod.registry.ModCreativeTabs;
import com.example.relicmod.registry.ModEntities;
import com.example.relicmod.registry.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(RelicMod.MODID)
public class RelicMod {
    public static final String MODID = "relicmod";

    public RelicMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(bus);
        ModEntities.ENTITIES.register(bus);
        ModCreativeTabs.TABS.register(bus);
    }
}
