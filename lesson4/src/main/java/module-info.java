module ru.gb.lesson4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.gb.lesson4 to javafx.fxml;
    exports ru.gb.lesson4;
}