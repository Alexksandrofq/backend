package controller;
import model.*;
import view.*;
import java.awt.event.*;

public class TelaDeLoginController extends TelaDeLoginView {
    public static void fazerLoginController(String login, String senha) {
        TelaDeLoginModel.fazerLoginModel(login, senha);

    }
    public static void notificarUsuario(String txt) {
        lblNotificacoes.setText(setHtmlFormat(txt));
    }
    public static void abrirTelaDeMenu() {
        TelaDeMenuView.appTelaDeMenuView = new TelaDeMenuView();
        TelaDeMenuView.appTelaDeMenuView.setDefaultCloseOperation(EXIT_ON_CLOSE);

         // O método abaixo irá executar o método removerImagensInuteis() da classe InterfaceView, antes de fechar totalmente a tela de menu
        TelaDeMenuView.appTelaDeMenuView.addWindowListener(
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    InterfaceView.removerImagensInuteis();
                }
            }
        );
        InterfaceView.definirIcone(TelaDeMenuView.appTelaDeMenuView);

        appTelaDeLoginView.dispose();//dispose: serve para tirar da memoria a reterização da tela de login
    }

} 