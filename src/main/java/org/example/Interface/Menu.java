package org.example.Interface;

import java.util.*;
import java.io.*;

import org.example.Entity.User;
import org.example.Util.OccurrenceCounter;
import org.example.SortStrategy.*;
import org.example.Data.*;
import org.example.Output.*;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private boolean repeat;
    private List<User> users = new ArrayList<>();

    public void start() {
        while (true) {
            printMainMenu();

            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input == 4) break;

                printNumberOfElements();

                if (!handleMainMenu(input)) continue;
                sortMenuLogic();

                countOccurrencesMenu();
                printWriteToFile();
                saveInToFile(users);
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат числа");
            }
        }
    }

    private void printMainMenu() {
        System.out.println("\nМЕНЮ");
        System.out.println("1. Загрузить данные из файла");
        System.out.println("2. Сгенерировать случайные данные");
        System.out.println("3. Ввести данные вручную");
        System.out.println("4. Выход");
        System.out.println("\nСделайте выбор:");
    }

    private void printNumberOfElements() {
        System.out.println("Введите количество элементов:");
    }

    private void printSortMenu() {
        System.out.println("Выберите сортировку:");
        System.out.println("1. По имени");
        System.out.println("2. По email");
        System.out.println("3. По Id");
        System.out.println("4. По четным ID");// Доп. Задание 1
    }

    private void printWriteToFile() {
        System.out.println("\nЗаписать отсортированный список в файл?");
        System.out.println("1. Да");
        System.out.println("2. Нет");
    }

    private boolean handleMainMenu(int input) {
        Data provider = switch (input) {
            case 1 -> new FileData("src/main/java/org/example/Data/file_data.txt");
            case 2 -> new RandomData();
            case 3 -> new ManualData();
            default -> null;
        };

        if (provider != null) {
            int count = Integer.parseInt(scanner.nextLine());
            users = provider.loadData(count);
            return true;
        } else {
            printNoNumber();
            return false;
        }
    }

    private boolean handleSortMenu(int sortChoice, List<User> users) {
        repeat = false;

        SortContext context = new SortContext();
        switch (sortChoice) {
            case 1 -> context.setStrategy(new NameSortStrategy());
            case 2 -> context.setStrategy(new EmailSortStrategy());
            case 3 -> context.setStrategy(new IdSortStrategy());
            case 4 -> context.setStrategy(new Even_Sort_Id());
        }
        ;
        context.executeSort(users);
       // if (strategy != null) {
         //   strategy.sort(users);

            printSorted(users);

       // } else {
        //printNoNumber();
       //     return true;
        //}
        return repeat;
    }

    private void sortMenuLogic() {
        do {
            printSortMenu();
            int sortChoice = Integer.parseInt(scanner.nextLine());
            repeat = handleSortMenu(sortChoice, users);
        } while (repeat);
    }

    private void printSorted(List<User> users) {
        List<String> lines = formatUsers(users);
        ConsoleOutput data = new ConsoleOutput();
        data.output(lines);
    }

    private void saveInToFile(List<User> users) {
        int printChoice = Integer.parseInt(scanner.nextLine());
        List<String> lines = formatUsers(users);

        if (printChoice == 1) {
            WriteInFile data = new WriteInFile();
            data.output(lines);
        }
    }

    private List<String> formatUsers(List<User> users) {
        List<String> lines = new ArrayList<>();

        for (User user : users) {
            lines.add(user.getName() + " | " + user.getEmail() + " | " + user.getId());
        }
        return lines;
    }

    private void countOccurrencesMenu() {
        System.out.println("\nВведите ID для подсчёта вхождений:");

        try {
            long id = Long.parseLong(scanner.nextLine());
            OccurrenceCounter.countOccurrences(users, id);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: ID должен быть числом");
        }
    }

    private void printNoNumber() {
        System.out.println("Такого значения нет");
        System.out.println("-------------------");
    }

}
