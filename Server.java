import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends QuadraticSolverImpl {
    public Server() {}
    public static void main(String[] args) {
        try {
            QuadraticSolverImpl obj = new QuadraticSolverImpl();

            QuadraticSolver quadraticSolver = (QuadraticSolver) UnicastRemoteObject.exportObject(obj, 50501);

            Registry registry = LocateRegistry.createRegistry(50501);

            registry.bind("QuadraticSolver", quadraticSolver);
            System.err.println("Server ready");
        } catch (Exception e) {
            System.out.println("Server exception: " + e);
            e.printStackTrace();
        }
    }
}
