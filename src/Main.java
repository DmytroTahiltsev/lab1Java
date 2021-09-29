package com.company;
import java.util.ArrayList;
import java.util.Calendar;
public class Main {

    public static void main(String[] args) {
        /*int a = 88;
        System.out.println("sss");
        PrintClass obj = new PrintClass();
        obj.printInt(a);*/

        Car[] carsArray = new Car[] {
                new Car(1, "toyota", "prado", 2018, "black", 32000, "AA2003CK"),
                new Car(2, "dodge", "durango", 2019, "gray", 29000, "AA4566CC"),
                new Car(3, "jeep", "grand-cherokee", 2016, "black", 25500, "AI5555EA"),
                new Car(4, "lexus", "lx-570", 2020, "black", 93000, "AA7777AA"),
                new Car(5, "lada", "2107", 2004, "purple", 1200, "AA1579CE"),
                new Car(6, "bmw", "320i", 2017, "green", 21000, "AA5389EC"),
                new Car(7, "dodge", "journey", 2016, "white", 14500, "AI8741OP"),
                new Car(8, "lada", "kalina", 2018, "white", 9000, "AI8412EA")
        };
        System.out.print("\n------------------\nTask1");
        for(Car car : CarsService.listByMark("dodge", carsArray)) {
            PrintClass.printCar(car);
        }
        System.out.print("\n------------------\nTask2");
        for(Car car : CarsService.listByOperationYearsMoreThanN(10, carsArray)) {
            PrintClass.printCar(car);
        }
        System.out.print("\n------------------\nTask3");
        for(Car car : CarsService.listByYearAndPriceMoreThanN(2018, 10000, carsArray)) {
            PrintClass.printCar(car);
        }

    }
}

class PrintClass {
    public static void printCar(Car car){
        System.out.print(
                "\nid:" + car.getId() + ", Mark: " + car.getMark() + ", Model: " + car.getModel() + ", Year: " + car.getYear()
                        + ", Color: " + car.getColor() + ", Price: " + car.getPrice() + ", regNumber: " + car.getRegNumber()
        );
    }
}

class CarsService {
    public static ArrayList<Car> listByMark(String mark, Car[] array) {
        ArrayList<Car> suitableCars = new ArrayList<Car>();

        for(Car car : array){
            if(car.getMark() == mark){
                suitableCars.add(car);
            }
        }
        return suitableCars;
    }
    public static ArrayList<Car> listByOperationYearsMoreThanN(int N, Car[] array) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        ArrayList<Car> suitableCars = new ArrayList<Car>();
        for(Car car : array){
            if(currentYear - car.getYear() >= N){
                suitableCars.add(car);
            }
        }
        return suitableCars;
    }
    public static ArrayList<Car> listByYearAndPriceMoreThanN(int year, float N, Car[] array){
        ArrayList<Car> suitableCars = new ArrayList<Car>();
        for(Car car : array){
            if(car.getYear() == year && car.getPrice() > N){
                suitableCars.add(car);
            }
        }
        return suitableCars;
    }
}

class Car {
    private int id;
    private String mark;
    private String model;
    private int year;
    private String color;
    private float price;
    private String regNumber;

    public Car(int id, String mark, String model, int year, String color, float price, String regNumber) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.regNumber = regNumber;
    }

    public int getId() {
        return this.id;
    }
    public String getMark() {
        return this.mark;
    }
    public String getModel() {
        return this.model;
    }
    public int getYear() {
        return this.year;
    }
    public String getColor() {
        return this.color;
    }
    public float getPrice() {
        return this.price;
    }
    public String getRegNumber() {
        return this.regNumber;
    }
}