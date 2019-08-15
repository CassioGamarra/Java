public  abstract class Cadastro {
    
    private String nome;
    private int ano;
    private float preco;
    private int regiao;
    private String rebobinado;

    public abstract void cadastrar();
    public abstract void exibir();
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    
    public void setAno(int ano){
        this.ano = ano;
    }
    public int getAno(){
        return ano;
    }
    
    public void setPreco(float preco){
        this.preco = preco;
    }
    public float getPreco(){
        return preco;
    }
    
    public void setRegiao(int regiao){
        this.regiao = regiao;
    }
    public int getRegiao(){
        return regiao;
    }
    
    public String getRebobinado() {
        return rebobinado;
    }
    public void setRebobinado(String rebobinado) {
        this.rebobinado = rebobinado;
    }
}
