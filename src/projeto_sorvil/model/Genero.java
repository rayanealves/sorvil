package projeto_sorvil.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public enum Genero {
	ADMINISTRACAO("Administração"), ARTES("Artes"), AUTOAJUDA("Autoajuda"), 
        AVENTURA("Aventura"), BIOGRAFIA("Biografia"), CONTO("Conto"), DICIONARIO("Dicionario"), 
	DIREITO("Direito"), ECONIMIA("Economia"), FANTASIA("Fantasia"), FICCAO_CIENTIFICA("Ficção Científica"), 
        FILOSOFIA("Filosofia"), GEOGRAFIA("Geografia"), HISTORIA("História"),
	HUMOR("Humor"), LINGUISTICA("Linguistica"), MEDICINA("Medicina"), POESIA("Poesia"), POLICIAL("Policial"), 
        PSICOLOGIA("Psicologia"), RELIGIAO("Religião"), ROMANCE("Romance"), SUSPENSE("Suspense"), 
        TERROR("Terror"), TURISMO("Turismo");
  
        private String nome;
        
        Genero(String nome){
            this.nome = nome;
        }
        
        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
        
        public static List<Genero> listaCidades(){
    	List<Genero> generos = new ArrayList<Genero>();
    	generos.addAll(Arrays.asList(Genero.values()));
    	return generos;
    }
}
        
