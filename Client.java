import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    private Client() {}
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(50501);
            QuadraticSolver solver = (QuadraticSolver) registry.lookup("QuadraticSolver");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Input a:");
            double a = scanner.nextDouble();

            System.out.println("Input b:");
            double b = scanner.nextDouble();

            System.out.println("Input c:");
            double c = scanner.nextDouble();

            QuadraticEquationResult result = solver.solveEquation(a, b, c);

            System.out.println("Root 1: " + result.getRoot1());
            System.out.println("Root 2: " + result.getRoot2());
        } catch (Exception e) {
            System.out.println("Client exception: " + e);
            e.printStackTrace();
        }
    }
}
