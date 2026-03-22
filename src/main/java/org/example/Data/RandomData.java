package org.example.Data;

import org.example.Entity.User;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomData implements Data {

    private static final String[] NAMES = {"Иван", "Петя", "Вася", "Аня", "Оля", "Вика"};
    private static final String[] NAMES2 = {"CyberKnight", "MoonlightFox", "NeonStorm", "ShadowWalker", "CrimsonEagle", "PhantomByte"};
    private final Random random = new Random();

    @Override
    public List<User> loadData(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> {
                    String name = randomName();
                    String Name2 = randomName2();
                    String email = Name2.toLowerCase() + random.nextInt(10000) + "@mail.ru";
                    return new User.builder()
                            .setName(name)
                            .setEmail(email)
                            .setId(randomId())
                            .build();
                })
                .collect(Collectors.toList());
    }
    private String randomName() {
        return NAMES[random.nextInt(NAMES.length)];
    }
    private String randomName2() {
        return NAMES2[random.nextInt(NAMES2.length)];
    }
    private long randomId() {
        long min = 1_000_000_000L;
        long max = 9_999_999_999L;
        return min + (long) (random.nextDouble() * (max - min));
    }
}