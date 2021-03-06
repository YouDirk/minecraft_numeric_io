/* This file is part of the `youdirk_numeric_io` Minecraft mod
 * Copyright (C) 2019  Dirk "YouDirk" Lehmann
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */


package net.dj_l.youdirk_numeric_io.debug;
import net.dj_l.youdirk_numeric_io.common.*;
import net.dj_l.youdirk_numeric_io.*;

// Server
import net.dj_l.youdirk_numeric_io.server.CommandRegistry;
import net.dj_l.youdirk_numeric_io.server.CommandBase;

// Forge Mod Loader
import net.minecraftforge.fml.common.Mod;

// Event Bus
import net.minecraftforge.eventbus.api.SubscribeEvent;

// Events
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

// Gameplay
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.InventoryPlayer;


/**
 * Implementation of all non-specific debug event handlers fired on
 * <code>FORGE</code> bus.
 *
 * <p><b>This class will only be compiled into DebugMode builds.</b></p>
 */
@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.FORGE)
public abstract class CommonEventsForgeDebug
{
  private static boolean _isLogicalServer(World world)
  {
    return !world.isRemote();
  }

  /* *****************************************************************
   *
   * Putting YoudirkNumericIO blocks and some other initial items into
   * players inventory on JOIN and RESPAWN for all Game-Modes.  So we
   * don't need to Grind&Craft it.
   */
  private static void _setItemToSlot(int slot, Item item,
                                     InventoryPlayer inventory)
  {
    ItemStack
      newStack = new ItemStack(item, item.getItemStackLimit(null)),
      replacedStack = inventory.getStackInSlot(slot);

    inventory.setInventorySlotContents(slot, newStack);

    if (replacedStack.getItem() != item)
      inventory.addItemStackToInventory(replacedStack);
  }

  private static String _getDebugCommands()
  {
    String result = "";

    for (CommandBase cmdBase: CommandRegistry.get()) {
      if (!(cmdBase instanceof CommandDebug)) continue;

      if (!result.equals("")) result += ", ";
      result += cmdBase.toString();
    }

    return result;
  }

  @SubscribeEvent
  public static void
  onPlayerJoin(final EntityJoinWorldEvent event)
  {
    World world = event.getWorld().getWorld();
    if (!_isLogicalServer(world)) return; // Also fired on client side

    Entity entity = event.getEntity();
    if (!(entity instanceof EntityPlayer)) return;

    EntityPlayer player = (EntityPlayer) entity;

    if (player.allowLogging()) {
      player.sendMessage(new TextComponentDebug(_getDebugCommands()));
      player.sendMessage(new TextComponentDebug(
        "Hey %1$s! Here, some gifts in your inventory :)",
        player.getDisplayName().getString()));
    }

    ItemBlockNumericIORegistry registry = ItemBlockNumericIORegistry
      .get();
    int slotNo = 0;
    for (ItemBlockNumericIORegistry.Entry itemEntry: registry) {
      _setItemToSlot(slotNo++, itemEntry.ITEM, player.inventory);
    }

    slotNo = slotNo < 4? 4: slotNo;

    _setItemToSlot(slotNo++,
      net.minecraft.init.Items.DEBUG_STICK,
      player.inventory);
    _setItemToSlot(slotNo++,
      net.minecraft.init.Blocks.REDSTONE_WIRE.asItem(),
      player.inventory);
    _setItemToSlot(slotNo++,
      net.minecraft.init.Blocks.REDSTONE_TORCH.asItem(),
      player.inventory);
    _setItemToSlot(slotNo++,
      net.minecraft.init.Blocks.LEVER.asItem(),
      player.inventory);
    _setItemToSlot(slotNo++,
      net.minecraft.init.Blocks.PISTON.asItem(),
      player.inventory);
    _setItemToSlot(slotNo++,
      net.minecraft.init.Blocks.CRAFTING_TABLE.asItem(),
      player.inventory);
    _setItemToSlot(slotNo++,
      net.minecraft.init.Items.POTION,
      player.inventory);
  }
}
