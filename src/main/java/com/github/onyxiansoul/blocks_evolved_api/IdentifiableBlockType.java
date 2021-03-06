package com.github.onyxiansoul.blocks_evolved_api;

import org.bukkit.Location;
import org.bukkit.block.data.BlockData;
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
  public void setBlock(Location location);
  
  /**Sets any (internal) additional information (required by BlocksEvolved) required for a custom block of this type at a location
   * If there is none required, will do nothing.
   * @param location Location where the placement of a block of this type took place.
   * @param blockData The data of the block that was placed. Its only used to verify that the rest of the block matches this custom block type. If null, Blocks Evolved will assume that the block data is of the correct type.
   * @throws IllegalArgumentException If BlockData wasn't null and was different to the expected data. To prevent the possibility of this exceptions use {@link BlocksEvolvedAPI#isValidBlockType} to prevent exceptions.
   */
  public void setAdditionalInfo(@NotNull Location location, @Nullable BlockData blockData);
  
}
