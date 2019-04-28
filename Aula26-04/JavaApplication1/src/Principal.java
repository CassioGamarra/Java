/**
 *
 * @author Gamarra
 */
public class Principal {

    public static void main(String[] args) {
        Atuador atuador1 = new Atuador();
        atuador1.status = true;
        
        System.out.println("Status A1 = "+atuador1.status);
        atuador1.setPoint("ON");
        System.out.println("Value A1 = "+atuador1.getValue());
        
        Atuador atuador2 = new Atuador("on");
        
        System.out.println("Status A2 = "+atuador2.status);
        System.out.println("Value A2 = "+atuador2.getValue());
    }
    
}
