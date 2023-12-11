package algoritmos;

import tipos.BruteForce;
import utils.GulosoUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GulosoBalance implements BruteForce {

    /*

    Estrategia Gulosa:

    Tirar a media do conjunto de candidatos e inserir no caminhao
    com a menor quantidade de elementos o numero candidato mais proximo da media
    até que nao sobre mais elementos

     */

    @Override
    public List<List<Integer>> run(List<int[]> routes, int truckQuantity) {

        List<List<Integer>> results = new ArrayList<>();

        for (int i = 0; i < truckQuantity; i++) {
            results.add(new ArrayList<>());
        }

        for (int[] route : routes) {

            List<Integer> workingSet = Arrays.stream(route).boxed().collect(Collectors.toList());

            double listAvg = GulosoUtils.getAvgOfList(workingSet);

            while (!workingSet.isEmpty()) {

                int routeIndex = GulosoUtils.findClosestToTarget(workingSet, listAvg);

                int truckIndex = GulosoUtils.findShortestListIndex(results);

                results.get(truckIndex).add(workingSet.get(routeIndex));

                workingSet.remove(routeIndex);

            }
        }

        return results;
    }
}
