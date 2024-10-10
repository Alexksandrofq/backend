package model;
import java.sql.*;

import controller.*;

public class TelaDePesquisaModel {
    public static void pesquisarModel(String textoPesquisa) {
        // try =  tentar
        // catch = pegar
        // Statement = declaração   
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlPesquisa = "select * from `db_senac`.`tbl_senac` where `nome` like '%" + textoPesquisa + "%' or `email` like '%" + textoPesquisa + "%' order by `id` asc;";
            Statement stmSqlPesquisa = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//TYPE_SCROLL_INSENSITIVE= para rolar pro lado ; CONCUR_READ_ONLY= que não pode ser habilitado
            ResultSet rstSqlPesquisa = stmSqlPesquisa.executeQuery(strSqlPesquisa);
            
            if (rstSqlPesquisa.next()) {// Aqui a função vai começa se achar algo e vai ir pra frente
                rstSqlPesquisa.last();// Vai para o ùltimo
                int rowNumbers = rstSqlPesquisa.getRow(); //Pega a quantidade de linhas
                rstSqlPesquisa.first();// Volta para primeiro
               
                TelaDePesquisaController.notificarUsuario("Legal! Foi(Foram) encontrado(s)" + rowNumbers + "resultados.");

                TelaDePesquisaController.preencherCampos(rstSqlPesquisa.getString("id"), 
                rstSqlPesquisa.getString("nome"), 
                rstSqlPesquisa.getString("email") );
                TelaDePesquisaController.registrarPesquisa();

                TelaDePesquisaController.desabilitarPesquisar();
                if (rowNumbers > 1) {// Se a quantiodade de linhas forem maior que 1, irá habilitar os botôes
                    TelaDePesquisaController.habilitarAvancar();
                }
                stmSqlPesquisa.close();
            } else {
                TelaDePesquisaController.registrarPesquisa();
                TelaDePesquisaController.desabilitarPesquisar();
                
                TelaDePesquisaController.notificarUsuario("Poxa vida! Não foram encontrados resultados para: \"" + textoPesquisa + "\".");
                stmSqlPesquisa.close();
            }
            
        } catch (Exception e) {
            TelaDePesquisaController.notificarUsuario("Não foi possível prosseguir com a pesquisa! Por favor, verifique e tente novamente.");
            System.err.println("Erro: " + e);
        }
            
    }
    public static void primeiroRegistroModel(String textoPesquisa) {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlPesquisa = "select * from `db_senac`.`tbl_senac` where `nome` like '%" + textoPesquisa + "%' or `email` like '%" + textoPesquisa + "%' order by `id` asc;";
            Statement stmSqlPesquisa = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlPesquisa = stmSqlPesquisa.executeQuery(strSqlPesquisa);
            if (rstSqlPesquisa.next()) {
                TelaDePesquisaController.preencherCampos(rstSqlPesquisa.getString("id"),
                rstSqlPesquisa.getString("nome"),
                rstSqlPesquisa.getString("email")
                );

                TelaDePesquisaController.habilitarAvancar();
            } else {
                TelaDePesquisaController.notificarUsuario("Poxa vida! Não foram encontrados resultados para: \"" + textoPesquisa + "\".");
            }
            TelaDePesquisaController.registrarPesquisa();
            
            TelaDePesquisaController.desabilitarPesquisar();     

            stmSqlPesquisa.close(); 
        } catch (Exception e) {
            TelaDePesquisaController.notificarUsuario("Não foi possível prosseguir com a pesquisa! Por favor, verifique e tente novamente.");
            System.err.println("Erro: " + e);
        }
    }
    public static void registroAnteriorModel(String idAtual, String nomeAtual, String emailAtual, String textoPesquisa){
        try {
            TelaDePesquisaController.limparCamposController("Registro anterior posicionado com scuesso.");
            Connection conexao = MySQLConnector.conectar();
            String strSqlProximoRegistro = "select * from `db_senac`.`tbl_senac` where (`nome` like '%" + textoPesquisa + "%' or `email` like '%" + textoPesquisa + "%') and `id` < " + idAtual + " order by `id` desc;";
            Statement stmSqlProximoRegistro = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);
            if (rstSqlProximoRegistro.next()) {
                TelaDePesquisaController.preencherCampos(rstSqlProximoRegistro.getString("id"),
                rstSqlProximoRegistro.getString("nome"),
                rstSqlProximoRegistro.getString("email")
                );
                TelaDePesquisaController.habilitarTodos();
            } else {
                TelaDePesquisaController.preencherCampos(idAtual, nomeAtual, emailAtual);
                
                TelaDePesquisaController.habilitarAvancar();

                TelaDePesquisaController.notificarUsuario("Você chegou ao primeiro registro.");
            }
            stmSqlProximoRegistro.close();
        } catch (Exception e) {
            TelaDePesquisaController.notificarUsuario("Não foi possível encontrar o próximo registro! Por favor, verifique e tente novamente.");
            System.err.println("Erro: " + e);
        } 
    }
    public static void proximoRegistroModel(String idAtual, String nomeAtual, String emailAtual, String textoPesquisa) {
        try {
            TelaDePesquisaController.limparCamposController("Próximo registro posicionado com scuesso.");
            Connection conexao = MySQLConnector.conectar();
            String strSqlProximoRegistro = "select * from `db_senac`.`tbl_senac` where (`nome` like '%" + textoPesquisa + "%' or `email` like '%" + textoPesquisa + "%') and `id` > " + idAtual + " order by `id` asc;";
            Statement stmSqlProximoRegistro = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//TYPE_SCROLL_INSENSITIVE= para rolar pro lado ; CONCUR_READ_ONLY= que não pode ser habilitado
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);
            
            if (rstSqlProximoRegistro.next()) {
                TelaDePesquisaController.preencherCampos(rstSqlProximoRegistro.getString("id"), 
                rstSqlProximoRegistro.getString("nome"), 
                rstSqlProximoRegistro.getString("email"));
                TelaDePesquisaController.habilitarTodos();

            } else {
                TelaDePesquisaController.preencherCampos(idAtual, nomeAtual, emailAtual);

                TelaDePesquisaController.habilitarVoltar();

                TelaDePesquisaController.notificarUsuario("Você chegou ao último registro.");
              
            }
            stmSqlProximoRegistro.close();
        } catch (Exception e) {
            TelaDePesquisaController.notificarUsuario("Não foi possível encontrar o próximo registro! Por favor, verifique e tente novamente.");
            System.err.println("Erro: " + e);
            
        }
    }
    public static void ultimoRegistroModel(String idAtual, String nomeAtual, String emailAtual, String textoPesquisa) {
        try {
            TelaDePesquisaController.limparCamposController("");

            Connection conexao = MySQLConnector.conectar();
            String strSqlProximoRegistro = "select * from `db_senac`.`tbl_senac` where (`nome` like '%" + textoPesquisa + "%' or `email` like '%" + textoPesquisa + "%') and `id` > " + idAtual + " order by `id` desc;";
            Statement stmSqlProximoRegistro = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//TYPE_SCROLL_INSENSITIVE= para rolar pro lado ; CONCUR_READ_ONLY= que não pode ser habilitado
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro);
            
            if (rstSqlProximoRegistro.next()) {
                TelaDePesquisaController.preencherCampos(rstSqlProximoRegistro.getString("id"),
                rstSqlProximoRegistro.getString("nome"),
                rstSqlProximoRegistro.getString("email"));

                TelaDePesquisaController.habilitarVoltar();

                TelaDePesquisaController.notificarUsuario("Você chegou ao último registro.");

            } else {
                TelaDePesquisaController.preencherCampos(strSqlProximoRegistro, strSqlProximoRegistro, strSqlProximoRegistro);
        
                TelaDePesquisaController.habilitarVoltar();

                TelaDePesquisaController.notificarUsuario("Você chegou ao último registro.");

            }
            stmSqlProximoRegistro.close();
        } catch (Exception e) {
            TelaDePesquisaController.notificarUsuario("Não foi possível encontrar o último registro! Por favor, verifique e tente novamente.");
            System.err.println("Erro: " + e);
            
        }
    }

    
    
    
}
