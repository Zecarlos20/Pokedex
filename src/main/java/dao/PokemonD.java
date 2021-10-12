package dao;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import modelo.PokemonM;

public class PokemonD {

    public static void main(String[] args) {
        List<PokemonM> lstPokemon;
        try {
            PokemonD dao = new PokemonD();
            lstPokemon = dao.listarPokemon();
            for (int i = 0; i < lstPokemon.size(); i++) {
                System.out.println("Especie Pokemon : " + (i + 1) + " - " + lstPokemon.get(i).getNombrePokemon());
            }
        } catch (Exception e) {
        }

    }

    public List<PokemonM> listarPokemon() throws MalformedURLException, IOException {
        JsonParser parser = new JsonParser();
        List<PokemonM> listaPokemon = null;
        try {
            URL url = new URL("https://pokeapi.co/api/v2/pokemon-species");
            URLConnection request = url.openConnection();
            JsonObject jsonObject = (JsonObject) parser.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonArray jsonArray = (JsonArray) jsonObject.get("results");//JsoArray -> HACE REFERENCIA AL NOMBRE Y VALOR DEL FILE JSON
            listaPokemon = new ArrayList();
            for (int i = 0; i < jsonArray.size(); i++) {
                PokemonM pokemonM = new PokemonM();
                JsonObject jsonObject1 = (JsonObject) jsonArray.get(i);
                pokemonM.setNombrePokemon(jsonObject1.get("name").getAsString());
//                pokemonM.setUrlPokemon(jsonObject1.get("url").getAsString());
                listaPokemon.add(pokemonM);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaPokemon;
    }
}
