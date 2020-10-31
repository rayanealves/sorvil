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
    private ListView<MeuLivro> lvListaPessoalLivros = new ListView<MeuLivro>();;

    @FXML
    private TextField txtLivro;

    @FXML
    private Text titulo;
    
    @FXML
    private Button btnBuscarNome;
	
	private MainTestes maintestes;
	
	private MeuLivro livroBuscado;
    
    private static ObservableList<MeuLivro> obsListPessoal;
    
    
	public TelaBibliotecaPessoalController(ObservableList<MeuLivro> ob) {
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
    	FachadaController.setUsuarioLogado(null);
    	maintestes.escolherTela(1);
    	
    }


    @FXML
    void irParaLivro(ActionEvent event) throws IOException {
    	MeuLivro onLivro =  this.lvListaPessoalLivros.getSelectionModel().getSelectedItem();
    	FachadaController.setOnLivro(onLivro);
    	if(FachadaController.getOnLivro() != null) {
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
        livroBuscado = FachadaController.getInstance().buscarLivroUsuario(FachadaController.getUsuarioLogado(), txtLivro.getText());
    	obsListPessoal.add(livroBuscado);
    	lvListaPessoalLivros.setItems(obsListPessoal); 
    }
    
}
