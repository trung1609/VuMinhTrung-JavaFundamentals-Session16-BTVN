package Session16.xuatsac2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderManagement {
    static List<Order> orders = new ArrayList<>();

    public static void main(String[] args) {
        addOrder();
        orderShipped();
        orderNotDelivered();
        countOrdersShipped();
    }

    public static void addOrder() {
        orders.add(new Order("Vu Minh Trung", Optional.of(LocalDate.of(2026, 2, 12))));
        orders.add(new Order("Nguyen Van A", Optional.empty()));
        orders.add(new Order("Nguyen Van B", Optional.of(LocalDate.of(2026, 10, 4))));
        orders.add(new Order("Vu Minh C", Optional.of(LocalDate.of(2026, 2, 14))));
        orders.add(new Order("Vu Van D", Optional.empty()));
    }

    public static void orderShipped() {
        System.out.println("Cac don hang da duoc giao: ");
        orders.stream().filter(o -> o.getDeliveryDate().isPresent()).forEach(System.out::println);
    }

    public static void orderNotDelivered() {
        System.out.println("Cac don hang chua duoc giao: ");
        orders.stream().filter(o -> o.getDeliveryDate().isEmpty()).forEach(System.out::println);
    }

    public static void countOrdersShipped() {
        LocalDate from = LocalDate.of(2026, 1, 1);
        LocalDate to = LocalDate.of(2026, 2, 15);
        long count = orders.stream()
                .filter(o -> o.getDeliveryDate().isPresent())
                .filter(o->{
                    LocalDate d = o.getDeliveryDate().get();
                    return !d.isBefore(from) && !d.isAfter(to);
                })
                .count();

        System.out.println("So don hang da giao trong khoang thoi gian tu 2026-01-01 den 2026-02-15: " + count);
    }
}
