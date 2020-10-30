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
import projeto_sorvil.controller.FachadaController;
import projeto_sorvil.exceptions.CPFinvalidoExeption;
import projeto_sorvil.exceptions.JaExisteException;
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
    
    LocalDate diaCadastro;

    @FXML
    void cadastrarUsuario(ActionEvent event) {
    	RadioButton tipoDeUser = (RadioButton) tipoDeUsuario.getSelectedToggle();
    	boolean tipo = false;
        
    	if(tipoDeUser.equals(radioadm)) {
    		tipo = true;
    	}
    	diaCadastro = LocalDate.now();
        System.out.println(FachadaController.getInstance().listarUsuario().size());
    	Usuario user = new Usuario(nome.getText(), cpf.getText(), login.getText(), senha.getText(), tipo, diaCadastro );
//<<<<<<< HEAD
        try {
        	FachadaController.adicionarUsuario(user);
                System.out.println(FachadaController.getInstance().listarUsuario().size());
        } catch (JaExisteException | CPFinvalidoExeption ex) {
            Logger.getLogger(TelaCadastroController.class.getName()).log(Level.SEVERE, null, ex);
        }

    	senha.clear();
	login.clear();
	nome.clear();
        cpf.clear();
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
