package model;
import controller.*;
import java.sql.*;

public class TelaDeLoginModel {
    public static void fazerLoginModel (String login, String senha) {
        try{
            Connection conexao =  MySQLConnector.conectar();
            String strSqlLogin = "select * from `db_senac`.`tbl_senac` where `email` = '" + login + "' and `senha` = '" + senha + "';";
            Statement stmSqlLogin = conexao.createStatement();
            ResultSet rstSqlLogin = stmSqlLogin.executeQuery(strSqlLogin);
            if (rstSqlLogin.next()) {
                TelaDeLoginController.abrirTelaDeMenu();
            } else {
                TelaDeLoginController.notificarUsuario("Login e/ou senha não encontrados! Por favor, verifique o texto novamente");
            }
            stmSqlLogin.close();   
        } catch (Exception e) { 
            TelaDeLoginController.notificarUsuario("Houve um problema e não será possível realizar o login agora. Por favor, teste novamente mais tarde.");
            System.err.println("Veja o erro:" + e); 
        } 
    }
    
}
 