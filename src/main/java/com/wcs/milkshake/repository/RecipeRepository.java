package com.wcs.milkshake.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.wcs.milkshake.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
