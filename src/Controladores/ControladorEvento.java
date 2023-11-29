package Controladores;
import Cadastro.Cadastro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
public class ControladorEvento implements Initializable {

    @FXML
    private Label labelCadEvento;
    @FXML
    private TextField textFieldLong;
    @FXML
    private TextField textFieldLat;
    @FXML
    private DatePicker datePickerData;
    @FXML
    private ChoiceBox<String> choiceBoxEventos;
    private String[] evento = {"Ciclone","Terremoto", "Seca"};
    @FXML
    private Label labelConfirma;
    @FXML
    private TextField textFieldVelocidade;
    @FXML
    private TextField textFieldMagnitude;
    @FXML
    private TextField textFieldSeca;
    @FXML
    private TextField textFieldPrecipitacao;
    @FXML
    private Label labelMagnitude;
    @FXML
    private Label labelVelocidade;
    @FXML
    private Label labelSeca;
    @FXML
    private Label labelPrecipitacao;
    @FXML
    private Label labelCodigo;
    @FXML
    private TextField textFieldCodigo;
    @FXML
    private TextArea textAreaDados;
    @FXML
    private VBox telaEvento;
    @FXML
    private AnchorPane telaEquipamento;
    private Main main;
    private Stage stage;

    public void setMain(Controladores.Main main){this.main = main;}


    public void fecharApp(){
        System.exit(0);
    }

    Cadastro cadEvent = new Cadastro();
    public void getEvento(ActionEvent event){
        String myEvento = choiceBoxEventos.getValue();
    }

