/**
 *
 * @author Gamarra
 */
public class Principal {

    public static void main(String[] args) {
        Sensor sensor = new Sensor();
        
        sensor.modelo = "Termo03-51";
        sensor.fabricante = "US Robotics";
        
        System.out.println("Modelo: "+sensor.modelo);
        sensor.exibirFabricante();
    }
    
}
