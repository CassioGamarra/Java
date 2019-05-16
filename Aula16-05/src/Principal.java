
public class Principal {
    public String nome;
    public int idade;
    public String telefone;
    
    public static void main(String[] args) {
        
        Principal dados = new Principal();
        
        dados.nome = "cassio";
        dados.idade = 24;
        dados.telefone = "9 9149-7946";
        
        System.out.println("Nome: "+dados.nome);
        System.out.println("Idade: "+dados.idade);
        System.out.println("Telefone: "+dados.telefone);
        
    }
    
}
