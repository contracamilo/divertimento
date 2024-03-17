package org.divertimento.ui;

import org.divertimento.attractions.Noria;
import org.divertimento.cra.CentralReceiver;
import org.divertimento.cra.Operator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainFrame {
    private static final String NORIA = "Noria";
    private static final String MONTANA_RUSA = "Montaña Rusa";
    private final Scanner scanner;
    private final Map<String, Boolean> attractionsStatus;
    private int visitorsInAttraction;

    private CentralReceiver centralReceiver;
    private Noria noria;


    public MainFrame(List<Operator> operators, Noria noria) {
        scanner = new Scanner(System.in);
        attractionsStatus = new HashMap<>();
        attractionsStatus.put(NORIA, true);
        attractionsStatus.put(MONTANA_RUSA, true);
        visitorsInAttraction = 0;

        this.centralReceiver = new CentralReceiver(operators);
        this.noria = noria;
    }

    public void run() {
        while (true) {
            System.out.println("\nDivertimento Park System - Main Menu");
            System.out.println("1. Simulate Breakdown");
            System.out.println("2. Repair Attraction");
            System.out.println("3. Simulate Visitors Flow");
            System.out.println("4. Exit");
            System.out.print("Please enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    simulateBreakdown();
                    break;
                case "2":
                    repairAttraction();
                    break;
                case "3":
                    simulateVisitorsFlow();
                    break;
                case "4":
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }
    private void simulateVisitorsFlow() {
        System.out.println("Current visitors in attraction: " + visitorsInAttraction);
        System.out.println("Enter number of visitors entering or leaving (- to leave): ");
        int change = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over

        int newCount = visitorsInAttraction + change;

        int maxVisitorsInAttraction = 50;
        if (newCount > maxVisitorsInAttraction) {
            System.out.println("Cannot have more than " + maxVisitorsInAttraction + " visitors in the attraction.");
        } else if (newCount < 0) {
            System.out.println("Cannot have fewer than 0 visitors in the attraction.");
        } else {
            visitorsInAttraction = newCount;
            System.out.println("Updated visitors in attraction: " + visitorsInAttraction);
        }
    }

    public void simulateBreakdown() {
        String attraction = getAttractionInput("Which attraction has a breakdown? (Noria/Montaña Rusa)");
        if (attraction != null) {
            attractionsStatus.put(attraction, false);
            System.out.println(attraction + " is now marked as having a breakdown.");
        }
    }

    public void repairAttraction() {
        String attraction = getAttractionInput("Which attraction did you repair? (Noria/Montaña Rusa)");
        if (attraction != null) {
            attractionsStatus.put(attraction, true);
            System.out.println(attraction + " has been repaired and is now operational.");
        }
    }

    private String getAttractionInput(String prompt) {
        System.out.println(prompt);
        String attraction = scanner.nextLine();
        if (!attractionsStatus.containsKey(attraction)) {
            System.out.println("Attraction not recognized.");
            return null;
        }
        return attraction;
    }

    public void close() {
        scanner.close();
    }
}