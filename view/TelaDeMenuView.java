package view;
import controller.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaDeMenuView extends JFrame {
    public JMenu cadastroMenu;//Tipo menu
    public JMenu arquivoMenu;

    //variaveis tipo item
    public JMenuItem novoItem;
    public JMenuItem pesquisarItem;
    public JMenuItem atualizarItem;
    public JMenuItem removerItem;

    public JMenuItem sobreItem;
    public JMenuItem sairItem;

    public JMenuBar barraDeMenu;

    public JLabel lblTelaDeMenu;

    public TelaDeMenuView() {
        super("Tela De Menu");

        cadastroMenu = new JMenu("Cadastro");
        arquivoMenu = new JMenu("Arquivo");

        novoItem = new JMenuItem("Novo");
        pesquisarItem = new JMenuItem("Pesquisar");
        atualizarItem = new JMenuItem("Atualizar");
        removerItem = new JMenuItem("Remover");

        sobreItem = new JMenuItem("Sobre");
        sairItem = new JMenuItem("Sair");

        barraDeMenu = new JMenuBar();

        lblTelaDeMenu = new JLabel("Tela De Menu", SwingConstants.CENTER);

        cadastroMenu.add(novoItem);
        cadastroMenu.add(pesquisarItem);
        cadastroMenu.add(atualizarItem);
        cadastroMenu.add(removerItem);


        arquivoMenu.add(sobreItem);
        arquivoMenu.add(sairItem);

        cadastroMenu.setMnemonic('C');
        novoItem.setMnemonic('N');
        pesquisarItem.setMnemonic('P');
        atualizarItem.setMnemonic('A');
        removerItem.setMnemonic('R');

        arquivoMenu.setMnemonic('A');
        sobreItem.setMnemonic('S');
        sairItem.setMnemonic('r');

        barraDeMenu.add(cadastroMenu);//adicionamos o cadastroMenu na barraDeMenu
        barraDeMenu.add(arquivoMenu);

        setJMenuBar(barraDeMenu);

        add(lblTelaDeMenu, BorderLayout.CENTER);

        novoItem.addActionListener(//escutador de ação
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {//Método
                    TelaDeMenuController.abrirTelaDeCadastroView();
                }
            }
        );

        pesquisarItem.addActionListener(//escutador de ação
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {//Método
                    TelaDeMenuController.abrirTelaDePesquisaView();
                }
            }
        );

        atualizarItem.addActionListener(//escutador de ação
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {//Método
                    TelaDeMenuController.abrirTelaDeAtualizacaoView();              }
            }
        );
        
        removerItem.addActionListener(//escutador de ação
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {//Método
                    TelaDeMenuController.abrirTelaDeRemoverView();
                }
            }
        );

        sobreItem.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Sistema de Cadastro Senac 2024");
                }
            }
        );

        sairItem.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);

                }
            }
        );




        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static TelaDeMenuView appTelaDeMenuView;
    public static void main(String[] args){
        appTelaDeMenuView = new TelaDeMenuView();
    }
    
}
