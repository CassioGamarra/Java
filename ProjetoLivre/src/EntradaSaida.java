public abstract class EntradaSaida {
    private boolean socio;
    private double desconto;
    private int numeroCartao;
    private float consumo;
    private float valorEntrada;

    public abstract void entrada();
    public abstract double saida();
    
    public void setSocio(boolean socio){
        this.socio = socio;
    }
    public boolean getSocio(){
        return socio;
    }
    
    public void setDesconto(double desconto){
        this.desconto = desconto;
    }
    public double getDesconto(){
        return desconto;
    }
    
    public void setNumeroCartao(int numeroCartao){
        this.numeroCartao = numeroCartao;
    }
    public int getNumeroCartao(){
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
