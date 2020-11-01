package projeto_sorvil.gui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import projeto_sorvil.controller.FachadaController;
import projeto_sorvil.model.Card;
import projeto_sorvil.model.Livro;
import projeto_sorvil.model.Usuario;

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
    
    @FXML
    private Text publico;

    @FXML
    private CheckBox chPublico;
    
    private FachadaController fachada;
    private MainTestes maintestes;
	
	
    public TelaCriacaoCardsController() {
		this.fachada = FachadaController.getInstance();
    	this.maintestes = MainTestes.getInstance();
	}
    
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
    @FXML
    void cancelar(ActionEvent event) throws IOException {
    	maintestes.escolherTela(6);
    }

    @FXML
    void criarCard(ActionEvent event) throws IOException {
    	int pagina = Integer.parseInt(paginaAtual.getText());
        Usuario user = fachada.getUsuarioLogado();
        Livro livro = fachada.getOnLivro().getLivro();
        LocalDateTime data = LocalDateTime.now();
        //boolean publico;
        //publico = chPublico.selectedProperty().getValue();

        Card card = new Card(tituloCard.getText(), null, textoDoCard.getText(), user, livro, data, chPublico.selectedProperty().getValue(), pagina);
        maintestes.escolherTela(6);
        
    }

}
