package Parametrizaçao;

import CarPredicate.CarPredicate;

import java.util.ArrayList;
import java.util.List;

public class Teste01 {
    public static void main(String[] args) {
        List<Car> cars = List.of(
                new Car("black", 2018),
                new Car("green", 2000),
                new Car("blue", 2008));

        List<Car> greenCars = filter(cars, car -> car.getColor().equals("green"));
        List<Car> redCars = filter(cars, car -> car.getColor().equals("red"));
        List<Car> blueCars = filter(cars, car -> car.getColor().equals("blue"));
        List<Car> byAge = filter(cars, car -> car.getYear() < 2018);

        System.out.println(greenCars);
        System.out.println(byAge);
    }

    private static List<Car> filter(List<Car> cars, CarPredicate carPredicate) {
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if(carPredicate.test(car)) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }

}
