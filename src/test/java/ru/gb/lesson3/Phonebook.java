package ru.gb.lesson3;

import java.util.*;

public class Phonebook {
    private Map<String, Set<String>> phonebook = new HashMap<>();

    void add(String name, String phone) {
        Set<String> records = new HashSet<>();
        phonebook.putIfAbsent(name, records);
        records.add(phone);
        phonebook.put(name, records);
    }

    Set<String> get(String name) {
        if (phonebook.containsKey(name)) {
            return phonebook.get(name);
        }
        return Collections.emptySet();
    }
}
