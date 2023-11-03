package Projekt;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SalonCalendar calendar = new SalonCalendar();
        SalonPayment payment = new SalonPayment();
        SalonApp salonApp = new SalonApp(calendar, payment);
        SalonRevisor salonRevisor = new SalonRevisor(calendar, payment);

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Menu:");
            System.out.println("1. Book Appointment");
            System.out.println("2. Cancel Appointment");
            System.out.println("3. Display Appointments");
            System.out.println("4. Generate Daily Report");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Book Appointment
                    System.out.print("Enter appointment date (yyyy-MM-dd): ");
                    String dateStr = scanner.next();
                    Date appointmentDate = SalonDateUtils.parseDate(dateStr);
                    System.out.print("Enter appointment time: ");
                    String appointmentTime = scanner.next();
                    System.out.print("Enter customer name: ");
                    scanner.nextLine();  // Forbrug linjeskiftet
                    String customerName = scanner.nextLine();
                    System.out.print("Enter customer phone number: ");
                    String customerPhoneNumber = scanner.next();
                    System.out.print("Enter appointment price: ");
                    double appointmentPrice = scanner.nextDouble();
                    Customer customer = new Customer(customerName, customerPhoneNumber);

                    salonApp.createAppointment(appointmentDate, appointmentTime, customer, appointmentPrice);
                    break;
                case 2:
                    // Cancel Appointment
                    System.out.print("Enter appointment date (yyyy-MM-dd): ");
                    String cancelDateStr = scanner.next();
                    Date cancelDate = SalonDateUtils.parseDate(cancelDateStr);
                    System.out.print("Enter appointment time: ");
                    String cancelTime = scanner.next();

                    salonApp.deleteAppointment(cancelDate, cancelTime);
                    break;
                case 3:
                    // Display Appointments
                    System.out.print("Enter date to display appointments (yyyy-MM-dd): ");
                    String displayDateStr = scanner.next();
                    Date displayDate = SalonDateUtils.parseDate(displayDateStr);

                    salonApp.displayAppointments(displayDate);
                    break;
                case 4:
                    // Generate Daily Report
                    System.out.print("Enter report date (yyyy-MM-dd): ");
                    String reportDateStr = scanner.next();
                    Date reportDate = SalonDateUtils.parseDate(reportDateStr);

                    salonRevisor.generateDailyReport(reportDate);
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }

        scanner.close();
    }
}