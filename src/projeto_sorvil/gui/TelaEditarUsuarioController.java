package projeto_sorvil.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import projeto_sorvil.controller.FachadaController;
import projeto_sorvil.exceptions.JaExisteException;
import projeto_sorvil.exceptions.NaoPodeException;
import projeto_sorvil.model.Usuario;

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
    private TextField nome;
    		
    @FXML
    private TextField senha;

    @FXML
    private Text telaedicaousuariotxt;

    @FXML
    private Button cancelar;

    @FXML
    private Button botaoEditar;
	
	private MainTestes maintestes;

    private static Usuario usuarioLogado = null;
    
	public TelaEditarUsuarioController() {
		this.maintestes = MainTestes.getInstance();
    }

    public void initialize(URL location, ResourceBundle resources) {
    	
    }
	
    @FXML
    void iniciar(MouseEvent event) {
    	if(TelaEditarUsuarioController.usuarioLogado == null) {
    		TelaEditarUsuarioController.usuarioLogado = FachadaController.getUsuarioLogado();
    	}	
    }
    
    @FXML
    void cancelar(ActionEvent event) throws IOException {
    	login.clear();
    	nome.clear();
    	senha.clear();
    	maintestes.escolherTela(3);
    }

    @FXML
    void editar(ActionEvent event) throws NaoPodeException, JaExisteException, IOException {
    	if(nome.getText() != null & nome.getText() != "") {
    		FachadaController.editarNomeUsuario(TelaEditarUsuarioController.usuarioLogado, nome.getText());  					
    	}
    	if(login.getText() != null & login.getText() != "") {
    		FachadaController.editarLoginUsuario(TelaEditarUsuarioController.usuarioLogado, login.getText());  					
    	}
    	if(senha.getText() != null & senha.getText() != "") {
    		FachadaController.editarSenhaUsuario(TelaEditarUsuarioController.usuarioLogado, senha.getText());  					
    	}
    	
    	login.clear();
    	nome.clear();
    	senha.clear();
    	maintestes.escolherTela(3);
    }

}
