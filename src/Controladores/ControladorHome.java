package Controladores;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class ControladorHome {
    @FXML
    private Button cadEventos;
    private Main main;
    public void setMain(Main main){this.main = main;}
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void evento(ActionEvent actionEvent) {
        main.mudar(2);
    }
    public void equipe(ActionEvent actionEvent){main.mudar(3);}
    public void equipamento(ActionEvent actionEvent){main.mudar(4);}

}
