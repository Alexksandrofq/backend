package controller;

import view.*;

import java.awt.event.*;
import model.*;

public class TelaDeMenuController extends TelaDeMenuView {
    public static void abrirTelaDeCadastroView() {
        TelaDeCadastroView.appTelaDeCadastroView = new TelaDeCadastroView();
        TelaDeCadastroView.appTelaDeCadastroView.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        InterfaceView.definirIcone(TelaDeCadastroView.appTelaDeCadastroView);

        appTelaDeMenuView.setVisible(false);//Desabilita a visibilidade da tela menu, então ela some ao abrir a tela de cadastro

        TelaDeCadastroView.appTelaDeCadastroView.addWindowListener(
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    appTelaDeMenuView.setVisible(true);//Habilita a tela de menu, ela volta ao fecha a tela de cadastro
                }
            }
        );
    }

    public static void abrirTelaDePesquisaView() {
        TelaDePesquisaView.appTelaDePesquisaView = new TelaDePesquisaView();
        TelaDePesquisaView.appTelaDePesquisaView.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        InterfaceView.definirIcone(TelaDePesquisaView.appTelaDePesquisaView);

        appTelaDeMenuView.setVisible(false);//Desabilita a visibilidade da tela menu, então ela some ao abrir a tela de pesquisa

        TelaDePesquisaView.appTelaDePesquisaView.addWindowListener(
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    appTelaDeMenuView.setVisible(true);//Habilita a tela de menu, ela volta ao fecha a tela de pesquisa
                }
            }
        );
    }

    public static void abrirTelaDeAtualizacaoView() {
        TelaDeAtualizacaoView.appTelaDeAtualizacaoView = new TelaDeAtualizacaoView();
        TelaDeAtualizacaoView.appTelaDeAtualizacaoView.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        InterfaceView.definirIcone(TelaDeAtualizacaoView.appTelaDeAtualizacaoView);

        appTelaDeMenuView.setVisible(false);//Desabilita a visibilidade da tela menu, então ela some ao abrir a tela de atualização

        TelaDeAtualizacaoView.appTelaDeAtualizacaoView.addWindowListener(
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    appTelaDeMenuView.setVisible(true);//Habilita a tela de menu, ela volta ao fecha a tela de atualização
                }
            }
        );
    }

    public static void abrirTelaDeRemoverView() {
        TelaDeRemoverView.appTelaDeRemoverView = new TelaDeRemoverView();
        TelaDeRemoverView.appTelaDeRemoverView.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        InterfaceView.definirIcone(TelaDeRemoverView.appTelaDeRemoverView);

        appTelaDeMenuView.setVisible(false);//Desabilita a visibilidade da tela menu, então ela some ao abrir a tela de remover

        TelaDeRemoverView.appTelaDeRemoverView.addWindowListener(
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    appTelaDeMenuView.setVisible(true);//Habilita a tela de menu, ela volta ao fecha a tela de Remover
                }
            }
        );
    }
    
}

