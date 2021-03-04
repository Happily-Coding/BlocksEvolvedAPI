package com.github.onyxiansoul.blocks_evolved_api;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IdentifiableBlockType {
  
  /**Checks if a location contains this block type
   * @param location The location to check
   * @return true if it is, false if its not.*/
  public @NotNull boolean isBlockOfType(Location location);
  
  /**Gets an items tack capable of placing this block
   * @param size The size the item stack should have.
   */
  public @Nullable ItemStack getItemStack(int size);
  
  /**Check if an item stack is capable of placing a block of this type
   * @param itemStack The item stack to check
   * @return true if it is, false if its not.*/
  public @NotNull boolean isPlacer(@NotNull ItemStack itemStack);
  
  /*Sets the block at a location to a custom block**/
  public @Nullable void setBlock(Location location);
  
}
