package controller;
import model.*;
import view.*;


public class TelaDePesquisaController extends TelaDePesquisaView {
    public static void notificarUsuario(String textoNotificacao) {
        lblNotificacoes.setText(setHtmlFormat(textoNotificacao));
    }

    public static void preencherCampos(String id, String nome, String email) {
        txtId.setText(id);
        txtNome.setText(nome);
        txtEmail.setText(email);//Define o texto com o que estiver definido no parâmetro
        registrarPesquisa();

    }
    public static void registrarPesquisa() {
        txtUsuario = txtPesquisa.getText();// Aqui irá pegar o que for digitado na pequisa e colocado na váriavel usuario

    }
    public static void pesquisar() {
        if (txtPesquisa.getText().trim().equals(txtUsuario) == false) {// Aqui o if vai compara o que o usuario pesquiso com o que ja havia pesquisado
            limparCampos("");
        }  
    }
   
    public static void primeiroRegistro() {
        limparCampos("Você está no primeiro registro.");
        TelaDePesquisaModel.primeiroRegistroModel(txtPesquisa.getText());
    }
    public static void registroAnterior() {
        limparCampos("Registro anterior posicionado com sucesso.");
        TelaDePesquisaModel.registroAnteriorModel(txtPesquisa.getText(), txtId.getText(), txtNome.getText(), txtEmail.getText());
        
        
    }
    public static void proximoRegistro() {
        limparCampos("Próximo registro posicionado com sucesso.");
        TelaDePesquisaModel.proximoRegistroModel(txtPesquisa.getText(), txtId.getText(), txtNome.getText(), txtEmail.getText());
    }
    public static void ultimoRegistro() {

        limparCampos("");
        TelaDePesquisaModel.ultimoRegistroModel(txtPesquisa.getText(), txtId.getText(), txtNome.getText(), txtEmail.getText());
        
    }
    public static void desabilitarTodos() {
        btnAnterior.setEnabled(false);
        btnPrimeiro.setEnabled(false);
        btnProximo.setEnabled(false);
        btnUltimo.setEnabled(false);
       
    }
    public static void habilitarTodos() {
        btnAnterior.setEnabled(true);
        btnPrimeiro.setEnabled(true);
        btnProximo.setEnabled(true);
        btnUltimo.setEnabled(true);
       
    }

    public static void habilitarVoltar() {
        desabilitarTodos();
        btnAnterior.setEnabled(true);
        btnPrimeiro.setEnabled(true);
    }
    public static void habilitarAvancar() {
        desabilitarTodos();
        btnProximo.setEnabled(true);
        btnUltimo.setEnabled(true);
    }
   public static void desabilitarPesquisar() {
    btnPesquisar.setEnabled(false);
   }
    
}   


