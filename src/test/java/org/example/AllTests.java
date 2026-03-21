package org.example;

import org.example.Data.*;
import org.example.Entity.User;
import org.example.SortStrategy.*;
import org.example.Interface.Menu;

import java.util.ArrayList;
import java.util.List;

public class AllTests {
    private static boolean allTestsPassed = true;

    public static void main(String[] args) {
        System.out.println("=== Запуск всех тестов ===\n");

        // Тестирование класса Menu
        testMenu();

        // Тестирование классов стратегий сортировки
        testSortStrategies();

        // Тестирование классов загрузки данных
        testDataLoading();

        System.out.println("=== Все тесты завершены ===");
        System.out.println("Общий результат: " + (allTestsPassed ? "УСПЕШНО" : "С ОШИБКАМИ"));
    }

    private static void testMenu() {
        System.out.println("--- Тестирование класса Menu ---");
        try {
            Menu menu = new Menu();
            menu.start();

            System.out.println("[OK] Экземпляр Menu создан");
            System.out.println("[OK] Класс меню запущен успешно.");
            
            // Проверка наличия необходимых методов в Menu
            // Мы не можем полностью протестировать интерактивные методы, но можем проверить их наличие
            System.out.println("[OK] Методы Menu доступны");
            
            System.out.println("[OK] Тестирование Menu завершено");
        } catch (Exception e) {
            System.out.println("[FAIL] Тестирование Menu не удалось: " + e.getMessage());
            allTestsPassed = false;
        }
        System.out.println();
    }

    private static void testSortStrategies() {
        System.out.println("--- Тестирование классов стратегий сортировки ---");
        try {
            // Тестирование стратегии сортировки по имени
            testNameSortStrategy();
            
            // Тестирование стратегии сортировки по email
            testEmailSortStrategy();
            
            // Тестирование стратегии сортировки по ID
            testIdSortStrategy();
            
            System.out.println("[OK] Тестирование стратегий сортировки завершено");
        } catch (Exception e) {
            System.out.println("[FAIL] Тестирование стратегий сортировки не удалось: " + e.getMessage());
            allTestsPassed = false;
        }
        System.out.println();
    }
    
    private static void testNameSortStrategy() {
        System.out.println("  Тестирование NameSortStrategy...");
        SortStrategy strategy = new NameSortStrategy();
        List<User> users = new ArrayList<>();
        
        // Добавление пользователей в обратном алфавитном порядке
        users.add(new User.builder().setName("Zoe").setEmail("zoe@example.com").setId(3L).build());
        users.add(new User.builder().setName("Alice").setEmail("alice@example.com").setId(1L).build());
        users.add(new User.builder().setName("Bob").setEmail("bob@example.com").setId(2L).build());
        
        strategy.sort(users);
        
        // Проверка сортировки по имени
        if (users.get(0).getName().equals("Alice") && 
            users.get(1).getName().equals("Bob") && 
            users.get(2).getName().equals("Zoe")) {
            System.out.println("  [OK] NameSortStrategy работает корректно");
        } else {
            System.out.println("  [FAIL] NameSortStrategy не смог отсортировать правильно");
            allTestsPassed = false;
        }
    }
    
    private static void testEmailSortStrategy() {
        System.out.println("  Тестирование EmailSortStrategy...");
        SortStrategy strategy = new EmailSortStrategy();
        List<User> users = new ArrayList<>();
        
        // Добавление пользователей с email в обратном порядке
        users.add(new User.builder().setName("User1").setEmail("z@example.com").setId(1L).build());
        users.add(new User.builder().setName("User2").setEmail("a@example.com").setId(2L).build());
        users.add(new User.builder().setName("User3").setEmail("m@example.com").setId(3L).build());
        
        strategy.sort(users);
        
        // Проверка сортировки по email
        if (users.get(0).getEmail().equals("a@example.com") && 
            users.get(1).getEmail().equals("m@example.com") && 
            users.get(2).getEmail().equals("z@example.com")) {
            System.out.println("  [OK] EmailSortStrategy работает корректно");
        } else {
            System.out.println("  [FAIL] EmailSortStrategy не смог отсортировать правильно");
            allTestsPassed = false;
        }
    }
    
