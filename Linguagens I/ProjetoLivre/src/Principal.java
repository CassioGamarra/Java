import javax.swing.JOptionPane;

public class Principal {
    
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        Socio socio = new Socio();
        String informacoes = "";
        
        int entrada = JOptionPane.showConfirmDialog(null, "SÓCIO?", "LENDS CLUB",
                JOptionPane.YES_NO_CANCEL_OPTION);
        
        if(entrada == JOptionPane.YES_OPTION){
            socio.entrada();
            socio.saida();
            
            informacoes = "Número cartão: "+socio.getNumeroCartao()+
                    "\nConsumo: R$"+socio.getConsumo()+
                    "\nValor desconto: R$"+socio.getDesconto()+
                    "\nValor total: R$"+socio.saida();
        }
        else if(entrada == JOptionPane.NO_OPTION){
            cliente.entrada();
            cliente.saida();
            
            informacoes = "Número cartão: "+cliente.getNumeroCartao()+
                    "\nConsumo: R$"+cliente.getConsumo()+
                    "\nValor entrada: R$"+cliente.getValorEntrada()+
                    "\nValor total: R$"+cliente.saida();
        }
        else{
            JOptionPane.showMessageDialog(null, "Saindo do sistema");
        }
        JOptionPane.showMessageDialog(null, informacoes, "SAIDA",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
}
