package com.github.onyxiansoul.blocks_evolved_api;

import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.jetbrains.annotations.Nullable;

/**Any type of cube that can be distinguished & can be applied actions.*/
public interface IdentfiableBlockType  {
  
  /**Gets the block data of this block type
   * Will be null if the block doesn't represent a particular block data.
   */
  public @Nullable BlockData getIdentifiyingBlockData();
  
  /**Gets the material of the custom block type;
   * Will be null if the block doesn't represent a particular material.
  */
 public @Nullable Material getIdentifiyingMaterial();
  
  /**Gets the short that identifies this subtype;
   * It will return null, if the block type doesn't require a short for identification, for example blocks defined exclusively by a material / blockdata.*/
  public @Nullable Short getIdentifiyingSubtype();

}
