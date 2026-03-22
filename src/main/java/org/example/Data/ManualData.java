package org.example.Data;

import org.example.Entity.User;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ManualData implements Data {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public List<User> loadData(int count) {
        return Stream.generate(this::readUser)
                .limit(count)
                .collect(Collectors.toList());
    }
    private User readUser() {
        return new User.builder()
                .setName(readName())
                .setEmail(readEmail())
                .setId(readId())
                .build();
    }
    private String readName() {
        System.out.println("Введите имя:");
        while (true) {
            String s = scanner.nextLine().trim();
            if (s.matches("[a-zA-Zа-яА-Я]+")) return s;
            System.out.println("Ошибка: только буквы.");
        }
    }
    private String readEmail() {
        System.out.println("Введите email:");
        while (true) {
            String s = scanner.nextLine().trim();
            if (s.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,6}$")) return s;
            System.out.println("Ошибка: некорректный email.");
        }
    }
    private long readId() {
        System.out.println("Введите ID:");
        while (true) {
            try {
                return Long.parseLong(scanner.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Ошибка: ID должен быть числом.");
            }
        }
    }
}