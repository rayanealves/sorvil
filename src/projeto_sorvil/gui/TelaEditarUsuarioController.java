package projeto_sorvil.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import projeto_sorvil.controller.FachadaController;
import projeto_sorvil.exceptions.JaExisteException;
import projeto_sorvil.exceptions.NaoPodeException;

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
    private Button btnExcluir;

    @FXML
    private Button botaoEditar;
    private FachadaController fachada;
	private MainTestes maintestes;
    
	public TelaEditarUsuarioController() {
		this.fachada = FachadaController.getInstance();
		this.maintestes = MainTestes.getInstance();
    }

    public void initialize(URL location, ResourceBundle resources) {
    	
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
    	if(nome.getText() != null & nome.getText() != "" & nome.getText() != " " & !fachada.getUsuarioLogado().getNome().equals(nome.getText())) {
    		fachada.editarNomeUsuario(fachada.getUsuarioLogado(), nome.getText());  					
    	}
    	if(login.getText() != null & login.getText() != "" & login.getText() != " " & !fachada.getUsuarioLogado().getLogin().equals(login.getText())) {
    		fachada.editarLoginUsuario(fachada.getUsuarioLogado(), login.getText());  					
    	}
    	if(senha.getText() != null & senha.getText() != "" & senha.getText() != " "  & !fachada.getUsuarioLogado().getSenha().equals(senha.getText())) {
    		fachada.editarSenhaUsuario(fachada.getUsuarioLogado(), senha.getText());  					
    	}
    	
    	login.clear();
    	nome.clear();
    	senha.clear();
    	maintestes.escolherTela(3);
    }
    

    @FXML
    void excluirUser(ActionEvent event) throws NaoPodeException, IOException {
    	fachada.removerUsuario(fachada.getUsuarioLogado());
    	fachada.setUsuarioLogado(null);

    	login.clear();
    	nome.clear();
    	senha.clear();
    	maintestes.escolherTela(1);
    }
    

}
