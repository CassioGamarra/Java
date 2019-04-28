/**
 * Class: tablet
 * @author Gnomo
 */
public class Tablet extends Eletronico {
    private String resolucao;
    private boolean rede4G;
    
    public Tablet(){
    }
    public Tablet(String marca, String modelo, String resolucao, boolean rede4G){
        
    }
    
    public String getResolucao(){
        return resolucao;
    }
    public void setResolucao(String resolucao){
        this.resolucao = resolucao;
    }
    
    public boolean isRede4G(){
        return rede4G;
    }
    public void setRede4G(boolean rede4G){
        this.rede4G = rede4G;
    }
}
