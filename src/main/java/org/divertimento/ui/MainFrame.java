package org.divertimento.ui;

import org.divertimento.attractions.Vehicle;
import org.divertimento.control.AttractionController;
import org.divertimento.cra.CentralReceiver;
import org.divertimento.cra.Operator;
import org.divertimento.utils.Utils;

import java.util.*;

public class MainFrame {
    private Scanner scanner;
    private Map<String, Boolean> attractionsStatus;
    private int visitorsInAttraction;
    private List<Operator> operators;
    private AttractionController noriaController;
    private AttractionController rollerCoasterController;
    private List<Vehicle> noriaVehicles;
    private List<Vehicle> rollerCoasterVehicles;
    private List<Vehicle> breakdownVehicles;
    private CentralReceiver centralReceiver;

    List<Vehicle> brokenVehicles = new ArrayList<>();

    public MainFrame(List<Operator> operators, AttractionController noriaController, AttractionController rollerCoasterController, List<Vehicle> noriaVehicles, List<Vehicle> rollerCoasterVehicles) {
        scanner = new Scanner(System.in);
        attractionsStatus = new HashMap<>();
        attractionsStatus.put("NORIA", true);
        attractionsStatus.put("MONTANA_RUSA", true);
        visitorsInAttraction = 0;

        this.operators = operators != null ? operators : new ArrayList<>();
        this.noriaController = noriaController;
        this.rollerCoasterController = rollerCoasterController;

        // Inicializar las listas de vehículos
        this.noriaVehicles = noriaVehicles != null ? noriaVehicles : new ArrayList<>();
        this.rollerCoasterVehicles = rollerCoasterVehicles != null ? rollerCoasterVehicles : new ArrayList<>();
        this.breakdownVehicles = new ArrayList<>();
        this.centralReceiver = CentralReceiver.getInstance(operators);
    }

    public boolean run() {
        System.out.println("\nDivertimento Park System - Main Menu");
        System.out.println("1. List attractions and vehicles");
        System.out.println("2. Simulations");
        System.out.println("3. Attractions Status");
        System.out.println("4. Check for failures");
        System.out.println("5. List Breakdowns");
        System.out.println("6. CRA Report");
        System.out.println("7. Exit");
        System.out.print("Please enter your choice: ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                printAttractionsAndVehicles();
                break;
            case "2":
                runSimulationsMenu();
                break;
            case "3":
                printStatus();
                break;
            case "4":
                checkForFailures();
                break;
            case "5":
                listBreakdowns();
                break;
            case "6":
                centralReceiver.getCRAReport();
                break;
            case "7":
                //close();
                System.out.println("Closing system...");
                System.exit(0);
                return false;
            default:
                System.out.println("Invalid choice, please try again.");
                break;
        }
        return true;
    }

    private void runSimulationsMenu() {
        while (true) {
            System.out.println("\nDivertimento Park System - Simulations Menu");
            System.out.println("1. Simulate Visitors Flow");
            System.out.println("2. Simulate Entrance to Noria");
            System.out.println("3. Simulate Exit from Noria");
            System.out.println("4. Simulate Entrance to RollerCoaster");
            System.out.println("5. Simulate Exit from RollerCoaster");
            System.out.println("6. Simulate Breakdown");
            System.out.println("7. Back to Main Menu");
            System.out.print("Please enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    //simulateVisitorsFlow();
                    break;
                case "2":
                    System.out.println("Entrance to Noria: " + noriaController.enterAttraction());
                    break;
                case "3":
                    System.out.println("Exit from Noria: " + noriaController.exitAttraction());
                    break;
                case "4":
                    System.out.println("Entrance to RollerCoaster: " + rollerCoasterController.enterAttraction());
                    break;
                case "5":
                    System.out.println("Exit from RollerCoaster: " + rollerCoasterController.exitAttraction());
                    break;
                case "6":
                    if (noriaVehicles != null) {
                        simulateBreakdown(noriaVehicles);
                    } else {
                        System.out.println("No vehicles found for Noria.");
                    }
                    break;
                case "7":
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }

    public void simulateBreakdown(List<Vehicle> vehicles) {
        Random random = new Random();
        int randomIndex = random.nextInt(vehicles.size());
        Vehicle vehicle = vehicles.get(randomIndex);

        vehicle.setHasReviewRequest(true);
        vehicle.setAnchorState(Utils.AnchorState.UNPINNED);

        // Agregar el vehículo averiado a la lista de vehículos averiados
        breakdownVehicles.add(vehicle);

        System.out.println("A breakdown has been simulated in vehicle: " + vehicle.getIdVehicle());
        System.out.println("The CRA and the attraction have been notified.");
    }

    public void printAttractionsAndVehicles() {
        System.out.println("Attractions and Vehicles:");

        System.out.println("\nNoria:");
        for (Vehicle vehicle : noriaVehicles) {
            System.out.println("Vehicle ID: " + vehicle.getIdVehicle() + ", Anchor State: " + vehicle.getAnchorState());
        }

        System.out.println("\nRollerCoaster:");
        for (Vehicle vehicle : rollerCoasterVehicles) {
            System.out.println("Vehicle ID: " + vehicle.getIdVehicle() + ", Anchor State: " + vehicle.getAnchorState());
        }
    }

    public void printStatus(){
        System.out.println("Attractions Status:");
        System.out.println("NORIA: " + noriaController.getAttraction().getStatus());
        System.out.println("MONTANA_RUSA: " + rollerCoasterController.getAttraction().getStatus());
    }

    public void listBreakdowns() {
        System.out.println("List of breakdowns:");
        for (Vehicle vehicle : breakdownVehicles) {
            System.out.println("Vehicle ID: " + vehicle.getIdVehicle());
        }
    }

    public void checkForFailures() {



    }
}