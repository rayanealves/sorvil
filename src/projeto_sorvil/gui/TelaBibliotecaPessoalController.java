package projeto_sorvil.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import projeto_sorvil.controller.FachadaController;
import projeto_sorvil.model.Livro;
import projeto_sorvil.model.MeuLivro;
import projeto_sorvil.model.Usuario;

@SuppressWarnings("unused")
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


	

	

    @FXML
    void iniciar(MouseEvent event) {
    	if(TelaBibliotecaPessoalController.usuarioLogado == null) {
    		TelaBibliotecaPessoalController.usuarioLogado = FachadaController.getUsuarioLogado();
    	}
    	vamover.setText(TelaBibliotecaPessoalController.usuarioLogado.getNome());
    }

    @FXML
    void vamo(ActionEvent event) {
    	
    	
    	System.out.println(usuarioLogado.getNome());
   	
    }



    @FXML
    void fechar(ActionEvent event) {
    	FachadaController.setUsuarioLogado(null);
    	TelaBibliotecaPessoalController.usuarioLogado = null;
    	MainTestes.escolherTela(1);
    	
    }


    @FXML
    void irParaLivro(ActionEvent event) {
    	
    	MeuLivro onLivro = new MeuLivro(null, null, 0);
    	FachadaController.setOnLivro(onLivro);
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
