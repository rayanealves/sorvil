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
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import projeto_sorvil.controller.FachadaController;
import projeto_sorvil.exceptions.NaoExisteException;
import projeto_sorvil.exceptions.NaoPodeException;
import projeto_sorvil.model.Nota;
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
    private ChoiceBox<Nota> chboxMinhaNota;
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
    private String notamedia;

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
        chboxMinhaNota = new ChoiceBox<Nota>();
        notaGeral = new Label();
        informacoes = new Label();
        chboxStatus = new ChoiceBox<Status>();
        btnVerCard = new Button();
        chFavorito = new CheckBox();
        this.fachada = FachadaController.getInstance();
        this.maintestes = MainTestes.getInstance();
        double mediadasnotas =  fachada.notaGeralLivro(fachada.getOnLivro().getLivro());
    	notamedia = String.valueOf(mediadasnotas);
    	System.out.println("estou no controle");
		
    }
   
    public void initialize(URL location, ResourceBundle resources) {
    	this.notaGeral.setText(notamedia);
    	this.informacoes.setText(fachada.getOnLivro().getLivro().toString());
    	this.chboxStatus.getItems().addAll(Status.values());
    	this.chboxStatus.setValue(fachada.getOnLivro().getStatus());
    	this.chboxMinhaNota.getItems().addAll(Nota.values());
    	this.chboxMinhaNota.setValue(fachada.getOnLivro().getNota());
    	this.chFavorito.selectedProperty().setValue(fachada.getOnLivro().getFavorito());
    	System.out.println("estou iniciando");
    }
    
    @FXML
    void telacriarCard(ActionEvent event) throws IOException {
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
    void salvar(ActionEvent event) throws IOException, NaoExisteException, NaoPodeException {
    	
    	
            fachada.getOnLivro().setNota(chboxMinhaNota.getValue());
            fachada.getOnLivro().setStatus(chboxStatus.getValue());
            fachada.getOnLivro().setFavorito(chFavorito.isSelected());
            fachada.atualizarLivroUsuario(fachada.getUsuarioLogado(),fachada.getOnLivro());    	
            fachada.setOnLivro(null);
            maintestes.escolherTela(3);
        
        
    }

}
