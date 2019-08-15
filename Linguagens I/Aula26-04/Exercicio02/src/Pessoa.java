public class Pessoa {
    private String nome;
    private int idade;
    
    public Pessoa(){}
    
    public Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }
    
    public void exibirInformacoes(String endereco){
        System.out.println("Nome: "+nome+" Idade: "+idade+" Endereço: "+endereco);
    }
    public void exibirInformacoes(){
        System.out.println("Nome: "+nome+" Idade: "+idade);
    }
}
