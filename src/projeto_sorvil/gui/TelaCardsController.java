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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
    private TextArea comentarioCard;
    @FXML
    private Button btnExcluir;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnVerCard;
    @FXML
    private Label tituloCard;
    @FXML
    private TextField pagAtual;
    
    @FXML
    private CheckBox chPublico;

    @FXML
    private CheckBox chPrivado;

    @FXML
    private Button btnSelecionar;
    
    private FachadaController fachada;
    private MainTestes maintestes;
    
    
    private ObservableList<Card> obsListCards =  FXCollections.observableArrayList();
    
  
    public TelaCardsController(ObservableList<Card> ob) {
    	lvCards = new ListView<Card>();
		this.fachada = FachadaController.getInstance();
		this.maintestes = MainTestes.getInstance();
		
		this.obsListCards = ob;
	}
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	obsListCards.addAll(fachada.listarCardsLivroUsuario(fachada.getUsuarioLogado(), fachada.getOnLivro().getLivro()));
        obsListCards.addAll(fachada.listarCardsPublicosLivro(fachada.getOnLivro().getLivro()));
        lvCards.setItems(obsListCards);
    	lvCards.refresh();
    	//menuPublicoPrivado.getItems().addAll(item1,item2);
    }
    
    @FXML
    void editarCard(ActionEvent event) {
        fachada.editarCard(fachada.getOnCard(), fachada.getUsuarioLogado(), comentarioCard.getText());
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
    void selecionarTipoCards(ActionEvent event) {
        if(chPublico.selectedProperty().getValue() == true && chPrivado.selectedProperty().getValue() == false){
           obsListCards.clear();
           obsListCards.addAll(fachada.listarCardsPublicosLivro(fachada.getOnLivro().getLivro()));
           lvCards.refresh();
           lvCards.setItems(obsListCards);
        }
        else{
            
            obsListCards.clear();
            obsListCards.addAll(fachada.listarCardsLivroUsuario(fachada.getUsuarioLogado(), fachada.getOnLivro().getLivro()));
            lvCards.refresh();
            lvCards.setItems(obsListCards); 
            }
    }
    
    @FXML
    void verCard(ActionEvent event) {
    	Card onCard = lvCards.getSelectionModel().getSelectedItem();
        fachada.setOnCard(onCard);
        this.tituloCard.setText(fachada.getOnCard().getTitulo());
        this.comentarioCard.setText(fachada.getOnCard().getTexto());
        String pag = String.valueOf(fachada.getOnCard().getPagina());
        this.pagAtual.setText(pag);
    }
    

}
