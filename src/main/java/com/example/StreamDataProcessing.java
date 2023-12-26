package com.example;

import java.util.*;
import java.util.stream.Collectors;

public class StreamDataProcessing implements DataProcessing {
    @Override
    public List<String> filterStrings(List<String> input, String filter) {
        return input.stream()
                .filter(s -> s.contains(filter))
                .collect(Collectors.toList());

    }

    @Override
    public Optional<Double> average(List<Integer> numbers) {
        OptionalDouble average = numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average();

        return average.isPresent() ? Optional.of(average.getAsDouble()) : Optional.empty();

    }

    @Override
    public Map<Boolean, List<Integer>> partitionByEvenness(List<Integer> numbers) {

        return numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
    }

    @Override
    public String concatenateStrings(List<String> strings) {

        return strings.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }

    @Override
    public int sumOfSquares(List<Integer> numbers) {

        return numbers.stream()
                .mapToInt(n -> n * n)
                .sum();
    }

    @Override
    public Map<String, Long> countOccurrences(List<String> strings) {
        return null;
    }

    @Override
    public List<Integer> sortAndFilterNegatives(List<Integer> numbers) {
        return null;
    }

    @Override
    public boolean allMatchPositive(List<Integer> numbers) {
        return false;
    }

    @Override
    public Optional<String> findFirstLongString(List<String> strings, int threshold) {
        return Optional.empty();
    }
}
