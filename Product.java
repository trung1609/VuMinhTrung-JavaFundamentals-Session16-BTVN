package Session16.kha1;

import java.util.Scanner;

public class Product {
    private int id;
    private String name;
    private double price;
    public static int AUTO_ID = 1;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Price: %.1f", name, price);
    }
    public void input(Scanner sc) {
        this.id = AUTO_ID++;
        System.out.print("Enter Product Name: ");
        name = sc.nextLine();
        price = inputPrice(sc);
    }
    public double inputPrice(Scanner sc) {
        do {
            try {
                System.out.print("Enter Product Price: ");
                double inputPrice = Double.parseDouble(sc.nextLine());
                if(inputPrice < 0){
                    System.err.println("Please enter a price greater than zero");
                    continue;
                }
                return inputPrice;
            }catch (NumberFormatException e) {
                System.err.println("Please enter a valid price.");;
            }
        }while (true);
    }
}
