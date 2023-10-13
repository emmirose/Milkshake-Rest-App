package com.wcs.milkshake.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wcs.milkshake.entity.Recipe;
import com.wcs.milkshake.repository.RecipeRepository;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

  private final RecipeRepository recipeRepository;

  public RecipeController(RecipeRepository recipeRepository) {
    this.recipeRepository = recipeRepository;
  }

  @GetMapping("")
  public List<Recipe> getRecipes() {
    return recipeRepository.findAll();
  }

  @GetMapping("/{id}")
  public Recipe getRecipe(@PathVariable Long id) {
    Optional<Recipe> recipe = recipeRepository.findById(id);
    if (recipe.isPresent()) {
      return recipe.get();
    } else {
      throw new RuntimeException("Recipe not found with id: " + id);
    }
  }

  @PostMapping("")
  public Recipe createRecipe(@RequestBody Recipe recipe) {
    return recipeRepository.save(recipe);
  }

  @PutMapping("/{id}")
  public Recipe updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
    Optional<Recipe> optionalRecipe = recipeRepository.findById(id);
    if (optionalRecipe.isPresent()) {
      Recipe updatRecipe = optionalRecipe.get();
      updatRecipe.setName(recipe.getName());
      updatRecipe.setQuantity(recipe.getQuantity());
      updatRecipe.setMainIngredient(recipe.getMainIngredient());
      return recipeRepository.save(updatRecipe);
    }
    throw new RuntimeException("Recipe not found with id: " + id);
  }

  @DeleteMapping("/{id}")
  public void deleteRecipe(@PathVariable Long id) {
   Optional<Recipe> optionalRecipe = recipeRepository.findById(id);
    if (optionalRecipe.isPresent()) {
      recipeRepository.deleteById(id);
    } else {
      throw new RuntimeException("Recipe not found with id: " + id);
    }
  }
}
