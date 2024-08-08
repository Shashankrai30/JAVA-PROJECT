import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

class Student {
    private String name;
    private String fname;
    private String rollNumber;
    private String grade;
    private Integer age;

    public Student(String name, String fname, String rollNumber, String grade, Integer age) {
        this.name = name;
        this.fname = fname;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getfname() {
        return fname;
    }
    public void setfname(String fname) {
        this.fname = fname;
    }
    public String getRollNumber() {
        return rollNumber;
    }
    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Name: " + name+ "\nFather Name : " + fname + "\nRoll Number: " + rollNumber + "\nGrade: " + grade + "\nAge: " + age ;
    }
}
class StudentManagementSystem {
    private List<Student> students;
    public StudentManagementSystem() {
        students = new ArrayList<>();
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public void removeStudent(String rollNumber) {
        students.removeIf(student -> student.getRollNumber().equals(rollNumber));
    }
    public Student searchStudent(String rollNumber) {
        Optional<Student> student = students.stream()
                                             .filter(s -> s.getRollNumber().equals(rollNumber))
                                             .findFirst();
        return student.orElse(null);
    }
    public void displayAllStudents() {
        students.forEach(System.out::println);
    }
}
public class Studentmanagement {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n* * * * * * * * * * * * * * * *");
            System.out.println("* Student Management System   *");
            System.out.println("* 1. Add Student              *");
            System.out.println("* 2. Remove Student           *");
            System.out.println("* 3. Search Student           *");
            System.out.println("* 4. Display All Students     *");
            System.out.println("* 5. Exit                     *");
            System.out.println("* * * * * * * * * * * * * * * *");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    System.out.print("Enter student's name: ");
                    String name = scanner.nextLine();
                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty.");
                        continue;
                    }
                    System.out.print("Enter student's roll number: ");
                    String rollNumber = scanner.nextLine();
                    if (rollNumber.isEmpty()) {
                        System.out.println("Roll number cannot be empty.");
                        continue;
                    }
                    System.out.print("Enter student's grade: ");
                    String grade = scanner.nextLine();
                    if (grade.isEmpty()) {
                        System.out.println("Grade cannot be empty.");
                        continue;
                    }
                    System.out.print("Enter student's age (optional): ");
                    String ageInput = scanner.nextLine();
                    Integer age = ageInput.isEmpty() ? null : Integer.parseInt(ageInput);
                    System.out.print("Enter student's Father Name : ");
                    String fname = scanner.nextLine();
                    Student student = new Student(name, fname, rollNumber, grade, age);
                    sms.addStudent(student);
                }
                case "2" -> {
                    System.out.print("Enter student's roll number to remove: ");
                    String rollNumber = scanner.nextLine();
                    sms.removeStudent(rollNumber);
                }
                case "3" -> {
                    System.out.print("Enter student's roll number to search: ");
                    String rollNumber = scanner.nextLine();
                    Student foundStudent = sms.searchStudent(rollNumber);
                    if (foundStudent != null) {
                        System.out.println(foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                }
                case "4" -> sms.displayAllStudents();
                case "5" -> {
                    System.out.println("Exiting the application.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
