package com.Mujo;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Language language = new Language();
        ResourceBundle messages = language.getMessages();
        CarDAO dao = CarDAOFactory.getCarDAO();
        PresidentDAO da = PresidentDAOFactory.getPresidentDAO();

        Scanner scanner = new Scanner(System.in);
        String menuTitle = "Main Menu";
        String prompt = "Select an option";
        int choice = 0;

        while (true) {
            String[] menuOptions = {
                    messages.getString("add-president"),
                    messages.getString("find-president"),
                    "Show all Presidents",
                    "Update a President",
                    "Delete a President",
                    "Change language"
            };
            choice = UIUtility.showMenuOptions(menuTitle, prompt, menuOptions, scanner, messages);
            if (choice == 0)
                continue;
            if (choice == menuOptions.length + 1)
                break;
            UIUtility.showSectionTitle().accept(menuOptions[Integer.valueOf(choice) - 1]);
            switch (choice) {
                case 1:
                    new AddPresident().handleTask(da, scanner, messages);
                    break;
                case 2:
                    new FindPresident().handleTask(da, scanner, messages);
                    break;
                case 3:
                    new ShowAllCars().handleTask(dao, scanner, messages);
                    break;
                case 4:
                    new UpdateCar().handleTask(dao, scanner, messages);
                    break;
                case 5:
                    new DeleteCar().handleTask(dao, scanner, messages);
                    break;
                case 6:
                    language.changeLanguage(scanner, messages);
                    break;
            }
            UIUtility.pressEnterToContinue(scanner, messages);
        }
        System.out.println("\nProgram complete. Goodbye.\n");
        scanner.close();
    }
}