    public void choiceBoxChange2() {
        String selectedEvent = choiceBoxEventos.getValue();
        limparCampos();
        if ("Ciclone".equals(selectedEvent)) {
            textFieldVelocidade.setVisible(true);
            labelVelocidade.setVisible(true);
            textFieldPrecipitacao.setVisible(true);
            labelPrecipitacao.setVisible(true);
        } else if ("Terremoto".equals(selectedEvent)) {
            textFieldMagnitude.setVisible(true);
            labelMagnitude.setVisible(true);
            textFieldPrecipitacao.setVisible(false);
            labelPrecipitacao.setVisible(false);
        } else if ("Seca".equals(selectedEvent)) {
            textFieldSeca.setVisible(true);
            labelSeca.setVisible(true);
            textFieldPrecipitacao.setVisible(false);
            labelPrecipitacao.setVisible(false);
        }
    }
    @FXML
    private void buttonClickAction() {
        try {
            String mensagem = "";
            String codigo = textFieldCodigo.getText();
            String data = datePickerData.getValue().toString();
            double longitude = Double.parseDouble(textFieldLong.getText());
            double latitude = Double.parseDouble(textFieldLat.getText());
            String selectedEvent = choiceBoxEventos.getValue();
            if (selectedEvent.equals("Terremoto")){
                double magnitude = Double.parseDouble(textFieldMagnitude.getText());
                mensagem = cadEvent.cadT(codigo,data,longitude,latitude,magnitude);
                exibirMensagem(mensagem);
            }
            else if(selectedEvent.equals("Ciclone")){
                double velocidade = Double.parseDouble(textFieldVelocidade.getText());
                double precipitacao = Double.parseDouble(textFieldPrecipitacao.getText());
                mensagem = cadEvent.cadC(codigo,data,longitude,latitude,velocidade,precipitacao);
                exibirMensagem(mensagem);
            }
            else if (selectedEvent.equals("Seca")) {
                int seca = Integer.parseInt(textFieldSeca.getText());
                mensagem = cadEvent.cadS(codigo,data,longitude,latitude,seca);
                exibirMensagem(mensagem);
            }
        } catch (NumberFormatException e) {
            exibirMensagem("Erro de formato numérico: Por favor, insira valores numéricos válidos.");
        } catch (NullPointerException e) {
            exibirMensagem("Erro de referência nula: Certifique-se de preencher todos os campos obrigatórios.");
        } catch (IllegalArgumentException e) {
            exibirMensagem("Erro de argumento inválido: O evento selecionado não é válido."); // tem nem como, mas coloquei
        } catch (Exception e) {
            exibirMensagem("Erro desconhecido: " + e.getMessage());
        }
    }
    private void limparCampos() {
        textFieldMagnitude.setVisible(false);
        labelMagnitude.setVisible(false);
        textFieldVelocidade.setVisible(false);
        labelVelocidade.setVisible(false);
        textFieldSeca.setVisible(false);
        labelSeca.setVisible(false);
    }
    public void limparDados(){
        textFieldMagnitude.setText(null);
        textFieldVelocidade.setText(null);
        datePickerData.setValue(null);
        textFieldLat.setText(null);
        textFieldLong.setText(null);
        textFieldSeca.setText(null);
        textFieldPrecipitacao.setText(null);
        textFieldCodigo.setText(null);
        textAreaDados.setText(null);
        labelCadEvento.setVisible(false);
    }
    public void exibirMensagem(String mensagem){
        labelConfirma.setVisible(true);
        labelConfirma.setText(mensagem);
    }
    public void mostrarDados() {
        String eventosStr = cadEvent.mostrarEventos();
        textAreaDados.setVisible(true);
        textAreaDados.setText(eventosStr);
        labelCadEvento.setVisible(true);
    }
    @FXML
    private TextField textFieldId;
    @FXML
    private TextField textFieldNome;
    @FXML
    private TextField textFieldcustoDia;
    @FXML
    private TextField textFieldCapInt;
    @FXML
    private TextField textFieldCapDouble;
    @FXML
    private TextField textFieldCarga;
    @FXML
    private Label labelCapInt;
    @FXML
    private Label labelCombustivel;
    @FXML
    private Label labelCarga;
    @FXML
    private ChoiceBox<String> choiceBoxEquipamento;
    @FXML
    private ChoiceBox<String> choiceBoxComb;
    @FXML
    private Label labelConfirma2;
    Cadastro cadEquip = new Cadastro();
    private String[] equipamento = {"Caminhão Tanque","Barco", "Escavadeira"};
    private String[] combustivel = {"Diesel","Gasolina", "Álcool"};
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBoxEventos.getItems().addAll(evento);
        choiceBoxEventos.setOnAction(event -> choiceBoxChange2());
        choiceBoxEquipamento.getItems().addAll(equipamento);
        choiceBoxEquipamento.setOnAction(event -> choiceBoxChange()); // Chama o método quando a escolha inicial muda
        choiceBoxComb.getItems().addAll(combustivel);
        choiceBoxComb.setOnAction(event -> choiceBoxChange());
    }
    public void choiceBoxChange() {
        String selectedEvent = choiceBoxEquipamento.getValue();
        limparCampos2();
        if ("Caminhão Tanque".equals(selectedEvent)) {
            textFieldCapDouble.setVisible(true);
            labelCapInt.setVisible(true);
            textFieldCarga.setVisible(false);
            choiceBoxComb.setVisible(false);
            labelCarga.setVisible(false);
        } else if ("Barco".equals(selectedEvent)) {
            textFieldCapInt.setVisible(true);
            textFieldCapDouble.setVisible(false);
            labelCapInt.setVisible(true);
            textFieldCarga.setVisible(false);
            choiceBoxComb.setVisible(false);
            labelCarga.setVisible(false);
        } else if ("Escavadeira".equals(selectedEvent)) {
            textFieldCarga.setVisible(true);
            labelCarga.setVisible(true);
            choiceBoxComb.setVisible(true);
            labelCombustivel.setVisible(true);
            labelCapInt.setVisible(false);
        }

    }
    public void confirmarDados() {
        try {
            String mensagem1 = "";
            int id = Integer.parseInt(textFieldId.getText());
            String nome = textFieldNome.getText();
            double custoDia = Double.parseDouble(textFieldcustoDia.getText());
            String selectedEvent = choiceBoxEquipamento.getValue();
            if (selectedEvent.equals("Caminhão Tanque")){
                double capacidade = Double.parseDouble(textFieldCapDouble.getText());
                mensagem1 = cadEquip.cadCaminhao(id, nome, custoDia, capacidade);
                exibirMensagem2(mensagem1);
            }
            else if(selectedEvent.equals("Barco")){
                int capacidade = Integer.parseInt(textFieldCapInt.getText());
                mensagem1 = cadEquip.cadBarco(id, nome, custoDia, capacidade);
                exibirMensagem2(mensagem1);
            }
            else if (selectedEvent.equals("Escavadeira")) {
                String combustivel = choiceBoxComb.getValue().toString();
                double carga = Double.parseDouble(textFieldCarga.getText());
                mensagem1 = cadEquip.cadEscavadeira(id, nome,custoDia, combustivel, carga);
                exibirMensagem2(mensagem1);
            }
        } catch (NumberFormatException e) {
            exibirMensagem2("Erro de formato numérico: Por favor, insira valores numéricos válidos.");
        } catch (NullPointerException e) {
            exibirMensagem2("Erro de referência nula: Certifique-se de preencher todos os campos obrigatórios.");
        } catch (IllegalArgumentException e) {
            exibirMensagem2("Erro de argumento inválido: O evento selecionado não é válido.");
        } catch (Exception e) {
            exibirMensagem2("Erro desconhecido: " + e.getMessage());
        }
    }

    private void limparCampos2() {
        textFieldCapDouble.setVisible(false);
        textFieldCarga.setVisible(false);
        textFieldCapInt.setVisible(false);
        labelCombustivel.setVisible(false);
        labelCapInt.setVisible(false);
        labelCarga.setVisible(false);
        choiceBoxComb.setVisible(false);
        labelConfirma2.setVisible(false);
    }
    public void limparDados2(){
        textFieldCarga.setText(null);
        textFieldCapDouble.setText(null);
        textFieldCapInt.setText(null);
        choiceBoxComb.setValue(null);
        textFieldId.setText(null);
        textFieldNome.setText(null);
        textFieldcustoDia.setText(null);
        labelConfirma2.setVisible(false);
    }
    public void exibirMensagem2(String mensagem){
        labelConfirma2.setVisible(true);
        labelConfirma2.setText(mensagem);
    }
    public void voltarHome(ActionEvent actionEvent){
        main.mudar(1);
    }
    public void mostrarEvento(){
        telaEvento.setVisible(true);
        telaEquipamento.setVisible(false);
    }
    public void mostrarEquipamento(){
        telaEquipamento.setVisible(true);
        telaEvento.setVisible(false);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}