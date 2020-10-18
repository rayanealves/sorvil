package projeto_sorvil.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import projeto_sorvil.model.Genero;

public class TelaAdicionarLivroController {
    
    @FXML
    private GridPane telaAdicionarLivro;
    
    @FXML
    private Text adicionar;
    
    @FXML
    private Text nome;

    @FXML
    private Text autor;

    @FXML
    private Text editora;

    @FXML
    private Text ano;

    @FXML
    private Text paginas;

    @FXML
    private Text genero;

    @FXML
    private TextField txtLivro;

    @FXML
    private TextField txtAutor;

    @FXML
    private TextField txtEditora;

    @FXML
    private TextField txtAno;

    @FXML
    private TextField txtPaginas;
    
    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnAdicionar;
    
    @FXML
    private CheckBox adm;

    @FXML
    private CheckBox artes;

    @FXML
    private CheckBox aventura;

    @FXML
    private CheckBox auto;

    @FXML
    private CheckBox bio;

    @FXML
    private CheckBox conto;

    @FXML
    private CheckBox dicionario;

    @FXML
    private CheckBox economia;

    @FXML
    private CheckBox ficci;

    @FXML
    private CheckBox geo;

    @FXML
    private CheckBox humor;

    @FXML
    private CheckBox med;

    @FXML
    private CheckBox direito;

    @FXML
    private CheckBox fantasia;

    @FXML
    private CheckBox filosofia;

    @FXML
    private CheckBox historia;

    @FXML
    private CheckBox ling;

    @FXML
    private CheckBox poesia;

    @FXML
    private CheckBox policial;

    @FXML
    private CheckBox psi;

    @FXML
    private CheckBox religiao;

    @FXML
    private CheckBox suspense;

    @FXML
    private CheckBox romance;

    @FXML
    private CheckBox terror;

    @FXML
    private CheckBox turismo;
    
    
    @FXML
    public void initialize() {
      
    }
    
    
    
    
    

   
}
