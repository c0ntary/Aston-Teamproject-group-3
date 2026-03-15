package org.example.Data;
import org.example.Entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomData implements Data {

    private static final String[] NAMES = {"Иван", "Петя", "Вася", "Аня", "Оля"};

    @Override
    public List<User> loadData(int count) {
        Random r = new Random();
        List<User> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            list.add(new User.builder()
                    .setName(NAMES[r.nextInt(NAMES.length)])
                    .setEmail(NAMES[r.nextInt(NAMES.length)] + "@mail.ru")
                    .setId(generateRandomId())
                    .build());
        }
        return list;
    }
    private Long generateRandomId() {
        Random r = new Random();
        long min = 1_000_000_000L;   // 10-значный ID
        long max = 9_999_999_999L;
        return min + (long)(r.nextDouble() * (max - min));

    }
}
