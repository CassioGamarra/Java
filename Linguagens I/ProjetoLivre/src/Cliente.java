
import javax.swing.JOptionPane;

public class Cliente extends Frequentador{
    
    @Override
    public void entrada() {
        this.setSocio(false);
        this.setNumeroCartao(JOptionPane.showInputDialog(null,
                "Número Cartão"));
        this.setConsumo(Float.parseFloat(JOptionPane.showInputDialog(null,
                "Consumo total:")));
        this.setValorEntrada(15);
    }

    @Override
    public float saida() {
        Calcular saida = new Calcular();
        float valorTotal;
        valorTotal = saida.calcular(this.getConsumo()) + this.getValorEntrada();
        return valorTotal;
    }
}
