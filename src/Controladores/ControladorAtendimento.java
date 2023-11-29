package Controladores;

import javafx.event.ActionEvent;

public class ControladorAtendimento {
    private Main main;
    public void voltarHome(ActionEvent actionEvent){
        main.mudar(1);
    }
    public void setMain(Main main) {
        this.main = main;
    }
}