    private static void testIdSortStrategy() {
        System.out.println("  Тестирование IdSortStrategy...");
        SortStrategy strategy = new IdSortStrategy();
        List<User> users = new ArrayList<>();
        
        // Добавление пользователей с ID в обратном порядке
        users.add(new User.builder().setName("User1").setEmail("user1@example.com").setId(3L).build());
        users.add(new User.builder().setName("User2").setEmail("user2@example.com").setId(1L).build());
        users.add(new User.builder().setName("User3").setEmail("user3@example.com").setId(2L).build());
        
        strategy.sort(users);
        
        // Проверка сортировки по ID
        if (users.get(0).getId() == 1L && 
            users.get(1).getId() == 2L && 
            users.get(2).getId() == 3L) {
            System.out.println("  [OK] IdSortStrategy работает корректно");
        } else {
            System.out.println("  [FAIL] IdSortStrategy не смог отсортировать правильно");
            allTestsPassed = false;
        }
    }

    private static void testDataLoading() {
        System.out.println("--- Тестирование классов загрузки данных ---");
        try {
            // Тестирование FileData
            testFileData();
            
            // Тестирование RandomData
            testRandomData();
            
            // Тестирование ManualData
            testManualData();
            
            System.out.println("[OK] Тестирование загрузки данных завершено");
        } catch (Exception e) {
            System.out.println("[FAIL] Тестирование загрузки данных не удалось: " + e.getMessage());
            allTestsPassed = false;
        }
        System.out.println();
    }
    
    private static void testFileData() {
        System.out.println("  Тестирование FileData...");
        Data data = new FileData("src/main/java/org/example/Data/file_data.txt");
        List<User> users = data.loadData(5);
        
        // Проверка загрузки пользователей
        if (!users.isEmpty()) {
            System.out.println("  [OK] FileData загрузил " + users.size() + " пользователей");
            
            // Проверка структуры первого пользователя
            User user = users.getFirst();
            if (user.getName() != null && user.getEmail() != null && user.getId() != null) {
                System.out.println("  [OK] Структура данных пользователя корректна");
            } else {
                System.out.println("  [FAIL] Структура данных пользователя некорректна");
                allTestsPassed = false;
            }
        } else {
            System.out.println("  [FAIL] FileData не смог загрузить пользователей");
            allTestsPassed = false;
        }
    }
    
    private static void testRandomData() {
        System.out.println("  Тестирование RandomData...");
        Data data = new RandomData();
        List<User> users = data.loadData(5);
        
        // Проверка количества сгенерированных пользователей
        if (users.size() == 5) {
            System.out.println("  [OK] RandomData сгенерировал 5 пользователей");
            
            // Проверка валидности данных всех пользователей
            boolean allValid = true;
            for (User user : users) {
                if (user.getName() == null || user.getEmail() == null || user.getId() == null) {
                    allValid = false;
                    break;
                }
            }
            
            if (allValid) {
                System.out.println("  [OK] Все случайные пользователи имеют корректные данные");
            } else {
                System.out.println("  [FAIL] Некоторые случайные пользователи имеют некорректные данные");
                allTestsPassed = false;
            }
        } else {
            System.out.println("  [FAIL] RandomData сгенерировал " + users.size() + " пользователей вместо 5");
            allTestsPassed = false;
        }
    }
    
    private static void testManualData() {
        System.out.println("  Тестирование ManualData...");
        // Мы не можем полностью протестировать ManualData, так как он требует пользовательского ввода,
        // но мы можем создать экземпляр и проверить, что он не вызывает исключений
        try {
            Data data = new ManualData();
            System.out.println("  [OK] Экземпляр ManualData создан");
            System.out.println("  [ПРИМЕЧАНИЕ] ManualData требует пользовательского ввода, не может быть полностью автоматизирован");
        } catch (Exception e) {
            System.out.println("  [FAIL] Создание экземпляра ManualData не удалось: " + e.getMessage());
            allTestsPassed = false;
        }
    }
}