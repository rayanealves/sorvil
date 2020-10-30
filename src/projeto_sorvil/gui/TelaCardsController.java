package projeto_sorvil.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class TelaCardsController {

    @FXML
    private AnchorPane tela;

    @FXML
    private Button botaoEditar;

    @FXML
    private Text cardtxt;

    @FXML
    private Button btnVoltar;

    @FXML
    private ScrollPane scrollCard;

    @FXML
    private ListView<?> listCard;

    @FXML
    private TextArea card;

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnSalvar;
    
    @FXML
    void iniciar(MouseEvent event) {
        
    }
    
    @FXML
    void editarCard(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {
    	MainTestes.escolherTela(6);
    }
    
     @FXML
    void excluirCard(ActionEvent event) {

    }
    
    @FXML
    void salvarEdicao(ActionEvent event) {

    }

}
