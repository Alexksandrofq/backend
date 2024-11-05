// Aqui importa as bibliotecas
package view;
import controller.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Aqui define a classe TelaDeAtualização que herderá do JFrame
public class TelaDeAtualizacaoView extends JFrame
{
    // Aqui há 16 váriaveis que serão manipuladas no construtor    
    public static JLabel lblId;
    public static JComboBox<String> cbxId;
    public static String[] ids;

    public static JLabel lblImagem;
    public static JButton btnCarregarImagem;
    public static JButton btnRemoverImagem;
    public static final JTextField txtImagem = new JTextField();

    public static JLabel lblNome;
    public static JTextField txtNome;
    public static String nomeAtual;

    public static JLabel lblEmail;
    public static JTextField txtEmail;
    public static String emailAtual;

    public static JLabel lblSenha;
    public static JPasswordField txtSenha;
    public static String senhaAtual;

    public static JLabel lblNotificacoes;

    public static JButton btnAtualizar;
    public static JButton btnCancelar;
    public static JButton btnApagarImg;

    public static int tamanhoInputs = 20;

    public static GridBagLayout gbLayout;
    public static GridBagConstraints gbConstraints;

    

    // Aqui define o construtor TelaDeAtualização()
    public TelaDeAtualizacaoView()
    {
        super("Tela de Atualização");// Aqui define o título que aparecerá
        gbLayout = new GridBagLayout();
        setLayout(gbLayout);// Aqui define o layout
        gbConstraints = new GridBagConstraints();

        lblId = new JLabel("Id:", SwingConstants.RIGHT);
        gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        addComponent(lblId, 0, 1,1,1);


        TelaDeAtualizacaoController.popularIds();
        cbxId = new JComboBox<String>(ids);
        gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        addComponent(cbxId, 0, 2,1,1);


        lblImagem = new JLabel(InterfaceController.imgPadrao);
        gbConstraints.fill = GridBagConstraints.BOTH;
        addComponent(lblImagem, 0, 0, 1,  7);


        btnCarregarImagem = new JButton("Carregar Imagem");
        gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        addComponent(btnCarregarImagem, 1, 1, 1, 1);


        btnRemoverImagem = new JButton("Remover Imagem");
        gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        addComponent(btnRemoverImagem, 5, 1, 1, 1);


        lblNome = new JLabel("Nome:", SwingConstants.RIGHT);
        gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        addComponent(lblNome, 2, 1, 1, 1);
     
        txtNome = new JTextField(tamanhoInputs);
        gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        addComponent(txtNome, 2,2,1,1);


        lblEmail = new JLabel("Email:", SwingConstants.RIGHT);
        gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        addComponent(lblEmail, 3, 1 ,1 ,1);

        txtEmail = new JTextField(tamanhoInputs);
        gbConstraints.fill = GridBagConstraints.HORIZONTAL;

        // add(linha_email);
        addComponent(txtEmail, 3, 2,1,1);


        lblSenha = new JLabel("Senha:", SwingConstants.RIGHT);
        gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        addComponent(lblSenha, 4, 1, 1, 1);

        txtSenha = new JPasswordField(tamanhoInputs);
        gbConstraints.fill = GridBagConstraints.HORIZONTAL;

        // add(linha_senha);
        addComponent(txtSenha, 4, 2,1,1);

        btnAtualizar = new JButton("Atualizar");
        gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        addComponent(btnAtualizar, 5, 1, 1, 1);

        btnCancelar = new JButton("Cancelar");
        gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        addComponent(btnCancelar, 5, 2, 1, 1);    

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        addComponent(lblNotificacoes, 6, 1, 2, 1);




        // Aqui define o método que adiciona o escutador da ação 
        btnAtualizar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeAtualizacaoController.atualizarId();

                }// Aqui fecha método actionPerformed

            }// Aqui fecha o objeto ActionListener

        );// Aqui fecha o parâmetro do método btnAtualizar que adiciona o excutador da ação

        btnCancelar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeAtualizacaoController.limparCampos();                                     
                }// Aqui fecha método actionPerformed

            }// Aqui fecha o objeto ActionListener

        );// Aqui fecha o parâmetro do método btnCancelar que adiciona o excutador da ação

        cbxId.addItemListener(
            new ItemListener() {
                @Override
                    public void itemStateChanged(ItemEvent event) {
                        if (event.getStateChange() == ItemEvent.SELECTED) {
                            TelaDeAtualizacaoController.atualizarCampos(cbxId.getSelectedItem().toString());
                        }// Aqui fecha o evento      

                    }// Aqui fecha método itemStateChangedd

            }// Aqui fecha o objeto ItemListener

        );// Aqui fecha o parâmetro do método cbxId que adiciona o excutador da ação

        btnCarregarImagem.addActionListener(
            new ActionListener() {
                @Override
                    public void actionPerformed(ActionEvent event) {        
                        TelaDeAtualizacaoController.carregarImagem();    
                    }// Aqui fecha método actionPerformedd

            }// Aqui fecha o objeto ActionListener

        );

        btnRemoverImagem.addActionListener(
            new ActionListener() {
                @Override
                    public void actionPerformed(ActionEvent event) {
                        TelaDeAtualizacaoController.RemoverImagem();   

                    }// Aqui fecha método itemStateChangedd

            }// Aqui fecha o objeto ItemListener

        );

        setSize(500, 300);// Aqui define a width(largura) e height(altura)        
        ImageIcon img = new ImageIcon("./senac-logo.png");// Aqui define a imagem do icon e dentro do parâmetro está indicando a localização da imagem
        setIconImage(img.getImage());
        setVisible(true);// Aqui define a visibilidade, para aparecer a tela
        cbxId.requestFocus();  

    }// Aqui fecha o construtor TelaDeAtualizacao  

    // Aqui define o método para deixa a escrita da notificação em html
    public static String setHtmlFormat(String strTexto) {
        return "<html><body>" + strTexto + "</body></html>";
    }// Aqui fecha o método setHtmlFormat

    public static TelaDeAtualizacaoView appTelaDeAtualizacaoView;


    public void addComponent(Component component, int row, int column, int width, int height) {
        if (height > 1) {
            gbConstraints.fill = GridBagConstraints.BOTH;
        } else {
            gbConstraints.fill = GridBagConstraints.BOTH;
        }
        // definição da localização vertical do elemento na grade
        gbConstraints.gridy = row;
        // definição da localização horizontal do elemento na grade
        gbConstraints.gridx = column;
        // definição do tamanho da largura do elemento na grade
        gbConstraints.gridwidth = width;
        // definição do tamanho da altura do elemento na grade
        gbConstraints.gridheight = height;
        // definição da restrição/regra do componente/elemento gráfico
        gbLayout.setConstraints(component, gbConstraints);//(oq, como)
        // adicionamento do componente já completo e pronto para renderização
        add(component);
    }

    // Aqui define o método executor main, de 1 parâmetro, argumento do tipo matriz de string, sem retorno, estatico, que sera importado
    //void = sem retorno ou retorno nulo
    public static void main(String[] args) {
        TelaDeAtualizacaoView appTelaDeAtualizacaoView = new TelaDeAtualizacaoView();
        appTelaDeAtualizacaoView.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }// Aqui fecha o método executor

}// Aqui fecha a classe TelaDeAtualizcao