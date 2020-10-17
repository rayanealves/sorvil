package Interface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class TelaEditarUsuarioController {

    @FXML
    private Text editarlogintxt;

    @FXML
    private Text editarnometxt;

    @FXML
    private Text editarsenhatxt;

    @FXML
    private TextField login;

    @FXML
    private Text telaedicaousuariotxt;

    @FXML
    private Button cancelar;

    @FXML
    private Button botaoEditar;

    @FXML
    void cancelar(ActionEvent event) {
    	MainTestes.escolherTela(3);
    }

    @FXML
    void editar(ActionEvent event) {

    }

}
