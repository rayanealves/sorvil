package projeto_sorvil.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import projeto_sorvil.model.MeuLivro;
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
    

    @FXML
    private Button botaoEditarUsuario;

    @FXML
    private Button botaoAdicionarLivro;

    @FXML
    private Button botaoTesteLivro;
    
    
	private static Usuario usuarioLogado = null;
	
	@SuppressWarnings("unused")
	private static MeuLivro onLivro = null;

	

	

    @FXML
    void iniciar(MouseEvent event) {
    	if(TelaBibliotecaPessoalController.usuarioLogado == null) {
    		TelaBibliotecaPessoalController.usuarioLogado = Fachada.getUsuarioLogado();
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


    @FXML
    void irParaLivro(ActionEvent event) {
    	MainTestes.escolherTela(6);
    }

    @FXML
    void telaAdicionarLivro(ActionEvent event) {
    	MainTestes.escolherTela(4);
    }

    @FXML
    void telaEditarUsuario(ActionEvent event) {
    	MainTestes.escolherTela(5);
    }
    
    
    
    
    
    
    
    
    
    
	public static Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	
	
	
	
	

}
