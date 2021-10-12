package controlador;

import dao.PokemonD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.Data;
import modelo.PokemonM;

@Data
@Named(value = "pokemonC")
@SessionScoped
public class PokemonC implements Serializable {

    private PokemonD dao = new PokemonD();
//    private PokemonD dao1;
//    private List<PokemonM> listarPokemon = new ArrayList<>();
    private List<PokemonM> listarPokemon1;

    
    @PostConstruct
    public void init() {
        try {
             listar();
        } catch (Exception e) {
        }
    }

    public void listar() throws MalformedURLException {
        try {
            listarPokemon1 = dao.listarPokemon();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

//    public static void main(String[] args) throws MalformedURLException {
//        List<PokemonM> listarPokemon1;
//        PokemonD dao1 = new PokemonD();
//        try {
//            listarPokemon1 = dao1.listarPokemon();
//            for (int i = 0; i < listarPokemon1.size(); i++) {
//                System.out.println(listarPokemon1.get(i).getNombrePokemon());
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }

}
