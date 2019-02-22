import com.Rocket;
import com.Simulation;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {

    Simulation simulation = new Simulation();

    System.out.println("U1 Fleet: " + (simulation.loadU1()).toString());
    System.out.println("U2 Fleet: " + (simulation.loadU2()).toString());
    System.out.println("Total para la simulación U1: " + (simulation.runSimulation(simulation.loadU1())).toString());
    System.out.println("Total para la simulación U2: " + (simulation.runSimulation(simulation.loadU2())).toString());

  }
}
