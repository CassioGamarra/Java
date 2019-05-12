
import javax.swing.JOptionPane;

public class Socio extends EntradaSaida{

    @Override
    public void entrada() {
        this.setSocio(true);
        this.setNumeroCartao(Integer.parseInt(JOptionPane.showInputDialog(null,
                "Número Cartão")));
        this.setConsumo(Float.parseFloat(JOptionPane.showInputDialog(null,
                "Consumo total:")));
        this.setDesconto(0.2*this.getConsumo());
    }

    @Override
    public double saida() {
        Calcular saida = new Calcular();
        double valorTotal;
        
        valorTotal = saida.calcular(this.getConsumo(), this.getDesconto());
        return valorTotal;
    }
    
}
