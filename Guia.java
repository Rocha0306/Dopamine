import java.sql.SQLException;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Guia {

    Scanner InputUser = new Scanner(System.in);




    protected String Cadastro;

    private Boolean VerifyCadastro;

    public Boolean getVerifyCadastro() {
        return VerifyCadastro;
    }

    public void setVerifyCadastro(Boolean verifyCadastro) {
        VerifyCadastro = verifyCadastro;

    }

    protected void Inicio() throws SQLException {
        //Esse metodo só irá exibir Informacoes por isso é vazio

        System.out.println("\nSeja bem vindo a Calculadora de Dopamina");
        System.out.println("\nO Usuario(a) possui cadastro? Sim ou Nao?: ");
        this.Cadastro = InputUser.nextLine();
        // Verificar a resposta do usuario
        String[] Sim = {"Sim", "sim", "sIM", "SiM", "SIM"};
        String[] Nao = {"Não", "Nao", "nao", "não", "nAo", "NAo", "NAO"};
        for (String i : Sim) {
            if(Objects.equals(this.Cadastro, i)) {

                this.VerifyCadastro = true;
                Dados LoginUsuario = new Dados();
                LoginUsuario.Login();
            }
        }

        for(String i : Nao) {
            if(Objects.equals(this.Cadastro, i)) {

                this.VerifyCadastro = false;
                Dados LoginUsuario = new Dados();
                LoginUsuario.Cadastro();
            }
        }






        /*
        System.out.println("\nNão consegue manter a produtividade nos estudos, trabalho e procrastina diariamente ou ocasionalmente?");
        System.out.println("\nIsso está ligado ao controle de sua dopamina! Mas o que é dopamina?");
        System.out.println("\nSegundo o site Reservatorio de Dopamina: A dopamina é um neurotransmissor, ou seja, uma substância química produzida pelo cérebro que atua na transmissão de sinais entre as células nervosas. Ela desempenha um papel vital no sistema de recompensa e no controle do movimento, entre outras funções.");
        System.out.println("\nGrandes Empresas dominaram o estudo desse neurotransmissor e desenvolveram um caminho para manterem seus usuarios costantamente presos aos seus produtos");
        System.out.println("\nUm exemplo disso é o TikTok, varias pessoas passam horas por dia assistindo aqueles videos curtos que geram uma enorme liberação de dopamina no seu cerebro e o aplicativo possui algoritmos muito bem construidos para acostumar o cerebro do usuario a super-estimulos fazendo");
        System.out.println("\nA chave para ter uma rotina produtiva e atingir metas é dominar a sua dopamina!");
        System.out.println("\nPronto para embarcar nessa jornada? ");
        */


    }




}
