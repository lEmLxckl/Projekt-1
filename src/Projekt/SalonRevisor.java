package Projekt;
import java.util.*;

public class SalonRevisor {
    private SalonCalendar calendar;
    private SalonPayment payment;

    public SalonRevisor(SalonCalendar calendar, SalonPayment payment) {
        this.calendar = calendar;
        this.payment = payment;
    }

    public void generateDailyReport(Date date) {
        List<Appointment> appointments = calendar.getAppointmentsForDate(date);
        if (appointments.isEmpty()) {
            System.out.println("No appointments for the selected date.");
        } else {
            System.out.println("Daily Report for " + SalonDateUtils.formatDate(date));
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
            payment.checkOutstandingPayments(appointments);
        }
    }
}
