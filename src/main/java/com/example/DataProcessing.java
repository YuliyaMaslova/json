package com.example;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Интерфейс для обработки коллекций данных.
 */
public interface DataProcessing {

    /**
     * Фильтрует строки в списке, оставляя только те, которые содержат заданный фрагмент текста.
     *
     * @param input Список строк для фильтрации.
     * @param filter Фильтрующий текст.
     * @return Отфильтрованный список строк.
     */
    List<String> filterStrings(List<String> input, String filter);

    /**
     * Вычисляет среднее значение из списка целых чисел.
     *
     * @param numbers Список целых чисел.
     * @return Среднее значение или пустой Optional, если список пуст.
     */
    Optional<Double> average(List<Integer> numbers);

    /**
     * Разделяет список чисел на четные и нечетные.
     *
     * @param numbers Список целых чисел для разделения.
     * @return Map, где ключ true соответствует списку четных чисел, а false - нечетным.
     */
    Map<Boolean, List<Integer>> partitionByEvenness(List<Integer> numbers);

    /**
     * Конкатенирует строки из списка в одну строку.
     *
     * @param strings Список строк для конкатенации.
     * @return Результирующая сконкатенированная строка.
     */
    String concatenateStrings(List<String> strings);

    /**
     * Вычисляет сумму квадратов чисел в списке.
     *
     * @param numbers Список целых чисел.
     * @return Сумма квадратов чисел.
     */
    int sumOfSquares(List<Integer> numbers);

    /**
     * Подсчитывает количество вхождений каждой строки в списке.
     *
     * @param strings Список строк.
     * @return Map, где ключ - это строка, а значение - количество её вхождений в список.
     */
    Map<String, Long> countOccurrences(List<String> strings);

    /**
     * Сортирует список чисел и удаляет отрицательные значения.
     *
     * @param numbers Список целых чисел для обработки.
     * @return Отсортированный список положительных чисел.
     */
    List<Integer> sortAndFilterNegatives(List<Integer> numbers);

    /**
     * Проверяет, все ли числа в списке положительные.
     *
     * @param numbers Список целых чисел для проверки.
     * @return true, если все числа положительные, иначе false.
     */
    boolean allMatchPositive(List<Integer> numbers);

    /**
     * Возвращает первую строку из списка, длина которой превышает заданный порог.
     *
     * @param strings Список строк для поиска.
     * @param threshold Порог длины строки.
     * @return Первая строка, длина которой превышает порог, или пустой Optional, если такой строки нет.
     */
    Optional<String> findFirstLongString(List<String> strings, int threshold);

    /**
     * Создает карту, в которой ключом является id объекта, а значением - сам объект.
     *
     * @param objects Список объектов для обработки.
     * @return Карта с id объектов в качестве ключей и объектами в качестве значений.
     */
    Map<Integer, MyObject> createIdToObjectMap(List<MyObject> objects);

    /**
     * Создает карту, в которой ключом является поле объекта, а значением - список объектов с этим полем.
     *
     * @param objects Список объектов для обработки.
     * @return Карта, группирующая объекты по значению их поля.
     */
    Map<String, List<MyObject>> createFieldToObjectListMap(List<MyObject> objects);
}

