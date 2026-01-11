module ec.edu.espoch.rutaspendie_max_min{
    requires javafx.controls;
    requires javafx.fxml;

    opens ec.edu.espoch.rutaspendie_max_min.controller to javafx.fxml;

    exports ec.edu.espoch.rutaspendie_max_min;
}

