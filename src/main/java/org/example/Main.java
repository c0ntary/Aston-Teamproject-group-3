package org.example;

import org.example.SortStrategy.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

//TIP Чтобы <b>запустить</b> код, нажмите <shortcut actionId="Run"/> или
// нажмите на значок <icon src="AllIcons.Actions.Execute"/> в поле.
public class Main {
    static void main() {
        User vadik = new User("Vadim", "bsdqw", "bsdsad@mail.ru");
        User katysha = new User("Katysha", "aasdsad","aasd@mail.ru");
        List<User> users = new ArrayList<>();
        users.add(vadik);
        users.add(katysha);
        for (User user : users) {
            System.out.printf("Имя: %s, Пароль: %s Почта: %s%n", user.getName(), user.getPassword(), user.getEmail());
        }
        System.out.println("Сортируем по паролю");
        SortContext sortContext = new SortContext();
        sortContext.setStrategy(new PasswordSortStrategy());
        sortContext.executeSort(users);


        for (User user : users) {
            System.out.printf("Имя: %s, Пароль: %s Почта: %s%n", user.getName(), user.getPassword(), user.getEmail());
        }
        System.out.println("Сортируем по имени");
        sortContext.setStrategy(new NameSortStrategy());
        sortContext.executeSort(users);

        for (User user : users) {
            System.out.printf("Имя: %s, Пароль: %s Почта: %s%n", user.getName(), user.getPassword(), user.getEmail());
        }
        System.out.println("Сортируем по почте");
        sortContext.setStrategy(new EmailSortStrategy());
        sortContext.executeSort(users);

        for (User user : users) {
            System.out.printf("Имя: %s, Пароль: %s Почта: %s%n", user.getName(), user.getPassword(), user.getEmail());
        }


    }
}
