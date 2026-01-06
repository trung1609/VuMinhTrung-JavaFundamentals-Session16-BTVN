package Session16.gioi2;

import java.util.List;
import java.util.function.Predicate;

public interface ProductProcessor<T> {
    double calculateTotalValue(List<T> items);

    static void printProductList(List<Product> products){
        for(Product product:products){
            System.out.println(product);
        }
    }

    default boolean hasExpensiveProduct(List<Product> products){
        Predicate<Product> expensive = p -> p.getPrice() > 100000;
        return products.stream().anyMatch(expensive);
    }
}
