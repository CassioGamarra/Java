package classes;

public abstract class Pessoa {
    private String nome;
    protected String CPF;
    protected String telefone;
    protected String email;
    protected long codigo;
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getCPF(){
        return CPF;
    }
    public void setCPF(String CPF){
        this.CPF = CPF;
    }
    
    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    public long getCodigo(){
        return codigo;
    }
    public void setCodigo(long codigo){
        this.codigo = codigo;
    }
}
