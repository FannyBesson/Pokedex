package com.example.pokedex;

public class PokemonView {
    //View in the MVC model
    //equivalent to a Pokemon view


    private PokemonController pokemonController;
    private Pokemon pokemon;

    //Constructor
    public PokemonView( PokemonController pokemonController) {
        this.pokemonController=pokemonController;
        this.pokemon= new Pokemon("","",null,null,"");
    }

    //generateView take the id of the pokemon we want to show, and show its information as if it was on a pokedex.
    public void generateView(String id){

        //Get the information of the pokemon with the id id from the database
        setPokemon(pokemonController.getPokemon(id,this.pokemon));

        //Show the informations
        System.out.println("=============================");
        System.out.println("Pokemon #"+id);
        System.out.println("Nom : " + pokemon.getName());
        System.out.println("Taille : " + pokemon.getHeight());
        System.out.println("Poids : " + pokemon.getWeight());
        //Add, the description variable of a Pokemon can be empty so we need to make sure it is not before showing it
        if (!pokemon.getDescription().isBlank()){
            System.out.println("Description : " + pokemon.getDescription());
        }
        System.out.println("=============================");
    }

    public PokemonController getPokemonController() {
        return pokemonController;
    }

    public void setPokemonController(PokemonController pokemonController) {
        this.pokemonController = pokemonController;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
}
