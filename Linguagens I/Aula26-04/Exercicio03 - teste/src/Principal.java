public class Principal {
    private Maca maca;
    private Uva uva;
    private Arquivo arquivo;
    
    public static void main(String[] args) {
        
        Maca maca = new Maca();
        Arquivo arquivo = new Arquivo();
        
        maca.setVariedade("redonda");
        maca.setQuantidade(15);
        
        arquivo.cadastrar(maca);
    }
}
