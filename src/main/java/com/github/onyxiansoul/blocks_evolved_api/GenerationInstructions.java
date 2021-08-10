package com.github.onyxiansoul.blocks_evolved_api;
import com.github.onyxiansoul.onyxiancoreapi.actionable_system.Actionable;

/**An action that replaces a block in the world*/
public interface GenerationInstructions {

  public Actionable<Integer> getProbability();
    
  public Actionable<Integer> getBound();
  
  public IdentifiableBlockType getTypeToReplace();
  
}
//TODO (OPTATIVO) IDEA: hacer que se puedan hacer tipos de Action|YmlObjects compuestos, es decir que vos pongas el value de una variable y le asignes un nombre, y que el usa el nombre del tipo compuesto lo tenga que ocmpletar?