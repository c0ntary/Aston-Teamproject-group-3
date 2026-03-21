package org.example.Data;

import org.example.Entity.User;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class FileData implements Data {

    private final String filePath;

    public FileData(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<User> loadData(int count) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            return br.lines()
                    .limit(count)
                    .map(this::parseUser)
                    .filter(u -> u != null)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
            return List.of();
        }
    }
    private User parseUser(String line) {
        try {
            String[] parts = line.split(",");
            if (parts.length != 3) return null;
            String name = parts[0].trim();
            String email = parts[1].trim();
            String idStr = parts[2].trim();
            if (!name.matches("[a-zA-Zа-яА-Я]+")) return null;
            if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,6}$")) return null;
            long id = Long.parseLong(idStr);
            return new User.builder()
                    .setName(name)
                    .setEmail(email)
                    .setId(id)
                    .build();
        } catch (Exception e) {
            return null;
        }
    }
}