package com.example;

import org.apache.el.stream.Stream;

import java.awt.event.ItemEvent;
import java.io.File;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
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

        return strings.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    }

    @Override
    public List<Integer> sortAndFilterNegatives(List<Integer> numbers) {
        return numbers.stream()
                .filter(s -> s >= 0)
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public boolean allMatchPositive(List<Integer> numbers) {

        return numbers.stream()
                .allMatch(integer -> integer > 0);
    }

    @Override
    public Optional<String> findFirstLongString(List<String> strings, int threshold) {
        return strings.stream()
                .filter(s -> s.length() > threshold)
                .findFirst();

    }

    @Override
    public Map<Integer, MyObject> createIdToObjectMap(List<MyObject> objects) {

        return objects.stream()
                .collect(Collectors.toMap(MyObject::getId, e -> e));
    }

    @Override
    public Map<String, List<MyObject>> createFieldToObjectListMap(List<MyObject> objects) {
        return objects.stream()
                .collect(Collectors.groupingBy(MyObject::getField));

    }


    @Override
    public Optional<String> findMaxByLength(List<String> strings) {
        return strings.stream()
                .max(Comparator.comparing(String::length));
    }


    @Override
    public int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
