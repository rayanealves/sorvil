package projeto_sorvil.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Testetela extends Application {
	
	
    @Override
    public void start(Stage stage) throws Exception {
    		
    		Parent root = FXMLLoader.load(getClass().getResource("TelaAdicionarLivro.fxml"));
    		
    		Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
    		
    		
		}
    	
    

   
    public static void main(String[] args) {
        launch(args);
        
       // Usuario user = new Usuario( nome, String id, String login, String senha, boolean admin, LocalDate dataCadastro)
        
        
        
        
    }
    
    
    
    
    
}
