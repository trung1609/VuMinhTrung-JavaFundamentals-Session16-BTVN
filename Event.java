package Session16.kha2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Event {
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Event(String name, LocalDateTime startDate, LocalDateTime endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Event() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("Name: %s, Start Date: %s, End Date: %s", name, startDate.format(dtf), endDate.format(dtf));
    }

    public void input(Scanner sc) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        System.out.print("Nhap ten su kien (hoac 'exit' de thoat): ");
        this.name = sc.nextLine();
        if (this.name.equals("exit")) {
            return;
        }
        if (name.isEmpty()) {
            System.out.println("Vui long khong de trong.");
            this.name = sc.nextLine();
        }
        do {
            try {
                System.out.print("Nhap thoi gian bat dau (dd-MM-yyyy HH:mm): ");
                this.startDate = LocalDateTime.parse(sc.nextLine(), dtf);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Vui long nhap ngay hop le.");
            }
        } while (true);
        do {
            try {
                System.out.print("Nhap thoi gian ket thuc (dd-MM-yyyy HH:mm): ");
                this.endDate = LocalDateTime.parse(sc.nextLine(), dtf);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Vui long nhap ngay hop le.");
            }
        } while (true);
    }
}
