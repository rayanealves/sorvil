package projeto_sorvil.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TelaCriacaoCardsController {

    @FXML
    private Button botaoCriarCard;

    @FXML
    private Button botaoCancelar;

    @FXML
    private TextField tituloCard;

    @FXML
    private TextField paginaAtual;

    @FXML
    private TextArea textoDoCard;
    
    @FXML
    private Label txtLivro;
	
	
	private MainTestes maintestes;
	
	
    public TelaCriacaoCardsController() {
    	this.maintestes = MainTestes.getInstance();
	}
    
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
    @FXML
    void cancelar(ActionEvent event) throws IOException {
    	maintestes.escolherTela(6);
    }

    @FXML
    void criarCard(ActionEvent event) {

    }

}
