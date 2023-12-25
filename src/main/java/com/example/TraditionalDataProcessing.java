package com.example;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TraditionalDataProcessing implements DataProcessing {
    @Override
    public List<String> filterStrings(List<String> input, String filter) {
        return null;
    }

    @Override
    public Optional<Double> average(List<Integer> numbers) {
        return Optional.empty();
    }

    @Override
    public Map<Boolean, List<Integer>> partitionByEvenness(List<Integer> numbers) {
        return null;
    }

    @Override
    public String concatenateStrings(List<String> strings) {
        return null;
    }

    @Override
    public int sumOfSquares(List<Integer> numbers) {
        return 0;
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
