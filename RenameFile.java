import javax.swing.*;
import static java.nio.file.StandardCopyOption.*;//Standard=camponente class, temos uma biblioteca java, um arquivo, camponente de copia
import java.nio.file.*;

public class RenameFile {
    public static void renomearArquivo() {
        try {
            JFileChooser chooser = new JFileChooser();

            chooser.setDialogTitle("Selecione o arquivo que deseja renomear");//nome da aba
            chooser.setApproveButtonText("Renomear arquivo");//nome do botão
            int returnVal1 = chooser.showOpenDialog(null);
            String fileFullPath = "";//Caminho completo do arquivo
            String folderFullPath = "";//Caminho completo da pasta
            String fileName = "";//nome do arquivo

            String fileAleatoryoName = "file-" + String.valueOf(Math.random());//Math.random = gerar um número decimal comprido aleatorio, e o valueOf converterá o valor em String

            if(returnVal1 == JFileChooser.APPROVE_OPTION) {//o if veririca se o returno da variavel é igual a aprovação selecionado
                fileFullPath = chooser.getSelectedFile().getAbsolutePath();//pega o caminho absoluto do arquivo selecionado
                folderFullPath = chooser.getSelectedFile().getParent();//pega objeto pai do arquivo(pasta onde está o arquivo)
                fileName = chooser.getSelectedFile().getName();//pega o nome do arquivo selecionado 
                
            } else {
                System.out.println("Que pena!");
            }
            String newFileName = JOptionPane.showInputDialog(null, "Digite o nome do arquivo." + fileName);

            Path pathOrigin = Paths.get(fileFullPath);
            Path pathDestination = Paths.get(folderFullPath + "\\" + newFileName);

            Path pathTemp = Paths.get(folderFullPath + "\\" + fileAleatoryoName);
            
            if (
                fileFullPath.length() > 0 &&
                folderFullPath.length() > 0 &&
                fileName.length() > 0 &&
                newFileName.length() > 0) {//se os 4 elementos forem verdadeiros 
                    Files.copy(pathOrigin, pathTemp, REPLACE_EXISTING);//copiar o arquivo original para um temporario 

                    Files.delete(pathOrigin);//apaga o aquivo original

                    Files.copy(pathTemp, pathDestination, REPLACE_EXISTING);//copiar o aquivo temporario para o original 

                    Files.delete(pathTemp);//apapa o arquivo temporario
                    
                    System.out.println("Arquivo" + chooser.getSelectedFile().getName() + " Renomeado com sucesso.");
                } else {
                    System.out.println("Ops! Não foi possível renomear o arquivo, Por favor tente novamente mais tarde.");
                }
        } catch (Exception e) {
            System.out.println("Não foi possível renomear o arquivo." + e);
        }
    }
}   