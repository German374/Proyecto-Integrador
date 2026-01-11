package ec.edu.espoch.rutaspendie_max_min.dao;

import ec.edu.espoch.rutaspendie_max_min.model.Funcion;

public interface FuncionDAO{
    double derivadaLineal(Funcion f);

    double puntoCritico(Funcion f);

    double valorFuncion(Funcion f, double x);

    double segundaDerivada(Funcion f);
}

