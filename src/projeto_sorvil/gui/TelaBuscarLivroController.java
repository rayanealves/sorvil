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
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import projeto_sorvil.controller.FachadaController;
import projeto_sorvil.model.Livro;
import projeto_sorvil.model.MeuLivro;
import projeto_sorvil.model.Status;
import projeto_sorvil.model.Usuario;


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
    private ListView<Livro> lvLivrosBuscados;
    
    private static Usuario usuarioLogado = null;

    private ObservableList<Livro> obsList =  FXCollections.observableArrayList();
    
    private static Livro livroBuscado = null;
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    void iniciar(MouseEvent event) {
    	if(TelaBuscarLivroController.usuarioLogado == null) {
    		TelaBuscarLivroController.usuarioLogado = FachadaController.getUsuarioLogado();
    	}

    	
    }
    
 
    @FXML
    void buscarLivro(ActionEvent event) {
    	livroBuscado = FachadaController.buscarLivro(livro.getText());
    	obsList.add(livroBuscado); 
    	lvLivrosBuscados.setItems(obsList);
    	
    }
    
    
    @FXML
    void AdicionarLivroPessoal(ActionEvent event) {
    	System.out.println(lvLivrosBuscados.getSelectionModel().getSelectedItem().getNome());
    	livroBuscado = lvLivrosBuscados.getSelectionModel().getSelectedItem();
    	Status status = null;
    	MeuLivro livroUser = new MeuLivro(livroBuscado, status , 0);
    	FachadaController.buscarUsuario(FachadaController.getUsuarioLogado().getLogin()).adicionarLivro(livroUser);
    	
    	livroBuscado = null;
    	obsList.clear();
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
    	livroBuscado = null;
    	obsList.clear();
    	lvLivrosBuscados = null;
    	livro.clear();
    	MainTestes.escolherTela(3);
    }
    
}
