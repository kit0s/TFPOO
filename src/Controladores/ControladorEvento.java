package Controladores;
import Cadastro.*;
import Dados.Atendimento.Status;
import Dados.Equipe.Equipamentos.Equipamento;
import Dados.Equipe.Equipe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
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
    private AnchorPane telaEquipe;
    @FXML
    private AnchorPane telaEquipamento;
    @FXML
    private AnchorPane telaAtendimento;
    @FXML
    private TextArea textAreaMostraEventos;
    private Main main;
    private Stage stage;
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
    @FXML
    private TextField textFieldCodEvento;
    @FXML
    private DatePicker dataInicio;
    @FXML
    private TextField duracao;
    @FXML
    private TextField codigoAtendimento;
    @FXML
    private Label confirmaAtendimento;
    @FXML
    private Button buttonVerAtendimentos;
    @FXML
    private TextArea textAreaAtendimentos;
    @FXML
    private Button buttonLimpaAtendimento;
    @FXML
    private Button buttonConfirmaEquipe;
    @FXML
    private TextField codinome;
    @FXML
    private TextField quantidade;
    @FXML
    private TextField latitudeEquipe;
    @FXML
    private TextField longitudeEquipe;
    @FXML
    private Label confirmaCadastroEquipe;
    @FXML
    private TextArea textAreaTodosDados;
    @FXML
    private AnchorPane telaRelatorioGeral;
    @FXML

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
    public void mostrarEvento(){
        telaEvento.setVisible(true);
        telaEquipamento.setVisible(false);
        telaAtendimento.setVisible(false);
        telaEquipe.setVisible(false);
        telaRelatorioGeral.setVisible(false);

    }
    public void mostrarEquipamento(){
        telaEquipamento.setVisible(true);
        telaEvento.setVisible(false);
        telaAtendimento.setVisible(false);
        telaEquipe.setVisible(false);
        telaRelatorioGeral.setVisible(false);

    }
    public void mostrarAtendimento(){
        telaAtendimento.setVisible(true);
        telaEvento.setVisible(false);
        telaEquipamento.setVisible(false);
        telaEquipe.setVisible(false);
        mostrarDadosEventos();
        telaRelatorioGeral.setVisible(false);

    }
    public void mostrarDadosEventos() {
        String eventosStr = cadEvent.mostrarEventos();
        textAreaMostraEventos.setVisible(true);
        textAreaMostraEventos.setText(eventosStr);
    }
    public void mostrarEquipe(){
        telaEquipe.setVisible(true);
        telaEvento.setVisible(false);
        telaEquipamento.setVisible(false);
        telaAtendimento.setVisible(false);
        telaRelatorioGeral.setVisible(false);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void cadastraAtendimento(){
        try {
            String msg = "";
            String codigoEvento = textFieldCodEvento.getText();
            int codigoAtend = Integer.parseInt(codigoAtendimento.getText());
            String dataInit = dataInicio.getValue().toString();
            int duracaoDias = Integer.parseInt(duracao.getText());
            Status status = Status.PENDENTE;
            msg = cadEvent.cadastroAtendimento(codigoEvento, codigoAtend, dataInit,duracaoDias,status);
            confirmaAtendimento.setText(msg);

        } catch (NumberFormatException e) {
            confirmaAtendimento.setVisible(true);
            confirmaAtendimento.setText("Erro de formato numérico: Por favor, insira valores numéricos válidos.");
        } catch (NullPointerException e) {
            confirmaAtendimento.setVisible(true);
            e.printStackTrace();
            confirmaAtendimento.setText("Erro de referência nula: Certifique-se de preencher todos os campos obrigatórios.");
        } catch (IllegalArgumentException e) {
            confirmaAtendimento.setVisible(true);
            confirmaAtendimento.setText("Erro de argumento inválido: O evento selecionado não é válido."); // tem nem como, mas coloquei
        } catch (Exception e) {
            confirmaAtendimento.setVisible(true);
            confirmaAtendimento.setText("Erro desconhecido: " + e.getMessage());
        }
    }
    public void mostraAtendimentos(){
        textAreaAtendimentos.setText(cadEvent.mostrarAtendimentos());
    }
    public void limparAtendimento(){
        textFieldCodEvento.setText(null);
        textAreaAtendimentos.setText(null);
        duracao.setText(null);
        codigoAtendimento.setText(null);
        dataInicio.setValue(null);
    }
    public void cadastraEquipe(){
        try{
            String msg = "";
            String codinomeEquipe = codinome.getText();
            int quantidadeMembros = Integer.parseInt(quantidade.getText());
            double latitude = Double.parseDouble(latitudeEquipe.getText());
            double longitude = Double.parseDouble(longitudeEquipe.getText());
            ArrayList<Equipamento> equipamentos = null;
            msg = cadEquip.cadastraEquipe(codinomeEquipe, quantidadeMembros, latitude, longitude, equipamentos);
            confirmaCadastroEquipe.setText(msg);
        } catch (NumberFormatException e) {
            confirmaCadastroEquipe.setText("Erro de formato numérico: Por favor, insira valores numéricos válidos.");
        } catch (NullPointerException e) {
            confirmaCadastroEquipe.setVisible(true);
            confirmaCadastroEquipe.setText("Erro de referência nula: Certifique-se de preencher todos os campos obrigatórios.");
        } catch (IllegalArgumentException e) {
            confirmaCadastroEquipe.setVisible(true);
            confirmaCadastroEquipe.setText("Erro de argumento inválido: O evento selecionado não é válido."); // tem nem como, mas coloquei
        } catch (Exception e) {
            confirmaCadastroEquipe.setVisible(true);
            confirmaCadastroEquipe.setText("Erro desconhecido: " + e.getMessage());
        }
    }
    public void mostrarTodosDados(){
        telaRelatorioGeral.setVisible(true);
        textAreaTodosDados.setText(cadEvent.mostrarTodosDados());
        telaEquipamento.setVisible(false);
        telaAtendimento.setVisible(false);
        telaEquipe.setVisible(false);
        telaEvento.setVisible(false);
    }
}