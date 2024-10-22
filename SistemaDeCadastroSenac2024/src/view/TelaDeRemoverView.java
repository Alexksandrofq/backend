package view;
import controller.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


// Aqui define a classe TelaDeAtualização que herderá do JFrame
public class TelaDeRemoverView extends JFrame
{
    // Aqui há 16 váriaveis que serão manipuladas no construtor    
    public static JLabel lblId;
    public static JComboBox<String> cbxId;
    public static String[] ids;

    public static JLabel lblNome;
    public static JTextField txtNome;
   
    public static JLabel lblEmail;
    public static JTextField txtEmail;
   
    public static JLabel lblNotificacoes;

    public static JButton btnRemover;
    public static JButton btnCancelar;

    public static int tamanhoInputs = 20;

    

    // Aqui define o construtor TelaDeRemover()
    public TelaDeRemoverView()
    {
        super("Tela de Atualização");// Aqui define o título que aparecerá
        setLayout(new GridLayout(5, 1, 5, 5));// Aqui define as linhas. colunas, tamanho horizontal e vertical 

        JPanel linha_id = new JPanel(new GridLayout(1, 2));
        /*JPanel = define a linha e coluna de cada variável*/

        lblId = new JLabel("Id:", SwingConstants.RIGHT);
        linha_id.add(lblId);// Aqui vai adicionar a linha_id ao lblId

        TelaDeRemoverController.popularIds();

        cbxId = new JComboBox<String>(ids);
        linha_id.add(cbxId);

        add(linha_id);// add sozinho =  adicona ao construtor 

        JPanel linha_nome = new JPanel(new GridLayout(1, 2));

        lblNome = new JLabel("Nome:", SwingConstants.RIGHT);
        linha_nome.add(lblNome);
        txtNome = new JTextField(tamanhoInputs);
        txtNome.setEditable(false);
        linha_nome.add(txtNome);

        add(linha_nome);

        JPanel linha_email = new JPanel(new GridLayout(1, 2));

        lblEmail = new JLabel("Email:", SwingConstants.RIGHT);
        linha_email.add(lblEmail);

        txtEmail = new JTextField(tamanhoInputs);
        txtEmail.setEditable(false);
        linha_email.add(txtEmail);

        add(linha_email);

        JPanel linha_botoes = new JPanel(new GridLayout(1, 2));

        
        btnRemover = new JButton("Remover");
        linha_botoes.add(btnRemover);// Aqui vai adicionar a linha_botoes

        btnCancelar = new JButton("Cancelar");
        linha_botoes.add(btnCancelar);
        

        add(linha_botoes);

        JPanel linha_notificacoes = new JPanel(new GridLayout(1, 1));

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        linha_notificacoes.add(lblNotificacoes);

        add(linha_notificacoes);

        // Aqui define o método que adiciona o escutador da ação 
        btnRemover.addActionListener( 
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeRemoverController.removerId();

                }// Aqui fecha método actionPerformed

            }// Aqui fecha o objeto ActionListener

        );// Aqui fecha o parâmetro do método btnAtualizar que adiciona o excutador da ação

        btnCancelar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeRemoverController.limparCampos();
                                      
                }// Aqui fecha método actionPerformed

            }// Aqui fecha o objeto ActionListener

        );// Aqui fecha o parâmetro do método btnCancelar que adiciona o excutador da ação

        cbxId.addItemListener(
            new ItemListener() {
                @Override
                    public void itemStateChanged(ItemEvent event) {
                        if (event.getStateChange() == ItemEvent.SELECTED) {
                            TelaDeRemoverController.atualizarCampos( false);
                               
                        }// Aqui fecha o evento      

                    }// Aqui fecha método itemStateChangedd

            }// Aqui fecha o objeto ItemListener

        );// Aqui fecha o parâmetro do método cbxId que adiciona o excutador da ação
        

    

        setSize(250, 330);// Aqui define a width(largura) e height(altura)        
        ImageIcon img = new ImageIcon("./senac-logo.png");// Aqui define a imagem do icon e dentro do parâmetro está indicando a localização da imagem
        setIconImage(img.getImage());
        setVisible(true);// Aqui define a visibilidade, para aparecer a tela
        cbxId.requestFocus();  

    }// Aqui fecha o construtor TelaDeRemover 



    // Aqui define o método para deixa a escrita da notificação em html
    public static String setHtmlFormat(String strTexto) {
        return "<html><body>" + strTexto + "</body></html>";
    }// Aqui fecha o método setHtmlFormat

    public static TelaDeRemoverView appTelaDeRemoverView;

    // Aqui define o método executor main, de 1 parâmetro, argumento do tipo matriz de string, sem retorno, estatico, que sera importado
    //void = sem retorno ou retorno nulo
    public static void main(String[] args) {
        TelaDeRemoverView appTelaDeRemoverView = new TelaDeRemoverView();
        appTelaDeRemoverView.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }// Aqui fecha o método executor

}// Aqui fecha a classe TeladeRemover