public class Smartphone implements PDA, Celular {
    
    public static void main(String[] args) {
        Smartphone s = new Smartphone();
        
        s.verificarEmail();
        s.realizarChamada();
    }
    public void verificarEmail(){
        System.out.println("Verificando...");
    }
    public void realizarChamada(){
        System.out.println("Discando...");
    }
    
    
}
