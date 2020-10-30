package projeto_sorvil.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import projeto_sorvil.controller.FachadaController;
import projeto_sorvil.exceptions.NaoPodeException;
import projeto_sorvil.model.Autor;
import projeto_sorvil.model.Editora;
import projeto_sorvil.model.Livro;
import projeto_sorvil.model.MeuLivro;


public class TelaBibliotecaPessoalController {


    @FXML
    private AnchorPane tela;

    @FXML
    private Button btnDeletarLivro;

    @FXML
    private Button btnSair;

    @FXML
    private Button btnEditarUsuario;

    @FXML
    private Button btnAdicionarLivro;

    @FXML
    private ListView<MeuLivro> lvListaPessoalLivros;

    @FXML
    private TextField txtLivro;

    @FXML
    private Text titulo;
    
    @FXML
    private Button btnBuscarNome;

    @FXML
    private Button btnBuscarAutor;

    @FXML
    private Button btnBuscarEditora;
    

    private static ObservableList<MeuLivro> obsListPessoal = null;
    
    private static MeuLivro livroBuscado = null;
    
    private static Editora editoraBuscada = null;
    
    private static Autor autorBuscado = null;

    @FXML
    void iniciar(MouseEvent event) {

    	if( obsListPessoal == null ){
    		obsListPessoal = FXCollections.observableArrayList(FachadaController.listarLivrosUsuario(FachadaController.getUsuarioLogado()));					

    		lvListaPessoalLivros.setItems(obsListPessoal);
    	}
    	
    }

    @FXML
    void fechar(ActionEvent event) {
    	obsListPessoal = null;
    	lvListaPessoalLivros.setItems(obsListPessoal);
    	FachadaController.setUsuarioLogado(null);
    	MainTestes.escolherTela(1);
    	
    }


    @FXML
    void irParaLivro(ActionEvent event) {
    	
    	MeuLivro onLivro = new MeuLivro(null, null, 0);
    	FachadaController.setOnLivro(onLivro);
    	MainTestes.escolherTela(6);
    }
    

    @FXML
    void DeletarLivroPessoal(ActionEvent event) {
    	obsListPessoal = null;

    	
    }

    @FXML
    void telaAdicionarLivro(ActionEvent event) {
    	obsListPessoal = null;
    	MainTestes.escolherTela(9);
    }

    @FXML
    void telaEditarUsuario(ActionEvent event) {
    	obsListPessoal  = null;
    	MainTestes.escolherTela(5);
    }
    
     @FXML
    void mostrarLivroAutor(ActionEvent event) {

    }

    @FXML
    void mostrarLivroEditora(ActionEvent event) {

    }

    /*@FXML
    void mostrarLivroNome(ActionEvent event) throws NaoPodeException {
         
    }*/
    
}
