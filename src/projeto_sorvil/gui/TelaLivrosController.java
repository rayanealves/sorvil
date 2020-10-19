package projeto_sorvil.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import projeto_sorvil.controller.FachadaController;
import projeto_sorvil.model.MeuLivro;

public class TelaLivrosController {

    @FXML
    private Button botaoVoltar;
    
    private static MeuLivro onLivro = null;

    @FXML
    void iniciar(MouseEvent event) {
    	if(TelaLivrosController.onLivro == null) {
    		TelaLivrosController.onLivro = FachadaController.getOnLivro();
    	}
    	
    }
    
    
    @FXML
    void voltar(ActionEvent event) {
    	FachadaController.setOnLivro(null);
    	onLivro = null;
    	MainTestes.escolherTela(3);
    }

}
