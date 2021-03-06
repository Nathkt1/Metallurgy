package rebelkeithy.mods.metallurgy.machines;

import java.io.File;

import net.minecraft.client.Minecraft;
import rebelkeithy.mods.keithyutils.guiregistry.GuiRegistry;
import rebelkeithy.mods.metallurgy.machines.abstractor.ContainerAbstractor;
import rebelkeithy.mods.metallurgy.machines.abstractor.GuiAbstractor;
import rebelkeithy.mods.metallurgy.machines.chests.ContainerPreciousChest;
import rebelkeithy.mods.metallurgy.machines.chests.GuiPreciousChest;
import rebelkeithy.mods.metallurgy.machines.chests.RenderHelperPreciousChest;
import rebelkeithy.mods.metallurgy.machines.chests.TileEntityPreciousChest;
import rebelkeithy.mods.metallurgy.machines.chests.TileEntityPreciousChestRenderer;
import rebelkeithy.mods.metallurgy.machines.crusher.ContainerCrusher;
import rebelkeithy.mods.metallurgy.machines.crusher.CrusherRenderHelper;
import rebelkeithy.mods.metallurgy.machines.crusher.GuiCrusher;
import rebelkeithy.mods.metallurgy.machines.crusher.TileEntityCrusher;
import rebelkeithy.mods.metallurgy.machines.crusher.TileEntityCrusherRenderer;
import rebelkeithy.mods.metallurgy.machines.enchanter.ContainerMetallurgyEnchantment;
import rebelkeithy.mods.metallurgy.machines.enchanter.GuiMetallurgyEnchantment;
import rebelkeithy.mods.metallurgy.machines.enchanter.MetallurgyEnchantmentTableRenderHelper;
import rebelkeithy.mods.metallurgy.machines.enchanter.RenderMetallurgyEnchantmentTable;
import rebelkeithy.mods.metallurgy.machines.enchanter.TileEntityMetallurgyEnchantmentTable;
import rebelkeithy.mods.metallurgy.machines.forge.ContainerNetherForge;
import rebelkeithy.mods.metallurgy.machines.forge.GuiNetherForge;
import rebelkeithy.mods.metallurgy.machines.furnace.ContainerMetalFurnace;
import rebelkeithy.mods.metallurgy.machines.furnace.GuiMetalFurnace;
import rebelkeithy.mods.metallurgy.machines.ladders.BlockMetalLadder;
import rebelkeithy.mods.metallurgy.machines.ladders.LadderRenderer;
import rebelkeithy.mods.metallurgy.machines.lantern.LanternRenderHelper;
import rebelkeithy.mods.metallurgy.machines.lantern.TileEntityLantern;
import rebelkeithy.mods.metallurgy.machines.lantern.TileEntityLanternRenderer;
import rebelkeithy.mods.metallurgy.machines.laser.LaserRenderHelper;
import rebelkeithy.mods.metallurgy.machines.laser.TileEntityLaser;
import rebelkeithy.mods.metallurgy.machines.laser.TileEntityLaserRenderer;
import rebelkeithy.mods.metallurgy.machines.mint.ContainerMintStorage;
import rebelkeithy.mods.metallurgy.machines.mint.GuiMintStorage;
import rebelkeithy.mods.metallurgy.machines.mint.MintRenderHelper;
import rebelkeithy.mods.metallurgy.machines.mint.TileEntityMint;
import rebelkeithy.mods.metallurgy.machines.mint.TileEntityMintRenderer;
import rebelkeithy.mods.metallurgy.machines.pylon.PylonRenderHelper;
import rebelkeithy.mods.metallurgy.machines.pylon.TileEntityPylon;
import rebelkeithy.mods.metallurgy.machines.pylon.TileEntityPylonRenderer;
import rebelkeithy.mods.metallurgy.machines.xptank.ContainerXpTank;
import rebelkeithy.mods.metallurgy.machines.xptank.GuiXpTank;
import rebelkeithy.mods.metallurgy.machines.xptank.orb.EntityXpOrbContainer;
import rebelkeithy.mods.metallurgy.machines.xptank.orb.renderXPOrbContainer;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
    @Override
    public File getMinecraftDir()
    {
        return Minecraft.getMinecraft().mcDataDir;
    }

    @Override
    public void registerGUIs()
    {
        GuiRegistry.registerGuiClient(GuiMetallurgyEnchantment.class, ContainerMetallurgyEnchantment.class, MetallurgyMachines.instance, "Enchanter");
        GuiRegistry.registerGuiClient(GuiMintStorage.class, ContainerMintStorage.class, MetallurgyMachines.instance, "MintStorage");
        GuiRegistry.registerGuiClient(GuiPreciousChest.class, ContainerPreciousChest.class, MetallurgyMachines.instance, "PreciousChest");
        GuiRegistry.registerGuiClient(GuiCrusher.class, ContainerCrusher.class, MetallurgyMachines.instance, "Crusher");
        GuiRegistry.registerGuiClient(GuiMetalFurnace.class, ContainerMetalFurnace.class, MetallurgyMachines.instance, "MetalFurnace");
        GuiRegistry.registerGuiClient(GuiNetherForge.class, ContainerNetherForge.class, MetallurgyMachines.instance, "NetherForge");
        GuiRegistry.registerGuiClient(GuiAbstractor.class, ContainerAbstractor.class, MetallurgyMachines.instance, "Abstractor");
        GuiRegistry.registerGuiClient(GuiXpTank.class, ContainerXpTank.class, MetallurgyMachines.instance, "XpTank");

    }

    @Override
    public void registerTileEntitySpecialRenderer()
    {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrusher.class, new TileEntityCrusherRenderer());
        RenderingRegistry.registerBlockHandler(new CrusherRenderHelper());

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPreciousChest.class, new TileEntityPreciousChestRenderer());
        RenderingRegistry.registerBlockHandler(new RenderHelperPreciousChest());

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMint.class, new TileEntityMintRenderer());
        RenderingRegistry.registerBlockHandler(new MintRenderHelper());

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLantern.class, new TileEntityLanternRenderer());
        RenderingRegistry.registerBlockHandler(new LanternRenderHelper());

        RenderingRegistry.registerBlockHandler(BlockMetalLadder.renderType, new LadderRenderer());

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMetallurgyEnchantmentTable.class, new RenderMetallurgyEnchantmentTable());
        RenderingRegistry.registerBlockHandler(new MetallurgyEnchantmentTableRenderHelper());

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLaser.class, new TileEntityLaserRenderer());
        RenderingRegistry.registerBlockHandler(new LaserRenderHelper());

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPylon.class, new TileEntityPylonRenderer());
        RenderingRegistry.registerBlockHandler(new PylonRenderHelper());

        RenderingRegistry.registerEntityRenderingHandler(EntityXpOrbContainer.class, new renderXPOrbContainer());

    }
}
