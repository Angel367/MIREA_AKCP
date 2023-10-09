import java.rmi.RemoteException;

public class QuadraticSolverImpl implements QuadraticSolver {
    @Override
    public QuadraticEquationResult solveEquation(double a, double b, double c) throws RemoteException {
        // Реализация решения квадратного уравнения
        double discriminant = b * b - 4 * a * c;
        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            return new QuadraticEquationResult(root1, root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            return new QuadraticEquationResult(root);
        } else {
            return new QuadraticEquationResult();
        }
    }
}
