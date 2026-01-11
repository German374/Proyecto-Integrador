package ec.edu.espoch.rutaspendie_max_min.util;

public class CalculadoraPendiente
{
    public static double derivadaLineal(double a){
        return a;
    }

    public static double puntoCritico(double a, double b){
        return -b / (2 * a);
    }

    public static double valorFuncionCuadratica(double a, double b, double c, double x){
        return a * x * x + b * x + c;
    }
}

