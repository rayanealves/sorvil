package Interface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainTestesLivro extends Application {
   
	
    @Override
    public void start(Stage stage) throws Exception {
    	
    		Parent telaAdicionarLivro = FXMLLoader.load(getClass().getResource("TelaAdicionarLivro.fxml"));
    		Scene scene = new Scene(telaAdicionarLivro);
                
                stage.setScene(scene);
                stage.show();
    	
    }

   
    public static void main(String[] args) {
        launch(args);
        
       // Usuario user = new Usuario( nome, String id, String login, String senha, boolean admin, LocalDate dataCadastro)
        
        
        
        
    }
    
    
    
}

