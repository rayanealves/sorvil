package projeto_sorvil.gui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
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
import projeto_sorvil.controller.FachadaController;
import projeto_sorvil.exceptions.CPFinvalidoException;
import projeto_sorvil.exceptions.CampoNaoPreenchidoException;
import projeto_sorvil.exceptions.JaExisteException;
import projeto_sorvil.exceptions.NaoPodeException;
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

    @FXML
    private Text cpftxt;
    
    @FXML
    private TextField cpf;
    private FachadaController fachada;
	private MainTestes maintestes;
    
    LocalDate diaCadastro;
	
	
	public TelaCadastroController() {
		this.fachada = FachadaController.getInstance();
		this.maintestes = MainTestes.getInstance();
	}
    
    public void initialize(URL location, ResourceBundle resources) {
    	
    }

    @FXML
    void cadastrarUsuario(ActionEvent event) throws IOException {
    	RadioButton tipoDeUser = (RadioButton) tipoDeUsuario.getSelectedToggle();
    	boolean tipo = false;
        
    	if(tipoDeUser.equals(radioadm)) {
    		tipo = true;
    	}
    	diaCadastro = LocalDate.now();
    	Usuario user = new Usuario(nome.getText(), cpf.getText(), login.getText(), senha.getText(), tipo, diaCadastro );

       
        try {
            fachada.adicionarUsuario(user);
        } catch (JaExisteException ex) {
            AlertBox.display(nome.getText() + " já está no sistema",
                    "Você não pode cadastrar um usuário com o mesmo cpf");
            Logger.getLogger(TelaCadastroController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CPFinvalidoException ex) {
            AlertBox.display("Formado de CPF invalido", "ok, você pode inventar um cpf,"
                    + " mas usa 11 numeros");
            Logger.getLogger(TelaCadastroController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CampoNaoPreenchidoException ex) {
            AlertBox.display("Campos não preenchidos", "Acredito que sem senha ou login não será possivel"
                    + " fazer muitas coisas nesse programa");
            Logger.getLogger(TelaCadastroController.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    	senha.clear();
    	login.clear();
    	nome.clear();
        cpf.clear();
        maintestes.escolherTela(1);
    }
    
    @FXML
    void voltar(ActionEvent event) throws IOException {
    	senha.clear();
		login.clear();
		nome.clear();
		maintestes.escolherTela(1);
    }

}
