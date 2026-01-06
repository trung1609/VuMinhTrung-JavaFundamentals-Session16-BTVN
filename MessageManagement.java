package Session16.gioi1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MessageManagement {
    static List<Message> messages = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        addMessage(sc);
        displayMessages();
    }

    public static void addMessage(Scanner sc) {
        while (true) {
            Message message = new Message();
            message.input(sc, messages);
            if(message.getSender().equals("exit")){
                break;
            }
        }
    }
    public static void displayMessages() {
        for (Message message : messages) {
            System.out.println(message);
        }
    }
}
