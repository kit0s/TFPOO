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
    private Parent equipe;
    private Parent equipamento;
    private Parent atendimento;
    //controladores
    private ControladorHome control1;
    private ControladorEvento control2;
    private ControladorEquipe control3;
    private ControladorEquipamento control4;
    private ControladorAtendimento control5;
    @Override
    public void start(Stage stage){
        try{
            FXMLLoader loader1 = new FXMLLoader();
            home = (Parent) loader1.load(getClass().getResource("home.fxml").openStream());
            control1 = (ControladorHome) loader1.getController();
            control1.setMain(this);
            control1.setStage(stage);

            FXMLLoader loader2 = new FXMLLoader();
            evento = (Parent) loader2.load(getClass().getResource("Eventos.fxml").openStream());
            control2 = (ControladorEvento) loader2.getController();
            control2.setMain(this);
            control2.setStage(stage);

            FXMLLoader loader3 = new FXMLLoader();
            equipe = (Parent) loader3.load(getClass().getResource("equipes.fxml").openStream());
            control3 = (ControladorEquipe) loader3.getController();
            control3.setMain(this);

            FXMLLoader loader4 = new FXMLLoader();
            equipamento = (Parent) loader4.load(getClass().getResource("equipamento.fxml").openStream());
            control4 = (ControladorEquipamento) loader4.getController();
            control4.setMain(this);

            FXMLLoader loader5 = new FXMLLoader();
            atendimento = (Parent) loader5.load(getClass().getResource("atendimento.fxml").openStream());
            control5 = (ControladorAtendimento) loader5.getController();
            control5.setMain(this);

            cena = new Scene(home);

            stage.setTitle("ACMERescue");
            stage.setWidth(700);
            stage.setHeight(650);
            stage.setScene(cena);
            stage.show();

        }
        catch (Exception e){
            System.out.println("Erro: "+ e);
        }
    }
    public boolean mudar(int stage) {
        switch (stage) {
            case 1:
                cena.setRoot(home);
                break;
            case 2:
                cena.setRoot(evento);
                break;
            case 3:
                cena.setRoot(equipe);
                break;
            case 4:
                cena.setRoot(equipamento);
                break;
            case 5:
                cena.setRoot(atendimento);
        }

        return false;
    }
    public static void main(String[] args) {
        launch();
    }
}
