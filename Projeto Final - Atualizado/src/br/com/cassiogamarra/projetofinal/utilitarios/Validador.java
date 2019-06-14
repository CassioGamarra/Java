package br.com.cassiogamarra.projetofinal.utilitarios;

import br.com.cassiogamarra.projetofinal.cadastro.Gerenciamento;
import br.com.cassiogamarra.projetofinal.classes.*;
import br.com.cassiogamarra.projetofinal.database.BancoDeDados;
import br.com.cassiogamarra.projetofinal.gui.FramePessoas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gnomo
 */
public class Validador{
    
    public Validador(){}
    
    BancoDeDados bd = new BancoDeDados();

    //Método para validar o CPF
    public boolean isCPF(String CPF){
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
           (CPF.length() != 11))
            return false;
        char dig10, dig11;
        int sm, i, r, num, peso;
        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {              
        // converte o i-esimo caractere do CPF em um numero:
        // por exemplo, transforma o caractere '0' no inteiro 0         
        // (48 eh a posicao de '0' na tabela ASCII)         
            num = (int)(CPF.charAt(i) - 48); 
            sm = sm + (num * peso);
            peso = peso - 1;
            }
          
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico
          
        // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }
          
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);
            
        // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return(true);
            else return(false);
        }
        catch (InputMismatchException erro) {
            return(false);
        }
    }
    //Método para validar o Código
    public boolean validarCodigo(String codigo){
        if((codigo.length()==6)&&(codigo.matches("[0-9]+"))){
            return true;
        }
        return false;
    }
    //Método para validar o Nome
    public boolean validarNome(String nome){
        String valor = nome.toUpperCase();
        if(nome.length() < 3){
            return false;
        }
        else{
            String regex = "^[[ ]|\\p{L}*]+$";
            return valor.matches(regex);
        }
    }
    //Método para validar o Telefone
    public boolean validarTelefone(String telefone){
        if(telefone.matches("(10)|([1-9][1-9])[9][2-9][0-9]{3}[0-9]{4}")||
                telefone.matches("(10)|([1-9][1-9])[2-9][0-9]{3}[0-9]{4}")){
            return true;
        }
        return false;
    }
    //Método para consultar a duplicidade de CPF
    public boolean consultarDuplicidade(String CPF){
        String sql = "SELECT cpf FROM usuario WHERE cpf = "+CPF;
        String cpfConsulta = "";
        try{
            PreparedStatement stmt = bd.conectar().prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            while(consulta.next()){
                cpfConsulta = consulta.getString("cpf");
            }
            return cpfConsulta.equals(CPF);
        }
        catch(SQLException e){
           throw new RuntimeException(e);
        }
    }
    //Método para verificar se o responsável possui dependentes
    public int verificarDependentes(long codigo) throws SQLException{
        String sql;
        int dependentes = 0;
        sql = "SELECT * FROM usuario WHERE situacao = 1 AND codigo = "+codigo;
        
        try{
            PreparedStatement stmt = bd.conectar().prepareStatement(sql);
            ResultSet consulta = stmt.executeQuery(sql);
            while(consulta.next()){
                String categoria = consulta.getString("categoria");
                if(categoria.equals("Responsável")){
                        String especial = consulta.getString("dependentes");
                        dependentes = Integer.parseInt(especial);
                }
            }
        }
        catch(SQLException e){
           throw new RuntimeException(e);
        }
        return dependentes;
    }
    //Método para validar o cadastro
    public void validarCadastro(FramePessoas frame){
        Pessoa pessoa = new Pessoa();
        
        String categoria = (String)frame.getComboBoxCategoria().getSelectedItem();
        String textoCategoria = frame.getCampoCategoria().getText();
        
        pessoa.setNome(frame.getCampoNome().getText());
        pessoa.setCPF(frame.getCampoCPF().getText());
        pessoa.setTelefone(frame.getCampoTelefone().getText());
        
        if(!validarNome(pessoa.getNome())){
            JOptionPane.showMessageDialog(null, "NOME INVÁLIDO");
        }
        else if(!isCPF(pessoa.getCPF())){
            JOptionPane.showMessageDialog(null, "CPF INVÁLIDO");
        }
        else if(!validarTelefone(pessoa.getTelefone())){
            JOptionPane.showMessageDialog(null, "TELEFONE INVÁLIDO");
        }
        else if((categoria.equals(""))||(textoCategoria.equals(""))){
            JOptionPane.showMessageDialog(null, "POR FAVOR, PREENCHA A CATEGORIA");
        }
        else if(consultarDuplicidade(pessoa.getCPF())){
            JOptionPane.showMessageDialog(null, "O CADASTRO JÁ EXISTE");
        }
        else{
            Gerenciamento cadastro = new Gerenciamento();
            cadastro.cadastrar(pessoa, categoria, textoCategoria);
            Frame.limparFrame(frame.getFrameCadastrar());
        }
    }
    //Método para verificar se é possível excluir
    public void verificarExclusao(FramePessoas frame){
        if(!validarCodigo(frame.getCampoConsultaExclusao().getText())){
            JOptionPane.showMessageDialog(null, "Consulta inválida!"
                    + "\nO código possui apenas 6 digitos numéricos");
            Frame.limparFrame(frame.getFrameExcluir());
        }
        else{
            long codigo = Long.parseLong(frame.getCampoConsultaExclusao().getText());
            try{
                if(bd.consultar(codigo).equals("")){
                    JOptionPane.showMessageDialog(null, "PESSOA NÃO ENCONTRADA");
                    Frame.limparFrame(frame.getFrameExcluir());
                }
                else{
                    frame.getTextoExclusao().setText(bd.consultar(codigo));
                    frame.getFrameExclusao().setVisible(true);
                }
            }
            catch (SQLException ex) {
                Logger.getLogger(FramePessoas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

