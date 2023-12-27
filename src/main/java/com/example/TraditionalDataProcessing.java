package com.example;

import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

public class TraditionalDataProcessing implements DataProcessing {
    @Override
    public List<String> filterStrings(List<String> input, String filter) {
        List<String> result = new ArrayList<>();
        for (String s : input) {
            if (s.contains(filter)) {
                result.add(s);
            }
        }
        return result;
    }

    @Override
    public Optional<Double> average(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return Optional.empty();
        }

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        double average = (double) sum / numbers.size();
        return Optional.of(average);
    }

    @Override
    public Map<Boolean, List<Integer>> partitionByEvenness(List<Integer> numbers) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for (Integer number : numbers) {
            if (number % 2 == 0) {
               even.add(number);
            }else {
                odd.add(number);
            }
        }
        Map<Boolean, List<Integer>> result = new HashMap<>();
        result.put(true, even);
        result.put(false, odd);

        return result;
    }

    @Override
    public String concatenateStrings(List<String> strings) {

        return String.join("", strings);

    }

    @Override
    public int sumOfSquares(List<Integer> numbers) {
        int sumSquares = 0;

        for ( Integer number : numbers) {
            sumSquares += number * number;
        }
        return sumSquares;

    }

    @Override
    public Map<String, Long> countOccurrences(List<String> strings) {
        Map<String, Long> result = new HashMap<>();
        for (String i : strings) {
            Long j = result.get(i);
            result.put(i, (j == null) ? 1 : j + 1);
        }
        return result;

    }

    @Override
    public List<Integer> sortAndFilterNegatives(List<Integer> numbers) {
        List<Integer> positiveNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (number >= 0) {
                positiveNumbers.add(number);
            }
        }
        Collections.sort(positiveNumbers);
        return positiveNumbers;
    }

    @Override
    public boolean allMatchPositive(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number <= 0) {
                return false;
            }
        }
        return true;

    }

    @Override
    public Optional<String> findFirstLongString(List<String> strings, int threshold) {
        for (String s : strings) {
            if (s.length() > threshold) {
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }
}
