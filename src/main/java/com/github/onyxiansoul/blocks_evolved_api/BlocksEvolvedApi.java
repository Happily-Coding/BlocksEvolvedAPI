package com.github.onyxiansoul.blocks_evolved_api;

import java.util.Set;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**The main place to interact with BlocksEvolved. 
 * As a developer, you most likely want to:
  * Add a configuration setting that represents the name of the block type 
  * Verify the configured block type exists
  * Get the identifiable block type (store it in a variable)
  * Use the identifiable block type to either place a custom block at a location, verify the location has a certain block type, get an item stack of that block type, or check if an item stack is of that type.
 * If you need help using the API, or want to let me know you used it so I can let BlocksEvolved users know, contact me at https://www.spigotmc.org/members/onyxiansoul.667504/ or discord: Onyx#2196 (I use spigot more frequently).
 */
public interface BlocksEvolvedApi {
    
  /**Checks if a block evolution of a certain name exists.
   * @param customBlockTypeName = the name of the section from which the block was registered.
   * @return true if it exists, or false if it doesn't*/
  @NotNull public boolean evolutionExists(@NotNull String customBlockTypeName);
  
  /** Get a previously registered custom block type, from its name & kind.
   * @param customBlockName = the name of the section from which the block was registered.
   * @return the previously registered custom block type.
   * @throws IllegalArgumentException If there is no block of that type.
   */
  @NotNull public Evolution getEvolution(@NotNull String customBlockName) throws IllegalArgumentException;

  /** Get all the block types of a location.
   * @return All the block types of a location. (Global, The type of the material, the type of the state, and any subtypes placed by this block due to metadata).
   */
  @Nullable public Set<Evolution> getBlockTypes(@NotNull Location location);
  
  /**Process a configurationSection and register the customBlockType.
   * @param configSection = the section that defines the blockType. The name of the section will become the name of the Custom_block_Type.
   * The contents of the section will define all block settings.
   * Uses the exact syntax required for any custom block defined within 'CustomBlocks' on the plugin config.
   */
  //public void registerCustomBlockType(@NotNull ConfigurationSection configSection);


}
