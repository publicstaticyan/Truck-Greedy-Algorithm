package algoritmos;

import tipos.BruteForce;
import utils.GulosoUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GulosoFinder implements BruteForce {

    /*

    Estrategia Gulosa:

    Esse algoritmo ao invés de escolher candidatos do conjunto base por algum critério,
    é escolhido o caminhão que possuir a menor soma de rotas

     */

    @Override
    public List<List<Integer>> run(List<int[]> routes, int truckQuantity) {

        List<List<Integer>> results = new ArrayList<>();

        for (int i = 0; i < truckQuantity; i++) {
            results.add(new ArrayList<>());
        }

        for (int[] conjuntoRotas : routes) {

            List<Integer> workingSet = Arrays.stream(conjuntoRotas.clone()).boxed().collect(Collectors.toList());

            while (!workingSet.isEmpty()) {

                // Acha o indice da lista com menor soma de conjuntos
                int index = GulosoUtils.lowestListSum(results, workingSet.get(0));

                // Adicina na lista
                results.get(index).add(workingSet.get(0));

                // Remove do conjunto de trabalho
                workingSet.remove(0);
            }
        }
        return results;
    }
}
