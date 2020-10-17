package projeto_sorvil.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TelaCriacaoCardsController {

    @FXML
    private Button criarCard;

    @FXML
    private Button cancelar;

    @FXML
    private TextField tituloCard;

    @FXML
    private TextField paginaAtual;

    @FXML
    private TextArea textoDoCard;

    @FXML
    void cancelar(ActionEvent event) {
    	MainTestes.escolherTela(6);
    }

    @FXML
    void criarCard(ActionEvent event) {

    }

}
