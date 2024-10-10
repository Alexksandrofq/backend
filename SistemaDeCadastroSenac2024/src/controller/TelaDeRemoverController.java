package controller;
import model.*;
import view.*;

import java.sql.*;
import java.util.*;
import javax.swing.*;

public class TelaDeRemoverController extends TelaDeRemoverView {
    public static void popularIds() {
    // try =  tentar
    // Statement = declaração 
        try {
            ArrayList<String> idsTemp = new ArrayList<>();
            idsTemp.add("Selecione aqui o id");
            Connection conexao = MySQLConnector.conectar();
            String strSqlPopularIds = "select * from `db_senac`.`tbl_senac` order by `id` asc;";
            Statement stmSqlPopularIds = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//TYPE_SCROLL_INSENSITIVE= para rolar pro lado ; CONCUR_READ_ONLY= que não pode ser habilitado
            ResultSet rstSqlPopularIds = stmSqlPopularIds.executeQuery(strSqlPopularIds);
            while (rstSqlPopularIds.next()) {
                idsTemp.add(rstSqlPopularIds.getString("id"));
            }
            ids = idsTemp.toArray(new String[0]);
            stmSqlPopularIds.close();     
            if (cbxId != null) {
                if (cbxId.getItemCount() > 0) {//getItemCoun = conta a quantidade de itens dentro no combobox
                    cbxId.removeAllItems();
                    DefaultComboBoxModel<String> newMod = new DefaultComboBoxModel<String>(ids);
                    cbxId.setModel(newMod);

                }// Aqui fecha o if que confere se tem algum item no id, se tiver repopula

            }// Aqui fecha o if que verifica se o id é nulo, se não for vai pro próxino if    
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar os ids! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }// Aqui fecha o método popularIds

    public static void removerId() {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlRemoverId = "delete from `db_senac`.`tbl_senac` where `id` = " + cbxId.getSelectedItem().toString() + ";";
            System.out.println(strSqlRemoverId);
            Statement stmSqlRemoverId = conexao.createStatement();
            stmSqlRemoverId.addBatch(strSqlRemoverId);
            stmSqlRemoverId.executeBatch();
            stmSqlRemoverId.close();
            lblNotificacoes.setText("O id " + cbxId.getSelectedItem().toString() + " foi removido com sucesso!");
            limparCampos();
            popularIds();

        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível remover o id! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }
    }// Aqui fecha o método removerid
    public static void limparCampos() {
        txtNome.setText("");
        txtEmail.setText("");
        cbxId.setSelectedIndex(0);
    }// Aqui fecha o método limparCampos

    public static void atualizarCampos(boolean notificar) {
        try {
            if (cbxId.getSelectedIndex() > 0) {
                Connection conexao = MySQLConnector.conectar();
                String strSqlAtualizarCampos = "select * from `db_senac`.`tbl_senac` where `id` = " + cbxId.getSelectedItem().toString() + ";";
                Statement stmSqlAtualizarCampos = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//TYPE_SCROLL_INSENSITIVE= para rolar pro lado ; CONCUR_READ_ONLY= que não pode ser habilitado
                ResultSet rstSqlAtualizarCampos = stmSqlAtualizarCampos.executeQuery(strSqlAtualizarCampos);
                if (rstSqlAtualizarCampos.next()) {
                    txtNome.setText(rstSqlAtualizarCampos.getString("nome"));
                    txtEmail.setText(rstSqlAtualizarCampos.getString("email"));
                    if (notificar == true) {
                        lblNotificacoes.setText("Campos atualizados com sucesso!");
                    }
                       
                } else {
                    if (notificar == true) {
                        lblNotificacoes.setText("Ops! Não foi encontrado o id selecionado. Por favor, verifique e tente novamente.");
                    }
                    
                }
                stmSqlAtualizarCampos.close();
            } else {
                if (notificar == true) {
                    lblNotificacoes.setText("Selecione um id para continuar.");
                    limparCampos();
                }               
            }
                
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar os ids! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e);
        }

    }// Aqui fecha o método atualizarCampos
    
}

