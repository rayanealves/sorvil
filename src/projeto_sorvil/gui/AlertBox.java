/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_sorvil.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author usuario
 */
public class AlertBox {
    public static void display(String titulo, String mansagem){
        Stage janela = new Stage();
        janela.initModality(Modality.APPLICATION_MODAL);
        janela.setTitle(titulo);
        janela.setMinWidth(250);
        Label label = new Label();
        label.setText(mansagem);
        Button botaoFechar = new Button("Fechar");
        botaoFechar.setOnAction(e -> janela.close());
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, botaoFechar);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        janela.setScene(scene);
        janela.showAndWait();
        
    }
}
