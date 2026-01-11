package ec.edu.espoch.rutaspendie_max_min.controller;

import javafx.fxml.FXML;
import ec.edu.espoch.rutaspendie_max_min.App;

public class SecondaryController{
    @FXML
    private void volverVistaPrincipal() throws Exception
    {
        App.cambiarVista("primary");
    }
}

