package Model;

/** 
 * Classe modelo do objeto jogo
 * @author Cássio Gamarra
 */
public class Jogo {
    private int id;
    private String descricao;
    private String classificacao;
    private float valorAluguel;
    private int status;
    
    public Jogo(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public float getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(float valor_aluguel) {
        this.valorAluguel = valor_aluguel;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }    
}
