package Session16.xuatsac2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Order {
    private int id;
    private String customerName;
    private LocalDate createdDate;
    private Optional<LocalDate> deliveryDate;
    public static int AUTO_ID = 1;

    public Order() {
    }

    public Order(String customerName, Optional<LocalDate> deliveryDate) {
        this.id = AUTO_ID++;
        this.customerName = customerName;
        this.createdDate = LocalDate.now();
        this.deliveryDate = deliveryDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Optional<LocalDate> getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Optional<LocalDate> deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return String.format("ID: %d - Ten khach hang: %s - Ngay dat: %s, - Ngay giao - %s",
                id,
                customerName,
                createdDate.format(dtf),
                deliveryDate
                        .map(d -> d.format(dtf))
                        .orElse("Chua giao"));
    }
}
