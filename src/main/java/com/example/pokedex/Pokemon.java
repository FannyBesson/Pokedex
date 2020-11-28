package com.example.pokedex;

public class Pokemon {
    //This class is to model the data of a Pokemon
    //Model in the MVC model

    private String id;
    private String name;
    private Long weight;
    private Long height;
    private String description;

    //Constructors
    public Pokemon(String id, String name, Long weight, Long height) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    public Pokemon(String id, String name, Long weight, Long height, String description) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.description = description;
    }

    //Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
