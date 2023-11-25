package Controladores;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class ControladorHome {
    @FXML
    private Button cadEventos;
    private Main main;
    public void setMain(Main main){this.main = main;}

    public void mudarCena(ActionEvent actionEvent) {
        main.mudar(2);
    }
}
