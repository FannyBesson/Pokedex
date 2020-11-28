package com.example.pokedex;

import java.sql.*;

public class PokemonControllerSQLLite implements PokemonController {

    private String url; //

    //Constructor
    public PokemonControllerSQLLite(String url) {
        this.url = url;
    }

    @Override
    //getPokemon take a Pokemon pokemon and the id it has in the database stored in url,
    //and return the pokemon after having update its variables (name, height, weight, description)
    //to match those of the database
    public Pokemon getPokemon(String id, Pokemon pokemon) {
        Connection conn = null;
        try {

            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

            //get the informations once the connection is established, with a query
            PreparedStatement stmt  = conn.prepareStatement("SELECT name, height, weight, description FROM pokemons WHERE id = ?");
            stmt.setInt(1, Integer.parseInt(id));
            ResultSet rs    = stmt.executeQuery();
            rs.next();

            //update the variables of pokemon with the informations collected
            pokemon.setId(id);
            pokemon.setName(rs.getString("name"));
            pokemon.setDescription(rs.getString("description"));
            pokemon.setHeight(rs.getLong("height"));
            pokemon.setWeight(rs.getLong("weight"));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    return pokemon;
    }

    //Getter and Setters

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
