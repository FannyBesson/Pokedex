package com.example.pokedex;

import org.junit.Test;
import org.assertj.core.api.Assertions;

public class PokemonViewTest {

    @Test
    //Test with the HTTPrequest
    public void generateViewHTTP() {
        //create the appropriate PokemonView instance
        PokemonControllerHTTP pokemonController = new PokemonControllerHTTP();
        PokemonView pokemonView = new PokemonView(pokemonController);
        pokemonView.generateView("1");

        //Tests to be sure that the info we get are the one we wanted
        Assertions.assertThat(pokemonView.getPokemon().getName()).isEqualTo("bulbasaur");
        Assertions.assertThat(pokemonView.getPokemon().getWeight()).isEqualTo(69L);
        Assertions.assertThat(pokemonView.getPokemon().getHeight()).isEqualTo(7L);
        Assertions.assertThat(pokemonView.getPokemon().getDescription()).isEqualTo("");

    }

    @Test
    //Test with the SQL query
    public void generateViewSQLLite() {
        //Create the appropriate PokemonView instance
        PokemonControllerSQLLite pokemonController = new PokemonControllerSQLLite("jdbc:sqlite:/tmp/pokemondatabase.sqlite");
        PokemonView pokemonView = new PokemonView(pokemonController);
        pokemonView.generateView("1");

        //Tests to be sure the info we get are the one we wanted
        Assertions.assertThat(pokemonView.getPokemon().getName()).isEqualTo("Bulbizarre");
        Assertions.assertThat(pokemonView.getPokemon().getWeight()).isEqualTo(69L);
        Assertions.assertThat(pokemonView.getPokemon().getHeight()).isEqualTo(7L);

        //The test on the description return Failed as there is a problem with the accent and the encoding of the text, however, the informations are corrects
        Assertions.assertThat(pokemonView.getPokemon().getDescription()).isEqualTo("Il a une étrange graine plantée sur son dos. Elle grandit avec lui depuis la naissance.");

    }
}

