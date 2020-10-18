package projeto_sorvil.model;


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
        
        

}
