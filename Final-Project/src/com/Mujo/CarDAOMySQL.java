package com.Mujo;

import com.Mujo.Car;
    import com.Mujo.CarDAO;

    import java.util.List;

    public class CarDAOMySQL implements CarDAO {
        private static List<Car> cars;

        @Override
        public void readInData() throws DataException {

        }

        @Override
        public void verifyCarList() throws DataException {

        }

        @Override
        public void createCarRecord(Car car) throws DataException {

        }

        @Override
        public Car getCarByLicensePlate(String licensePlate) throws DataException {
            Car car = null;

            return car;
        }

        @Override
        public List<Car> getAllCars() throws DataException {
            List<Car> cars = null;

            return cars;
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
