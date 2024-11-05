import javax.swing.*;
import java.awt.*;
import java.io.*;

public class OpenFile {
    public static void abrirArquivo() {
        try {
            JFileChooser chooser = new JFileChooser();//choose: escolha
            chooser.setDialogTitle("Selecione o arquivo que deseja abrir");//Define o texto da aba
            chooser.setApproveButtonText("Abrir arquivo");//Define o texto do botão
            int returnVal1 = chooser.showOpenDialog(null);
            String fileFullPath = "";//caminho completo do arquivo
            if (returnVal1 == JFileChooser.APPROVE_OPTION) {
                fileFullPath = chooser.getSelectedFile().getAbsolutePath();
            } else {
                System.out.println("que pena!");
            }
            try{
                File file = new File(fileFullPath);
                if(!Desktop.isDesktopSupported()) {
                    System.out.println("desktop is not supported in this machine");//desktop: area de trabalho
                    return;
                }
                Desktop desktop = Desktop.getDesktop();
                if(file.exists()) {
                    desktop.open(file);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Arquivo aberto com sucesso!");
        } catch (Exception e) {
            System.out.println("Não foi possível abrir o arquivo");
        }
    }
}
