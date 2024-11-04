package view;
import controller.*;

// Aqui importa as bibliotecas
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


// Aqui define a classe TelaDePesquisa que herderá do JFrame
public class TelaDePesquisaView extends JFrame
{
    // Aqui há 14 váriaveis que serão manipuladas no construtor 
    public static JLabel lblPesquisa;
    public static JTextField txtPesquisa;

    public static JLabel lblId;
    public static JTextField txtId;

    public static JLabel lblNome;
    public static JTextField txtNome;

    public static JLabel lblEmail;
    public static JTextField txtEmail;

    public static JButton btnPesquisar;
    public static JButton btnPrimeiro;
    public static JButton btnAnterior;
    public static JButton btnProximo;
    public static JButton btnUltimo;

    public static JButton btnHistorico;

    public static JLabel lblNotificacoes;

    public static int tamanhoInputs = 20;

    public static String txtUsuario = "";

    // Aqui define o construtor TelaDePesquisa()
    public TelaDePesquisaView()
    {
        super("Tela de Pesquisa");// Aqui define o título que aparecerá
        setLayout(new GridLayout(7, 1, 5, 5));// Aqui define as linhas. colunas, tamanho horizontal e vertical 

        JPanel linha_lblPesquisa = new JPanel(new GridLayout(1, 2)); // Declaração de váriavel
        /*JPanel = define a linha e coluna de cada variável*/

        lblPesquisa = new JLabel("Pesquisa:", SwingConstants.CENTER);
        linha_lblPesquisa.add(lblPesquisa);

        btnPesquisar = new JButton("🔎");
        btnPesquisar.setToolTipText("Pesquisar");
        linha_lblPesquisa.add(btnPesquisar);

        /*add sozinho = está adicionando ao construtor */
        add(linha_lblPesquisa);

      
 
        JPanel linha_inputPesquisa = new JPanel(new GridLayout(1, 2));


        txtPesquisa = new JTextField(tamanhoInputs);// Declaração de várivael 
        linha_inputPesquisa.add(txtPesquisa);// Aqui vai adicionar a linha_inputPesquisa
        

        add(linha_inputPesquisa);

        JPanel linha_id = new JPanel(new GridLayout(1, 2));

        lblId = new JLabel("Id:", SwingConstants.RIGHT);
        linha_id.add(lblId);// Aqui vai adicionar a linha_id ao lblId
        txtId = new JTextField(tamanhoInputs);
        txtId.setEnabled(false);
        linha_id.add(txtId);// Aqui vai adicionar a linha_id ao txtId

        add(linha_id);

        JPanel linha_nome = new JPanel(new GridLayout(1, 2));

        lblNome = new JLabel("Nome:", SwingConstants.RIGHT);
        linha_nome.add(lblNome);
        txtNome = new JTextField(tamanhoInputs);
        txtNome.setEditable(false);
        linha_nome.add(txtNome);// Aqui vai adicionar a linha_nome

        add(linha_nome);

        JPanel linha_email = new JPanel(new GridLayout(1, 2));

        lblEmail = new JLabel("Email:", SwingConstants.RIGHT);
        linha_email.add(lblEmail);// Aqui vai adicionar a linha_email
        txtEmail = new JTextField(10);
        txtEmail.setEditable(false);
        linha_email.add(txtEmail);// Aqui vai adicionar a linha_email

        add(linha_email);


        JPanel linha_botoes = new JPanel(new GridLayout(1, 4));

        
        btnPrimeiro = new JButton("<<");
        btnPrimeiro.setEnabled(false);

        linha_botoes.add(btnPrimeiro);// Aqui vai adicionar a linha_botoes

        btnAnterior = new JButton("<");
        btnAnterior.setEnabled(false);
        
        linha_botoes.add(btnAnterior);
        
        btnProximo = new JButton(">");
        btnProximo.setEnabled(false);
        
        linha_botoes.add(btnProximo);
        
        btnUltimo = new JButton(">>");
        btnUltimo.setEnabled(false);

        linha_botoes.add(btnUltimo);

        add(linha_botoes);

        JPanel linha_notificacoes = new JPanel(new GridLayout(1, 1));

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        linha_notificacoes.add(lblNotificacoes);

        add(linha_notificacoes);

        // Aqui define o método que adiciona o escutador da ação 
        btnPesquisar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                  
                    if (txtPesquisa.getText().trim().length() <= 0) {
                        lblNotificacoes.setText(setHtmlFormat("Por favor, digite algo e tente novamente."));
                        txtPesquisa.requestFocus();
                        return;
                    } else {
                        TelaDePesquisaController.pesquisar();
                    }

                }// Aqui fecha método actionPerformed

            }// Aqui fecha o objeto ActionListener

        );// Aqui fecha o parâmetro do método que adiciona o excutador da ação

        btnPrimeiro.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                  
                    if (ntfCampoVazio() == false) {
                        TelaDePesquisaController.primeiroRegistro();
                    }

                }// Aqui fecha método actionPerformed

            }// Aqui fecha o objeto ActionListener

        );
        
        btnAnterior.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                  
                    if (ntfCampoVazio() == false) {
                        TelaDePesquisaController.registroAnterior();
                    }

                }// Aqui fecha método actionPerformed

            }// Aqui fecha o objeto ActionListener

        );
        
        btnProximo.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (ntfCampoVazio() == false) {
                        TelaDePesquisaController.proximoRegistro();
                    }
                }
            }
        );

        btnUltimo.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (ntfCampoVazio() == false) {
                        TelaDePesquisaController.ultimoRegistro();
                    }
                }// Aqui fecha método actionPerformed
            }// Aqui fecha o objeto ActionListener
        );
        

        txtPesquisa.addKeyListener( //Escutador chave, iremos sobescrever, incluir no método KeyReleased que ja existe denro do objeto KeyAdapter
            new KeyAdapter() {//KeyAdapter = para receber eventos de teclado
                @Override
                public void keyReleased(KeyEvent e) { //KeyAdapter serve para quando o usuário soltar a tecla e então ocorre o evento
                    //Trim= remove os espaços, equals= vai comparar e length = contar os caracteres 
                    if (txtPesquisa.getText().trim().equals(txtUsuario) == false && txtPesquisa.getText().trim().length() > 0) {// Aqui define se o que o usuário pesquisar, vai compará como que já foi pesquisado e se for diferente e sem espaço e amior que zero, habilita o botão de pesquisar
                        if (e.getKeyCode() == 10) {//KeyCode serve para ver um número que corresponde à tecla pressionada no teclado
                            TelaDePesquisaController.pesquisar();
                        }
                        btnPesquisar.setEnabled(true);//Irá habilitar o botão se o que o usuário digito for diferente da pesquisa anterior
                        
                    }else{
                        btnPesquisar.setEnabled(false);// Se o que o usuário tenta pesquisar não concedir com o if, desabilita o botão de pesquisa e limpa os campos
                        if (e.getKeyCode() == 10) {
                            limparCampos("Digite algo para continuar.");                       
                        }
                    }// Aqui fecha o else

                }// Aqui fecha o método keyReleased

            }// Aqui fecha o objeto KeyAdapter
            
        );// Aqui fecha o método addKeyListener  

        setSize(250, 380);// Aqui define a width(largura) e height(altura)
        setVisible(true);// Aqui define a visibilidade, para aparecer a tela  
        txtPesquisa.requestFocus();  

    }// Aqui fecha o construtor TelaDePesquisa  

    public static boolean ntfCampoVazio() {
        if (txtPesquisa.getText().trim().length() <= 0) {// se o úsuario clicar em pesquisar sem ter escrito algo
            lblNotificacoes.setText(setHtmlFormat("Ops! Campo vazio.Por favor, digite algo e tente novamente."));
            txtPesquisa.requestFocus();// RequestFocus serve para conduzir o usuário a focar no campo de texto
            return true;
        } else {
            return false;
        }
    }

    public static void limparCampos(String notificacao) {// Aqui define o método para limpa os campos ápos ja ter realizado uma pesquisa
        btnPesquisar.setEnabled(false);
        txtId.setText("");
        txtNome.setText("");
        txtEmail.setText("");
        btnPrimeiro.setEnabled(false);
        btnAnterior.setEnabled(false);
        btnProximo.setEnabled(false);
        btnUltimo.setEnabled(false);
        if (notificacao.trim().length() > 0) {
            lblNotificacoes.setText(setHtmlFormat(notificacao));
        }
    }
    // Aqui define o método para deixa a escrita da notificação em html
    public static String setHtmlFormat(String strTexto) {
        return "<html><body>" + strTexto + "</body></html>";
    }// Aqui fecha o método setHtmlFormat

    public static TelaDePesquisaView appTelaDePesquisaView;

    // Aqui define o método executor main, de 1 parâmetro, argumento do tipo matriz de string, sem retorno, estatico, que sera importado
    //void = sem retorno ou retorno nulo
    public static void main(String[] args) {
        TelaDePesquisaView appTelaDePesquisaView = new TelaDePesquisaView();
        appTelaDePesquisaView.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }// Aqui fecha o método executor

    /*
     * ação de abrir
     */

}// Aqui fecha a classe TelaDePesqusa