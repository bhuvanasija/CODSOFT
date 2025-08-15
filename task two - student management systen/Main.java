import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String input = sc.nextLine();
            switch (input) {
                case "1":
                
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine().trim();
                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty!");
                        break;
                    }

                    System.out.print("Enter Roll Number: ");
                    String rollStr = sc.nextLine().trim();
                    int rollNumber;
                    try {
                        rollNumber = Integer.parseInt(rollStr);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid roll number!");
                        break;
                    }

                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine().trim();
                    if (grade.isEmpty()) {
                        System.out.println("Grade cannot be empty!");
                        break;
                    }

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine().trim();
                    if (course.isEmpty()) {
                        System.out.println("Course cannot be empty!");
                        break;
                    }

                    sms.addStudent(new Student(name, rollNumber, grade, course));
                    System.out.println("Student added successfully!");
                    break;

                case "2":
            
                    System.out.print("Enter Roll Number to remove: ");
                    try {
                        int rollToRemove = Integer.parseInt(sc.nextLine().trim());
                        if (sms.removeStudent(rollToRemove)) {
                            System.out.println("Student removed successfully!");
                        } else {
                            System.out.println("Student not found!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid roll number!");
                    }
                    break;

                case "3":
            
                    System.out.print("Enter Roll Number to search: ");
                    try {
                        int rollToSearch = Integer.parseInt(sc.nextLine().trim());
                        Student s = sms.searchStudent(rollToSearch);
                        if (s != null) {
                            System.out.println("Student Found: " + s);
                        } else {
                            System.out.println("Student not found!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid roll number!");
                    }
                    break;

                case "4":
    
                    sms.displayAllStudents();
                    break;

                case "5":
                    exit = true;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}
