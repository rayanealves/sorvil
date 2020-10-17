package Interface;

import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import projeto_sorvil.controller.ControladorUsuarios;
import projeto_sorvil.model.Usuario;

public class TelaCadastroController {

    @FXML
    private TextField login;

    @FXML
    private TextField nome;

    @FXML
    private Text logintxt;

    @FXML
    private Text nometxt;

    @FXML
    private Text senhatxt;

    @FXML
    private Label mensagem;

    @FXML
    private Button cadastrar;

    @FXML
    private Button voltar;

    @FXML
    private PasswordField senha;

    @FXML
    private ToggleGroup tipoDeUsuario;
    
    @FXML
    private RadioButton radiopadrao;
    
    @FXML
    private RadioButton radioadm;

    LocalDate diaCadastro;

    ControladorUsuarios controladorUsers = new ControladorUsuarios();
  

   

    @FXML
    void cadastrarUsuario(ActionEvent event) {
    	RadioButton tipoDeUser = (RadioButton) tipoDeUsuario.getSelectedToggle();
    	boolean tipo = false;
    	if(tipoDeUser.equals(radioadm)) {
    		tipo = true;
    	}
    	diaCadastro = LocalDate.now();
    	Usuario user = new Usuario(nome.getText(), null, login.getText(), senha.getText(), tipo, diaCadastro );
    	System.out.println(controladorUsers.adicionar(user));
    	senha.clear();
		login.clear();
		nome.clear();
    	MainTestes.escolherTela(1);
    }

    @FXML
    void voltar(ActionEvent event) {
    	senha.clear();
		login.clear();
		nome.clear();
    	MainTestes.escolherTela(1);
    }

}
