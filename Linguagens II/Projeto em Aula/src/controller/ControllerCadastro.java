package controller;

import javax.swing.JOptionPane;
import model.Funcionario;
import model.ModelCadastro;
import view.ViewPrincipal;


/**
 * Classe com o controller do cadastro
 * @author cassio
 */
public class ControllerCadastro {
    public ControllerCadastro(){}
    
    ModelCadastro cadastro = new ModelCadastro();
    
    public void cadastrar(ViewPrincipal view){
        Funcionario func = new Funcionario();
        
        String nome, email, cargo;
        
        nome = view.getFieldNomeCadastro().getText();
        email = view.getFieldEmailCadastro().getText();
        cargo = view.getFieldCargoCadastro().getText();
        
        if(!isNome(nome)){
            System.out.println("ERRO NOME");
        }
        if(!isEmail(email)){
            System.out.println("ERRO EMAIL");
        }
        else{
            func.setNome(nome);
            func.setEmail(email);
            func.setCargo(cargo);
            if(cadastro.cadastrar(func)){
                JOptionPane.showMessageDialog(null, "CADASTRO REALIZADO COM SUCESSO!");
                view.getFieldNomeCadastro().setText("");
                view.getFieldEmailCadastro().setText("");
                view.getFieldCargoCadastro().setText("");
            }
            else{
                JOptionPane.showMessageDialog(null, "ERRO NO CADASTRO");
            }
        }
    }
    
    public void consultar(ViewPrincipal view, int idConsulta){
        //O id consulta verifica qual a consulta necessária:
        //1 - Apenas consulta
        //2 - Alteração
        //3 - Exclusão
        
        int id;
        String nome, email, cargo;
        String consulta;
        String tipoConsulta = "";
        
        if(idConsulta == 1){
            consulta = view.getFieldConsulta().getText();

            if(view.getRadioNome().isSelected()){
                tipoConsulta = "nome";
                if(!isNome(consulta)){
                    JOptionPane.showMessageDialog(null, "CONSULTA INVÁLIDA!");
                    return;
                }
            }
            if(view.getRadioEmail().isSelected()){
                tipoConsulta = "email";
                if(!isEmail(consulta)){
                    JOptionPane.showMessageDialog(null, "CONSULTA INVÁLIDA!");
                    return;
                }
            }
            if(view.getRadioCargo().isSelected()){
                tipoConsulta = "cargo";
            }
            Funcionario func;
            //Realizando a consulta
            func = cadastro.consultar(consulta, tipoConsulta);
            if(func != null && func.getId()!=0){
                id = func.getId();
                nome = func.getNome();
                email = func.getEmail();
                cargo = func.getCargo();
                view.getFieldIdConsulta().setText(String.valueOf(id));
                view.getFieldNomeConsulta().setText(nome);
                view.getFieldEmailConsulta().setText(email);
                view.getFieldCargoConsulta().setText(cargo);
            }
            else{
                JOptionPane.showMessageDialog(null, "NENHUM RESULTADO!");
            }
        }
        
        else if(idConsulta == 2){
            Funcionario func;
            consulta = view.getFieldConsultaAlteracao().getText();
            tipoConsulta = "email";
            //Realizando a consulta
            func = cadastro.consultar(consulta, tipoConsulta);
            if(func != null && func.getId()!=0){
                id = func.getId();
                nome = func.getNome();
                email = func.getEmail();
                cargo = func.getCargo();
                view.getFieldIdAlteracao().setText(String.valueOf(id));
                view.getFieldNomeAlteracao().setText(nome);
                view.getFieldEmailAlteracao().setText(email);
                view.getFieldCargoAlteracao().setText(cargo);
            }
            else{
                JOptionPane.showMessageDialog(null, "NENHUM RESULTADO!");
            }
        }
        
        else if(idConsulta == 3){
            Funcionario func;
            consulta = view.getFieldConsultaExcluir().getText();
            tipoConsulta = "email";
            //Realizando a consulta
            func = cadastro.consultar(consulta, tipoConsulta);
            if(func != null && func.getId()!=0){
                id = func.getId();
                nome = func.getNome();
                email = func.getEmail();
                cargo = func.getCargo();
                view.getFieldIdExcluir().setText(String.valueOf(id));
                view.getFieldNomeExcluir().setText(nome);
                view.getFieldEmailExcluir().setText(email);
                view.getFieldCargoExcluir().setText(cargo);
            }
            else{
                JOptionPane.showMessageDialog(null, "NENHUM RESULTADO!");
            }
        }
    }
    
    public void alterar(ViewPrincipal view){
        Funcionario func = new Funcionario();
        
        String nome, email, cargo;
        int id;
        id = Integer.parseInt(view.getFieldIdAlteracao().getText());
        nome = view.getFieldNomeAlteracao().getText();
        email = view.getFieldEmailAlteracao().getText();
        cargo = view.getFieldCargoAlteracao().getText();
        
        if(!isNome(nome)){
            System.out.println("ERRO NOME");
        }
        if(!isEmail(email)){
            System.out.println("ERRO EMAIL");
        }
        else{
            func.setId(id);
            func.setNome(nome);
            func.setEmail(email);
            func.setCargo(cargo);
            if(cadastro.alterar(func)){
                JOptionPane.showMessageDialog(null, "CADASTRO ALTERADO COM SUCESSO!");
                view.getFieldConsultaAlteracao().setText("");
                view.getFieldIdAlteracao().setText("");
                view.getFieldNomeAlteracao().setText("");
                view.getFieldEmailAlteracao().setText("");
                view.getFieldCargoAlteracao().setText("");
            }
            else{
                JOptionPane.showMessageDialog(null, "ERRO NA ALTERACAO");
            }
        }
    }
    
    public void excluir(ViewPrincipal view){
        Funcionario func = new Funcionario();
        int opcao;
        
        func.setId(Integer.parseInt(view.getFieldIdExcluir().getText()));
        opcao = JOptionPane.showConfirmDialog(null, "DESEJA EXCLUIR?");
        if(opcao == 0){
            cadastro.excluir(func);
            JOptionPane.showMessageDialog(null, "CADASTRO EXCLUIDO COM SUCESSO!");
            view.getFieldConsultaExcluir().setText("");
            view.getFieldIdExcluir().setText("");
            view.getFieldNomeExcluir().setText("");
            view.getFieldEmailExcluir().setText("");
            view.getFieldCargoExcluir().setText("");
                  
        }
        else if(opcao == 1){
            JOptionPane.showMessageDialog(null, "SEM ALTERAÇÕES!");
        }
        else{
            return;
        }
    }
    
    //Métodos de verificação, podem ser migrados para uma classe
    
    //Método para verificar se o nome é válido
    public boolean isNome(String nome){
        String valor = nome.toUpperCase();
        if(nome.length() < 3){
            return false;
        }
        else{
            String regex = "^[[ ]|\\p{L}*]+$";
            return valor.matches(regex);
        }
    }
    
    //Método para verificar se o email é válido
    public boolean isEmail(String email){
        String valor = email.toUpperCase();
        if(!valor.contains("@")){
            return false;
        }
        else{
            return true;
        }
    }
}
