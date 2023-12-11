package utils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class GulosoUtils {

    public static int lowestListSum(List<List<Integer>> listOfLists, int fixedInteger) {
        return IntStream.range(0, listOfLists.size())
                .reduce((index1, index2) ->
                        sumList(listOfLists.get(index1), fixedInteger) < sumList(listOfLists.get(index2), fixedInteger) ? index1 : index2)
                .orElse(-1);
    }

    public static int sumList(List<Integer> list, int fixedInteger) {
        return list.stream().mapToInt(i -> i + fixedInteger).sum();
    }

    public static double getAvgOfList(List<? extends Number> list) {
        return list.stream().mapToDouble(Number::doubleValue).average().orElse(0.0);
    }

    public static int findClosestToTarget(List<Integer> numbers, double target) {
        return IntStream.range(0, numbers.size())
                .boxed()
                .min(Comparator.comparingDouble(i -> Math.abs(numbers.get(i) - target)))
                .orElseThrow();
    }

    public static int findShortestListIndex(List<List<Integer>> listOfLists) {
        return IntStream.range(0, listOfLists.size())
                .boxed()
                .min(Comparator.comparingInt(i -> listOfLists.get(i).size()))
                .orElseThrow(); // Throws NoSuchElementException if the list is empty
    }

    public static void printListOfLists(List<List<Integer>> results) {
        for (int i = 0; i < results.size(); i++) {
            System.out.print("[" + i + "]: [");
            for (int j = 0; j < results.get(i).size(); j++) {
                System.out.print(results.get(i).get(j) + ", ");
            }
            System.out.println("]");
        }
    }

}
