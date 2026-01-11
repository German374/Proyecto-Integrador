package ec.edu.espoch.rutaspendie_max_min;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/ec/edu/espoch/rutaspendie_max_min/primary.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Análisis de Pendientes");
        stage.setScene(scene);
        stage.show();
    }

    public static void cambiarVista(String fxml) throws Exception{
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/ec/edu/espoch/rutaspendie_max_min/" + fxml + ".fxml"));
        stage.setScene(new Scene(loader.load()));
    }

    public static void main(String[] args){
        launch(args);
    }
}
