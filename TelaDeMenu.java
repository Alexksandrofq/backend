import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaDeMenu extends JFrame {
    public JMenu arquivoMenu;

    //variaveis tipo item
    public JMenuItem abrirItem;
    public JMenuItem copiarItem;
    public JMenuItem moverItem;
    public JMenuItem apagarItem;
    public JMenuItem renomearItem;

    public JMenuItem sobreItem;
    public JMenuItem sairItem;

    public JMenuBar barraDeMenu;

    public JLabel lblTelaDeMenu;

    public TelaDeMenu() {
        super("Tela De Menu");

        barraDeMenu = new JMenuBar();

        arquivoMenu = new JMenu("Arquivo");

        abrirItem = new JMenuItem("Abrir");
        copiarItem = new JMenuItem("Copiar");
        moverItem = new JMenuItem("Mover");
        apagarItem = new JMenuItem("Apagar");
        renomearItem = new JMenuItem("Renomear");

        sobreItem = new JMenuItem("Sobre");
        sairItem = new JMenuItem("Sair");

        lblTelaDeMenu = new JLabel("Tela De Menu", SwingConstants.CENTER);

        arquivoMenu.add(abrirItem);
        arquivoMenu.add(copiarItem);
        arquivoMenu.add(moverItem);
        arquivoMenu.add(apagarItem);
        arquivoMenu.add(renomearItem);

        arquivoMenu.add(sobreItem);
        arquivoMenu.add(sairItem);

        arquivoMenu.setMnemonic('A');

        abrirItem.setMnemonic('b');
        copiarItem.setMnemonic('C');
        moverItem.setMnemonic('M');
        apagarItem.setMnemonic('p');
        renomearItem.setMnemonic('n');
        sobreItem.setMnemonic('S');
        sairItem.setMnemonic('r');

        barraDeMenu.add(arquivoMenu);//adicionamos o arquivoMenu na barraDeMenu

        setJMenuBar(barraDeMenu);

        add(lblTelaDeMenu, BorderLayout.CENTER);

        abrirItem.addActionListener(//escutador de ação
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {//Método
                    OpenFile.abrirArquivo();
                }
            }
        );

        copiarItem.addActionListener(//escutador de ação
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {//Método
                    CopyFile.copiarArquivo();
                }
            }
        );

        moverItem.addActionListener(//escutador de ação
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {//Método
                    MoveFile.moverArquivo();              }
            }
        );
        
        apagarItem.addActionListener(//escutador de ação
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {//Método
                    DeleteFile.apagarArquivo();
                }
            }
        );
        
        renomearItem.addActionListener(//escutador de ação
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {//Método
                    RenameFile.renomearArquivo();
                }
            }
        );

        sobreItem.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Manipulador de arquivos em java desktop");
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
        setVisible(true);
    }
    public static TelaDeMenu appTelaDeMenu;
    public static void main(String[] args){
        appTelaDeMenu = new TelaDeMenu();
        appTelaDeMenu.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}

