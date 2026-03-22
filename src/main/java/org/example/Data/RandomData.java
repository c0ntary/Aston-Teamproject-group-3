package org.example.Data;

import org.example.Entity.User;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomData implements Data {

    private static final String[] NAMES = {"Иван", "Петя", "Вася", "Аня", "Оля"};
    private final Random random = new Random();

    @Override
    public List<User> loadData(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new User.builder()
                        .setName(randomName())
                        .setEmail(randomEmail())
                        .setId(randomId())
                        .build())
                .collect(Collectors.toList());
    }
    private String randomName() {
        return NAMES[random.nextInt(NAMES.length)];
    }
    private String randomEmail() {
        return randomName().toLowerCase() + "@mail.ru";
    }
    private long randomId() {
        long min = 1_000_000_000L;
        long max = 9_999_999_999L;
        return min + (long) (random.nextDouble() * (max - min));
    }
}