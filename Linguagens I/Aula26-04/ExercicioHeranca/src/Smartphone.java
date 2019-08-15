/**
 * Class: Smartphone
 * @author Gnomo
 */
public class Smartphone extends Eletronico {
    private String resolucao;
    private int numChips;

    public Smartphone(){
    }
    
    public Smartphone(String marca, String modelo, String resolucao, int numChips){
        
    }
    
    public String getResolucao(){
        return resolucao;
    }
    public void setResolucao(String resolucao){
        this.resolucao = resolucao;
    }
    
    public int getNumChips() {
        return numChips;
    }
    public void setNumChips(int numChips) {
        this.numChips = numChips;
    }
}
