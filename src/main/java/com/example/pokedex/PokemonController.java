package com.example.pokedex;

public interface PokemonController {
    //Controller in the MVC model

    //getPokemon take a Pokemon pokemon and the id it has in the database,
    //and return the pokemon after having update its variables
    //to match those of the database
    public Pokemon getPokemon(String id, Pokemon pokemon);

}
