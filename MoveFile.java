import javax.swing.*;
import static java.nio.file.StandardCopyOption.*;//Standard=camponente class, temos uma biblioteca java, um arquivo, camponente de copia
import java.nio.file.*;

public class MoveFile {
    public static void moverArquivo() {
        try {
            JFileChooser chooser = new JFileChooser();

            chooser.setDialogTitle("Selecione o arquivo que deseja mover");//nome da aba
            chooser.setApproveButtonText("Selecionar arquivo");//nome do botão
            int returnVal1 = chooser.showOpenDialog(null);
            String fileFullPath = "";//Caminho completo do arquivo
            String fileName = "";//nome do arquivo
            if(returnVal1 == JFileChooser.APPROVE_OPTION) {
                fileFullPath = chooser.getSelectedFile().getAbsolutePath();//pega o caminho absoluto,pegar o arquivo selecionado
                fileName = chooser.getSelectedFile().getName();
            } else {
                System.out.println("Que pena!");
            }

            chooser.setDialogTitle("Selecione a pasta de destino.");//nome da aba
            chooser.setApproveButtonText("Mover aqui");//nome do botão
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//se o usuario clicar em colar, retorna 0
            int returnVal2 = chooser.showOpenDialog(null);
            String folderFullPath = "";//caminho completo da pasta
            if(returnVal2 == JFileChooser.APPROVE_OPTION) {
                folderFullPath = chooser.getSelectedFile().getAbsolutePath();//pega o caminho absoluto,pegar o arquivo selecionado
            } else {
                System.out.println("Que pena!");
            }

            Path pathOrigin = Paths.get(fileFullPath);
            Path pathDestination = Paths.get(folderFullPath + "\\" + fileName);
            if (fileFullPath.length() > 0 && folderFullPath.length() > 0) {
                Files.move(pathOrigin, pathDestination, REPLACE_EXISTING);//REPLACE_EXISTING= se hover, substitua 
                System.out.println("Arquivo" + fileName + "movido com sucesso!");
            } else {
                System.out.println("Ops! Não foi possível copiar o arquivo. Por favor, verifique e tente novamente mais tarde.");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível copiar o arquivo.");
        }
    }  
}
