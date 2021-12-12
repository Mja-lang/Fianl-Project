package com.Mujo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class PresidentDAOCSV implements PresidentDAO{
    private static final String FILE_NAME = "presidents.csv";
    private static List<President> presidents;

    @Override
    public void readInData() throws DataException {
        try(Scanner in = new Scanner(new File(FILE_NAME))) {
            presidents = new ArrayList<>();
            int lineCount = 1;
            String line;
            String[] fields;
            String firstName;
            String lastName;
            String bday ;
            String index;
            String inaugurationAge_Years;
            String inaugurationAge_Days;

            line = in.nextLine(); // Reads the header line
            while(in.hasNextLine()) {
                line = in.nextLine();
                lineCount++;
                fields = line.split(",");
                index = fields[0];
                firstName = fields[1];
                lastName = fields[2];
                bday = fields[3];
                inaugurationAge_Years = fields[4];
                inaugurationAge_Days = fields[5];
                String year, month, date;
                year = bday.substring(0, 4);
                month = bday.substring(5, 7);
                date = bday.substring(8, 10);
                presidents.add(new President(firstName, lastName, LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(date)),
                        Integer.parseInt(inaugurationAge_Years), Integer.parseInt(inaugurationAge_Days)));
            }
        } catch(FileNotFoundException e) {
            throw new DataException(e.getMessage());
        }


    }

    public void saveToFile() throws DataException {
        try(PrintWriter writer = new PrintWriter(FILE_NAME)) {
            writer.println("nth,firstName,lastName,birthday,inaugurationAge-Years,inaugurationAge-Days");
            int index = 1;
            for(President president: presidents) {
                writer.println(index + "," + president.getFirstName() + "," + president.getLastName() + "," +
                        president.getBirthday() + "," + president.getInaugurationAge_Years() + "," + president.getInaugurationAge_Days());
                index++;
            }
        } catch(FileNotFoundException e) {
            throw new DataException(e.getMessage());
        }
    }

    @Override
    public void verifyPresidentList() throws DataException {
        if (presidents == null) {
            readInData();
        }
    }

    @Override
    public void createPresidentRecord(President president) throws DataException{
        verifyPresidentList();
        presidents.add(president);
        saveToFile();
    }

    public President getPresidentbyfirstName(String firstname) throws DataException {
        verifyPresidentList();
        for(President president: presidents) {
            if (president.getFirstName().equals(firstname)) {
                return president;
            }
        }
        return null;
    }

    public President getPresidentbylastName(String lastname) throws DataException {
        verifyPresidentList();
        for(President president: presidents) {
            if (president.getLastName().equals(lastname)) {
                return president;
            }
        }
        return null;
    }

    @Override
    public List<President> getAllPresidents() throws DataException {
        verifyPresidentList();
        return presidents;
    }

    @Override
    public void updatePresident(President original, President updated) throws DataException {

    }

    @Override
    public void deletePresident(President president) throws DataException {

    }
}
