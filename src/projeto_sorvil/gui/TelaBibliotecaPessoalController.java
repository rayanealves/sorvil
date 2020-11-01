package projeto_sorvil.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import projeto_sorvil.controller.FachadaController;
import projeto_sorvil.exceptions.NaoExisteException;
import projeto_sorvil.model.MeuLivro;



public class TelaBibliotecaPessoalController implements Initializable {

    @FXML
    private AnchorPane tela;

    @FXML
    private Button btnDeletarLivro;

    @FXML
    private Button btnSair;

    @FXML
    private Button btnEditarUsuario;

    @FXML
    private Button btnAdicionarLivro;

    @FXML
    private ListView<MeuLivro> lvListaPessoalLivros;

    @FXML
    private TextField txtLivro;

    @FXML
    private Text titulo;
    
    @FXML
    private Button btnBuscarNome;
	
	private MainTestes maintestes;
    private FachadaController fachada;

	private MeuLivro livroBuscado;
    
    private ObservableList<MeuLivro> obsListPessoal;
    
    
	public TelaBibliotecaPessoalController(ObservableList<MeuLivro> ob) {
		lvListaPessoalLivros = new ListView<MeuLivro>();
		this.fachada = FachadaController.getInstance();
		this.maintestes = MainTestes.getInstance();
		obsListPessoal = ob;
		
	}
	
    
   
    public void initialize(URL url, ResourceBundle rb) {
    	this.lvListaPessoalLivros.setItems(obsListPessoal);
		this.lvListaPessoalLivros.refresh();

    }

    @FXML
    void fechar(ActionEvent event) throws IOException {
    	obsListPessoal = null;
    	lvListaPessoalLivros.setItems(obsListPessoal);
    	fachada.setUsuarioLogado(null);
    	maintestes.escolherTela(1);
    	
    }


    @FXML
    void irParaLivro(ActionEvent event) throws IOException {
    	MeuLivro onLivro =  this.lvListaPessoalLivros.getSelectionModel().getSelectedItem();
    	fachada.setOnLivro(onLivro);
    	if(fachada.getOnLivro() != null) {
    		maintestes.escolherTela(6);
    	}
    }
    

    @FXML
    void DeletarLivroPessoal(ActionEvent event) {
    	@SuppressWarnings("unused")
	MeuLivro deleteLivro =this.lvListaPessoalLivros.getSelectionModel().getSelectedItem();
    	
    	obsListPessoal = null;

    }

    @FXML
    void telaAdicionarLivro(ActionEvent event) throws IOException {
    	obsListPessoal = null;
    	maintestes.escolherTela(9);
    }

    @FXML
    void telaEditarUsuario(ActionEvent event) throws IOException {
    	obsListPessoal  = null;
    	maintestes.escolherTela(5);
    }

    @FXML
    void mostrarLivroNome(ActionEvent event) throws NaoExisteException {
        livroBuscado = fachada.buscarLivroUsuario(fachada.getUsuarioLogado(), txtLivro.getText());
    	obsListPessoal.clear();
        obsListPessoal.add(livroBuscado);
        lvListaPessoalLivros.refresh();
    	lvListaPessoalLivros.setItems(obsListPessoal); 
    }
    
}
