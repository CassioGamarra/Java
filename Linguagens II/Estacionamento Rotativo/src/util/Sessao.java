package util;

/**
 *
 * @author cassio
 */
public class Sessao {
    private static Sessao instance;
    private int nivelAcesso;
    
    private Sessao(){}
    
    public static Sessao getInstance(){
        if(instance == null){
            instance = new Sessao();
        }
        return instance;
    }

    public int getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
    
  
}
