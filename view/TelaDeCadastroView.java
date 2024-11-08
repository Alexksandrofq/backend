// Aqui importa as biblitecas
package view;
import controller.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


// Aqui está definindo a classe TelaDeCadastro que está herdando do JFrame
public class TelaDeCadastroView extends JFrame
{   //Aqui está declarando as váriaveis 
    public static JLabel lblImagem;
    public static String nomeDoArquivo;

    public static JLabel lblNome;
    public static JTextField txtNome;

    public static JLabel lblEmail; 
    public static JTextField txtEmail;

    public static JLabel lblSenha;
    public static JPasswordField txtSenha;

    public static JLabel lblImg;

    public static JButton btnFoto;

    public static JButton btnCadastrar;

    public static JButton btnCarregar;
    public static JButton btnRemover;

    public static JLabel lblNotificacoes;

    public static GridBagLayout gbLayout;
    public static GridBagConstraints gbConstraints;

    // Aqui define o construtor TelaDeCadastro
    public TelaDeCadastroView() 
    { 
        super("Tela De Cadastro");// Aqui Declara o título da aba
        gbLayout = new GridBagLayout();
        setLayout(gbLayout);// Aqui define o layout, linhas, colunas
        gbConstraints = new GridBagConstraints();

        lblImagem = new JLabel("", SwingConstants.CENTER);
        lblImagem.setIcon(InterfaceController.imgPadrao);
        addComponent(lblImagem, 0, 0, 2, 2);

        lblNome = new JLabel("Nome:");
        addComponent(lblNome, 3, 0, 1, 1);

        txtNome = new JTextField(10);
        addComponent(txtNome, 3, 1, 1, 1);

        lblEmail = new JLabel("Email:");
        addComponent(lblEmail, 4, 0, 1, 1);

        txtEmail = new JTextField(10);
        addComponent(txtEmail, 4, 1, 1, 1);

        lblSenha = new JLabel("Senha:");
        addComponent(lblSenha, 5, 0, 1, 1);

        txtSenha = new JPasswordField(10);
        addComponent(txtSenha, 5, 1, 1, 1);

        btnCadastrar = new JButton("Cadastrar");
        addComponent(btnCadastrar, 6, 0, 2, 1);

        btnCarregar = new JButton("Carregar");
        addComponent(btnCarregar, 2, 0, 1, 1);

        btnRemover = new JButton("Remover");
        addComponent(btnRemover, 2, 1, 1, 1);

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        addComponent(lblNotificacoes, 7, 0, 2, 1);

        // Aqui define o método que adiciona o escutador da ação 
        btnCadastrar.addActionListener(
            new ActionListener() {
                @Override
                // Aqui define o método actionPerformed, nele foi definido as mensagens de notificações
                /**trim = remove os espaços em branco, setHtmlFormat = para deixa em formato html e quabra a mensagem, length = contador de caracteres*/
                public void actionPerformed(ActionEvent event) {
                    if (txtNome.getText().trim().length() <= 0) {
                        lblNotificacoes.setText(setHtmlFormat("É necessário digitar um Nome para o cadastro. Por favor, digite um nome e tente novamente."));
                        txtNome.requestFocus();
                        return;
                    }
                    if (txtEmail.getText().trim().length() <= 0) {
                        lblNotificacoes.setText(setHtmlFormat("É necessário digitar um Email para o cadastro. Por favor, digite um Email e tente novamente."));
                        txtEmail.requestFocus();
                        return;
                    }
                    // Aqui está transformando a senha em uma string, utilizando o valueOf
                    if (String.valueOf(txtSenha.getPassword()).trim().length() <= 0) {
                        lblNotificacoes.setText(setHtmlFormat("É necessário digitar uma Senha para o cadastro. Por favor, digite uma Senha e tente novamente."));
                        txtSenha.requestFocus();// Aqui Força o condutor do teclado 
                        return;
                    }
                    lblNotificacoes.setText(TelaDeCadastroController.cadastrarController(txtNome.getText(), txtEmail.getText(), String.valueOf(txtSenha.getPassword())));
                    //...Aqui deverá ser chamado o método da controller de cadastro

                }// Aqui fecha o método actionPerformed

            }// Aqui fecha o novo objeto ActionListener

        );// Aqui fecha o parâmetro do addActionListener

        btnCarregar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeCadastroController.carregarImagem();
                }
            }
        );

        btnRemover.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeCadastroController.removerImagem();
                }
            }
        );
        
        // Aqui define a width(largura) height(altura) e visibilidade 
        setSize(220, 280);
        setVisible(true);

    }// Aqui fecha o construtor TelaDeCadastro
    public void addComponent(Component component, int row, int column, int width, int height) {
        try {
            if (height > 1 && height > 1) {
                gbConstraints.fill = GridBagConstraints.BOTH;
            } else if (height > 1) {
                gbConstraints.fill = GridBagConstraints.VERTICAL;
            } else {
                gbConstraints.fill = GridBagConstraints.HORIZONTAL;
            }

            gbConstraints.gridy = row;
            gbConstraints.gridx = column;
            gbConstraints.gridwidth = width;
            gbConstraints.gridheight = height;
            gbLayout.setConstraints(component, gbConstraints);
            add(component);
        } catch (Exception e) {
            System.err.println("Erro: " + e);
        }
    }
    public static void notificarUsuario(String txt) {
        lblNotificacoes.setText(setHtmlFormat(txt));
    }

    // Aqui Define o método html
    private static String setHtmlFormat(String strTexto) {
        return "<html><body>" + strTexto + "</body></html>";
    }// Aqui fecha o método html

    public static TelaDeCadastroView appTelaDeCadastroView;

    // Aqui está definindo o método executor main, com 1 parâmentro, tipo argumento de matriz string, sem retorno, estático e será importado 
    public static void main(String[] args) {
        appTelaDeCadastroView = new TelaDeCadastroView();// Declaração de variável 
        appTelaDeCadastroView.setDefaultCloseOperation(EXIT_ON_CLOSE);// Aqui Define o fechamento padrão, sair ao fechar 

        appTelaDeCadastroView.getRootPane().addComponentListener(
            new ComponentAdapter() {
                public void componentResized(ComponentEvent e) {
                    int larguraTela = appTelaDeCadastroView.getWidth();
                    int alturaTela = appTelaDeCadastroView.getHeight();
                    notificarUsuario(String.format("Largura: %s, Altura: %s", larguraTela, alturaTela));
                }
            }
        );
    }// Aqui fecha o método executor

}// Aqui fecha a classe TelaDeCadastro
