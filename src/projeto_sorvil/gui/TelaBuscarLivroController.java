/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_sorvil.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import projeto_sorvil.controller.FachadaController;
import projeto_sorvil.exceptions.JaExisteException;
import projeto_sorvil.exceptions.NaoExisteException;
import projeto_sorvil.exceptions.NaoPodeException;
import projeto_sorvil.model.Autor;
import projeto_sorvil.model.Editora;
import projeto_sorvil.model.Livro;
import projeto_sorvil.model.MeuLivro;
import projeto_sorvil.model.Status;


public class TelaBuscarLivroController implements Initializable {

    @FXML
    private Text nometxt;

    @FXML
    private TextField livro;

    @FXML
    private Label aviso;

    @FXML
    private Button btnBuscar;
    
    @FXML
    private Button btnADDMinhaBiblioteca;

    @FXML
    private Button btnADDSorvil;
    
    @FXML
    private Button btnVoltar;
    
    @FXML
    private Button btnExcluir;

    @FXML
    private ListView<Livro> lvLivrosBuscados;
    
    @FXML
    private Button btnPorAutor;

    @FXML
    private Button btnPorEditora;
	
	private MainTestes maintestes;

    private static final ObservableList<Livro> obsListBuscada =  FXCollections.observableArrayList();
    
    private static Livro livroBuscado = null;
    
    private static Autor autorBuscado = null;
  
    @SuppressWarnings("unused")
	private static Editora editoraBuscada = null;
	
	
    public TelaBuscarLivroController() {
		this.maintestes = MainTestes.getInstance();
	}
    

    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
    
 
    @FXML
    void buscarLivro(ActionEvent event) throws NaoPodeException {
    	livroBuscado = FachadaController.buscarLivro(livro.getText());
    	obsListBuscada.add(livroBuscado); 
    	lvLivrosBuscados.setItems(obsListBuscada);	
    }
    
    @FXML
    void buscarPorAutor(ActionEvent event) throws NaoExisteException {
        autorBuscado = FachadaController.getInstance().bucarAutorPorNome(livro.getText());
        obsListBuscada.addAll(FXCollections.observableArrayList(FachadaController.getInstance().listarPorAutor(autorBuscado)));
        lvLivrosBuscados.setItems(obsListBuscada);
    }

    @FXML
    void buscarPorEditora(ActionEvent event) {

    }
    
    @FXML
    void AdicionarLivroPessoal(ActionEvent event) throws JaExisteException, IOException {
    	//tabelaContas.getSelectionModel (). selectedItemProperty () .addListener ((observable, oldValue, newValue) -> mostrarDetalhesConta (newValue));

    	TelaBuscarLivroController.livroBuscado = lvLivrosBuscados.getSelectionModel().getSelectedItem();

    	Status status =  Status.EM_BRANCO;
    	MeuLivro livroUser = new MeuLivro(TelaBuscarLivroController.livroBuscado, status , 0);
    	FachadaController.adicionarLivroUsuario(FachadaController.getUsuarioLogado(), livroUser);
    	//FachadaController.getUsuarioLogado().adicionarLivro(livroUser);
    	TelaBuscarLivroController.livroBuscado = null;
    	TelaBuscarLivroController.obsListBuscada.clear();
    	lvLivrosBuscados = null;
    	livro.clear();
    	maintestes.escolherTela(3);
    }

    @FXML
    void adicionarLivroSorvil(ActionEvent event) throws IOException {
    	maintestes.escolherTela(4);
    }
    
    
    @FXML
    void voltar(ActionEvent event) throws IOException {
    	TelaBuscarLivroController.livroBuscado = null;
    	TelaBuscarLivroController.obsListBuscada.clear();
    	lvLivrosBuscados.setItems(obsListBuscada);
    	livro.clear();
    	maintestes.escolherTela(3);
    }
    
    @FXML
    void excluirLivro(ActionEvent event) {

    }
    
}
