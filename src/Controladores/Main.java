package Controladores;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application {
    private Scene cena;
    //paineis
    private Parent evento;
    //controladores
    private ControladorEvento control2;

    @Override
    public void start(Stage stage){
        try{
            FXMLLoader loader2 = new FXMLLoader();
            evento = (Parent) loader2.load(getClass().getResource("TelaPrincipal.fxml").openStream());
            control2 = (ControladorEvento) loader2.getController();
            control2.setMain(this);
            control2.setStage(stage);


            cena = new Scene(evento);

            stage.setTitle("ACMERescue");
            stage.setWidth(860);
            stage.setHeight(650);
            stage.setScene(cena);
            stage.show();

        }
        catch (Exception e){
            System.out.println("Erro: "+ e);
        }
    }
    public static void main(String[] args) {
        launch();
    }
}
