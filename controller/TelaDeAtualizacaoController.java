package controller;
import model.*;
import view.*;
import javax.swing.*;
import static java.nio.file.StandardCopyOption.*;
import java.nio.file.*;

public class TelaDeAtualizacaoController extends TelaDeAtualizacaoView {
    public static void popularIds() {
        TelaDeAtualizacaoModel.popularIdsModel();
    }

    public static void enviarIds(String [] idsView) {
        ids = idsView;
    } 
    public static void atualizarId() {
        String atualizarNome = "";
        String atualizarEmail = "";
        String atualizarSenha = "";
        String atualizarImagem = "";

        if (txtNome.getText().trim().equals(nomeAtual) == false) {
            atualizarNome = "`nome` = '" + txtNome.getText() + "'";
        }

        if (txtEmail.getText().trim().equals(emailAtual) == false) {
            if (atualizarNome.length() > 0) {
                atualizarEmail = " , ";
            }
            atualizarEmail += "`email` = '" + txtEmail.getText() + "'";
        }
        if (String.valueOf(txtSenha.getPassword()).trim().equals(senhaAtual) == false) {
            if (atualizarNome.length() > 0 || atualizarEmail.length() > 0) {
                atualizarSenha = " , ";
            }
            atualizarSenha += "`senha` = '" + String.valueOf(txtSenha.getPassword()) + "'";
        }

        if (txtImagem.getText().trim().equals("") == false) {
            if (atualizarNome.length() > 0 || atualizarEmail.length() > 0 || atualizarSenha.length() > 0) {
                atualizarImagem = " , ";
            }
            atualizarImagem += "`img` = '" + String.valueOf(txtSenha.getPassword()) + "'";
        }




        if (atualizarNome.length() > 0 || atualizarEmail.length() > 0 || atualizarSenha.length() > 0) {
        } else {
            lblNotificacoes.setText("Não foram encontradas alterações para atualizar o id " + cbxId.getSelectedItem().toString());
        }         
    }
    public static void limparCampos() {
        txtNome.setText("");
        txtEmail.setText("");
        txtSenha.setText("");
        cbxId.setSelectedIndex(0);
    }
    public static void atualizarCampos(String id) {
        if (cbxId.getSelectedIndex() > 0) {
            String idAtual = String.valueOf(cbxId.getSelectedItem());
            TelaDeAtualizacaoModel.atualizarCamposModel(idAtual);
        } else {
            lblNotificacoes.setText("Selecione um id para continuar.");
            limparCampos();
        }      
    }

    public static void enviarCampos(String nome, String email, String senha) {
        txtNome.setText(nome);
        nomeAtual = txtNome.getText();
        txtEmail.setText(email);
        emailAtual = txtEmail.getText();
        txtSenha.setText(senha);
        senhaAtual = String.valueOf(txtSenha.getPassword());
    }

    public static void notificarUsuario(String txt) {
        lblNotificacoes.setText(setHtmlFormat(txt));
    }
    
    public static void registrarAtualizacao() {
        nomeAtual = txtNome.getText();
        emailAtual = txtEmail.getText();
        senhaAtual = String.valueOf(txtSenha.getPassword());
    }

    public static void carregarImagem(){

        String fileName = "";//nome do arquivo

        try {
            JFileChooser chooser = new JFileChooser();

            chooser.setDialogTitle("Selecione o arquivo que deseja carregar");//nome da aba
            chooser.setApproveButtonText("Carregar arquivo");//nome do botão
            int returnVal1 = chooser.showOpenDialog(null);
            String fileFullPath = "";//Caminho completo do arquivo
            
            if (returnVal1 == JFileChooser.APPROVE_OPTION) {
                fileFullPath = chooser.getSelectedFile().getAbsolutePath();//pega o caminho absoluto,pegar o arquivo selecionado
                fileName = chooser.getSelectedFile().getName();
            } else {
                System.out.println("Que pena!");
                return;
            }

            String folderFullPath = InterfaceController.localViewImgFolder;

            Path pathOrigin = Paths.get(fileFullPath);
            Path pathDestination = Paths.get(folderFullPath + "\\" + fileName);
            if (fileFullPath.length() > 0 && folderFullPath.length() > 0) {
                Files.copy(pathOrigin, pathDestination, REPLACE_EXISTING);//REPLACE_EXISTING= se hover, substitua 
                System.out.println("Arquivo" + fileName + "copiado/colado com sucesso.");
            } else {
                System.out.println("Ops! Não foi possível copiar o arquivo. Por favor, verifique e tente novamente mais tarde.");
            }

        } catch (Exception e) {
            System.out.println("Não foi possível copiar o arquivo.");
        }

        Icon imgCarregada = new ImageIcon(InterfaceController.localViewImgFolder + "\\" + fileName);
        lblImagem.setIcon(imgCarregada);
        txtImagem.setText(fileName);
        
    }

    public static void RemoverImagem(){
        //
    }
    
}

