package com.Mujo;

import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class FindPresident implements PresidentDataHandler{
    @Override
    public void handleTask(PresidentDAO da, Scanner in, ResourceBundle messages) {
        try {
            List<President> pres = da.getAllPresidents();
            if(pres != null) {
                String firstname = Helpers.getUserString("Enter the firstname", in);
                System.out.println("\nSearching for first name " + firstname + "...");
                President president = da.getPresidentbyfirstName(firstname);
                if (president == null) {
                    System.out.println("No president found with the first name: " + firstname);
                    String lastname = Helpers.getUserString("Enter the lastname", in);
                    System.out.println("\nSearching for last name " + lastname + "...");
                    president = da.getPresidentbylastName(lastname);
                    if (president == null) {
                        System.out.println("No president found with the last name: " + lastname);
                        System.out.println("There are no person available.");
                    } else {
                        System.out.println("Retrieved: " + president);
                        System.out.println("\nFind a President complete.");
                    }
                } else {
                    System.out.println("Retrieved: " + president);
                    System.out.println("\nFind a President complete.");
                }
            } else {
                System.out.println("There are no person available.");
            }
        } catch (DataException e) {
            UIUtility.showErrorMessage(e.getMessage(), in, messages);
        }
    }
}
