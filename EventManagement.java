package Session16.kha2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventManagement {
    static List<Event> events = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        addEvent(sc);
        displayEvents();
    }

    public static void addEvent(Scanner sc) {
        while (true) {
            Event event = new Event();
            event.input(sc);
            if (event.getName().equals("exit")) {
                break;
            }
            events.add(event);
        }
    }

    public static void displayEvents() {
        System.out.println("Danh sach su kien:");
        for (Event e : events) {
            System.out.println(e);
        }
    }
}
