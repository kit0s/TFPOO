package Controladores;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application {
    private Scene cena;
    //paineis
    private Parent home;
    private Parent evento;
    //controladores
    private ControladorHome control1;
    private ControladorEvento control2;
    @Override
    public void start(Stage stage){
        try{
            FXMLLoader loader1 = new FXMLLoader();
            home = (Parent) loader1.load(getClass().getResource("home.fxml").openStream());
            control1 = (ControladorHome) loader1.getController();
            control1.setMain(this);
            FXMLLoader loader2 = new FXMLLoader();
            evento = (Parent) loader2.load(getClass().getResource("Eventos.fxml").openStream());
            control2 = (ControladorEvento) loader2.getController();
            control2.setMain(this);

            cena = new Scene(home, 700, 275);
            stage.setTitle("Home");
            stage.setWidth(700);
            stage.setHeight(500);
            stage.setScene(cena);
            stage.show();

        }
        catch (Exception e){
            System.out.println("Erro: "+ e);
        }
    }
    public void mudar(int stage) {
        switch (stage) {
            case 1:
                cena.setRoot(home);
                break;
            case 2:
                cena.setRoot(evento);
                break;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
