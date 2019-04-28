public class Smartphone {
    private String resolucao;
    private int numChips;
    
    public Smartphone(){
    }
    
    public Smartphone(String marca, String modelo, String resolucao, int numChips){
        
    }
    
    public void setResolucao(String resolucao){
        this.resolucao = resolucao;
    }
    public String getResolucao(){
        return resolucao;
    }
    
    public void setNumChips(int numChips){
        this.numChips = numChips;
    }
    public int getNumChips(){
        return numChips;
    } 
}
