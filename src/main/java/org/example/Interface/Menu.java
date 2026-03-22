package org.example.Interface;
import java.util.*;
import org.example.Data.*;
import org.example.SortStrategy.*;
import org.example.Entity.User;

public class Menu {
	private final Scanner scanner = new Scanner(System.in);
	private boolean repeat;
	private List<User> users = new ArrayList<>();

	public void start() {
		while (true){
			printMainMenu();

			try {
				int input = Integer.parseInt(scanner.nextLine());
				if (input == 4) break;

				printNumberOfElements();

				if (!handleMainMenu(input)) continue;
				sortMenuLogic();
			}
			catch (NumberFormatException e) {
				System.out.println("Неверный формат числа");
			}
		}
	}

	private void printMainMenu(){
  	System.out.println("\nМЕНЮ");
  	System.out.println("1. Загрузить данные из файла");
  	System.out.println("2. Сгенерировать случайные данные");
  	System.out.println("3. Ввести данные вручную");
  	System.out.println("4. Выход");
  	System.out.println("\nСделайте выбор:");
  }

  private void printNumberOfElements(){
  	System.out.println("Введите количество элементов:");
  }

  private void printSortMenu() {
  	System.out.println("Выберите сортировку:");
    System.out.println("1. По имени");
    System.out.println("2. По email");
    System.out.println("3. По Id");
	System.out.println("4. По четным ID");// Доп. Задание 1
  }

  private void printNoNumber() {
  	System.out.println("Такого значения нет");
    System.out.println("-------------------");
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
		}
		else {
  		printNoNumber();
			return false;	
		}
	}

  private boolean handleSortMenu(int sortChoice, List<User> users) {
		repeat = false;
		SortStrategy strategy = switch (sortChoice) {
			case 1 -> new NameSortStrategy();
			case 2 -> new EmailSortStrategy();
			case 3 -> new IdSortStrategy();
			case 4 -> new Even_Sort_Id();
			default -> null;
		};

		if (strategy != null) {
      strategy.sort(users);
      printSorted(users);
    }
    else {
    	printNoNumber();
    	return true;
    }
		return repeat;
	}

	private void sortMenuLogic() {
		do {
			printSortMenu();
			int sortChoice = Integer.parseInt(scanner.nextLine());
			repeat = handleSortMenu(sortChoice, users);
		}
		while(repeat);
	}

	private void printSorted(List<User> users) {
  	System.out.println("Отсортированный список:");
	
		for (User user : users) {
		  System.out.println( user.getName() + " | " + user.getEmail() + " | " + user.getId() );
		}
	}
}
