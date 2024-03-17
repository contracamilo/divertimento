package org.divertimento;

import org.divertimento.attractions.Noria;
import org.divertimento.attractions.Vehicle;
import org.divertimento.cra.CentralReceiver;
import org.divertimento.cra.Operator;
import org.divertimento.ui.MainFrame;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear una lista de operadores
        List<Operator> operators = new ArrayList<>();
        operators.add(new Operator("Operador 1"));
        operators.add(new Operator("Operador 2"));

        // Crear una lista de vehículos para la Noria
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("Vehículo 1", null, false, Vehicle.AnchorState.UNPINNED));
        vehicles.add(new Vehicle("Vehículo 2", null, false, Vehicle.AnchorState.UNPINNED));

        // Crear una instancia de Noria
        Noria noria = new Noria(vehicles, 0);

        // Crear una instancia de MainFrame y ejecutarla
        MainFrame mainFrame = new MainFrame(operators, noria);
        mainFrame.run();
    }
}