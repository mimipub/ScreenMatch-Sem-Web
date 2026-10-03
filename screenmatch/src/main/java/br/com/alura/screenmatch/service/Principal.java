package br.com.alura.screenmatch.service;

import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSeries;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.model.Episodios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private final String ENDERECO = "https://omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6585022c";
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversorDados = new ConverteDados();
    private Scanner sc = new Scanner(System.in);

    public void exibirMenu() {

        //Busca de dados apartir do terminal
        System.out.println("Digite o nome da serie");
        var nomeSeriado = sc.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSeriado.replace(" ", "+") + API_KEY);
        var dados = conversorDados.converteDados(json, DadosSeries.class);
        System.out.println(dados);

        //episodios por totalTemporada

        DadosEpisodio dadosEpisodio = conversorDados.converteDados(json, DadosEpisodio.class);
//        System.out.println(dadosEpisodio);

        //Dados Temporada

        List<DadosTemporada> listaTemporadas = new ArrayList<>();
        for (int i = 1; i <= dados.totalTemporada(); i++) {
            json = consumo.obterDados(ENDERECO + nomeSeriado.replace(" ", "+") + "&season=" + i + API_KEY);
            DadosTemporada dadosTemporada = conversorDados.converteDados(json, DadosTemporada.class);
            listaTemporadas.add(dadosTemporada);
        }
        listaTemporadas.forEach(System.out::println);

        listaTemporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.title())));


        // Identificando os top 5 melhores episódios
        // I- Primeiro passo coletar os dados e armazenar numa lista nova
        List<DadosEpisodio> dadosEpisodios = listaTemporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());


        System.out.println("\n Top 5 episódios");
        dadosEpisodios.stream()
                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
                .limit(5)
                .forEach(System.out::println);

        List<Episodios> episodio = listaTemporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .map(d -> new Episodios(d.numero(), d))
                .collect(Collectors.toList());
        episodio.forEach(System.out::println);



//        busca a partir de determinada data
        System.out.println("A partir de qual ano deseja ver os seriados?");
        var ano = sc.nextInt();
        sc.nextLine();

        LocalDate dataLancamento = LocalDate.of(ano, 1, 1);

        DateTimeFormatter fomatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        episodio.stream()
                .filter(e -> e.getDataLancameto().isAfter(dataLancamento) && e.getDataLancameto() != null)
                .forEach(e -> System.out.println(
                       "Temporada: " + e.getTemporada() +
                               "Episodio: " + e.getTitle() +
                               "Data de lançamento" + e.getDataLancameto().format(fomatador)
                ));

    }
}