package Interface;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import projeto_sorvil.controller.ControladorUsuarios;
import projeto_sorvil.model.Usuario;


public class TelaLoginController  implements Initializable {
	
	ControladorUsuarios userController = new ControladorUsuarios();
	
	@FXML
    private Button Entrar;
    @FXML
    private PasswordField senha;
    @FXML
    private TextField Login;
    @FXML
    private Text senhatxt;
    @FXML
    private Text logintxt;
    @FXML
    private Button Cadastrar;
    @FXML
    private Label TelaLogin;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	

	@FXML
	void verificarUsuario(ActionEvent event) {
		Usuario user = userController.buscar(logintxt.getText());
		if(user != null) {
			if(user.getSenha().equals(senhatxt.getText())) {
				
			}
		}
	}

	@FXML
	void fazerLogin(ActionEvent event) {

	 }

	 @FXML
	 void fecharPrograma(ActionEvent event) {
		
	 }

	 @FXML
	 void irParaCadastro(ActionEvent event) {

	 }


   

}
