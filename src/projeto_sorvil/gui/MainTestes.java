package projeto_sorvil.gui;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import projeto_sorvil.controller.FachadaController;
import projeto_sorvil.dados.UsuarioRepositorio;
import projeto_sorvil.model.Card;
import projeto_sorvil.model.MeuLivro;

public class MainTestes extends Application {
    
	
	private static Scene cenaTelaAdicionarLivro, cenaTelaBibliotecaPessoal,cenaTelaCadastro
	, cenaTelaCards , cenaTelaCriacaoCards, cenaTelaEditarUsuario, cenaTelaLivros
	, cenaTelaLogin, cenaTelaBuscarLivro, cenaTelaEditarLivro ;
	private static Stage estagioPrimario;
	private static MainTestes instance;
	private FachadaController fachada = FachadaController.getInstance();
	
    public static MainTestes getInstance() {
	if(instance == null) {
		instance = new MainTestes();
	}
	return instance;
    }
	

    public void start(Stage stage) throws Exception {
    	try {
    		FXMLLoader telaLogin = new FXMLLoader(getClass().getResource("TelaLogin.fxml"));
    		Parent parentTelaLogin = telaLogin.load();
    		cenaTelaLogin = new Scene(parentTelaLogin);
    		
    		
    		estagioPrimario = stage;
    		estagioPrimario.setTitle("SORVIL");
    	
    		//Parent parentTelaLogin = telaLogin.load();
    		//Parent parentTelaCadastro = telaCadastro.load();
    		/*
    		Parent root = FXMLLoader.load(getClass().getResource("Botao.fxml"));
        	@SuppressWarnings("unused")
			Scene scene = new Scene(root);
    		 */
        
        
    		estagioPrimario.setScene(cenaTelaLogin);
    		estagioPrimario.show();
    		
    	} catch(Exception e) {
			e.printStackTrace();
		}
    	
    }

   
    public static void main(String[] args) {
    	//UsuarioRepositorio.getInstancia().getUsuarios().clear();
    	//DAO.salvarArquivo(UsuarioRepositorio.getInstancia(), "src/usuarios.dat");
    	System.out.println(UsuarioRepositorio.getInstancia().getUsuarios().size());
    	
        launch(args);

        
        
        
    }
    
    
    public void escolherTela(int opcao) throws IOException {
    	try{
    		switch (opcao){
    			case 0:
    				estagioPrimario.close();		
    			break;
    			case 1:
    				estagioPrimario.setScene(cenaTelaLogin);			
    				break;
    			case 2:
	        		FXMLLoader telaCadastro = new FXMLLoader(getClass().getResource("TelaCadastro.fxml"));
	        		telaCadastro.setController(new TelaCadastroController());
	        		Parent parentTelatelaCadastro = telaCadastro.load();
        			cenaTelaCadastro = new Scene(parentTelatelaCadastro);
        			estagioPrimario.setScene(cenaTelaCadastro);
    				break;
    			case 3:			
	        		FXMLLoader telaBibliotecaPessoal = new FXMLLoader(getClass().getResource("TelaBibliotecaPessoal.fxml"));
	        		telaBibliotecaPessoal.setController(new TelaBibliotecaPessoalController(atualizarListaPessoal()));
	        		Parent parentTelaBibliotecaPessoal = telaBibliotecaPessoal.load();
	    			cenaTelaBibliotecaPessoal = new Scene(parentTelaBibliotecaPessoal);
    				estagioPrimario.setScene(cenaTelaBibliotecaPessoal);
    				break;
    			case 4:
    				FXMLLoader telaAdicionarLivro = new FXMLLoader(getClass().getResource("TelaAdicionarLivro.fxml"));
    				telaAdicionarLivro.setController(new TelaAdicionarLivroController());
    				Parent parentTelaAdicionarLivro = telaAdicionarLivro.load();
    				cenaTelaAdicionarLivro = new Scene( parentTelaAdicionarLivro);
    				estagioPrimario.setScene(cenaTelaAdicionarLivro);
    				break;
    			case 5:
    				FXMLLoader telaEditarUsuario = new FXMLLoader(getClass().getResource("TelaEditarUsuario.fxml"));
    				telaEditarUsuario.setController(new TelaEditarUsuarioController());
    				Parent parentTelaEditarUsuario = telaEditarUsuario.load();
    	    		cenaTelaEditarUsuario = new Scene(parentTelaEditarUsuario);
    				estagioPrimario.setScene(cenaTelaEditarUsuario);
    				break;	
    			case 6:
    				FXMLLoader telaLivros = new FXMLLoader(getClass().getResource("TelaLivros.fxml"));
    				telaLivros.setController(new TelaLivrosController());
    				Parent parentTelaLivros = telaLivros.load();
    	    		cenaTelaLivros = new Scene(parentTelaLivros);
    				estagioPrimario.setScene(cenaTelaLivros);
    				break;	
    			case 7:
    				FXMLLoader telaCards = new FXMLLoader(getClass().getResource("TelaCards.fxml"));
    				telaCards.setController(new TelaCardsController(atualizarListaCards()));
    				Parent parentTelaCards = telaCards.load();
    	    		cenaTelaCards = new Scene(parentTelaCards);
    				estagioPrimario.setScene(cenaTelaCards);
    				break;
    			case 8:
    				FXMLLoader telaCriacaoCards = new FXMLLoader(getClass().getResource("TelaCriacaoCards.fxml"));
    				telaCriacaoCards.setController(new TelaCriacaoCardsController());
    				Parent parentTelaCriacaoCards = telaCriacaoCards.load();
    	    		cenaTelaCriacaoCards = new Scene(parentTelaCriacaoCards);
    				estagioPrimario.setScene(cenaTelaCriacaoCards);
    				break;
    			case 9:
    				FXMLLoader telaBuscarLivro = new FXMLLoader(getClass().getResource("TelaBuscarLivro.fxml"));
    				telaBuscarLivro.setController(new TelaBuscarLivroController());
    				Parent parentTelaBuscarLivro = telaBuscarLivro.load();
    	    		cenaTelaBuscarLivro = new Scene(parentTelaBuscarLivro);
    				estagioPrimario.setScene(cenaTelaBuscarLivro);
    				break;
    			case 10:
    				FXMLLoader telaEditarLivro = new FXMLLoader(getClass().getResource("TelaEditarLivro.fxml"));
    				telaEditarLivro.setController(new TelaEditarLivroController());
    				Parent parentTelaEditarLivro = telaEditarLivro.load();
    	    		cenaTelaEditarLivro = new Scene(parentTelaEditarLivro);
    				estagioPrimario.setScene(cenaTelaEditarLivro);
    				break;	

    			default:
    			
    		}
    	
    	} catch(Exception e){
			e.printStackTrace();
		}
    }
    
    
    
  	public  ObservableList<MeuLivro> atualizarListaPessoal() {
  		ArrayList<MeuLivro> estante = new ArrayList<MeuLivro>(fachada.listarLivrosUsuario(fachada.getUsuarioLogado()));
  		ObservableList<MeuLivro> obsListPessoal =  FXCollections.observableArrayList(estante);  
  		return obsListPessoal;	 	
    }
  	
  	public  ObservableList<Card> atualizarListaCards() {
  		ArrayList<Card> listaCards = new ArrayList<Card>(fachada.listarCardsUsuario(fachada.getUsuarioLogado()));
  		
  		ObservableList<Card> obsListaCards =  FXCollections.observableArrayList(listaCards);
  		return obsListaCards;	 	
    }
  	
    
    
}
