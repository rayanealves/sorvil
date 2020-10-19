package projeto_sorvil.gui;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import projeto_sorvil.controller.ControladorAutor;
import projeto_sorvil.controller.ControladorEditora;
import projeto_sorvil.model.Autor;
import projeto_sorvil.model.Editora;
import projeto_sorvil.model.Genero;
import projeto_sorvil.model.Livro;


public class TelaAdicionarLivroController {
    
    @FXML
    private GridPane telaAdicionarLivro;
    
    @FXML
    private Text adicionar;
    
  @FXML
    private Text nometxt;

    @FXML
    private Text autortxt;

    @FXML
    private Text editoratxt;

    @FXML
    private Text anoPubtxt;

    @FXML
    private Text numPagtxt;

    @FXML
    private Text generotxt;

   @FXML
    private TextField nome;

    @FXML
    private TextField autor;

    @FXML
    private TextField editora;

    @FXML
    private TextField anoPub;

    @FXML
    private TextField numPag;

    @FXML
    private Button botaoCancelar;

    @FXML
    private Button botaoCriar;
    
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
    private Button btnAbrir;

    private ControladorEditora controladorEditora = new ControladorEditora();
    
    private ControladorAutor controladorAutor = new ControladorAutor();
    
    
    @FXML
    public void initialize() {
      
    }

    @FXML
    void criarLivro(ActionEvent event) {
    	/*
    	Editora novaEditora = new Editora(editora.getText(), null);
    	controladorEditora.novaEditora(novaEditora);
    	novaEditora = controladorEditora.buscarEditora(editora.getText());
    	Autor(String nome, String sobrenome, String id)
    	
    	
    	//int num = (int) numPag.
    	
    	Livro livroAdicionado = new Livro(nome.getText(), null , novaEditora,  autor, null,numPag ,
    			edicao,LocalDate anoP )
    			
    			*/
    }

    @FXML
    void voltar(ActionEvent event) {
    	nome.clear();
    	autor.clear();
    	editora.clear();
    	anoPub.clear();
    	numPag.clear();
    	MainTestes.escolherTela(3);
    }
  
}
