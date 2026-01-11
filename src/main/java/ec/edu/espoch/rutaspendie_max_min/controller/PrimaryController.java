package ec.edu.espoch.rutaspendie_max_min.controller;

import ec.edu.espoch.rutaspendie_max_min.App;
import ec.edu.espoch.rutaspendie_max_min.dao.FuncionDAO;
import ec.edu.espoch.rutaspendie_max_min.dao.FuncionDAOImpl;
import ec.edu.espoch.rutaspendie_max_min.model.Funcion;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PrimaryController{
    @FXML
    private ComboBox<String> cmbTipoFuncion;

    @FXML
    private TextField txtA;

    @FXML
    private TextField txtB;

    @FXML
    private TextField txtC;

    @FXML
    private Label lblResultado;

    @FXML
    private Label lblMaxima;

    @FXML
    private Label lblMinima;

    @FXML
    private Label lblMensaje;

    private final FuncionDAO dao = new FuncionDAOImpl();

    @FXML
    public void initialize(){
        cmbTipoFuncion.setItems(FXCollections.observableArrayList("Función lineal", "Función cuadrática"));
        cmbTipoFuncion.getSelectionModel().selectFirst();
        actualizarCampos();
    }

    @FXML
    private void actualizarCampos(){
        txtC.setDisable(cmbTipoFuncion.getValue().equals("Función lineal"));
    }

    @FXML
    private void calcular(){
        try{
            lblResultado.setText("");
            lblMaxima.setText("");
            lblMinima.setText("");
            lblMensaje.setText("");

            double a = Double.parseDouble(txtA.getText());
            double b = Double.parseDouble(txtB.getText());

            if (cmbTipoFuncion.getValue().equals("Función lineal")){
                Funcion f = new Funcion(a, b);
                double derivada = dao.derivadaLineal(f);

                lblResultado.setText("Derivada: f'(x) = " + derivada);

                if (derivada > 0){
                    lblMaxima.setText("Función creciente");
                    lblMinima.setText("No tiene máximo ni mínimo");
                }
                else if (derivada < 0){
                    lblMaxima.setText("Función decreciente");
                    lblMinima.setText("No tiene máximo ni mínimo");
                }
                else{
                    lblMaxima.setText("Función constante");
                    lblMinima.setText("No tiene máximo ni mínimo");
                }
            }
            else{
                double c = Double.parseDouble(txtC.getText());
                Funcion f = new Funcion(a, b, c);
                double xCritico = dao.puntoCritico(f);
                double yCritico = dao.valorFuncion(f, xCritico);
                double segunda = dao.segundaDerivada(f);
                lblResultado.setText("Punto crítico: (" + xCritico + " , " + yCritico + ")");

                if (a > 0){
                    lblMinima.setText("Mínimo en y = " + yCritico);
                    lblMaxima.setText("No existe máximo");
                }
                else{
                    lblMaxima.setText("Máximo en y = " + yCritico);
                    lblMinima.setText("No existe mínimo");
                }

                lblMensaje.setText("Segunda derivada: f''(x) = " + segunda);
            }
        }
        catch (NumberFormatException e){
            lblMensaje.setText("Ingrese solo valores numéricos");
        }
    }

    @FXML
    private void limpiar(){
        txtA.clear();
        txtB.clear();
        txtC.clear();

        lblResultado.setText("");
        lblMaxima.setText("");
        lblMinima.setText("");
        lblMensaje.setText("");
    }

    
    @FXML
    private void switchToSecondary() throws Exception{
        App.cambiarVista("secondary");
    }
}


