package projeto_sorvil.gui;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import projeto_sorvil.controller.ControladorAutor;
import projeto_sorvil.controller.ControladorEditora;
import projeto_sorvil.controller.ControladorLivro;
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
    private TextField livro;

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
    private CheckBox Genero;

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
    

    private ControladorEditora controladorEditora = ControladorEditora.getInstance();
    
    private ControladorAutor controladorAutor = ControladorAutor.getInstance();
    
    private ControladorLivro controladorLivro = ControladorLivro.getInstance();
    
    
    @FXML
    public void initialize() {
      
    }
    
    

    @FXML
    void criarLivro(ActionEvent event) {
    	
    	Editora novaEditora = new Editora(editora.getText(), null);
    	controladorEditora.novaEditora(novaEditora);
    	novaEditora = controladorEditora.buscarEditora(editora.getText());
    	//Autor(String nome, String sobrenome, String id);
    	
    	int anoPublica = Integer.parseInt(anoPub.getText());
        int numeroPag = Integer.parseInt(numPag.getText());
    	
    	
    	Livro livroAdicionado = new Livro(livro.getText(), null , novaEditora, null, null,numeroPag ,
    			0, anoPublica);
        controladorLivro.novoLivro(livroAdicionado);
        System.out.println(anoPublica);
        System.out.println(numeroPag);
        
    			
    			
    }

    @FXML
    void voltar(ActionEvent e) {
        this.fecharGeneros();
    	livro.clear();
        autor.clear();
    	editora.clear();
    	anoPub.clear();
    	numPag.clear();
    	MainTestes.escolherTela(3);
    }
    
    @FXML
    void abrirGeneros(ActionEvent event){
        adm.setVisible(true);
        artes.setVisible(true);
        aventura.setVisible(true);
        auto.setVisible(true);
        bio.setVisible(true);
        conto.setVisible(true);
        dicionario.setVisible(true);
        economia.setVisible(true);  
        ficci.setVisible(true);  
        geo.setVisible(true); 
        humor.setVisible(true);
        med.setVisible(true);
        direito.setVisible(true);
        fantasia.setVisible(true);
        filosofia.setVisible(true);
        historia.setVisible(true);
        ling.setVisible(true);
        poesia.setVisible(true);
        policial.setVisible(true);
        psi.setVisible(true);
        religiao.setVisible(true);
        suspense.setVisible(true);
        romance.setVisible(true);
        terror.setVisible(true);
        turismo.setVisible(true);
    }
    
    public void fecharGeneros(){
        adm.setVisible(false);
        artes.setVisible(false);
        aventura.setVisible(false);
        auto.setVisible(false);
        bio.setVisible(false);
        conto.setVisible(false);
        dicionario.setVisible(false);
        economia.setVisible(false);  
        ficci.setVisible(false);  
        geo.setVisible(false); 
        humor.setVisible(false);
        med.setVisible(false);
        direito.setVisible(false);
        fantasia.setVisible(false);
        filosofia.setVisible(false);
        historia.setVisible(false);
        ling.setVisible(false);
        poesia.setVisible(false);
        policial.setVisible(false);
        psi.setVisible(false);
        religiao.setVisible(false);
        suspense.setVisible(false);
        romance.setVisible(false);
        terror.setVisible(false);
        turismo.setVisible(false);
    }
    
    
}
