package org.example.Data;
import org.example.Entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManualData implements Data {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public List<User> loadData(int count) {
        List<User> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {

            System.out.println("Введите имя:");
            String inputName;
            while (true) {
                inputName = scanner.nextLine().trim();
                if (inputName.matches("[a-zA-Zа-яА-Я]+")) break;
                System.out.println("Ошибка: можно вводить только буквы. Попробуйте снова.");
            }

            System.out.println("Введите email:");
            String inputEmail;
            while (true) {
                inputEmail = scanner.nextLine().trim();
                if (inputEmail.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,6}$")) break;
                System.out.println("Ошибка: некорректный email. Попробуйте снова.");
            }

            System.out.println("Введите ID (число):");
            long inputId;
            while (true) {
                String line = scanner.nextLine().trim();
                try {
                    inputId = Long.parseLong(line);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: ID должен быть числом. Попробуйте снова.");
                }
            }
            try {
                list.add(new User.builder()
                        .setName(inputName)
                        .setEmail(inputEmail)
                        .setId(inputId)
                        .build());
            } catch (Exception e) {
                System.out.println("Ошибка создания пользователя: " + e.getMessage());
                i--;
            }
        }
        return list;
    }
}