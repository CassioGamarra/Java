
public class Atuador {
   public boolean status = false;
   private String value;
   
   public Atuador(){
   
   }
   
   public Atuador(String value){
       this.status = true;
       this.value = value;
   }
   
   public void setPoint(String value){
       this.value = value;
   }
   
   public String getValue(){
       return value;
   }
}
