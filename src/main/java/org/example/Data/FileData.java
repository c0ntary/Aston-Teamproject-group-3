package org.example.Data;
import org.example.Entity.User;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileData implements Data {

    private final String filePath;

    public FileData(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<User> loadData(int count) {
        List<User> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null && list.size() < count) {
                String[] parts = line.split(",");
                if (parts.length != 3) continue;

                String name = parts[0].trim();
                String email = parts[1].trim();
                long id = Long.parseLong(parts[2].trim());

                list.add(new User.builder()
                        .setName(name)
                        .setEmail(email)
                        .setId(id)
                        .build());
            }
        } catch (Exception e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
        return list;
    }
}
