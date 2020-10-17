package Interface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.SwipeEvent;
import javafx.scene.layout.AnchorPane;
import projeto_sorvil.model.Usuario;

public class TelaBibliotecaPessoalController {


    @FXML
    private AnchorPane tela;
    @FXML
    private Label vamover;

    @FXML
    private Button botao;

    @FXML
    private Button fechar;

    @FXML
    private Button printar;
    
	private static Usuario usuarioLogado = null;
	
	

	

    @FXML
    void iniciar(MouseEvent event) {
    	if(TelaBibliotecaPessoalController.usuarioLogado == null) {
    		TelaBibliotecaPessoalController.usuarioLogado = TelaLoginController.getUsuarioLogado();
    	}
    	vamover.setText(TelaBibliotecaPessoalController.usuarioLogado.getNome());
    }

    @FXML
    void vamo(ActionEvent event) {
    	
    	
    	System.out.println(usuarioLogado.getNome());
   	
    }



    @FXML
    void fechar(ActionEvent event) {
    	TelaBibliotecaPessoalController.usuarioLogado = null;
    	MainTestes.escolherTela(1);
    	
    }


	public static Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	
	
	
	
	

}
