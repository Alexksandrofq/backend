package view;
import controller.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaDeMenuView extends JFrame {
    public JMenu cadastroMenu;//Tipo menu
    //variaveis tipo item
    public JMenuItem novoItem;
    public JMenuItem pesquisarItem;
    public JMenuItem atualizarItem;
    public JMenuItem removerItem;

    public JMenuBar barraDeMenu;

    public JLabel lblTelaDeMenu;

    public TelaDeMenuView() {
        super("Tela De Menu");

        cadastroMenu = new JMenu("Cadastro");

        novoItem = new JMenuItem("Novo");
        pesquisarItem = new JMenuItem("Pesquisar");
        atualizarItem = new JMenuItem("Atualizar");
        removerItem = new JMenuItem("Remover");

        barraDeMenu = new JMenuBar();

        lblTelaDeMenu = new JLabel("Tela De Menu", SwingConstants.CENTER);

        cadastroMenu.add(novoItem);
        cadastroMenu.add(pesquisarItem);
        cadastroMenu.add(atualizarItem);
        cadastroMenu.add(removerItem);

        cadastroMenu.setMnemonic('C');
        novoItem.setMnemonic('N');
        pesquisarItem.setMnemonic('P');
        atualizarItem.setMnemonic('A');
        removerItem.setMnemonic('R');

        barraDeMenu.add(cadastroMenu);//adicionamos o cadastroMenu na barraDeMenu

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
                    JOptionPane.showMessageDialog(null, "Você clicou no item: " + event.getActionCommand());
                }
            }
        );

        atualizarItem.addActionListener(//escutador de ação
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {//Método
                    JOptionPane.showMessageDialog(null, "Você clicou no item: " + event.getActionCommand());
                }
            }
        );
        
        removerItem.addActionListener(//escutador de ação
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {//Método
                    JOptionPane.showMessageDialog(null, "Você clicou no item: " + event.getActionCommand());
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
