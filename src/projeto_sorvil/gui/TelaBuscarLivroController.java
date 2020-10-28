/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_sorvil.gui;

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
import projeto_sorvil.exceptions.NaoPodeException;
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


    private static ObservableList<Livro> obsListBuscada =  FXCollections.observableArrayList();
    
    private static Livro livroBuscado = null;
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    

    
 
    @FXML
    void buscarLivro(ActionEvent event) throws NaoPodeException {
    	TelaBuscarLivroController.livroBuscado = FachadaController.buscarLivro(livro.getText());
    	TelaBuscarLivroController.obsListBuscada.add(livroBuscado); 
    	lvLivrosBuscados.setItems(TelaBuscarLivroController.obsListBuscada);
    	
    }
    
    
    @FXML
    void AdicionarLivroPessoal(ActionEvent event) throws JaExisteException {
    	
    	TelaBuscarLivroController.livroBuscado = lvLivrosBuscados.getSelectionModel().getSelectedItem();

    	Status status =  Status.EM_BRANCO;
    	MeuLivro livroUser = new MeuLivro(TelaBuscarLivroController.livroBuscado, status , 0);
    	FachadaController.adicionarLivroUsuario(FachadaController.getUsuarioLogado(), livroUser);
    	//FachadaController.getUsuarioLogado().adicionarLivro(livroUser);
    	TelaBuscarLivroController.livroBuscado = null;
    	TelaBuscarLivroController.obsListBuscada.clear();
    	lvLivrosBuscados = null;
    	livro.clear();
    	MainTestes.escolherTela(3);
    }

    @FXML
    void adicionarLivroSorvil(ActionEvent event) {
    	MainTestes.escolherTela(4);
    }
    
    
    @FXML
    void voltar(ActionEvent event) {
    	TelaBuscarLivroController.livroBuscado = null;
    	TelaBuscarLivroController.obsListBuscada.clear();
    	lvLivrosBuscados = null;
    	livro.clear();
    	MainTestes.escolherTela(3);
    }
    
    @FXML
    void excluirLivro(ActionEvent event) {

    }
    
}
