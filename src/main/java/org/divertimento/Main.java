package org.divertimento;

import org.divertimento.attractions.Noria;
import org.divertimento.attractions.RollerCoaster;
import org.divertimento.attractions.Vehicle;
import org.divertimento.control.AttractionController;
import org.divertimento.cra.CentralReceiver;
import org.divertimento.cra.Operator;
import org.divertimento.cra.OperatorDevice;
import org.divertimento.ui.MainFrame;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Crear una lista de operadores
        List<Operator> operators = new ArrayList<>();

        // Crear una instancia de CentralReceiver
        CentralReceiver cra = new CentralReceiver(operators);

        // Crear operadores y agregarlos a la lista
        Operator operator1 = new Operator("Operador 1");
        operators.add(operator1);

        Operator operator2 = new Operator("Operador 2");
        operators.add(operator2);

        // Crear dispositivos para los operadores y asignarlos
        OperatorDevice device1 = new OperatorDevice(operator1);
        operator1.setDevice(device1);

        OperatorDevice device2 = new OperatorDevice(operator2);
        operator2.setDevice(device2);

        // Crear una lista de vehículos para la Noria
        List<Vehicle> vehicles = new ArrayList<>();

        // Crear una instancia de Noria
        Noria noria = new Noria(vehicles, 0, 10); // capacidad de 10

        // Crear una instancia de RollerCoaster
        RollerCoaster rollerCoaster = new RollerCoaster(vehicles, 0, 5); // capacidad de 5

        // Crear vehículos y agregarlos a la lista
        vehicles.add(new Vehicle("Vehículo 1", noria, false, Vehicle.AnchorState.UNPINNED, cra));
        vehicles.add(new Vehicle("Vehículo 2", noria, false, Vehicle.AnchorState.UNPINNED, cra));

        // Crear controladores de atracciones
        AttractionController noriaController = new AttractionController(noria);
        AttractionController rollerCoasterController = new AttractionController(rollerCoaster);

        // Crear una instancia de MainFrame y ejecutarla
        MainFrame mainFrame = new MainFrame(operators, noria, noriaController, rollerCoasterController);
        mainFrame.run();
    }
}