package Interface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

public class TelaCadastroController {

    @FXML
    private TextField logintxt;

    @FXML
    private TextField nometxt;

    @FXML
    private Text login;

    @FXML
    private Text nome;

    @FXML
    private Text senha;

    @FXML
    private Label mensagem;

    @FXML
    private Button cadastrar;

    @FXML
    private Button voltar;

    @FXML
    private PasswordField senhatxt;

    @FXML
    private ToggleGroup tipoDeUsuario;


  

    @FXML
    void cadastrarUsuario(ActionEvent event) {
    	@SuppressWarnings("unused")
		RadioButton tipoDeUser = (RadioButton) tipoDeUsuario.getSelectedToggle(); 
    	
    	
    }

    @FXML
    void criarNovaConta(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {

    }

}
