package org.divertimento.ui;

import org.divertimento.attractions.Vehicle;
import org.divertimento.control.AttractionController;
import org.divertimento.control.EntranceTurnstile;
import org.divertimento.control.ExitTurnstile;
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
    private EntranceTurnstile noriaEntranceTurnstile;
    private ExitTurnstile noriaExitTurnstile;
    private EntranceTurnstile rollerCoasterEntranceTurnstile;
    private ExitTurnstile rollerCoasterExitTurnstile;

    public List<Vehicle> brokenVehicles = new ArrayList<>();

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

        // Initialize the turnstiles
        this.noriaEntranceTurnstile = new EntranceTurnstile(noriaController.getAttraction());
        this.noriaExitTurnstile = new ExitTurnstile(noriaController.getAttraction());
        this.rollerCoasterEntranceTurnstile = new EntranceTurnstile(rollerCoasterController.getAttraction());
        this.rollerCoasterExitTurnstile = new ExitTurnstile(rollerCoasterController.getAttraction());
    }

    public boolean run() {
        System.out.println("\nDivertimento Park System - Main Menu");
        System.out.println("1. List attractions and vehicles");
        System.out.println("2. Simulations");
        System.out.println("3. Attractions Status");
        System.out.println("4. List Breakdowns");
        System.out.println("5. CRA Report");
        System.out.println("6. Resolve Breakdown");
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
                listBreakdowns();
                break;
            case "5":
                centralReceiver.getCRAReport();
                break;
            case "6":
                resolveBreakdown();
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
            System.out.println("1. Simulate Turnstile status");
            System.out.println("2. Simulate Breakdown");
            System.out.println("3. Simulate Entrance");
            System.out.println("4. Simulate Breakdown");
            System.out.println("5. Simulate start attraction");
            System.out.println("6. Simulate stop attraction");
            System.out.println("7. Simulate entrance");
            System.out.println("8. Back to main menu");
            System.out.print("Please enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    checkTurnstileStatus();
                    break;
                case "2":
                    if (noriaVehicles != null) {
                        simulateBreakdown(noriaVehicles);
                    } else {
                        System.out.println("No vehicles found.");
                    }
                    break;
                case "3":
                    simulateEntrance();
                    break;
                case "4":
                    simulateExit();
                    break;
                case "5":
                    simulateStartAttraction();
                    break;

                case "6":
                    simulateStopAttraction();
                    break;
                case "7":
                    simulateEntrance();
                    return;
                case "8":
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

    private void resolveBreakdown() {
        System.out.print("Enter the ID of the operator who resolved the breakdown: ");
        String operatorId = scanner.nextLine();

        for (Operator operator : operators) {
            if (operator.getIdOperator().equals(operatorId)) {
                operator.resolveBreakdown();
                System.out.println("Breakdown resolved by operator: " + operatorId);
                return;
            }
        }

        System.out.println("No operator found with the ID: " + operatorId);
    }

    private void simulateEntrance() {
        System.out.print("Enter the name of the attraction (Noria or RollerCoaster): ");
        String attractionName = scanner.nextLine();

        if (attractionName.equalsIgnoreCase("Noria")) {
            System.out.println("Entrance to Noria: " + noriaEntranceTurnstile.enter());
        } else if (attractionName.equalsIgnoreCase("RollerCoaster")) {
            System.out.println("Entrance to RollerCoaster: " + rollerCoasterEntranceTurnstile.enter());
        } else {
            System.out.println("Invalid attraction name, please try again.");
        }
    }

    private void simulateExit() {
        System.out.print("Enter the name of the attraction (Noria or RollerCoaster): ");
        String attractionName = scanner.nextLine();

        if (attractionName.equalsIgnoreCase("Noria")) {
            System.out.println("Exit from Noria: " + noriaController.exitAttraction());
        } else if (attractionName.equalsIgnoreCase("RollerCoaster")) {
            System.out.println("Exit from RollerCoaster: " + rollerCoasterController.exitAttraction());
        } else {
            System.out.println("Invalid attraction name, please try again.");
        }
    }

    private void simulateStartAttraction() {
        System.out.print("Enter the ID of the operator who will start the attraction: ");
        String operatorId = scanner.nextLine();

        for (Operator operator : operators) {
            if (operator.getIdOperator().equals(operatorId)) {
                operator.controlAttraction();
                System.out.println("Attraction started by operator: " + operatorId);
                return;
            }
        }

        System.out.println("No operator found with the ID: " + operatorId);
    }

    private void simulateStopAttraction() {
        System.out.print("Enter the ID of the operator who will stop the attraction: ");
        String operatorId = scanner.nextLine();

        for (Operator operator : operators) {
            if (operator.getIdOperator().equals(operatorId)) {
                operator.controlAttraction();
                System.out.println("Attraction stopped by operator: " + operatorId);
                return;
            }
        }

        System.out.println("No operator found with the ID: " + operatorId);
    }

    private void checkTurnstileStatus() {
        System.out.print("Enter the name of the attraction (Noria or RollerCoaster) and the type of turnstile (Entrance or Exit): ");
        String input = scanner.nextLine();
        String[] parts = input.split(" ");

        if (parts.length != 2) {
            System.out.println("Invalid input, please try again.");
            return;
        }

        String attractionName = parts[0];
        String turnstileType = parts[1];

        if (attractionName.equalsIgnoreCase("Noria")) {
            if (turnstileType.equalsIgnoreCase("Entrance")) {
                System.out.println("Noria Entrance Turnstile Status: " + noriaEntranceTurnstile.getStatus());
            } else if (turnstileType.equalsIgnoreCase("Exit")) {
                System.out.println("Noria Exit Turnstile Status: " + noriaExitTurnstile.getStatus());
            } else {
                System.out.println("Invalid turnstile type, please try again.");
            }
        } else if (attractionName.equalsIgnoreCase("RollerCoaster")) {
            if (turnstileType.equalsIgnoreCase("Entrance")) {
                System.out.println("RollerCoaster Entrance Turnstile Status: " + rollerCoasterEntranceTurnstile.getStatus());
            } else if (turnstileType.equalsIgnoreCase("Exit")) {
                System.out.println("RollerCoaster Exit Turnstile Status: " + rollerCoasterExitTurnstile.getStatus());
            } else {
                System.out.println("Invalid turnstile type, please try again.");
            }
        } else {
            System.out.println("Invalid attraction name, please try again.");
        }
    }
}