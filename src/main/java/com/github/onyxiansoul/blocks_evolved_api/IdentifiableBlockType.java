package com.github.onyxiansoul.blocks_evolved_api;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IdentifiableBlockType {
  
  /**Gets the material of the custom block type. 
   * Please note this may be null for blocks that are defined exclusively by their subtype & for the block type that represents the 'GLOBAL BLOCK'
   * If you are getting this in order to handle block placement, and it is null, you should just call @link{ #setAdditionalInfo} and consider the block placed. No modification of the world is necessary.*/
  public @Nullable Material getIdentifyingMaterial();
  
  /**Gets the block data of the custom block type. 
   * Please note this may be null for blocks that are defined exclusively by their subtype
   * if you are getting this in order to handle block placement, and it is null, you should just call @link{#setAdditionalInfo} and consider the block placed. No modification of the world is necessary.*/
  public @Nullable BlockData getIdentifiyingBlockData();
  
  /**Gets the short that identifies this subtype.
   * It will return null, if the block type doesn't require a short for identification, for example blocks defined exclusively by a material / blockdata.*/
  public @Nullable Short getIdentifiyingSubtype();
   
  /**Gets an items tack capable of placing this block
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
  
  /**Sets any (internal) additional information (required by BlocksEvolved) required for a custom block of this type at a location
   * If there is none required, will do nothing.
   * @param location Location where the placement of a block of this type took place.
   * @param blockData The data of the block that was placed. Its only used to verify that the rest of the block matches this custom block type. If null, Blocks Evolved will assume that the block data is of the correct type.
   * @throws IllegalArgumentException If BlockData wasn't null and was different to the expected data. To prevent the possibility of this exceptions use {@link BlocksEvolvedAPI#isValidBlockType} to prevent exceptions.
   */
  public void setAdditionalInfo(@NotNull Location location, @Nullable BlockData blockData);

}
