package com.Mujo;

import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class AddPresident implements PresidentDataHandler {
    public void handleTask(PresidentDAO da, Scanner in, ResourceBundle messages) {
        President president = new President("", "", LocalDate.now());
        boolean needed = true;
        while (needed) {
            try {
                president.setFirstName(Helpers.getUserString("Enter your first name ", in));
                needed = false;
            } catch (IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), in, messages);
            }
        }
        needed = true;
        while (needed) {
            try {
                president.setLastName(Helpers.getUserString("Enter your last name ", in));
                needed = false;
            } catch (IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), in, messages);
            }
        }

        String prompt = "Enter the your birthday in year-month-date";
        String birthdayofuser = "";
        needed = true;
        while (needed) {
            try {
                birthdayofuser = Helpers.getUserString(prompt, in);

                needed = false;
            } catch (IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), in, messages);
            }
        }
        String year, month, date;
        year = birthdayofuser.substring(0, 4);
        month = birthdayofuser.substring(5, 7);
        date = birthdayofuser.substring(8, 10);
        president.setBirthday(LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(date)));

        needed = true;
        while (needed) {
            try {
                president.setInaugurationAge_Days(Helpers.getUserInt("Enter the inauguration days ", in, messages));
                needed = false;
            } catch (IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), in, messages);
            }
        }
        needed = true;
        while (needed) {
            try {
                president.setInaugurationAge_Years(Helpers.getUserInt("Enter the inauguration years", in, messages));
                needed = false;
            } catch (IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), in, messages);
            }
        }

        try{
            da.createPresidentRecord(president);
            System.out.println("\nAdded: " + president);
        } catch (DataException e) {
            UIUtility.showErrorMessage(e.getMessage(), in, messages);
        }
        System.out.println("\nAdd a President complete.");
    }
}

