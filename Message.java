package Session16.gioi1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

public class Message {
    private String sender;
    private String content;
    private LocalDateTime timestamp;

    public Message() {
    }

    public Message(String sender, String content, LocalDateTime timestamp) {
        this.sender = sender;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void input(Scanner sc, List<Message> messages) {
        System.out.print("Nhap ten nguoi gui (hoac 'exit' de thoat): ");
        sender = sc.nextLine();
        if (sender.equals("exit")) {
            return;
        }
        System.out.print("Nhap noi dung tin nhan: ");
        content = sc.nextLine();
        timestamp = LocalDateTime.now();
        do {
            System.out.println("Nhap 'history' de xem lich su");
            System.out.println("Nhap 'filter' de loc tin nhan theo nguoi gui");
            System.out.println("Nhap 'date' de loc theo ngay");
            System.out.print("Chon lua chon: ");
            String choice = sc.nextLine();
            messages.add(new Message(sender, content, timestamp));
            switch (choice) {
                case "history":
                    historyMessage(messages);
                    return;
                case "filter":
                    filterSender(messages);
                    return;
                case "date":
                    filterDate(messages);
                    return;
                default:
                    System.err.println("Vui long nhap lua chon phu hop.");
            }
        } while (true);
    }

    public void historyMessage(List<Message> messages) {
        System.out.println("Lich su chat:");
        for (Message m : messages) {
            if (m.getSender().equals(sender)) {
                printMessage(m);
            }
        }
    }

    public void filterDate(List<Message> messages) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date;
        do {
            try {
                System.out.print("Nhap ngay (dd-MM-yyyy): ");
                String dateInput = sc.nextLine();
                date = LocalDate.parse(dateInput, dtf);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Vui long nhap dung dinh dang ngay.");
            }
        } while (true);
        LocalDate finalDate = date;

        System.out.println("Tin nhan trong ngay " + date.format(dtf));
        messages.stream()
                .filter(d -> d.getTimestamp().toLocalDate()
                        .equals(finalDate)).forEach(this::printMessage);
    }

    public void filterSender(List<Message> messages) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten nguoi de loc: ");
        String senderName = sc.nextLine();
        System.out.println("Tin nhan tu " + senderName + ":");
        messages.stream().filter(n -> n.getSender().equals(senderName)).forEach(this::printMessage);
    }

    public void printMessage(Message m) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        System.out.printf("[%s] %s: %s%n",
                m.getTimestamp().format(dtf),
                m.getSender(),
                m.getContent());
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return "Message{" +
                "sender='" + sender + '\'' +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp.format(dtf) +
                '}';
    }
}
