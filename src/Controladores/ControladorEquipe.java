package Controladores;

import javafx.event.ActionEvent;

public class ControladorEquipe {
    private Main main;
    public void setMain(Main main){
        this.main = main;
    }
    public void voltarHome(ActionEvent actionEvent){
        main.mudar(1);
    }
}
