public class Principal {
   
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Cássio", 24);
        
        pessoa.exibirInformacoes();
        pessoa.exibirInformacoes("Av. Idependencia");
    }
}
