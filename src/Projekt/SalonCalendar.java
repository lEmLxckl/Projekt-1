package Projekt;

import java.util.*;

public class SalonCalendar {
    private Map<Date, List<Appointment>> appointments;
    private Set<Date> closedDates;

    public SalonCalendar() {
        appointments = new HashMap<>();
        closedDates = new HashSet<>();
    }

    public void bookAppointment(Date date, String time, Customer customer, double price) {
        if (!closedDates.contains(date)) {
            Appointment appointment = new Appointment(date, time, customer, price);
            List<Appointment> appointmentsForDate = appointments.computeIfAbsent(date, k -> new ArrayList<>());
            appointmentsForDate.add(appointment);
        } else {
            System.out.println("The salon is closed on the selected date.");
        }
    }

    public void cancelAppointment(Date date, String time) {
        List<Appointment> appointmentsForDate = appointments.get(date);
        if (appointmentsForDate != null) {
            appointmentsForDate.removeIf(appointment -> appointment.getTime().equals(time));
            if (appointmentsForDate.isEmpty()) {
                appointments.remove(date);
            }
        }
    }

    public List<Appointment> getAppointmentsForDate(Date date) {
        return appointments.getOrDefault(date, new ArrayList<>());
    }

    public void markDateAsClosed(Date date) {
        closedDates.add(date);
    }
}



