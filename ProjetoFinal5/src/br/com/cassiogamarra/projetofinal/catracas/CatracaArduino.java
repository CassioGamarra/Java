package br.com.cassiogamarra.projetofinal.catracas;
import br.com.cassiogamarra.projetofinal.utilitarios.ControlePortaSerial;

public class CatracaArduino {
  private ControlePortaSerial arduino;

  public CatracaArduino(){
      arduino = new ControlePortaSerial("COM3",9600);//Windows - porta e taxa de transmissão
  }    
  
  public void comunicacaoArduino(int status) {        
      arduino.enviaDados(status);
      arduino.close();
  }
}