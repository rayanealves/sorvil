package Interface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainTestes extends Application {
    
	
	private static Scene cenaTelaAdicionarLivro, cenaTelaBibliotecaPessoal,cenaTelaCadastro, cenaTelaCards, cenaTelaCriacaoCards, cenaTelaEditarUsuario, cenaTelaLivros, cenaTelaLogin ;
	private static Stage estagioPrimario;
	static FXMLLoader telaBibliotecaPessoal;
	
	
    public void start(Stage stage) throws Exception {
    	try {
    		//FXMLLoader telaLogin = new FXMLLoader(getClass().getResource("/Interface/TelaLogin.fxml"));
    		Parent telaLogin =FXMLLoader.load(getClass().getResource("/Interface/TelaLogin.fxml"));
    		//Parent parentTelaLogin = telaLogin.load();
    		cenaTelaLogin = new Scene(telaLogin);
    		
    		//FXMLLoader telaCadastro = new FXMLLoader(getClass().getResource("/Interface/TelaCadastro.fxml"));
    		Parent telaCadastro =FXMLLoader.load(getClass().getResource("/Interface/TelaCadastro.fxml"));
    		//Parent parentTelaCadastro = telaCadastro.load();
    		cenaTelaCadastro = new Scene(telaCadastro);
    		
    		Parent telaAdicionarLivro = FXMLLoader.load(getClass().getResource("/Interface/TelaAdicionarLivro.fxml"));
    		cenaTelaAdicionarLivro = new Scene(telaAdicionarLivro);
    		
    		//FXMLLoader telaBibliotecaPessoal = new FXMLLoader(getClass().getResource("/Interface/TelaBibliotecaPessoal.fxml"));
    		Parent telaBibliotecaPessoal = FXMLLoader.load(getClass().getResource("/Interface/TelaBibliotecaPessoal.fxml"));
    		//Parent parentTelaBibliotecaPessoal = telaBibliotecaPessoal.load();
    		cenaTelaBibliotecaPessoal = new Scene(telaBibliotecaPessoal);
    		
    		Parent telaCards = FXMLLoader.load(getClass().getResource("/Interface/TelaCards.fxml"));
    		cenaTelaCards = new Scene(telaCards);
    		
    		Parent telaCriacaoCards = FXMLLoader.load(getClass().getResource("/Interface/TelaCriacaoCards.fxml"));
    		cenaTelaCriacaoCards = new Scene(telaCriacaoCards);
    		
    		Parent telaEditarUsuario = FXMLLoader.load(getClass().getResource("/Interface/TelaEditarUsuario.fxml"));
    		cenaTelaEditarUsuario = new Scene(telaEditarUsuario);
    		
    		Parent telaLivros = FXMLLoader.load(getClass().getResource("/Interface/TelaLivros.fxml"));
    		cenaTelaLivros = new Scene(telaLivros);

    		
    		
    		
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
        launch(args);
        
       // Usuario user = new Usuario( nome, String id, String login, String senha, boolean admin, LocalDate dataCadastro)
        
        
        
        
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
    		default:
    			
    	}
    	
    	
    }
    
    
}
