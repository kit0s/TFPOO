package Controladores;

import Cadastro.Cadastro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladorEquipamento implements Initializable {
    private Main main;
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
    private Label labelConfirma;
    Cadastro cadEquip = new Cadastro();
    private String[] equipamento = {"Caminhão Tanque","Barco", "Escavadeira"};
    private String[] combustivel = {"Diesel","Gasolina", "Álcool"};
    public void setMain(Main main){
        this.main = main;
    }
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBoxEquipamento.getItems().addAll(equipamento);
        choiceBoxEquipamento.setOnAction(event -> choiceBoxChange()); // Chama o método quando a escolha inicial muda
        choiceBoxComb.getItems().addAll(combustivel);
        choiceBoxComb.setOnAction(event -> choiceBoxChange());
    }
    public void choiceBoxChange() {
        String selectedEvent = choiceBoxEquipamento.getValue();
        limparCampos();
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
            String mensagem = "";
            int id = Integer.parseInt(textFieldId.getText());
            String nome = textFieldNome.getText();
            double custoDia = Double.parseDouble(textFieldcustoDia.getText());
            String selectedEvent = choiceBoxEquipamento.getValue();
            if (selectedEvent.equals("Caminhão Tanque")){
                double capacidade = Double.parseDouble(textFieldCapDouble.getText());
                mensagem = cadEquip.cadCaminhao(id, nome, custoDia, capacidade);
                exibirMensagem(mensagem);
            }
            else if(selectedEvent.equals("Barco")){
                int capacidade = Integer.parseInt(textFieldCapInt.getText());
                mensagem = cadEquip.cadBarco(id, nome, custoDia, capacidade);
                exibirMensagem(mensagem);
            }
            else if (selectedEvent.equals("Escavadeira")) {
                String combustivel = choiceBoxComb.getValue().toString();
                double carga = Double.parseDouble(textFieldCarga.getText());
                mensagem = cadEquip.cadEscavadeira(id, nome,custoDia, combustivel, carga);
                exibirMensagem(mensagem);
            }
        } catch (NumberFormatException e) {
            exibirMensagem("Erro de formato numérico: Por favor, insira valores numéricos válidos.");
        } catch (NullPointerException e) {
            exibirMensagem("Erro de referência nula: Certifique-se de preencher todos os campos obrigatórios.");
        } catch (IllegalArgumentException e) {
            exibirMensagem("Erro de argumento inválido: O evento selecionado não é válido.");
        } catch (Exception e) {
            exibirMensagem("Erro desconhecido: " + e.getMessage());
        }
    }

    private void limparCampos() {
        textFieldCapDouble.setVisible(false);
        textFieldCarga.setVisible(false);
        textFieldCapInt.setVisible(false);
        labelCombustivel.setVisible(false);
        labelCapInt.setVisible(false);
        labelCarga.setVisible(false);
        choiceBoxComb.setVisible(false);
        labelConfirma.setVisible(false);
    }
    public void limparDados(){
        textFieldCarga.setText(null);
        textFieldCapDouble.setText(null);
        textFieldCapInt.setText(null);
        choiceBoxComb.setValue(null);
        textFieldId.setText(null);
        textFieldNome.setText(null);
        textFieldcustoDia.setText(null);
        labelConfirma.setVisible(false);
    }
    public void exibirMensagem(String mensagem){
        labelConfirma.setVisible(true);
        labelConfirma.setText(mensagem);
    }
    public void voltarHome(ActionEvent actionEvent){
        main.mudar(1);
    }

}
