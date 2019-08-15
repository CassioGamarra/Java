public abstract class Frequentador {
    private boolean socio;
    private float desconto;
    private String numeroCartao;
    private float consumo;
    private float valorEntrada;

    public abstract void entrada();
    public abstract float saida();
    
    public void setSocio(boolean socio){
        this.socio = socio;
    }
    public boolean getSocio(){
        return socio;
    }
    
    public void setDesconto(float desconto){
        this.desconto = desconto;
    }
    public float getDesconto(){
        return desconto;
    }
    
    public void setNumeroCartao(String numeroCartao){
        this.numeroCartao = numeroCartao;
    }
    public String getNumeroCartao(){
        return numeroCartao;
    }
    
    public void setConsumo(float consumo){
        this.consumo = consumo;
    }
    public float getConsumo(){
        return consumo;
    }
    
    public float getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(float valorEntrada) {
        this.valorEntrada = valorEntrada;
    }
}
