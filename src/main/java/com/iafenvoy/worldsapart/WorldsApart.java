package com.iafenvoy.worldsapart;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(WorldsApart.MOD_ID)
public class WorldsApart {
    public static final String MOD_ID = "worlds_apart";
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final RegistryObject<Item> KRISTA_SWORD = ITEMS.register("krista_sword", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> KRISTA_SWORD_ACTIVE = ITEMS.register("krista_sword_active", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VAREK_SWORD = ITEMS.register("varek_sword", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VAREK_SWORD_ACTIVE = ITEMS.register("varek_sword_active", () -> new Item(new Item.Properties()));

    public static final RegistryObject<CreativeModeTab> MAIN = CREATIVE_MODE_TABS.register("main", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(KRISTA_SWORD.get()))
            .displayItems((parameters, output) -> {
                output.accept(KRISTA_SWORD.get());
                output.accept(KRISTA_SWORD_ACTIVE.get());
                output.accept(VAREK_SWORD.get());
                output.accept(VAREK_SWORD_ACTIVE.get());
            }).build());

    public WorldsApart() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
        CREATIVE_MODE_TABS.register(bus);
    }
}
