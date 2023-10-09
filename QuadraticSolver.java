import java.rmi.Remote;
import java.rmi.RemoteException;

public interface QuadraticSolver extends Remote {
    QuadraticEquationResult solveEquation(double a, double b, double c) throws RemoteException;
}
