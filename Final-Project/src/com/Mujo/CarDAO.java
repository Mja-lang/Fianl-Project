package com.Mujo;

//import com.Mujo.Car;

import java.util.List;

public interface CarDAO {

        // Read in data from the data source
        void readInData() throws DataException;

        // Verify that the data has been read in and assigned to an ArrayList
        void verifyCarList() throws DataException;

        // Creates a new car record based on the values in the supplied com.Mujo.Car object
        void createCarRecord(Car car) throws DataException;

        // Returns the com.Mujo.Car record associated with the licensePlate or null if there is no such car.
        Car getCarByLicensePlate(String licensePlate) throws DataException;

        // Returns a list of all the current com.Mujo.Car records.
        List<Car> getAllCars() throws DataException;

        // Looks for the original com.Mujo.Car and updates it to match the updated com.Mujo.Car.
        // If the original com.Mujo.Car cannot be found, the method will throw an Exception.
        void updateCar(Car original, Car updated) throws DataException;

        // Permanently deletes the supplied com.Mujo.Car record
        void deleteCar(Car car) throws DataException;

        // Permanently deletes the com.Mujo.Car record with the supplied license plate value.
        void deleteCar(String licensePlate) throws DataException;
    }

