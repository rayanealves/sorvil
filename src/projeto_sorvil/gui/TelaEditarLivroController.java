/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_sorvil.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import projeto_sorvil.controller.FachadaController;
import projeto_sorvil.exceptions.NaoPodeException;
import projeto_sorvil.model.Editora;
import projeto_sorvil.model.Genero;

/**
 * FXML Controller class
 *
 * @author Rayan
 */
public class TelaEditarLivroController implements Initializable {

     @FXML
    private Text editar;

    @FXML
    private TextField editoratxt;

    @FXML
    private Text editora;

    @FXML
    private Text genero;

    @FXML
    private ChoiceBox<Genero> chboxGenero;

    @FXML
    private Button btnSalvar;
    
    public Editora editoraAlterada = null;
    
    public Genero generoAlterado = null;
    
    private FachadaController fachada;

    private MainTestes maintestes;
    
    public TelaEditarLivroController(){
        this.fachada = FachadaController.getInstance();
	this.maintestes = MainTestes.getInstance();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.chboxGenero.getItems().addAll(Genero.values());
    }

    @FXML
    void salvar(ActionEvent event) throws NaoPodeException, IOException {
        if(editoratxt.getText() != null && !"".equals(editoratxt.getText())){
            editoraAlterada = fachada.novaEditoraNome(editoratxt.getText());
            fachada.alterarEditora(fachada.getUsuarioLogado(), fachada.getLivroSelected(), editoraAlterada);
        }
        if(chboxGenero.getValue() != null){
            generoAlterado = chboxGenero.getValue();
            fachada.alterarGenero(fachada.getUsuarioLogado(), fachada.getLivroSelected(), generoAlterado);
        }
        maintestes.escolherTela(9);
    }
    
}
