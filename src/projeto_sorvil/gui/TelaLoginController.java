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
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import projeto_sorvil.controller.FachadaController;
import projeto_sorvil.exceptions.NaoExisteException;
import projeto_sorvil.model.Usuario;


public class TelaLoginController  implements Initializable {

	
    @FXML
    private Button botaoentrar;
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
    @FXML
    private ImageView imageSorvil;
    private FachadaController fachada;
    private MainTestes maintestes;
    

	public TelaLoginController() {
		this.fachada = FachadaController.getInstance();
		this.maintestes = MainTestes.getInstance();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//imageSorvil.applyCss();
		//imageSorvil.setImage(null);
			
	}

	@FXML
	void fazerLogin(ActionEvent event) throws IOException {
            
            Usuario user = null;
            try {
                 user = fachada.buscarUsuario(login.getText());
            } catch (NaoExisteException e) {
                AlertBox.display("Você ainda não foi cadastrado :( ", "Não fique triste, pode se cadastrar quando quiser :)");
            }
           
		if(user != null) {
			if(user.getSenha().equals(senha.getText())) {
				fachada.setUsuarioLogado(user);
				senha.clear();
				login.clear();
				maintestes.escolherTela(3);
				
				
			}
            else{
                AlertBox.display("Senha inválida", "Tente novamente com outra senha"
                                    + "\nVocê pode tentar quantas vezes quiser."
                                    + "Talvez em algum momento dê certo");
            }
		}
                
	}


	 @FXML
	 void fecharPrograma(ActionEvent event) throws IOException {
		senha.clear();
		login.clear();
		maintestes.escolherTela(0);
	 }

	 @FXML
	 void irParaCadastro(ActionEvent event) throws IOException {
		 senha.clear();
		 login.clear();
		 maintestes.escolherTela(2);
	 }


   

}
