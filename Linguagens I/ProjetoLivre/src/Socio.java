
import javax.swing.JOptionPane;

public class Socio extends Frequentador{

    @Override
    public void entrada() {
        this.setSocio(true);
        this.setNumeroCartao(JOptionPane.showInputDialog(null,
                "Número Cartão"));
        this.setConsumo(Float.parseFloat(JOptionPane.showInputDialog(null,
                "Consumo total:")));
        this.setDesconto((float)(0.2*this.getConsumo()));
        
    }

    @Override
    public float saida() {
        Calcular saida = new Calcular();
        float valorTotal;
        
        valorTotal = saida.calcular(this.getConsumo(), this.getDesconto());
        return valorTotal;
    }
    
}
