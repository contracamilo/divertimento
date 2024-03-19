package org.divertimento;

import org.divertimento.attractions.Noria;
import org.divertimento.attractions.RollerCoaster;
import org.divertimento.attractions.Vehicle;
import org.divertimento.control.AttractionController;
import org.divertimento.cra.CentralReceiver;
import org.divertimento.cra.Operator;
import org.divertimento.cra.OperatorDevice;
import org.divertimento.ui.MainFrame;
import org.divertimento.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        boolean running = true;

        List<Operator> operators = new ArrayList<>();
        operators.add(new Operator("Operador 1"));

        List<Vehicle> noriaVehicles = new ArrayList<>();
        List<Vehicle> rollerCoasterVehicles = new ArrayList<>();

        Noria noria = new Noria(noriaVehicles, 0, 100);
        RollerCoaster rollerCoaster = new RollerCoaster(rollerCoasterVehicles, 0, 20);

        CentralReceiver cra = new CentralReceiver(operators);

        // Vehículos para la Noria
        noriaVehicles.add(new Vehicle("Vehículo 1", noria, false, Utils.AnchorState.PINNED, cra));
        noriaVehicles.add(new Vehicle("Vehículo 2", noria, false, Utils.AnchorState.PINNED, cra));
        noriaVehicles.add(new Vehicle("Vehículo 3", noria, false, Utils.AnchorState.PINNED, cra));
        // Vehículos para la m. rusa
        rollerCoasterVehicles.add(new Vehicle("Carro 1", rollerCoaster, false, Utils.AnchorState.PINNED, cra));
        rollerCoasterVehicles.add(new Vehicle("Carro 2", rollerCoaster, false, Utils.AnchorState.PINNED, cra));
        rollerCoasterVehicles.add(new Vehicle("Carro 3", rollerCoaster, false, Utils.AnchorState.PINNED, cra));


        while (running) {

            // Crear controladores de atracciones
            AttractionController noriaController = new AttractionController(noria);
            AttractionController rollerCoasterController = new AttractionController(rollerCoaster);

            MainFrame mainFrame = new MainFrame(operators, noriaController, rollerCoasterController, noriaVehicles, rollerCoasterVehicles);
            running = mainFrame.run();
        }
    }
}