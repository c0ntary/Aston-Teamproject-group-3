package org.example.Util;

import org.example.Entity.User;
import java.util.List;

public class OccurrenceCounter {

    public static void countOccurrences(List<User> list, long id) {
        Thread t = new Thread(() -> {
            long count = list.stream()
                    .filter(u -> u.getId() == id)
                    .count();
            System.out.println("Количество вхождений ID " + id + ": " + count);
        });
        t.start();
    }
}