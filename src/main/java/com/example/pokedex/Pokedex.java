package com.example.pokedex;


import org.apache.commons.lang3.StringUtils;;

public class Pokedex {

    public static void main(String[] args) {

        //The argument are either a number or the url of the database stored localy.
        //The code go through all the arguments as there can be more than one pokemon asked to be shown
        for (int i=0; i<args.length; i++) {

            //Verify if args[i] can be the id of one pokemon, need to be sure it is numeric
            if (StringUtils.isNumeric(args[i])) {

                //to know if the user is asking to use a local database,
                // verify that the argument after args[i] is not the id of another pokemon
                if (i + 1 < args.length && !StringUtils.isNumeric(args[i + 1])) {
                    //the user is asking to use a local database, there will be a SQL query
                    //create the appropriate controller class
                    PokemonControllerSQLLite pokeSQLITE = new PokemonControllerSQLLite("jdbc:sqlite:"+args[i + 1]);
                    PokemonView pokemonView = new PokemonView(pokeSQLITE);
                    pokemonView.generateView(args[i]);
                }

                else {
                    //the user is asking to use the API, there will be a HTTP request
                    //create the appropriate controller class
                    PokemonControllerHTTP pokeHTTP = new PokemonControllerHTTP();
                    PokemonView pokemonView = new PokemonView(pokeHTTP);
                    pokemonView.generateView(args[i]);
                }
            }
        }
    }

    public String getName() {
        return "Hello";
    }
}
