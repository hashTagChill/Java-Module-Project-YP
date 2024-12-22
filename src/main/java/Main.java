import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();
        ArrayList<Car> cars = new ArrayList<>();

        System.out.println("Добро пожаловать в 24 часа Ле-Мана!!!");
        for (int i = 1; i <= 3; i++) {
            System.out.println("Введите название машины №" + i + ":");
            String name = scanner.nextLine();

            int speed = 0;
            while (true) {
                System.out.println("Введите скорость машины №" + i + ":");
                try {
                    speed = Integer.parseInt(scanner.nextLine());
                    if (speed > 0 && speed <= 250) {
                        break;
                    } else {
                        System.out.println("Введена неправильная скорость! Скорость должна быть от 1 до 250.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Введите корректное целое число от 1 до 250.");
                }
            }

            Car car = new Car(name, speed);
            cars.add(car);
        }

        for (Car car : cars) {
            race.findLeader(car);
        }

        System.out.println("Самая быстрая машина: " + race.getLeaderName());
    }
}

class Car {
    private String name;
    private int speed;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}

class Race {
    private String leaderName;
    private int maxDistance;

    public void findLeader(Car car) {
        int distance = car.getSpeed() * 24;
        if (distance > maxDistance) {
            maxDistance = distance;
            leaderName = car.getName();
        }
    }

    public String getLeaderName() {
        return leaderName;
    }
}










