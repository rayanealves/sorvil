package projeto_sorvil.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class TelaCardsController {

    @FXML
    private AnchorPane tela;

    @FXML
    private Label textoCard;

    @FXML
    private Button botaoEditar;

    @FXML
    private Label tituloCard;

    @FXML
    private Text cardtxt;

    @FXML
    private Button voltar;

    @FXML
    void editarCard(ActionEvent event) {

    }

    @FXML
    void iniciar(MouseEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {
    	MainTestes.escolherTela(6);
    }

}
