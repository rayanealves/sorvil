package projeto_sorvil.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    private ComboBox<Genero> cbGenero;
    
    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnAdicionar;
    
    @SuppressWarnings("unused")
	private ObservableList<Genero> obsGenero;
            
    public void carregarGenero(){
        cbGenero.setItems(FXCollections.observableArrayList(Genero.values()));
    }
}
