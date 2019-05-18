package br.com.cassiogamarra.projetofinal.database;

/**
 * Classe com os parâmetros para conectar ao banco de dados
 * @author Gnomo
 */
public class Database {
    private String url;
    private int porta;
    private String nome;
    private String usuario;
    private char[] senha;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public char[] getSenha() {
        return senha;
    }

    public void setSenha(char[] senha) {
        this.senha = senha;
    }
}
