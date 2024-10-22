package controller;
import model.*;
import view.*;


public class TelaDeLoginController extends TelaDeLoginView {
    public static void fazerLoginController(String login, String senha) {
        TelaDeLoginModel.fazerLoginModel(login, senha);

    }
    public static void notificarUsuario(String txt) {
        lblNotificacoes.setText(setHtmlFormat(txt));
    }
}