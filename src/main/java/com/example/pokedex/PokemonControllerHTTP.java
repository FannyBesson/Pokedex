package com.example.pokedex;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class PokemonControllerHTTP implements PokemonController {

    //Constructor
    public PokemonControllerHTTP() {
    }

    @Override
    //getPokemon take a Pokemon pokemon and the id it has in the remote API database,
    //and return the pokemon after having update its variables (name, height, weight
    //to match those of the database
    //It gets information through a HTTP request
    public Pokemon getPokemon(String id, Pokemon pokemon) {

        //execute the Request
        String jsonResponse = "";
        try {

            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet("https://pokeapi.co/api/v2/pokemon/"+id);
            request.addHeader("content-type", "application/json");
            HttpResponse result = httpClient.execute(request);
            jsonResponse = EntityUtils.toString(result.getEntity(), "UTF-8");

            JSONParser parser = new JSONParser();
            Object resultObject = parser.parse(jsonResponse);
            if (resultObject instanceof JSONObject) {
                JSONObject obj = (JSONObject) resultObject;

                //update the pokemon object
                pokemon.setId(id);
                pokemon.setName((String)obj.get("name"));
                pokemon.setHeight((Long)obj.get("height"));
                pokemon.setWeight((Long)obj.get("weight"));

            } else {
                System.err.println("Error, we expected a JSON Object from the API");
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not parse the response given by the API as JSON");
            System.err.println("Response body is :");
            System.err.println(jsonResponse);
            e.printStackTrace();
        }

        return pokemon;
    }

}
