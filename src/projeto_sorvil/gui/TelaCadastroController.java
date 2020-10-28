package projeto_sorvil.gui;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

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
<<<<<<< HEAD
import projeto_sorvil.exceptions.JaExisteException;
=======
import projeto_sorvil.controller.FachadaController;
>>>>>>> d67718a85693628502ec7c1fd34f369e64c7155e
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

  

   

    @FXML
    void cadastrarUsuario(ActionEvent event) {
    	RadioButton tipoDeUser = (RadioButton) tipoDeUsuario.getSelectedToggle();
    	boolean tipo = false;
    	if(tipoDeUser.equals(radioadm)) {
    		tipo = true;
    	}
    	diaCadastro = LocalDate.now();
    	Usuario user = new Usuario(nome.getText(), null, login.getText(), senha.getText(), tipo, diaCadastro );
<<<<<<< HEAD
        try {
            System.out.println(controladorUsers.adicionar(user));
        } catch (JaExisteException ex) {
            Logger.getLogger(TelaCadastroController.class.getName()).log(Level.SEVERE, null, ex);
        }
=======
    	System.out.println(FachadaController.adicionarUsuario(user));
>>>>>>> d67718a85693628502ec7c1fd34f369e64c7155e
    	senha.clear();
		login.clear();
		nome.clear();
		System.out.println(FachadaController.listarLivrosUsuario(user).size());
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
