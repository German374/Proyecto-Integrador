package ec.edu.espoch.rutaspendie_max_min.model;

public class Funcion {
    private double a;
    private double b;
    private double c;

    public Funcion(double a, double b){
        this.a = a;
        this.b = b;
    }

    public Funcion(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA(){
        return a;
    }

    public double getB(){
        return b;
    }

    public double getC(){
        return c;
    }
}
