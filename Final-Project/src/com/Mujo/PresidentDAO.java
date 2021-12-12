package com.Mujo;

import java.util.List;

public interface PresidentDAO {
    void readInData() throws DataException;

    // Verify that the data has been read in and assigned to an ArrayList
    void verifyPresidentList() throws DataException;


    void createPresidentRecord(President president) throws DataException;

    // Returns the com.Mujo.President record associated with the firstname or null if there is no such person.
    President getPresidentbyfirstName(String firstname) throws DataException;

    // Returns the com.Mujo.President record associated with the firstname or null if there is no such person.
    President getPresidentbylastName(String lastname) throws DataException;

    // Returns a list of all the current com.Mujo.Car records.
    List<President> getAllPresidents() throws DataException;

    // Looks for the original com.Mujo.Car and updates it to match the updated com.Mujo.Car.
    // If the original com.Mujo.Car cannot be found, the method will throw an Exception.
    void updatePresident(President original,President updated) throws DataException;

    // Permanently deletes the supplied com.Mujo.Car record
    void deletePresident(President president) throws DataException;


}
