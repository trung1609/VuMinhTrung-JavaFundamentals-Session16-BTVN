package Session16.gioi2;

import java.util.Scanner;

public class Product {
    private String name;
    private double price;

    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
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

    public void input(Scanner sc){
        System.out.print("Nhap ten san pham: ");
        name = sc.nextLine();
        do{
            try {
                System.out.print("Nhap gia san pham: ");
                 double priceInput = Double.parseDouble(sc.nextLine());
                if(priceInput <= 0){
                    System.err.println("Vui long nhap lai gia lon hon hoac bang 0.");
                    continue;
                }
                this.price = priceInput;
                break;
            }catch (NumberFormatException e){
                System.err.println("Vui long nhap dung dinh dang gia tien.");
            }
        }while (true);
    }
}
