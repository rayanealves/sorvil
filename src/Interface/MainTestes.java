package Interface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainTestes extends Application {
    
	
	@SuppressWarnings("unused")
	private static Scene cenaTelaLogin, cenaTelaCadastro;
	private static Stage estagioPrimario;
	
    @Override
    public void start(Stage stage) throws Exception {
    	try {
    		Parent telaLogin = FXMLLoader.load(getClass().getResource("/Interface/TelaLogin.fxml"));
    		//FXMLLoader telaCadastro = new FXMLLoader(getClass().getResource("TelaCadastro.fxml"));
    		estagioPrimario = stage;
    	
    		estagioPrimario.setTitle("SORVIL");
    	
    	
    		//Parent parentTelaLogin = telaLogin.load();
    		//Parent parentTelaCadastro = telaCadastro.load();
    	
    		cenaTelaLogin = new Scene(telaLogin);
    		//cenaTelaCadastro = new Scene(parentTelaCadastro);
    	
    	
    		/*
    		Parent root = FXMLLoader.load(getClass().getResource("Botao.fxml"));
        	@SuppressWarnings("unused")
			Scene scene = new Scene(root);
    		 */
        
        
    		stage.setScene(cenaTelaLogin);
    		stage.show();
    		
    	} catch(Exception e) {
			e.printStackTrace();
		}
    	
    }

   
    public static void main(String[] args) {
        launch(args);
        
       // Usuario user = new Usuario( nome, String id, String login, String senha, boolean admin, LocalDate dataCadastro)
        
        
        
        
    }
    
}

