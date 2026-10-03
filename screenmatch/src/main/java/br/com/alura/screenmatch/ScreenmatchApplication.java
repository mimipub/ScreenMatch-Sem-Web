package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSeries;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import br.com.alura.screenmatch.service.Principal;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScreenmatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        Principal principal = new Principal();
        principal.exibirMenu();


//        Dados Episodio
//        DadosEpisodio dadosEpisodio = conversorDados.converteDados(json, DadosEpisodio.class);
//        System.out.println(dadosEpisodio);
//
//        //Dados Temporada
//
//		List<DadosTemporada> listaTemporadas = new ArrayList<>();
//        for (int i = 1; i <= dadosEpisodio.totalTemporada(); i++) {
//            json = consumoApi.obterDados("https://omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=6585022c");
//            DadosTemporada dadosTemporada = conversorDados.converteDados(json, DadosTemporada.class);
//			listaTemporadas.add(dadosTemporada);
//        }
//		listaTemporadas.forEach(System.out::println);
    }
}