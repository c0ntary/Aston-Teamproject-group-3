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
            String inputname;

            while (true) {
                inputname = scanner.nextLine().trim();
                if (inputname.matches("[a-zA-Zа-яА-Я]+")) {
                    break;
                }
                System.out.println("Ошибка: можно вводить только буквы. Попробуйте снова.");
            }
            System.out.print("Введите свой Email: ");
            System.out.println("Введите свой ID:");
            try {
                list.add(new User.builder()
                        .setName(inputname)
                        //.setEmail(inputemail)
                        //.setId(inputeid)
                        .build());
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
                i--;
            }
        }
        return list;
    }
}
