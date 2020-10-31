package projeto_sorvil.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import projeto_sorvil.controller.FachadaController;

public class TelaLivrosController {

    @FXML
    private GridPane telaLivro;
    
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
    private TextField notaGeral;
    
    @FXML
    private TextArea informacoes;
    
    @FXML
    private ChoiceBox<?> chboxStatus;
    
    @FXML
    private Button btnVerCard;
	
	private MainTestes maintestes;
    

    public TelaLivrosController() {
		this.maintestes = MainTestes.getInstance();
    }
    
    public void initialize(URL url, ResourceBundle rb) {
    	
    	
    }
    
    @FXML
    void TelacriarCard(ActionEvent event) throws IOException {
    	maintestes.escolherTela(8);
    }
    
    @FXML
    void voltar(ActionEvent event) throws IOException {
    	FachadaController.setOnLivro(null);
    	maintestes.escolherTela(3);
    }
    
    @FXML
    void verCard(ActionEvent event) throws IOException {
    	maintestes.escolherTela(7);
    }

}
