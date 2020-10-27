package projeto_sorvil.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import projeto_sorvil.controller.FachadaController;
import projeto_sorvil.model.MeuLivro;

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
    
    private static MeuLivro onLivro = null;

    @FXML
    void iniciar(MouseEvent event) {
    	if(TelaLivrosController.onLivro == null) {
    		TelaLivrosController.onLivro = FachadaController.getOnLivro();
    	}
    	
    }
    
    @FXML
    void TelacriarCard(ActionEvent event) {
    	MainTestes.escolherTela(8);
    }
    
    @FXML
    void voltar(ActionEvent event) {
    	FachadaController.setOnLivro(null);
    	onLivro = null;
    	MainTestes.escolherTela(3);
    }

}
