package com.Mujo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarDAOCSV implements CarDAO{
        private static final String FILE_NAME = "cars.csv";
        private static List<Car> cars;

        @Override
        public void readInData() throws DataException {
                try(Scanner in = new Scanner(new File(FILE_NAME))) {
                        cars = new ArrayList<>();
                        int lineCount = 1;
                        String line;
                        String[] fields;
                        String licensePlate;
                        String make;
                        String model;
                        int modelYear;
                        line = in.nextLine(); // Reads the header line
                        while(in.hasNextLine()) {
                                line = in.nextLine();
                                lineCount++;
                                fields = line.split(",");
                                licensePlate = fields[0];
                                make = fields[1];
                                model = fields[2];
                                try {
                                        modelYear = Integer.parseInt(fields[3]);
                                } catch(NumberFormatException e) {
                                        throw new DataException(e.getMessage() + " in " + FILE_NAME + " on line " + lineCount);
                                }
                                cars.add(new Car(licensePlate, make, model, modelYear));
                        }
                } catch(FileNotFoundException e) {
                        throw new DataException(e.getMessage());
                }
        }

        public void saveToFile() throws DataException {
                try(PrintWriter writer = new PrintWriter(new File(FILE_NAME))) {
                        writer.println("licensePlate,make,model,modelYear");
                        for(Car car: cars) {
                                writer.println(car.getLicensePlate() + "," + car.getMake() + "," +
                                        car.getModel() + "," + car.getModelYear());
                        }
                } catch(FileNotFoundException e) {
                        throw new DataException(e.getMessage());
                }
        }

        @Override
        public void verifyCarList() throws DataException {
                if(cars == null) {
                        readInData();
                }
        }

        @Override
        public void createCarRecord(Car car) throws DataException {
                verifyCarList();
                cars.add(car);
                saveToFile();
        }

        @Override
        public Car getCarByLicensePlate(String licensePlate) throws DataException {
                return null;
        }

        @Override
        public List<Car> getAllCars() throws DataException {

                return null;
        }

        @Override
        public void updateCar(Car original, Car updated) throws DataException {

        }

        @Override
        public void deleteCar(Car car) throws DataException {

        }

        @Override
        public void deleteCar(String licensePlate) throws DataException {

        }
}
