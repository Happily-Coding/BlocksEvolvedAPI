package com.github.onyxiansoul.blocks_evolved_api;

import com.github.onyxiansoul.onyxiancoreapi.identity.Nameable;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface Evolution extends Nameable, IdentfiableBlockType {
  
  /**Gets an item stack capable of placing this block
   * @param size The size the item stack should have.
   */
  public @Nullable ItemStack getItemStack(int size);
  
  /**Checks if a location contains this block type
   * @param location The location to check
   * @return true if it is, false if its not.*/
  public @NotNull boolean isBlockOfType(Location location);
  
  /**Check if an item stack is capable of placing a block of this type
   * @param itemStack The item stack to check
   * @return true if it is, false if its not.*/
  public @NotNull boolean isPlacer(@NotNull ItemStack itemStack);
  
  /*Sets the block at a location to a custom block**/
  public void setBlock(Location location);
  
  /**Sets additional information,(required by BlocksEvolved) to make a location have this block type. DOES NOT modify the world in any way.
   * If there is none required, will do nothing.
   * @param location Location where the placement of a block of this type took place.
   */
  public void setAdditionalInfo(@NotNull Location location);
  
  /**Checks if it'd be necessairy to change the block data of a certain location with a data produced by #getIdentifiyingBlockData in order to place a custom block type
   * It can prevent unnecessairy world modifications and it is HIGHLY suggested that if you are manually handling the placement of the block and you have the block data of the location you call it prior to doing so.
   */
  public @NotNull boolean areWorldChangesNecessairy(BlockData blockDataAtPlacementLocation);

}
