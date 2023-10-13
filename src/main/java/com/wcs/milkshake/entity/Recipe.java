package com.wcs.milkshake.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Recipe {

  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private String mainIngredient;


    public Recipe() {
    }

    public Recipe(String name, int quantity, String mainIngredient) {
      this.name = name;
      this.quantity = quantity;
      this.mainIngredient = mainIngredient;
    }


    public Long getId() {
      return id;
    }

    public String getName() {
      return name;
    }


    public void setName(String name) {
      this.name = name;
    }


    public int getQuantity() {
      return quantity;
    }


    public void setQuantity(int quantity) {
      this.quantity = quantity;
    }


    public String getMainIngredient() {
      return mainIngredient;
    }


    public void setMainIngredient(String mainIngredient) {
      this.mainIngredient = mainIngredient;
    }

}
