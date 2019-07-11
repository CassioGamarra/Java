package gerenciadordecatracas.gerenciamento;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe com métodos relacionados com o histórico
 * @author CassioGamarra
 */
public class Historico {
    Conexao conexao = new Conexao();
    Utilitario utilitario = new Utilitario();
    
    //Método que retorna os usuários ativos
    public String ativos(){
        String usuariosAtivos = "";
        String sql = "SELECT * FROM usuario WHERE situacao = 1";
        try{
            PreparedStatement stmt = conexao.conectar().prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            while(consulta.next()){
                String nome = consulta.getString("nome");
                String codigo = consulta.getString("codigo");
                if(usuariosAtivos.equals("")){
                    usuariosAtivos = "Código: "+codigo+
                            " |  Nome: "+nome+"\n";
                }
                else{
                    usuariosAtivos = usuariosAtivos + "\nCódigo: "+codigo+
                            " |  Nome: "+nome+"\n";
                }
            }
            if(usuariosAtivos.equals("")){
                return "SEM USUÁRIOS ATIVOS";
            }
            else{
                return usuariosAtivos;
            }
        }
        catch(SQLException e){
           utilitario.erroTabela();
           return usuariosAtivos;
        }
    }
    
    //Método que retorna o histórico de excluidos
    public String excluidos(){
        String usuariosExcluidos = "";
        String sql = "SELECT * FROM usuario WHERE situacao = 0";
        try{
            PreparedStatement stmt = conexao.conectar().prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            while(consulta.next()){
                String nome = consulta.getString("nome");
                String codigo = consulta.getString("codigo");
                if(usuariosExcluidos.equals("")){
                    usuariosExcluidos = "Código: "+codigo+
                            " |  Nome: "+nome+"\n";
                }
                else{
                    usuariosExcluidos = usuariosExcluidos + "\nCódigo: "+codigo+
                            " |  Nome: "+nome+"\n";
                } 
            }
            if(usuariosExcluidos.equals("")){
                return "SEM HISTÓRICO";
            }
            else{
                return usuariosExcluidos;
            }
        }
        catch(SQLException e){
            utilitario.erroTabela();
            return usuariosExcluidos;
        }
    }
    
    //Método que retorna o histórico de entrada
    public String historicoEntrada(){
        String historicoEntrada = "";
        String sql = "SELECT usuario.nome, catraca.codigo, catraca.dataHora "
                + "FROM usuario, catraca "
                + "WHERE usuario.codigo = catraca.codigo "
                + "AND catraca.situacao = 1";
        
        try {
            PreparedStatement stmt = conexao.conectar().prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            while(consulta.next()){
                String nome = consulta.getString("nome");
                String codigo = consulta.getString("codigo");
                String dataHora = consulta.getString("dataHora");
                if(historicoEntrada.equals("")){
                    historicoEntrada = "Código: "+codigo+" |  Nome: "+nome+
                            " | "+dataHora+"\n";
                }
                else{
                    historicoEntrada = historicoEntrada+"Código: "+codigo+
                            " |  Nome: "+nome+" | "+dataHora+"\n";
                }
            }
            if(historicoEntrada.equals("")){
                return "SEM HISTÓRICO";
            }
            else{
                return historicoEntrada;
            }
        } 
        catch (SQLException e) {
            utilitario.erroTabela();
            return historicoEntrada;
        }
    }
    
    //Método que retorna o histórico de saída
    public String historicoSaida(){
        String historicoSaida = "";
        String sql = "SELECT usuario.nome, catraca.codigo, catraca.dataHora "
                + "FROM usuario, catraca "
                + "WHERE usuario.codigo = catraca.codigo "
                + "AND catraca.situacao = 0";
        
        try {
            PreparedStatement stmt = conexao.conectar().prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            while(consulta.next()){
                String nome = consulta.getString("nome");
                String codigo = consulta.getString("codigo");
                String dataHora = consulta.getString("dataHora");
                if(historicoSaida.equals("")){
                    historicoSaida = "Código: "+codigo+" |  Nome: "+nome+
                            " | "+dataHora+"\n";
                }
                else{
                    historicoSaida = historicoSaida+"Código: "+codigo+
                            " |  Nome: "+nome+" | "+dataHora+"\n";
                }
            }
            if(historicoSaida.equals("")){
                return "SEM HISTÓRICO";
            }
            else{
                return historicoSaida;
            }
        } 
        catch (SQLException e) {
            utilitario.erroTabela();
            return historicoSaida;
        }
    }
}
