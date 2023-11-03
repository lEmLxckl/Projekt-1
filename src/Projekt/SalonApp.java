package Projekt;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class SalonApp {
    private SalonCalendar calendar;
    private SalonPayment payment;

    public SalonApp(SalonCalendar calendar, SalonPayment payment) {
        this.calendar = calendar;
        this.payment = payment;
    }

    public void createAppointment(Date date, String time, Customer customer, double price) {
        calendar.bookAppointment(date, time, customer, price);
    }

    public void deleteAppointment(Date date, String time) {
        calendar.cancelAppointment(date, time);
    }

    public void displayAppointments(Date date) {
        List<Appointment> appointments = calendar.getAppointmentsForDate(date);
        if (appointments.isEmpty()) {
            System.out.println("No appointments for the selected date.");
        } else {
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        }
    }
}

