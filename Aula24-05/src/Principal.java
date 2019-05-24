public class Principal {

    public static void main(String[] args) {
        
        ClasseB classeB = new ClasseB();
        
        classeB.atributo1 = "Atributo 1";
        classeB.setAtributoB("Atributo B");
        
        System.out.println(classeB.atributo1);
        System.out.println(classeB.getAtributoB());
        System.out.println(classeB.metodo2(15));
    }    
}
