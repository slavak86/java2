package ru.gb.lesson3;

import java.util.*;


public class Words {
    public static void main(String[] args) {
        String[] words = {
                "Огурец",
                "Помидор",
                "Лук",
                "Чеснок",
                "Морковь",
                "Картофель",
                "Кабачок",
                "Огурец",
                "Баклажан",
                "Лук",
                "Помидор",
                "Чеснок"
        };

        Set<String> wordsSet = new HashSet<>();
        Collections.addAll(wordsSet, words);
        System.out.println(wordsSet);

        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            wordsMap.putIfAbsent(word, 0);
            Integer wordCount = wordsMap.get(word);
            wordsMap.put(word, ++wordCount);
            //wordsMap.computeIfPresent(word, (k, count) -> count + 1);
        }
        System.out.println("Количество вхождений: " + wordsMap);

    }
}
