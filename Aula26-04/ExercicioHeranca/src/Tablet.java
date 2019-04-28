public class Tablet {
    private String resolucao;
    private boolean rede4G;
    
    public Tablet(){
    }
    public Tablet(String marca, String modelo, String resolucao, boolean rede4G){
        
    }
    
    public void setResolucao(String resolucao){
        this.resolucao = resolucao;
    }
    public String getResolucao(){
        return resolucao;
    }
    
    public void setRede4G(boolean rede4G){
        this.rede4G = rede4G;
    }
    public boolean isRede4G(){
        return rede4G;
    }
    
    
}
