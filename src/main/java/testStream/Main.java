package testStream;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream()
                .filter(arg -> (arg % 2 == 0))
                .forEach(System.out::println);

        List<String> names = Arrays.asList("John", "Jan", "Tirion", "Marry", "Nikolas", "John", "Daenerys", "Tyrion", "", null, "Arya");

        names.stream()
                .filter(Objects::nonNull)
                .filter(name -> !name.isEmpty())
                .filter(name -> name.contains("a"))
                .map(String::toLowerCase)
                .map(name -> name + " hey")
                .forEach(System.out::println);

        List<Car> cars = Arrays.asList(
                new Car("AA1111BX", 2007),
                new Car("AK5555IT", 2010),
                new Car(null, 2012),
                new Car("", 2015),
                new Car("AI3838PP", 2017));

        cars.stream()
                .filter(car -> car.getYear() > 2010)
                .filter(car -> car.getNumber() != null && !car.getNumber().isEmpty())
                .map(Car::getNumber)
                .forEach(System.out::println);
    }
}

