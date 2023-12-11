import algoritmos.GulosoBalance;
import algoritmos.GulosoFinder;
import tipos.BruteForce;
import utils.GeradorDeProblemas;
import utils.GulosoUtils;

import java.util.*;

public class Main {

    public static int DEFAULT_QTD_CONJUNTO_ROTAS = 10; // 10
    public static int DEFAULT_QTD_CAMINHOES =  3; // 3

    public static void main(String[] args) {

        executeAlgorithms(new GulosoBalance());

    }

    public static void executeAlgorithms(BruteForce bruteForce) {

        // Aumentando de T em T até 10T
//        for (int i = 300; ; i++) {
        for (int i = 1; i <= 10; i++) {

            List<Long> times = new ArrayList<>();

            // Fazendo 10 Testes / Tamanho de Conjunto
            for (int j = 1; j <= 10; j++) {

                long start = System.currentTimeMillis();

                List<int[]> rotasGeradas = gerarRotas(6 * i, DEFAULT_QTD_CONJUNTO_ROTAS);

                guloso(bruteForce, DEFAULT_QTD_CAMINHOES, rotasGeradas);

                long elapsed = System.currentTimeMillis() - start;

                times.add(elapsed);
            }

            double elapsedAvg = GulosoUtils.getAvgOfList(times);

            System.out.println("Para 10 testes de 10 conjuntos candidatos cada um com [" + (6 * i) + "] rotas e uma solução com [" + DEFAULT_QTD_CAMINHOES + "] caminhões a media de tempo de execução foi de: " + elapsedAvg + " ms");
        }

//        System.out.println("Executado para: [" + ROTAS_START_COUNT * currentStep + "] rotas [" + CAMINHOES_START_COUNT + "] caminhões");
    }

    public static void guloso(BruteForce bruteForce, int qtdCaminhoes, List<int[]> rotasGeradas) {
        List<List<Integer>> results = bruteForce.run(rotasGeradas, qtdCaminhoes);

//        System.out.println("Resultado guloso para [" + qtdCaminhoes + "] caminhões: ");

//        GulosoUtils.printListOfLists(results);
    }

    public static List<int[]> gerarRotas(int quantidadeRotas, int quantidadeConjuntos) {
//        System.out.println("Gerando conjuntos base...");

        List<int[]> rotasGeradas = GeradorDeProblemas.geracaoDeRotas(quantidadeRotas, quantidadeConjuntos, 0.5);

//        System.out.println("Conjuntos base gerados!");

//        for (int i = 0; i < rotasGeradas.size(); i++) {
//            System.out.print("[");
//            for (int j = 0; j < rotasGeradas.get(i).length; j++) {
//                System.out.print(rotasGeradas.get(i)[j] + ", ");
//            }
//            System.out.println("]");
//        }

        return rotasGeradas;
    }
}