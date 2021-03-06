package com.github.onyxiansoul.blocks_evolved_api;

import com.github.onyxiansoul.onyxiancoreapi.actions.interpreters.RuntimeSupplier;
import java.util.Set;
import org.bukkit.Location;
import org.bukkit.block.data.BlockData;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**The main place to interact with BlocksEvolved. 
 As a developer, you most likely want to:
 * Add a configuration setting that represents the name of the block type 
 * Verify the configured block type exists
 * Get the identifiable block type (store it in a variable)
 * Use the identifiable block type to either place a custom block at a location, verify the location has a certain block type,  get an item stack of that block type, or check if an item stack is of that type.
 */
public interface BlocksEvolvedApi {
  
  /**Checks if a block type of a certain name exists. If you are handling placement instead of asking the block type to place the block, use isValidBlockType instead.
   * @param customBlockTypeName = the name of the section from which the block was registered.
   * @return true if it exists, or false if it doesn't*/
  @NotNull public boolean isIdentifiableBlockType(@NotNull String customBlockTypeName);
  
  /**Checks if there is a block type called customBlockTypeName, and if that block type is ok to be placed to a block of a certain block data.
   * Should be called by plugins who want to allow BlocksEvolved block types to be placed, but at the same time want to handle the placement of the block.
   * This ensures that user's configuration errors don't lead to inconsistent data on the blocks evolved data base.
   */
  @NotNull public boolean isValidBlockType(@NotNull String customBlockTypeName, BlockData expectedBlockData);
  
  /** Get a previously registered custom block type, from its name & kind.
   * @param customBlockName = the name of the section from which the block was registered.
   * @return the previously registered custom block type.
   * @throws IllegalArgumentException If there is no block of that type.
   */
  @NotNull public IdentifiableBlockType getIdentifiableBlockType(@NotNull String customBlockName) throws IllegalArgumentException;
    
  /**Process a configurationSection and register the customBlockType.
   * @param configSection = the section that defines the blockType. The name of the section will become the name of the Custom_block_Type.
   * The contents of the section will define all block settings.
   * Uses the exact syntax required for any custom block defined within 'CustomBlocks' on the plugin config.
   */
  public void registerCustomBlockType(@NotNull ConfigurationSection configSection);

  /** Get all the block types of a location.
   * @return All the block types of a location. (Global, The type of the material, the type of the state, and any subtypes placed by this block due to metadata).
   */
  @Nullable public Set<IdentifiableBlockType> getBlockTypes(@NotNull Location location);
  
  /**Register a data obtainer, so the plugin can obtain data from another type of the event. The plugin will add an event listener for that kind of event as well!
   * To create a BlockEventDataObtainer, simply implement {@link me.onyxiansoul.blockyapi.BlockEventDataObtainer}. 
   * Make sure to override every method that could yield a value for your event, for example {@link com.github.onyxiansoul.onyxiancoreapi.actions.interpreters.RuntimeSupplier #getTriggerPlayer()}
   * @param dataObtainer = The class implementing BlockEventDataObtainer that allows the plugin to obtain data for the event.
   * @deprecated May be removed or changed.
   */
  @Nullable public void registerEventDataObtainer(RuntimeSupplier dataObtainer);
  
}
