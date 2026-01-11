package ec.edu.espoch.rutaspendie_max_min.dao;

import ec.edu.espoch.rutaspendie_max_min.model.Funcion;

public class FuncionDAOImpl implements FuncionDAO{

    @Override
    public double derivadaLineal(Funcion f){
        return f.getA();
    }

    @Override
    public double puntoCritico(Funcion f){
        return -f.getB() / (2 * f.getA());
    }

    @Override
    public double valorFuncion(Funcion f, double x){
        return f.getA() * x * x + f.getB() * x + f.getC();
    }

    @Override
    public double segundaDerivada(Funcion f){
        return 2 * f.getA();
    }
}

