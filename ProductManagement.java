package Session16.gioi2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    static List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("--- QUAN LY SAN PHAM ---");
            System.out.println("1. Them san pham");
            System.out.println("2. Kiem tra san pham co gia hon 100000 hay khong");
            System.out.println("3. Tinh tong gia tri san pham");
            System.out.println("4. In danh sach san pham");
            System.out.println("5. Thoat");
            System.out.print("Lua chon cua ban: ");
            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        addProduct(sc);
                        break;
                    case 2:
                        checkProduct();
                        break;
                    case 3:
                        totalProductPrice();
                        break;
                    case 4:
                        displayProducts();
                        break;
                    case 5:
                        System.exit(0);
                    default:
                        System.err.println("Vui long nhap tu 1-5.");
                }
            }catch (NumberFormatException e){
                System.err.println("Vui long nhap dung dinh dang");
            }
        } while (true);
    }

    public static void addProduct(Scanner sc) {
        Product p = new Product();
        p.input(sc);
        products.add(p);
        System.out.println("Them san pham thanh cong.");
    }

    public static void displayProducts() {
        ProductProcessor.printProductList(products);
    }

    public static void checkProduct() {
        ProductProcessor<Product> productProcessor = new ProductProcessorImpl();
        if (productProcessor.hasExpensiveProduct(products)) {
            products.stream()
                    .filter(p -> p.getPrice() > 100000)
                    .forEach(System.out::println);
        } else {
            System.out.println("Khong co san pham dat tien.");
        }
    }

    public static void totalProductPrice() {
        ProductProcessorImpl productProcessor = new ProductProcessorImpl();
        System.out.println("Tong gia tri san pham: " + productProcessor.calculateTotalValue(products));
    }
}
