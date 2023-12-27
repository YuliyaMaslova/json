package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class DataProcessingTest {

    final DataProcessing streamProcessor = new StreamDataProcessing();
    final DataProcessing traditionalProcessor = new TraditionalDataProcessing();

    @Test
    public void testFilterStrings() {
        List<String> input = Arrays.asList("apple", "banana", "apricot", "cherry");
        List<String> expected = Arrays.asList("apple", "apricot");



        assertEquals(expected, streamProcessor.filterStrings(input, "ap"));
        assertEquals(expected, traditionalProcessor.filterStrings(input, "ap"));
    }

    @Test
    public void testFilterStringsEmptyList() {
        List<String> input = Collections.emptyList();
        List<String> expected = Collections.emptyList();

        assertEquals(expected, streamProcessor.filterStrings(input, "ap"));
        assertEquals(expected, traditionalProcessor.filterStrings(input, "ap"));
    }

    @Test
    public void testAverage() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Double> expected = Optional.of(3.0);

        assertEquals(expected, streamProcessor.average(numbers));
        assertEquals(expected, traditionalProcessor.average(numbers));
    }

    @Test
    public void testAverageEmptyList() {
        List<Integer> numbers = Collections.emptyList();
        Optional<Double> expected = Optional.empty();

        assertEquals(expected, streamProcessor.average(numbers));
        assertEquals(expected, traditionalProcessor.average(numbers));
    }

    @Test
    public void testPartitionByEvenness() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Map<Boolean, List<Integer>> expected = new HashMap<>();
        expected.put(true, Arrays.asList(2, 4));
        expected.put(false, Arrays.asList(1, 3, 5));

        assertEquals(expected, streamProcessor.partitionByEvenness(numbers));
        assertEquals(expected, traditionalProcessor.partitionByEvenness(numbers));
    }

    @Test
    public void testPartitionByEvennessEmptyList() {
        List<Integer> numbers = Collections.emptyList();
        Map<Boolean, List<Integer>> expected = new HashMap<>();
        expected.put(true, Collections.emptyList());
        expected.put(false, Collections.emptyList());

        assertEquals(expected, streamProcessor.partitionByEvenness(numbers));
        assertEquals(expected, traditionalProcessor.partitionByEvenness(numbers));
    }

    @Test
    public void testConcatenateStrings() {
        List<String> strings = Arrays.asList("Hello", " ", "World", "!");
        String expected = "Hello World!";

        assertEquals(expected, streamProcessor.concatenateStrings(strings));
        assertEquals(expected, traditionalProcessor.concatenateStrings(strings));
    }

    @Test
    public void testConcatenateStringsEmptyList() {
        List<String> strings = Collections.emptyList();
        String expected = "";

        assertEquals(expected, streamProcessor.concatenateStrings(strings));
        assertEquals(expected, traditionalProcessor.concatenateStrings(strings));
    }

    @Test
    public void testSumOfSquares() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        int expected = 14; // 1^2 + 2^2 + 3^2 = 14

        assertEquals(expected, streamProcessor.sumOfSquares(numbers));
        assertEquals(expected, traditionalProcessor.sumOfSquares(numbers));
    }

    @Test
    public void testSumOfSquaresEmptyList() {
        List<Integer> numbers = Collections.emptyList();
        int expected = 0;

        assertEquals(expected, streamProcessor.sumOfSquares(numbers));
        assertEquals(expected, traditionalProcessor.sumOfSquares(numbers));
    }

    @Test
    public void testCountOccurrences() {
        List<String> strings = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "apple");
        Map<String, Long> expected = Map.of("apple", 3L, "banana", 2L, "cherry", 1L);

        assertEquals(expected, streamProcessor.countOccurrences(strings));
        assertEquals(expected, traditionalProcessor.countOccurrences(strings));
    }

    @Test
    public void testCountOccurrencesEmptyList() {
        List<String> strings = Collections.emptyList();
        Map<String, Long> expected = Collections.emptyMap();

        assertEquals(expected, streamProcessor.countOccurrences(strings));
        assertEquals(expected, traditionalProcessor.countOccurrences(strings));
    }

    @Test
    public void testSortAndFilterNegatives() {
        List<Integer> numbers = Arrays.asList(-1, 3, -2, 4, 0);
        List<Integer> expected = Arrays.asList(0, 3, 4);

        assertEquals(expected, streamProcessor.sortAndFilterNegatives(numbers));
        assertEquals(expected, traditionalProcessor.sortAndFilterNegatives(numbers));
    }

    @Test
    public void testSortAndFilterNegativesEmptyList() {
        List<Integer> numbers = Collections.emptyList();
        List<Integer> expected = Collections.emptyList();

        assertEquals(expected, streamProcessor.sortAndFilterNegatives(numbers));
        assertEquals(expected, traditionalProcessor.sortAndFilterNegatives(numbers));
    }

    @Test
    public void testAllMatchPositive() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        assertTrue(streamProcessor.allMatchPositive(numbers));
        assertTrue(traditionalProcessor.allMatchPositive(numbers));

        List<Integer> mixedNumbers = Arrays.asList(-1, 2, 3);
        assertFalse(streamProcessor.allMatchPositive(mixedNumbers));
        assertFalse(traditionalProcessor.allMatchPositive(mixedNumbers));
    }

    @Test
    public void testAllMatchPositiveEmptyList() {
        List<Integer> numbers = Collections.emptyList();
        assertTrue(streamProcessor.allMatchPositive(numbers));
        assertTrue(traditionalProcessor.allMatchPositive(numbers));
    }

    @Test
    public void testFindFirstLongString() {
        List<String> strings = Arrays.asList("hello", "world", "programming", "java");
        Optional<String> expected = Optional.of("programming");

        assertEquals(expected, streamProcessor.findFirstLongString(strings, 10));
        assertEquals(expected, traditionalProcessor.findFirstLongString(strings, 10));
    }

    @Test
    public void testFindFirstLongStringNoMatch() {
        List<String> strings = Arrays.asList("hello", "world", "java");
        Optional<String> expected = Optional.empty();

        assertEquals(expected, streamProcessor.findFirstLongString(strings, 10));
        assertEquals(expected, traditionalProcessor.findFirstLongString(strings, 10));
    }

    @Test
    public void testFindFirstLongStringEmptyList() {
        List<String> strings = Collections.emptyList();
        Optional<String> expected = Optional.empty();

        assertEquals(expected, streamProcessor.findFirstLongString(strings, 10));
        assertEquals(expected, traditionalProcessor.findFirstLongString(strings, 10));
    }

    @Test
    public void testCreateIdToObjectMap() {
        List<MyObject> objects = Arrays.asList(
                new MyObject(1, "Field1"),
                new MyObject(2, "Field2")
        );
        Map<Integer, MyObject> result = streamProcessor.createIdToObjectMap(objects);
        assertEquals(2, result.size());
        assertTrue(result.containsKey(1));
        assertTrue(result.containsKey(2));

        result = traditionalProcessor.createIdToObjectMap(objects);
        assertEquals(2, result.size());
        assertTrue(result.containsKey(1));
        assertTrue(result.containsKey(2));
    }

    @Test
    public void testCreateFieldToObjectListMap() {
        List<MyObject> objects = Arrays.asList(
                new MyObject(1, "Field1"),
                new MyObject(2, "Field1"),
                new MyObject(3, "Field2")
        );
        Map<String, List<MyObject>> result = streamProcessor.createFieldToObjectListMap(objects);
        assertEquals(2, result.size());
        assertEquals(2, result.get("Field1").size());
        assertEquals(1, result.get("Field2").size());

        result = traditionalProcessor.createFieldToObjectListMap(objects);
        assertEquals(2, result.size());
        assertEquals(2, result.get("Field1").size());
        assertEquals(1, result.get("Field2").size());
    }

    @Test
    public void testFindMaxByLength() {
        List<String> strings = Arrays.asList("Hello", "World", "Java", "Stream");
        Optional<String> expected = Optional.of("Stream");

        assertEquals(expected, streamProcessor.findMaxByLength(strings));
        assertEquals(expected, traditionalProcessor.findMaxByLength(strings));
    }

    @Test
    public void testSumOfEvenNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int expected = 12; // 2 + 4 + 6

        assertEquals(expected, streamProcessor.sumOfEvenNumbers(numbers));
        assertEquals(expected, traditionalProcessor.sumOfEvenNumbers(numbers));
    }
}
