/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_sorvil.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

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
import projeto_sorvil.exceptions.NaoPodeException;
import projeto_sorvil.model.Autor;
import projeto_sorvil.model.Editora;
import projeto_sorvil.model.Livro;
import projeto_sorvil.model.MeuLivro;


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
    private FachadaController fachada;

	private MainTestes maintestes;

    private ObservableList<Livro> obsListBuscada =  FXCollections.observableArrayList();
    
    private static Livro livroBuscado = null;
    
    private static Autor autorBuscado = null;
  
	private static Editora editoraBuscada = null;
	
	
    public TelaBuscarLivroController() {
		this.fachada = FachadaController.getInstance();
		this.maintestes = MainTestes.getInstance();
	}
    

    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
    
 
    @FXML
    void buscarLivro(ActionEvent event) throws NaoPodeException {
    	livroBuscado = fachada.buscarLivro(livro.getText());
        obsListBuscada.clear();
    	obsListBuscada.add(livroBuscado);
        lvLivrosBuscados.refresh();
    	lvLivrosBuscados.setItems(obsListBuscada);	
    }
    
    @FXML
    void buscarPorAutor(ActionEvent event){
        autorBuscado = fachada.bucarAutorPorNome(livro.getText());
        obsListBuscada.clear();
      if(autorBuscado != null){
        System.out.println(autorBuscado);
        obsListBuscada.addAll(fachada.listarPorAutor(autorBuscado));  
      }
      else{
          AlertBox.display(" :( ninguém adicionou livros de " + livro.getText() + "no sistema",
                  "Você pode nos ajudar e adicionar mais livros quando quiser :)");
      }
                
        lvLivrosBuscados.refresh();

        lvLivrosBuscados.setItems(obsListBuscada);
    }

    @FXML

    void buscarPorEditora(ActionEvent event) {
        editoraBuscada = fachada.buscarEditora(livro.getText());
        obsListBuscada.clear();
        obsListBuscada.addAll(FXCollections
                .observableArrayList(fachada
                .listarPorEditora(editoraBuscada)));

        lvLivrosBuscados.refresh();
        lvLivrosBuscados.setItems(obsListBuscada);
    }
    
    @FXML
    void AdicionarLivroPessoal(ActionEvent event) throws IOException, NaoPodeException{
    	//tabelaContas.getSelectionModel (). selectedItemProperty () .addListener ((observable, oldValue, newValue) -> mostrarDetalhesConta (newValue));

    	TelaBuscarLivroController.livroBuscado = lvLivrosBuscados.getSelectionModel().getSelectedItem();
    	
    	MeuLivro livroUser = new MeuLivro(TelaBuscarLivroController.livroBuscado);
        try {
            fachada.adicionarLivroUsuario(fachada.getUsuarioLogado(), livroUser);
        } catch (JaExisteException ex) {
            AlertBox.display("Um velho sábio de algum lugar disse...",
                    "\"Não se pode adicionar um livro que já está na sua estante,"
                            + "deverá busca-lo e assim ha de encontra-lo\"");
            Logger.getLogger(TelaBuscarLivroController.class.getName()).log(Level.SEVERE, null, ex);
        }
    	//FachadaController.getUsuarioLogado().adicionarLivro(livroUser);
    	TelaBuscarLivroController.livroBuscado = null;
    	this.obsListBuscada.clear();
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
    	this.obsListBuscada.clear();
    	lvLivrosBuscados.setItems(obsListBuscada);
    	livro.clear();
    	maintestes.escolherTela(3);
    }
    
    @FXML
    void excluirLivro(ActionEvent event) {
        
    }
    
}
