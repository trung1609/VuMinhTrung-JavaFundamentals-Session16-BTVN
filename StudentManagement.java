package Session16.xuatsac1;

import java.util.*;
import java.util.stream.Collectors;

public class StudentManagement {
    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        addData();
        thongKe();
    }

    public static void addData() {
        students.add(new Student("Vu Minh Trung", "IT", 9.5));
        students.add(new Student("Nguyen Van Hung", "IT", 8.5));
        students.add(new Student("Vu Van Hai", "IT", 7.6));
        students.add(new Student("Vu Minh Hung", "Ke Toan", 8.8));
        students.add(new Student("Vu Minh Long", "Ke Toan", 9.5));
        students.add(new Student("Nguyen Minh Quan", "Du Lich", 7.5));
        students.add(new Student("Nguyen Van Minh", "Marketing", 6.5));
        students.add(new Student("Vu Van Hung", "IT", 5.4));
        students.add(new Student("Nguyen Van Trung", "IT", 8.2));
        students.add(new Student("Trinh Van Trung", "IT", 7.3));
    }

    public static void thongKe() {
        Map<String, Long> numberStudents = students.stream()
                .collect(Collectors.groupingBy(Student::getMajor, Collectors.counting()));

        numberStudents.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(e -> System.out.println("Chuyen nganh " + e.getKey() + ": " + e.getValue() + " sinh vien"));
    }
}
