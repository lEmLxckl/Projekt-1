package Projekt;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;
class Appointment {
    private Date date;
    private String time;
    private Customer customer;
    private double totalAmount;
    private boolean paid;

    public Appointment(Date date, String time, Customer customer, double price) {
        this.date = date;
        this.time = time;
        this.customer = customer;
        this.totalAmount = price;
        this.paid = false;
    }

    public Date getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public boolean isPaid() {
        return paid;
    }

    public void markAsPaid() {
        paid = true;
    }

    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdf.format(date);
        return "Date: " + dateStr + ", Time: " + time + ", Customer: " + customer.getName() + ", Total Amount: " + totalAmount + ", Paid: " + (paid ? "Yes" : "No");
    }
}
