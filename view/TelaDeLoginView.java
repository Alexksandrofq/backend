package view;
import controller.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



// Aqui está definindo a classe TelaDeLogin que está herdando do JFrame
public class TelaDeLoginView extends JFrame 
{

// Aqui está definindo as variáveis que serão manipuladas no construtor 
    private final JLabel lblLogin;
    public final JTextField txtLogin;

    private final JLabel lblSenha;
    public final JPasswordField txtSenha;

    private final JButton btnEntrar;

    public static JLabel lblNotificacoes;

// Aqui está definindo o construtor e dentro dele as variáveis
    public TelaDeLoginView() 
{
    
    super("Tela de Login"); // Aqui está definindo o título que aparecerá em cima 
    setLayout(new FlowLayout()); // Aqui para definir o layout, que será responsivo, por causa do flow

    lblLogin = new JLabel("Login:"); // Declaração de váriavel, Login
    add(lblLogin);

    txtLogin = new JTextField(10); // Declaração de váriavel, está definindo o tamanho da coluna
    add(txtLogin);

    lblSenha = new JLabel("Senha:"); // Declaração de váriavel, senha
    add(lblSenha);

    txtSenha = new JPasswordField(10); // Declaração de váriavel, está definindo o tamanho da coluna
    add(txtSenha);

    btnEntrar = new JButton("Entrar"); // Declaração de váriavel, button
    add(btnEntrar);


    add(new JLabel(" "));
    lblNotificacoes = new JLabel("Notifiações"); // Declaração de váriavel notifacacoes
    add(lblNotificacoes);

    btnEntrar.addActionListener(//Ação de clicar no botão entrar
        // Aqui está definindo o novo objeto 
        new ActionListener() {
            @Override    
            // Aqui está definido o método actionPerformed     
            public void actionPerformed(ActionEvent event) {
                if (validarCampos() == true)
                TelaDeLoginController.fazerLoginController(txtLogin.getText(), String.valueOf(txtSenha.getPassword()));
            }
        }
    );//Aqui fecha a ação btnEntrar.addActionListener

    btnEntrar.addKeyListener(//Quando o botão entrar estiver focado, a ação de clicar no teclado 
        // Aqui está definindo qual decla = key, o usuario vai usar
        new KeyAdapter() {
            @Override      
            public void keyReleased(KeyEvent event) {//Released: ao soltar
                if (event.getKeyCode() == 10 && validarCampos() == true) {
                    TelaDeLoginController.fazerLoginController(txtLogin.getText(), String.valueOf(txtSenha.getPassword()));
                }
            }           
        } 
    );

    txtSenha.addKeyListener(
        new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent event) {
                if (event.getKeyCode() == 10 && validarCampos() == true) {
                    TelaDeLoginController.fazerLoginController(txtLogin.getText(), String.valueOf(txtSenha.getPassword()));
                }
            }
        }
    );

    txtLogin.addKeyListener(
        new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent event) {
                if (event.getKeyCode() == 10 && validarCampos() == true) {
                    TelaDeLoginController.fazerLoginController(txtLogin.getText(), String.valueOf(txtSenha.getPassword()));
                }
            }
        }
    );


    // Aqui está definindo o tamanho e visibilidade
    //setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(162, 170); 
    setVisible(true);   
    
}


public boolean validarCampos() {
    if (txtLogin.getText().trim().length() == 0) {
        TelaDeLoginController.notificarUsuario("Ops! É necessário digitar um login válido para continuar. Por favor, digite um login e tecle: \"Enter\".");
        txtLogin.requestFocus();//requesfocus: Coloca o curso do teclado piscando no campo ,dando foco ao campo 
        return false;
    }
    if (String.valueOf(txtSenha.getPassword()).trim().length() == 0) {
        TelaDeLoginController.notificarUsuario("Ops! É necessário digitar uma senha válida para continuar. Por favor, digite uma senha e tecle: \"Enter\".");
        txtSenha.requestFocus();//requesfocus: Coloca o curso do teclado piscando no campo ,dando foco ao campo 
        return false;
    }
    return true;
}

    public static String setHtmlFormat(String txt) {
    return "<html><body>" + txt + "</body></html>";
    }

    public static TelaDeLoginView appTelaDeLoginView;

//Aqui está definindo o método executor main, de 1 parâmetro, argumento, do tipo matriz de String, sem retorno(void), que é tipo estático(static), que será exportado(public)
    public static void main(String[] args) {
        // Aqui está declarando a variável 
        appTelaDeLoginView = new TelaDeLoginView(); 
        // Aqui está definindo o modo padrão de fechamento, sair ao fechar 
        appTelaDeLoginView.setDefaultCloseOperation(EXIT_ON_CLOSE);
        InterfaceView.definirIcone(appTelaDeLoginView);
    }

}// Aqui fecha a classe


