package controller;
import model.*;
import view.*;
import java.sql.*;
import java.util.*;

public class TelaDeAtualizacaoController extends TelaDeAtualizacaoView {
    public static void popularIds() {
        TelaDeAtualizacaoModel.popularIdsModel();
    }

    public static void enviarIds(String [] idsView) {
        ids = idsView;
    }
   
    public static void atualizarId() {
        String atualizarNome = "";
        String atualizarEmail = "";
        String atualizarSenha = "";

        if (txtNome.getText().trim().equals(nomeAtual) == false) {
            atualizarNome = "`nome` = '" + txtNome.getText() + "'";
        }

        if (txtEmail.getText().trim().equals(emailAtual) == false) {
            if (atualizarNome.length() > 0) {
                atualizarEmail = " , ";
            }
            atualizarEmail += "`email` = '" + txtEmail.getText() + "'";
        }
        if (String.valueOf(txtSenha.getPassword()).trim().equals(senhaAtual) == false) {
            if (atualizarNome.length() > 0 || atualizarEmail.length() > 0) {
                atualizarSenha = " , ";
            }
            atualizarSenha += "`senha` = '" + String.valueOf(txtSenha.getPassword()) + "'";
        }
        if (atualizarNome.length() > 0 || atualizarEmail.length() > 0 || atualizarSenha.length() > 0) {
        } else {
            lblNotificacoes.setText("Não foram encontradas alterações para atualizar o id " + cbxId.getSelectedItem().toString());
        }
       
        
    }
    public static void limparCampos() {
        txtNome.setText("");
        txtEmail.setText("");
        txtSenha.setText("");
        cbxId.setSelectedIndex(0);
    }
    public static void atualizarCampos(String id) {
        if (cbxId.getSelectedIndex() > 0) {
            TelaDeAtualizacaoModel.atualizarCamposModel(String.valueOf(cbxId.getSelectedIndex()));
        } else {
            lblNotificacoes.setText("Selecione um id para continuar.");
            limparCampos();
        }      
    }

    public static void enviarCampos(String nome, String email, String senha) {
        txtNome.setText(nome);
        nomeAtual = txtNome.getText();
        txtEmail.setText(email);
        emailAtual = txtEmail.getText();
        txtSenha.setText(senha);
        senhaAtual = String.valueOf(txtSenha.getPassword());
    }
   
    public static void notificarUsuario(String txt) {
        lblNotificacoes.setText(setHtmlFormat(txt));
    }
    
    public static void registrarAtualizacao() {
        nomeAtual = txtNome.getText();
        emailAtual = txtEmail.getText();
        senhaAtual = String.valueOf(txtSenha.getPassword());
    }
    
}
