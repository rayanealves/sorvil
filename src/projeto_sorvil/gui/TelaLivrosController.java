package projeto_sorvil.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import projeto_sorvil.controller.FachadaController;
import projeto_sorvil.model.Status;

public class TelaLivrosController implements Initializable{

    @FXML
    private GridPane telaLivro ;
    @FXML
    private Button botaoVoltar;
    @FXML
    private Button botaoCriarCard;
    @FXML
    private Text txtStatus;
    @FXML
    private Text txtNota;
    @FXML
    private Text txtNotaGeral;
    @FXML
    private Button botaoGuardar;
    @FXML
    private Text txtInforma;
    @FXML
    private Text txtLivro;
    @FXML
    private TextField minhaNota;
    @FXML
    private Label notaGeral;
    @FXML
    private Label informacoes;
    @FXML
    private ChoiceBox<Status> chboxStatus;
    @FXML
    private Button btnVerCard;
    @FXML
    private CheckBox chFavorito;
    private FachadaController fachada;
    private MainTestes maintestes;
    

    public TelaLivrosController() {
    	this.telaLivro =  new GridPane();
    	botaoVoltar = new Button();
        botaoCriarCard = new Button();
        txtStatus = new Text();
        txtNota = new Text();
        txtNotaGeral = new Text();
        botaoGuardar = new Button();
        txtInforma = new Text();
        txtLivro = new Text();
        minhaNota = new TextField();
        notaGeral = new Label();
        informacoes = new Label();
        chboxStatus = new  ChoiceBox<Status>();
        btnVerCard = new Button();
        chFavorito = new CheckBox();
        this.fachada = FachadaController.getInstance();
        this.maintestes = MainTestes.getInstance();
		
    	System.out.println("estou no controle");
		
    }
    
    public void initialize(URL location, ResourceBundle resources) {
    	this.informacoes.setText(fachada.getOnLivro().getLivro().toString());
    	this.chboxStatus.getItems().addAll(Status.values());
    	this.chboxStatus.setValue(fachada.getOnLivro().getStatus());
    	String nota = String.valueOf(fachada.getOnLivro().getNota());
    	this.minhaNota.setText(nota);
    	chFavorito.selectedProperty().setValue(fachada.getOnLivro().getFavorito());
    	System.out.println("estou iniciando");
    }
    
    @FXML
    void TelacriarCard(ActionEvent event) throws IOException {
    	maintestes.escolherTela(8);
    }
    
    @FXML
    void voltar(ActionEvent event) throws IOException {
    	fachada.setOnLivro(null);
    	maintestes.escolherTela(3);
    }
    
    @FXML
    void verCard(ActionEvent event) throws IOException {
    	maintestes.escolherTela(7);
    }
        
    @FXML
    void salvar(ActionEvent event) throws IOException {
    	int index = fachada.getUsuarioLogado().getEstante().indexOf(fachada.getOnLivro());
    	int nota =  Integer.parseInt(minhaNota.getText());
    	fachada.getUsuarioLogado().getEstante().get(index).setNota(nota);
    	fachada.getUsuarioLogado().getEstante().get(index).setStatus(chboxStatus.getValue());
        //chboxStatus.getSelectionModel();
    	
    	fachada.setOnLivro(null);
    	maintestes.escolherTela(3);
    }

}
