module org.example.batallanaval1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.batallanaval1 to javafx.fxml;
    exports org.example.batallanaval1;
    opens org.example.batallanaval1.controller;
    exports org.example.batallanaval1.controller;
}