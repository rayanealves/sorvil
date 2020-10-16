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
        
    	FXMLLoader telaLogin = new FXMLLoader(getClass().getResource("TelaLogin.fxml"));
    	FXMLLoader telaCadastro = new FXMLLoader(getClass().getResource("TelaCadastro.fxml"));
    	estagioPrimario = stage;
    	
    	estagioPrimario.setTitle("SORVIL");
    	
    	
    	Parent parentTelaLogin = telaLogin.load();
    	Parent parentTelaCadastro = telaCadastro.load();
    	
    	cenaTelaLogin = new Scene(parentTelaLogin, 480,480);
    	cenaTelaCadastro = new Scene(parentTelaCadastro, 480,480);
    	
    	
    	/*
    	Parent root = FXMLLoader.load(getClass().getResource("Botao.fxml"));
        @SuppressWarnings("unused")
		Scene scene = new Scene(root);
        */
        
        
        stage.setScene(cenaTelaLogin);
        stage.show();
    }

   
    public static void main(String[] args) {
        launch(args);
        
       // Usuario user = new Usuario( nome, String id, String login, String senha, boolean admin, LocalDate dataCadastro)
        
        
        
        
    }
    
}

