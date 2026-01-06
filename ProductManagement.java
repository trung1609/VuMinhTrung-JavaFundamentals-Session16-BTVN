package Session16.kha1;

import java.util.*;

public class ProductManagement implements IProduct<Product> {
    static Map<Integer, Product> productMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductManagement productManagement = new ProductManagement();
        do {
            System.out.println("--- Product Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. Edit Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Products");
            System.out.println("5. Filter Products");
            System.out.println("6. Total Value Of Products");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    productManagement.addProduct(new Product());
                    break;
                case 2:
                    productManagement.updateProduct();
                    break;
                case 3:
                    productManagement.deleteProduct();
                    break;
                case 4:
                    productManagement.showProducts();
                    break;
                case 5:
                    productManagement.filterProducts();
                    break;
                case 6:
                    productManagement.totalProductPrice();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.err.println("Invalid choice");
            }
        } while (true);
    }

    @Override
    public void addProduct(Product item) {
        Scanner sc = new Scanner(System.in);
        item.input(sc);
        productMap.put(item.getId(), item);
    }

    @Override
    public void updateProduct() {
        if (productMap.isEmpty()) {
            System.out.println("There is no product");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Product ID to edit: ");
            int id = Integer.parseInt(sc.nextLine());
            Optional<Product> optProduct = productMap.values().stream().filter(p -> p.getId() == id).findFirst();
            optProduct.ifPresentOrElse(p -> {
                do {
                    System.out.println("1. Update Product Name");
                    System.out.println("2. Update Product Price");
                    System.out.println("3. Exit");
                    System.out.print("Enter your choice: ");
                    int choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1:
                            System.out.print("Enter new Product Name: ");
                            p.setName(sc.nextLine());
                            System.out.println("Product Name updated successfully");
                            break;
                        case 2:
                            double newPrice;
                            do {
                                try {
                                    System.out.print("Enter new Product Price: ");
                                    newPrice = Double.parseDouble(sc.nextLine());
                                    if (newPrice < 0) {
                                        System.err.println("Please enter a price greater than zero");
                                        continue;
                                    }
                                    p.setPrice(newPrice);
                                    break;
                                } catch (NumberFormatException e) {
                                    System.err.println("Please enter a valid price.");
                                }
                            } while (true);
                            break;
                        case 3:
                            return;
                        default:
                            System.err.println("Invalid choice");
                    }
                } while (true);
            }, () -> System.out.println("Not found ID Product"));
        }
    }

    @Override
    public void deleteProduct() {
        if (productMap.isEmpty()) {
            System.out.println("There is no product");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Product ID to delete: ");
            int id = Integer.parseInt(sc.nextLine());
            Optional<Product> optionalProduct = productMap.values().stream().filter(p -> p.getId() == id).findFirst();
            optionalProduct.ifPresentOrElse(p -> {
                System.out.print("Are you sure you want to delete this product? (Y/N): ");
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("N")) {
                    System.out.println("Cancel delete product");
                } else if (choice.equalsIgnoreCase("Y")) {
                    productMap.remove(id);
                    System.out.println("Product deleted successfully");
                }

            }, () -> System.out.println("Not Found ID Product"));
        }
    }

    @Override
    public void showProducts() {
        if (productMap.isEmpty()) {
            System.out.println("There are no products to display");
        } else {
            for (Map.Entry<Integer, Product> entry : productMap.entrySet()) {
                System.out.println("ID: " + entry.getKey() + "," + " " + entry.getValue());
            }
        }
    }

    @Override
    public void filterProducts() {
        if (productMap.isEmpty()) {
            System.out.println("There are no products to display");
        } else {
            Scanner sc = new Scanner(System.in);
            double price;
            do {
                System.out.print("Enter Product price to filter: ");
                price = Double.parseDouble(sc.nextLine());
                if (price < 0) {
                    System.err.println("Please enter a price greater than zero");
                }
            } while (price < 0);
            double finalPrice = price;
            long count = productMap.values().stream().filter(p -> p.getPrice() > finalPrice).count();

            if (count == 0) {
                System.out.println("Not found Product have price less than " + finalPrice);
            } else {
                productMap.values().stream()
                        .filter(p -> p.getPrice() > finalPrice)
                        .forEach(System.out::println);
            }
        }
    }

    @Override
    public void totalProductPrice() {
        if (productMap.isEmpty()) {
            System.out.println("There are no products to display");
        } else {
            DoubleSummaryStatistics total = productMap.values().stream()
                    .mapToDouble(Product::getPrice)
                    .summaryStatistics();

            System.out.println("Total value of products: " + total.getSum());
        }
    }
}
