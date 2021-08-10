package com.github.onyxiansoul.blocks_evolved_api;

import com.github.onyxiansoul.onyxiancoreapi.identity.Nameable;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface IdentifiableBlockType extends Nameable {
  
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
  
  //The next methods are meant to be used exclusively by plugins that manually handle the placement of Blocks Evolved Custom Block Types.  
  //-------------------------------------------------------------------------------------------------------------------------
  
  /**Gets the block data of the custom block type.
   * Please note this will be null for blocks that are defined exclusively by their subtype & for the block type that represents the 'GLOBAL BLOCK'. It will not be null for blocks that return true to #areWorldChangesNecessary
   * If you are using this data to manually handle block placement, use #areWorldChangesNecessary, and if the result is false, just call @link{#setAdditionalInfo} and consider the block placed, o modification of the world is necessary.
   */
  public @Nullable BlockData getIdentifiyingBlockData();
  
  /**Gets the material of the custom block type; included for sake of completeness but you shouldn't need this.
   * Please note this may be null for blocks that are defined exclusively by their subtype & for the block type that represents the 'GLOBAL BLOCK' It will not be null for blocks that return true to #areWorldChangesNecessary
   * If you are getting this in order to handle block placement, and it is null, you should just call @link{ #setAdditionalInfo} and consider the block placed. No modification of the world is necessary.*/
  public @Nullable Material getIdentifiyingMaterial();
  
  /**Gets the short that identifies this subtype; included for sake of completeness but you shouldn't need this.
   * It will return null, if the block type doesn't require a short for identification, for example blocks defined exclusively by a material / blockdata.*/
  public @Nullable Short getIdentifiyingSubtype();
  
  /** Gets the list of generation instructions of this block type's config. 
   * Used automatically by blocks evolved, to make sure the block type's world generation takes place.
   * Shouldn't be required by external plugins.
  */
  public @NotNull List<GenerationInstructions> getGenerationInstructions();
  
  /**Checks if it'd be necessairy to change the block data of a certain location with a data produced by #getIdentifiyingBlockData in order to place a custom block type
   * It can prevent unnecessairy world modifications and it is HIGHLY suggested that if you are manually handling the placement of the block and you have the block data of the location you call it prior to doing so.
   */
  public @NotNull boolean areWorldChangesNecessairy(BlockData blockDataAtPlacementLocation);
  
  /**Sets any (internal) additional information (required by BlocksEvolved) for a custom block of this type at a location
   * If there is none required, will do nothing.
   * @param location Location where the placement of a block of this type took place.
   * @param blockData The data of the block that was placed. Its only used to verify that the rest of the block matches this custom block type. If null, Blocks Evolved will assume that the block data is of the correct type.
   * @throws IllegalArgumentException If BlockData wasn't null and was different to the expected data. Won't happen if you called {@link BlocksEvolvedAPI#isValidBlockType} when you got this IdentifiableBlockType, and the blockData of this method is the same you used to call #isValidBlockType.
   */
  public void setAdditionalInfo(@NotNull Location location, @Nullable BlockData blockData);

}
