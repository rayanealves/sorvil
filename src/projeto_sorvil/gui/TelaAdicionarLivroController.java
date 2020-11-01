package projeto_sorvil.gui;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import projeto_sorvil.controller.FachadaController;
import projeto_sorvil.exceptions.JaExisteException;
import projeto_sorvil.model.Autor;
import projeto_sorvil.model.Editora;
import projeto_sorvil.model.Genero;
import projeto_sorvil.model.Livro;


public class TelaAdicionarLivroController implements Initializable {
    
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
    private TextField nomeLivro;
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
    private TextField anoEd;
    @FXML
    private Button btnAbrir;
    @FXML 
    ChoiceBox<Genero> boxGenero;
    @FXML 
    private Text isbntxt;
    @FXML 
    private TextField isbn;
    private FachadaController fachada;
	private MainTestes maintestes;

	
	public TelaAdicionarLivroController() {
		boxGenero = new ChoiceBox<Genero>();
		this.fachada = FachadaController.getInstance();
		this.maintestes = MainTestes.getInstance();
	}

    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	this.boxGenero.getItems().addAll(Genero.values());
    }
    
    

    @FXML
    void criarLivro(ActionEvent event) throws IOException{
    	
        Editora novaEditora;
        novaEditora = fachada.novaEditoraNome(editora.getText());   
        Autor novoAutor = fachada.novoAutorNome(autor.getText());
        
    	Genero onGenero = boxGenero.getValue();
    	int anoEdicao = Integer.parseInt(anoEd.getText());
    	int anoPublica = Integer.parseInt(anoPub.getText());
        int numeroPag = Integer.parseInt(numPag.getText());
    	
    	
    	Livro livroAdicionado = new Livro(nomeLivro.getText(), isbn.getText() , novaEditora, novoAutor, onGenero ,numeroPag ,
    			anoEdicao, anoPublica);
        
    	
        try {
            fachada.novoLivro(livroAdicionado);
            System.out.println(fachada.listarLivros().size());
        } catch (JaExisteException ex) {
            AlertBox.display("Você não pode adicionar esse livro", ex.getMessage());
            Logger.getLogger(TelaAdicionarLivroController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(anoPublica);
        System.out.println(numeroPag);
        
        maintestes.escolherTela(9);
    			
    			
    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
        this.limparCampos();
        maintestes.escolherTela(9);
    }
    
    public void limparCampos(){
        nomeLivro.clear();
        autor.clear();
    	editora.clear();
    	anoPub.clear();
    	numPag.clear();
        anoEd.clear();
        isbn.clear();
        this.boxGenero.getSelectionModel().clearSelection();
    }



}
