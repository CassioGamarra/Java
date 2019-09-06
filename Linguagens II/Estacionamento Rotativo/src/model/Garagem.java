
package model;

/**
 *
 * @author cassio
 */
public class Garagem {
    
    public Garagem(){}
    
    private int vagas;
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getVagas() {
        return vagas;
    }
    
    public void setVagas(int vagas) {
        this.vagas = vagas;
    }
}
