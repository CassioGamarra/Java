package gerenciadordecatracas.gerenciamento;

import gerenciadordecatracas.gerenciamento.Conexao;
import gerenciadordecatracas.gui.MenuCatracas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CatracaVirtual implements ICatracas {
    
    Utilitario util = new Utilitario();

    //Entrada catraca virtual manual
    public String entradaCatracaVirtual(MenuCatracas frame){
        Verificador verificador = new Verificador();
        String mensagem =  "";
        
        if(!verificador.isCodigo(frame.getCampoConsultaEntrada().getText())){
            JOptionPane.showMessageDialog(null, "Código inválido!"
                    + "\nO código possui apenas 6 digitos numéricos");
        }
        else{
            long codigo = Long.parseLong(frame.getCampoConsultaEntrada().getText());
            mensagem = entrada(codigo);
            return mensagem;
        }
        return mensagem;
    }
    //Saída catraca virtual manual
    public String saidaCatracaVirtual(MenuCatracas frame){
        Verificador verificador = new Verificador();
        String mensagem =  "";
        
        if(!verificador.isCodigo(frame.getCampoConsultaSaida().getText())){
            JOptionPane.showMessageDialog(null, "Código inválido!"
                    + "\nO código possui apenas 6 digitos numéricos");
        }
        else{
            long codigo = Long.parseLong(frame.getCampoConsultaSaida().getText());
            mensagem = saida(codigo);
            return mensagem;
        }
        return mensagem;
    }
    //Catraca virtual automatica
    public String catracaVirtualAutomatica(MenuCatracas frame){
        Verificador verificador = new Verificador();
        Conexao conexao = new Conexao();
        String mensagem =  "";
        if(!verificador.isCodigo(frame.getCampoConsultaAuto().getText())){
            JOptionPane.showMessageDialog(null, "Código inválido!"
                    + "\nO código possui apenas 6 digitos numéricos");
        }
        else{
            long codigo = Long.parseLong(frame.getCampoConsultaAuto().getText());
            String sql = "SELECT situacao FROM catraca WHERE codigo = "+codigo;
            int status = 0;
            String horaAtual = util.dataHoraSistema();
            try {
                PreparedStatement stmt = conexao.conectar().prepareStatement(sql);
                ResultSet consulta = stmt.executeQuery(sql);
                while(consulta.next()){
                    status = Integer.parseInt(consulta.getString("situacao"));
                }
                //Se a pessoa ainda não entrou
                if(status == 0){
                    //Procura o nome da pessoa
                    sql = "SELECT * FROM usuario WHERE codigo = "+codigo;
                    String nome = "";
                    int situacao = 0;
                    stmt = conexao.conectar().prepareStatement(sql);
                    consulta = stmt.executeQuery(sql);
                    while(consulta.next()){
                        nome = consulta.getString("nome");
                        situacao = consulta.getInt("situacao");
                    }
                    if(situacao == 0){
                        JOptionPane.showMessageDialog(null, "PESSOA INATIVA!!!");
                        return mensagem;
                    }
                    else{
                        //Faz a entrada da pessoa
                        sql = "INSERT INTO catraca(codigo, dataHora ,situacao)VALUES(?,?,?)";
                        stmt = conexao.conectar().prepareStatement(sql);
                        stmt.setLong(1, codigo);
                        stmt.setString(2, horaAtual);
                        stmt.setInt(3, 1);
                        stmt.execute();
                        mensagem = "BEM VINDO(A): "+nome+"\nEntrada: "+horaAtual;
                        return mensagem;
                    }
                }
                //Caso a pessoa ja tenha entrado
                else{
                    //Procura o nome da pessoa
                    sql = "SELECT usuario.*, catraca.dataHora FROM usuario,"
                            + "catraca WHERE usuario.codigo = "+codigo
                            +" AND catraca.situacao = 1";
                    String nome = "", dataEntrada = "";
                    int situacao = 0;
                    
                    stmt = conexao.conectar().prepareStatement(sql);
                    consulta = stmt.executeQuery(sql);
                    while(consulta.next()){
                        nome = consulta.getString("nome");
                        situacao = consulta.getInt("situacao");
                        dataEntrada = consulta.getString("dataHora");
                    }
                    if(situacao == 0){
                        JOptionPane.showMessageDialog(null, "PESSOA INATIVA!!!");
                        return mensagem;
                    }
                    else{
                        //Faz a saída da pessoa
                        sql = "INSERT INTO catraca(codigo, dataHora ,situacao)VALUES(?,?,?)";
                        stmt = conexao.conectar().prepareStatement(sql);
                        stmt.setLong(1, codigo);
                        stmt.setString(2, horaAtual);
                        stmt.setInt(3, 0);
                        stmt.execute();
                        mensagem = "VOLTE SEMPRE: "+nome+"\nEntrada: "+dataEntrada+"\n"+"Saída: "+horaAtual;
                        return mensagem;
                    }
                }
            }
            catch (SQLException e) {
                util.erroTabela();
                throw new RuntimeException(e);
            }
            
        }
        return mensagem;
    }
    
    //métodos implementados
    @Override
    public String entrada(long codigo) {
        Conexao conexao = new Conexao();
        
        String textoEntrada = "";
        String sql = "SELECT situacao FROM catraca WHERE codigo = "+codigo;
        int status = 0;
        String horaAtual = util.dataHoraSistema();
        
        try {
            PreparedStatement stmt = conexao.conectar().prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            while(consulta.next()){
                status = Integer.parseInt(consulta.getString("situacao"));
            }
            //Verifica se não é uma entrada dupla
            if(status == 1){
                JOptionPane.showMessageDialog(null, "ENTRADA DUPLA!!!", "ERRO", JOptionPane.WARNING_MESSAGE);
                return textoEntrada;
            }
            else{
                //Procura o nome da pessoa
                sql = "SELECT * FROM usuario WHERE codigo = "+codigo;
                String nome = "";
                int situacao  = 0;
                stmt = conexao.conectar().prepareStatement(sql);
                consulta = stmt.executeQuery(sql);
                while(consulta.next()){
                    nome = consulta.getString("nome");
                    situacao = consulta.getInt("situacao");
                }
                //Verifica se a pessoa está ativa
                if(situacao == 0){
                    JOptionPane.showMessageDialog(null, "PESSOA INATIVA!!!");
                    return textoEntrada;
                }
                //Realiza a entrada da pessoa
                else{
                    sql = "INSERT INTO catraca(codigo, dataHora ,situacao)VALUES(?,?,?)";
                    stmt = conexao.conectar().prepareStatement(sql);
                    stmt.setLong(1, codigo);
                    stmt.setString(2, horaAtual);
                    stmt.setInt(3, 1);
                    stmt.execute();
                    textoEntrada = "BEM VINDO(A): "+nome+"\n"+"Entrada: "+horaAtual;
                    return textoEntrada;
                }
            }
        }
        catch (SQLException e) {
            util.erroTabela();
            throw new RuntimeException(e);
        }
        
    }

    @Override
    public String saida(long codigo) {
        Conexao conexao = new Conexao();
        
        String textoSaida = "";
        
        String sql = "SELECT situacao FROM catraca WHERE codigo = "+codigo;
        int status = 0;
        String horaAtual = util.dataHoraSistema();
        
        try {
            PreparedStatement stmt = conexao.conectar().prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            while(consulta.next()){
                status = Integer.parseInt(consulta.getString("situacao"));
            }
            
            //Procura o nome da pessoa
            sql = "SELECT usuario.*, catraca.dataHora FROM usuario,catraca "
                    + "WHERE usuario.codigo = "+codigo+" AND catraca.situacao = 1";
            String nome = "", dataEntrada = "";
            int situacao = 0;
            stmt = conexao.conectar().prepareStatement(sql);
            consulta = stmt.executeQuery(sql);
            while(consulta.next()){
                nome = consulta.getString("nome");
                situacao = consulta.getInt("situacao");
                dataEntrada = consulta.getString("dataHora");
            }
            //Se a pessoa já realizou uma saída e está ativa no sistema
            if(status == 0 && situacao == 1){
                JOptionPane.showMessageDialog(null, "SAÍDA DUPLA!!!", "ERRO", JOptionPane.WARNING_MESSAGE);
                return textoSaida;
            }
            //Se a pessoa já foi excluida e já entrou ou se apenas entrou
            else if((situacao == 0 && status == 1) || (status == 1)){
                //Faz a saída da pessoa
                sql = "INSERT INTO catraca(codigo, dataHora ,situacao)VALUES(?,?,?)";
                stmt = conexao.conectar().prepareStatement(sql);
                stmt.setLong(1, codigo);
                stmt.setString(2, horaAtual);
                stmt.setInt(3, 0);
                stmt.execute();
                
                textoSaida = "VOLTE SEMPRE: "+nome+"\n"
                        + "Entrada: "+dataEntrada+"\n"+"Saída: "+horaAtual;
                return textoSaida;
            }
            //Caso a pessoa esteja inativa no sistema
            else{
                JOptionPane.showMessageDialog(null, "PESSOA INATIVA!!!");
                return textoSaida;
            }
        }
        catch (SQLException e) {
            util.erroTabela();
            throw new RuntimeException(e);
        }
    }
}
