package controller;
import model.*;
import view.*;

public class TelaDeCadastroController extends TelaDeCadastroView {
    public static String[] retornoUsuario = {
        "Email já cadastrado! Favor digita outro email e tente novamente." , //resposta 0
        "Não foi possível relizar o cadastro. por uma falha no servidor! Por favor, tente novamente mais tarde.", //resposta 1
        "Cadastro realizado com sucesso."//resposta 2
    }; 

    public static String cadastrarController(String nome, String email, String senha) {
        return retornoUsuario[TelaDeCadastroModel.cadastrarModel(nome, email, senha)];
    }

}
