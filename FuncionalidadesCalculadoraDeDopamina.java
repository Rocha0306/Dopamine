import java.util.ArrayList;
import java.util.Scanner;

public class FuncionalidadesCalculadoraDeDopamina {
        Scanner InputUser = new Scanner(System.in);
    protected void MensagensAposCadastro() {
        System.out.println("Seja bem vindo oficialmente a Calculadora de Dopamina!");
        System.out.println("\nNão consegue manter a produtividade nos estudos, trabalho e procrastina diariamente ou ocasionalmente?");
        System.out.println("\nIsso está ligado ao controle de sua dopamina! Mas o que é dopamina?");
        System.out.println("\nSegundo o site Reservatorio de Dopamina: A dopamina é um neurotransmissor, ou seja, uma substância química produzida pelo cérebro que atua na transmissão de sinais entre as células nervosas. Ela desempenha um papel vital no sistema de recompensa e no controle do movimento, entre outras funções.");
        System.out.println("\nGrandes Empresas dominaram o estudo desse neurotransmissor e desenvolveram um caminho para manterem seus usuarios costantamente presos aos seus produtos");
        System.out.println("\nUm exemplo disso é o TikTok, varias pessoas passam horas por dia assistindo aqueles videos curtos que geram uma enorme liberação de dopamina no seu cerebro e o aplicativo possui algoritmos muito bem construidos para acostumar o cerebro do usuario a super-estimulos fazendo");
        System.out.println("\nA chave para ter uma rotina produtiva e atingir metas é dominar a sua dopamina!");
        System.out.println("\nVamos lá? Será exibido alguns questionarios para ser realizado o calculo da dopamina!");


    }

    protected void FuncionalidadeUsuarioPosCadastro() {
        for(int i = 0; i < 7; i++) {
            int [] SuperEstimulos = new int[8];
            System.out.println("Voce consome alguns desses itens abaixo? Seja o mais sincero na sua resposta possivel");
            System.out.println("\n1.Alcool\n2.Drogas\n3.Pornografia\n4.Jogos Eletronicos\n5.Redes Sociais como TikTok, Instagram\n6.Alimentos Altamente Caloricos(Chocolates, Hamburgueres, Sorvetes, Pizzas etc\n7.Outros\n8.Mais Nenhum");
            SuperEstimulos[i] = InputUser.nextInt();
        }

    }



}
