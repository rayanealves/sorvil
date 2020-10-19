package projeto_sorvil.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

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

    @FXML
    void cancelar(ActionEvent event) {
    	login.clear();
    	nome.clear();
    	senha.clear();
    	MainTestes.escolherTela(3);
    }

    @FXML
    void editar(ActionEvent event) {
    	if(nome.getText() != null & nome.getText() != "") {
    		
    	}
    	

    }

}
