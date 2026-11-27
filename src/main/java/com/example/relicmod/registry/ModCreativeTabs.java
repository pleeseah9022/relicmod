package com.example.relicmod.registry;

import com.example.relicmod.RelicMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RelicMod.MODID);

    public static final RegistryObject<CreativeModeTab> MAIN = TABS.register("main",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.relicmod"))
                    .icon(() -> ModItems.GUARDIAN_HEART.get().getDefaultInstance())
                    .displayItems((params, output) -> {
                        output.accept(ModItems.GUARDIAN_HEART.get());
                        output.accept(ModItems.ANCIENT_GUARDIAN_SPAWN_EGG.get());
                    })
                    .build());
}
