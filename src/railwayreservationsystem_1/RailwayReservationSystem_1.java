/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railwayreservationsystem_1;

import java.util.ArrayList;
import java.util.Scanner;

class Passenger {
    private String name;
    private int age;

    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
class Train {
    private String trainNum;
    private String trainName;
    private int totalSeats;
    private int availableSeats;

    public Train(String trainNum, String trainName, int totalSeats) {
        this.trainNum = trainNum;
        this.trainName = trainName;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public String getTrainNumber() {
        return trainNum;
    }

    public String getTrainName() {
        return trainName;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookSeats(int seatsToBook) {
        if (seatsToBook > 0 && seatsToBook <= availableSeats) {
            availableSeats -= seatsToBook;
            System.out.println(seatsToBook + " seat(s) booked successfully.");
        } else {
            System.out.println("Invalid number of seats to book.");
        }
    }

    public void displayTrainInfo() {
        System.out.println("Train Number: " + trainNum);
        System.out.println("Train Name: " + trainName);
        System.out.println("Total Seats: " + totalSeats);
        System.out.println("Available Seats: " + availableSeats);
    }
}

public class RailwayReservationSystem_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get the number of tickets to be booked
        System.out.print("Enter the number of tickets to book: ");
        int numTickets = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        // Create a new Train object
        Train expressTrain = new Train("57698", "VANDE BHARATH", 200);

        // Display train information
        expressTrain.displayTrainInfo();
        
        // ArrayList to store passenger details
        ArrayList<Passenger> passengers = new ArrayList<>();

        // Book tickets and get passenger details
        for (int i = 0; i < numTickets; i++) {
            System.out.println("\nEnter details for Passenger " + (i+1) + ":");
            System.out.print("Enter passenger name: ");
            String name = scanner.nextLine();
            System.out.print("Enter passenger age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            passengers.add(new Passenger(name, age));
            expressTrain.bookSeats(1); // Book one seat for each passenger
        }

        // Display passenger details
        System.out.println("\nPassenger Details:");
        for (int i = 0; i < passengers.size(); i++) {
            Passenger passenger = passengers.get(i);
            System.out.println("Passenger " + (i+1) + ": Name - " + passenger.getName() + ", Age - " + passenger.getAge());
        }

        // Display updated train information
        expressTrain.displayTrainInfo();
        
        scanner.close();
    }
}

