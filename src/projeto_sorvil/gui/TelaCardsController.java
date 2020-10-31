package projeto_sorvil.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import projeto_sorvil.controller.FachadaController;
import projeto_sorvil.exceptions.NaoPodeException;
import projeto_sorvil.model.Card;

public class TelaCardsController implements Initializable {

    @FXML
    private AnchorPane tela;
    @FXML
    private Button btnEditar;
    @FXML
    private Text cardtxt;
    @FXML
    private Button btnVoltar;
    @FXML
    private ScrollPane scrollCard;
    @FXML
    private ListView<Card> lvCards;
    @FXML
    private TextArea card;
    @FXML
    private Button btnExcluir;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnVerCard;
    @FXML
    private MenuButton menuPublicoPrivado;
	private FachadaController fachada;
	private MainTestes maintestes;
    
    MenuItem item1 = new MenuItem("Privado");
    MenuItem item2 = new MenuItem("Publico");
    //MenuButton menuPublicoPrivado = new MenuButton("Selecione", null, item1,item2);
	private ObservableList<Card> obsListCards =  FXCollections.observableArrayList();
    
  
    public TelaCardsController(ObservableList<Card> ob) {
    	lvCards = new ListView<Card>();
		this.fachada = FachadaController.getInstance();
		this.maintestes = MainTestes.getInstance();
		
		this.obsListCards = ob;
	}
  
    public void initialize(URL url, ResourceBundle rb) {
    	lvCards.setItems(obsListCards);
    	lvCards.refresh();
    	menuPublicoPrivado.getItems().addAll(item1,item2);
    }
    
    @FXML
    void editarCard(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
    	maintestes.escolherTela(6);
    }
    
     @FXML
    void excluirCard(ActionEvent event) throws NaoPodeException {
    	 fachada.deleteCard(fachada.getUsuarioLogado(), fachada.getOnCard() );
    }
    
    @FXML
    void salvarEdicao(ActionEvent event) {

    }
    
    @FXML
    void selecionarTipoCards(ActionEvent event) {
        if(item1.getText().equals(menuPublicoPrivado.getText())) {
        	
        
        }
        else if(item2.getText().equals(menuPublicoPrivado.getText())) {
        	
        
        }
    }
    
    @FXML
    void verCard(ActionEvent event) {
    	Card onCard = lvCards.getSelectionModel().getSelectedItem();
        fachada.setOnCard(onCard);
        this.card.setText(fachada.getOnCard().toString());
    }
    

}
