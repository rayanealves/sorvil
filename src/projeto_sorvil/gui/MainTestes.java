package projeto_sorvil.gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import projeto_sorvil.controller.FachadaController;
import projeto_sorvil.dados.UsuarioRepositorio;
import projeto_sorvil.model.MeuLivro;

public class MainTestes extends Application {
    
	
	private static Scene cenaTelaAdicionarLivro, cenaTelaBibliotecaPessoal,cenaTelaCadastro
	, cenaTelaCards , cenaTelaCriacaoCards, cenaTelaEditarUsuario, cenaTelaLivros
	, cenaTelaLogin, cenaTelaBuscarLivro ;
	private static Stage estagioPrimario;
	static FXMLLoader telaBibliotecaPessoal;
	
	
    public void start(Stage stage) throws Exception {
    	try {
    		//FXMLLoader telaLogin = new FXMLLoader(getClass().getResource("/projeto_sorvil.gui/TelaLogin.fxml"));
    		Parent telaLogin = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));
    		//Parent parentTelaLogin = telaLogin.load();
    		cenaTelaLogin = new Scene(telaLogin);
    		
    		//FXMLLoader telaCadastro = new FXMLLoader(getClass().getResource("/projeto_sorvil.gui/TelaCadastro.fxml"));
    		Parent telaCadastro =FXMLLoader.load(getClass().getResource("TelaCadastro.fxml"));
    		//Parent parentTelaCadastro = telaCadastro.load();
    		cenaTelaCadastro = new Scene(telaCadastro);
    		
    		Parent telaAdicionarLivro = FXMLLoader.load(getClass().getResource("TelaAdicionarLivro.fxml"));
    		cenaTelaAdicionarLivro = new Scene(telaAdicionarLivro);
    		
    		//FXMLLoader telaBibliotecaPessoal = new FXMLLoader(getClass().getResource("/projeto_sorvil.gui/TelaBibliotecaPessoal.fxml"));
    		Parent telaBibliotecaPessoal = FXMLLoader.load(getClass().getResource("TelaBibliotecaPessoal.fxml"));
    		//Parent parentTelaBibliotecaPessoal = telaBibliotecaPessoal.load();
    		cenaTelaBibliotecaPessoal = new Scene(telaBibliotecaPessoal);
    		
    		Parent telaCards = FXMLLoader.load(getClass().getResource("TelaCards.fxml"));
    		cenaTelaCards = new Scene(telaCards);
    		
    		Parent telaCriacaoCards = FXMLLoader.load(getClass().getResource("TelaCriacaoCards.fxml"));
    		cenaTelaCriacaoCards = new Scene(telaCriacaoCards);
    		
    		Parent telaEditarUsuario = FXMLLoader.load(getClass().getResource("TelaEditarUsuario.fxml"));
    		cenaTelaEditarUsuario = new Scene(telaEditarUsuario);
    		
    		Parent telaLivros = FXMLLoader.load(getClass().getResource("TelaLivros.fxml"));
    		cenaTelaLivros = new Scene(telaLivros);
    		
    		Parent telaBuscarLivro = FXMLLoader.load(getClass().getResource("TelaBuscarLivro.fxml"));
    		cenaTelaBuscarLivro = new Scene(telaBuscarLivro);

    		
    		
    		
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
    
    
    public static void escolherTela(int opcao) {
    	
    	switch (opcao){
    		case 0:
    			estagioPrimario.close();		
    		break;
    		case 1:
    			estagioPrimario.setScene(cenaTelaLogin);
    			
    			break;
    		case 2:
    			estagioPrimario.setScene(cenaTelaCadastro);
    			break;
    		case 3:
    			estagioPrimario.setScene(cenaTelaBibliotecaPessoal);
    			break;
    		case 4:
    			estagioPrimario.setScene(cenaTelaAdicionarLivro);
    			break;
    		case 5:
    			estagioPrimario.setScene(cenaTelaEditarUsuario);
    			break;	
    		case 6:
    			estagioPrimario.setScene(cenaTelaLivros);
    			break;	
    		case 7:
    			estagioPrimario.setScene(cenaTelaCards);
    			break;
    		case 8:
    			estagioPrimario.setScene(cenaTelaCriacaoCards);
    			break;
    		case 9:
    			estagioPrimario.setScene(cenaTelaBuscarLivro);
    			break;	
 
    		default:
    			
    	}
    	
    	
    }
    
    
    
  	public  ListView<MeuLivro> atualizarListaPessoal() {
      	
  		ObservableList<MeuLivro> obsListPessoal =  FXCollections.observableArrayList(FachadaController.listarLivrosUsuario(FachadaController.getUsuarioLogado()));
         
  		ListView<MeuLivro> lv = new ListView<MeuLivro>();
  		lv.setItems(obsListPessoal);
         
  		return lv;	
      	
      	 	
      }
    
    
}
