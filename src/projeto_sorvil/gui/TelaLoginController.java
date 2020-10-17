package projeto_sorvil.gui;


import java.io.IOException;
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
    private TextField login;
    @FXML
    private Text senhatxt;
    @FXML
    private Text logintxt;
    @FXML
    private Button Cadastrar;
    @FXML
    private Label TelaLogin;
    @FXML
    private Button sair;
    
    private static Usuario usuarioLogado;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
			
	}
	
	

	@FXML
	void fazerLogin(ActionEvent event) throws IOException {
		Usuario user = userController.buscar(login.getText());
		if(user != null) {
			if(user.getSenha().equals(senha.getText())) {
				usuarioLogado = user;
				senha.clear();
				login.clear();
				MainTestes.escolherTela(3);
				
				
			}
		}
	}


	 @FXML
	 void fecharPrograma(ActionEvent event) {
		MainTestes.escolherTela(0);
	 }

	 @FXML
	 void irParaCadastro(ActionEvent event) {
		 MainTestes.escolherTela(2);
	 }



	public static Usuario getUsuarioLogado() {
		return usuarioLogado;
	}



	public static void setUsuarioLogado(Usuario user) {
		TelaLoginController.usuarioLogado = user;
	}


   

}
