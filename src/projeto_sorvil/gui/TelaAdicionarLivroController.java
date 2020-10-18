package projeto_sorvil.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
    private ChoiceBox<Genero> chGenero;
    
    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnAdicionar;
    
    @FXML
    public void initialize() {
        this.chGenero.getItems().addAll(Genero.values());
    }
}
