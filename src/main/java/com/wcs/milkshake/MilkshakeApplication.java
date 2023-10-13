package com.wcs.milkshake;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.wcs.milkshake.entity.Recipe;
import com.wcs.milkshake.entity.Vendor;
import com.wcs.milkshake.repository.RecipeRepository;
import com.wcs.milkshake.repository.VendorRepository;

@SpringBootApplication
public class MilkshakeApplication {

  private RecipeRepository recipeRepository;
  private VendorRepository vendorRepository;

  public MilkshakeApplication(RecipeRepository recipeRepository, VendorRepository vendorRepository) {
    this.recipeRepository = recipeRepository;
    this.vendorRepository = vendorRepository;
  }

	public static void main(String[] args) {
		SpringApplication.run(MilkshakeApplication.class, args);
	}

  @Bean
  public CommandLineRunner run() throws Exception {
    return (String[] args) -> {

      recipeRepository.save(new Recipe("Rainbow", 15, "Banana"));
      recipeRepository.save(new Recipe("Hula Hoop", 1, "Cherry"));
      recipeRepository.save(new Recipe("Muddy Blues", 7, "Chocolate"));
      recipeRepository.save(new Recipe("Snow White", 1, "Vanilla"));
      vendorRepository.save(new Vendor("Mike", 25));
      vendorRepository.save(new Vendor("Isabella", 30));
    };
  }

}
