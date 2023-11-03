package Projekt;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;
public class SalonPayment {
    public void recordPayment(Appointment appointment) {
        appointment.markAsPaid();
        System.out.println("Payment recorded for " + appointment.getCustomer().getName() + " - Amount: " + appointment.getTotalAmount());
    }

    public void checkOutstandingPayments(List<Appointment> appointments) {
        for (Appointment appointment : appointments) {
            if (!appointment.isPaid()) {
                System.out.println("Outstanding payment for " + appointment.getCustomer().getName() + " - Total Amount: " + appointment.getTotalAmount());
            }
        }
    }
}

