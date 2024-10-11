package controller;
import model.*;
import view.*;

import javax.swing.*;



public class TelaDeRemoverController extends TelaDeRemoverView {
    public static void popularIds() {
        TelaDeRemoverModel.popularIdsModel();
        if (cbxId != null) {
            if (cbxId.getItemCount() > 0) {//getItemCoun = conta a quantidade de itens dentro no combobox
                cbxId.removeAllItems();
                DefaultComboBoxModel<String> newMod = new DefaultComboBoxModel<String>(ids);
                cbxId.setModel(newMod);
            }// Aqui fecha o if que confere se tem algum item no id, se tiver repopula
        }// Aqui fecha o if que verifica se o id é nulo, se não for vai pro próxino if 
    }  
    public static void removerId() {
        TelaDeRemoverModel.removerIdModel(cbxId.getSelectedItem().toString());
    }
    public static void limparCampos() {
        txtNome.setText("");
        txtEmail.setText("");
        cbxId.setSelectedIndex(0);
    }// Aqui fecha o método limparCampos

    public static void atualizarCampos(boolean notificar) {
        if (cbxId.getSelectedIndex() > 0) {
            TelaDeRemoverModel.atualizarCamposModel(cbxId.getSelectedItem().toString(), notificar);
        } else {
            if (notificar == true) {
                lblNotificacoes.setText("Selecione um id para continuar.");
                limparCampos();
            }
        }
    }
    public static void preencherCampos(String nome, String email) {
        txtNome.setText(nome);
        txtEmail.setText(email);
    }
    public static void enviarIds(String[] idsTemp) {
        ids =idsTemp;
    }
    public static void notificarUsuario(String txt) {
        lblNotificacoes.setText(setHtmlFormat(txt));
    }


    
    
}

