import java.util.*;

//Declaração de classe
public class Classe1 {
    public static void main(String[] args) {
        Scanner scnInputUsuario = new Scanner(System.in);// Serve para criar o input de entrada via terminal do usuario
        System.out.println("Olá! Bem vindo a calculadora de Java. \nDigite o primeiro número a ser calculado e tecle: \"Enter\"");
        int intInputUsuario1 = scnInputUsuario.nextInt();// Coleta o que o usuario digitar, para o usuario digitar algo no terminal
        System.out.println("Digite o segundo número a ser calculado e tecle: \"Enter\"");
        int intInputUsuario2 = scnInputUsuario.nextInt();//Aguarda o usuário digita algo no terminal 
        System.out.println("Digite o número da opção desejada e tecle: \"Enter\"");
        String[] opcoes = Classe2.mostrarOpcoes();
        for (int count = 0; count < opcoes.length; count++) { // Laço de repetição, count recebe 0, enquanto count for menor que a quantidade de opcoes, soma 1
            System.out.println(count + " - " + opcoes[count]);    
        }
        int opcaoEscolhida = scnInputUsuario.nextInt();
        System.out.println("O resultado da " + opcoes[opcaoEscolhida] + " é: " + Classe2.resultado(intInputUsuario1, intInputUsuario2, opcaoEscolhida) );
        scnInputUsuario.close();
    }
}