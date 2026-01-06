package Session16.kha1;

public interface IProduct<T> {
    void addProduct(T item);

    void updateProduct();

    void deleteProduct();

    void showProducts();

    void filterProducts();

    void totalProductPrice();
}
