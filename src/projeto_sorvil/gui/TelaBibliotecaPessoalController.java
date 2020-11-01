package projeto_sorvil.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    void deletarLivroPessoal(ActionEvent event)  {
    	MeuLivro deleteLivro = this.lvListaPessoalLivros.getSelectionModel().getSelectedItem();
        try {
            fachada.removerLivroUsuario(fachada.getUsuarioLogado(), deleteLivro);
        } catch (NaoExisteException ex) {
            AlertBox.display("Esta tentando deletar um livro inexistente", "Não pode deletar o que não existe");
            Logger.getLogger(TelaBibliotecaPessoalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    	obsListPessoal = maintestes.atualizarListaPessoal();
    	this.lvListaPessoalLivros.setItems(obsListPessoal);
		this.lvListaPessoalLivros.refresh();

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
    void mostrarLivroNome(ActionEvent event) {
        try {
            livroBuscado = fachada.buscarLivroUsuario(fachada.getUsuarioLogado(), txtLivro.getText());
        } catch (NaoExisteException ex) {
            AlertBox.display("Livro não adicionado", 
                    "Voce esta buscando um livro que nao esta na sua estante,\n "
                            + "tente adiciona-lo antes da exclusão");
            Logger.getLogger(TelaBibliotecaPessoalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    	obsListPessoal.clear();
        obsListPessoal.add(livroBuscado);
        lvListaPessoalLivros.refresh();
    	lvListaPessoalLivros.setItems(obsListPessoal); 
    }
    
}
