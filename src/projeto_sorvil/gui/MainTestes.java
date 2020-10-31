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
import projeto_sorvil.model.MeuLivro;

public class MainTestes extends Application {
    
	
	private static Scene cenaTelaAdicionarLivro, cenaTelaBibliotecaPessoal,cenaTelaCadastro
	, cenaTelaCards , cenaTelaCriacaoCards, cenaTelaEditarUsuario, cenaTelaLivros
	, cenaTelaLogin, cenaTelaBuscarLivro ;
	private static Stage estagioPrimario;
	private static MainTestes instance;
	
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
        			Parent telaCadastro =FXMLLoader.load(getClass().getResource("TelaCadastro.fxml"));
        			cenaTelaCadastro = new Scene(telaCadastro);
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
    				Parent telaEditarUsuario = FXMLLoader.load(getClass().getResource("TelaEditarUsuario.fxml"));
    	    		cenaTelaEditarUsuario = new Scene(telaEditarUsuario);
    				estagioPrimario.setScene(cenaTelaEditarUsuario);
    				break;	
    			case 6:
    				Parent telaLivros = FXMLLoader.load(getClass().getResource("TelaLivros.fxml"));
    	    		cenaTelaLivros = new Scene(telaLivros);
    				estagioPrimario.setScene(cenaTelaLivros);
    				break;	
    			case 7:
    				Parent telaCards = FXMLLoader.load(getClass().getResource("TelaCards.fxml"));
    	    		cenaTelaCards = new Scene(telaCards);
    				estagioPrimario.setScene(cenaTelaCards);
    				break;
    			case 8:
    				Parent telaCriacaoCards = FXMLLoader.load(getClass().getResource("TelaCriacaoCards.fxml"));
    	    		cenaTelaCriacaoCards = new Scene(telaCriacaoCards);
    				estagioPrimario.setScene(cenaTelaCriacaoCards);
    				break;
    			case 9:
    				Parent telaBuscarLivro = FXMLLoader.load(getClass().getResource("TelaBuscarLivro.fxml"));
    	    		cenaTelaBuscarLivro = new Scene(telaBuscarLivro);
    				estagioPrimario.setScene(cenaTelaBuscarLivro);
    				break;	
 
    			default:
    			
    		}
    	
    	} catch(Exception e){
			e.printStackTrace();
		}
    }
    
    
    
  	public  ObservableList<MeuLivro> atualizarListaPessoal() {
      	
  		ArrayList<MeuLivro> estante = new ArrayList<MeuLivro>(FachadaController.listarLivrosUsuario(FachadaController.getUsuarioLogado()));
  		//estante = FachadaController.listarLivrosUsuario(FachadaController.getUsuarioLogado());
  		ObservableList<MeuLivro> obsListPessoal =  FXCollections.observableArrayList(estante);
  		
  		
         
  		return obsListPessoal;
      	
      	 	
    }
  	
    
    
}
