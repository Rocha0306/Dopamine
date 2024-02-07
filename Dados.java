import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;


public class Dados {
    Scanner InputUser = new Scanner(System.in);

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    // Dados para o Cadastro
    private String Id;

    public String getNome() {
        return Nome;

    }

    public void setNome(String nome) {
        Nome = nome;

    }

    private String Nome;

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int idade) {
        Idade = idade;
    }

    private int Idade;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    private String Email;

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    private String Senha;

    public String getIDLogin() {
        return IDLogin;
    }

    public void setIDLogin(String IDLogin) {
        this.IDLogin = IDLogin;
    }

    private String IDLogin;

    public String getSenhaLogin() {
        return SenhaLogin;
    }

    public void setSenhaLogin(String senhaLogin) {
        SenhaLogin = senhaLogin;
    }

    private String SenhaLogin;


    public boolean isIDExiste() {
        return IDExiste;
    }

    public void setIDExiste(boolean IDExiste) {
        this.IDExiste = IDExiste;
    }

    private boolean IDExiste;

    public boolean isSenhaExiste() {
        return SenhaExiste;
    }

    public void setSenhaExiste(boolean senhaExiste) {
        SenhaExiste = senhaExiste;
    }

    private boolean SenhaExiste;







    ClasseDeVerificacao Verificar = new ClasseDeVerificacao();



    protected void Cadastro() throws SQLException {
        // Nesse metodo irei fazer a conexão com o banco de dados e preenchimento das Informacoes por parte do Usuario

        for(int i = 0; i < 1; i++) {
            System.out.println("\nCerto voce não possui cadastro, logo preencha as informaçoes abaixo para utilizar o programa!");
            System.out.println("O id deve conter no maximo 2 digitos sendo eles numeros!");
            System.out.print("Digite seu Id: ");
            this.Id = InputUser.next();
            Verificar.VerificarInfoID();
            System.out.print("Digite seu Nome: ");
            this.Nome = InputUser.next();
            System.out.print("Digite sua Idade: ");
            this.Idade= InputUser.nextInt();
            System.out.print("Digite seu email: ");
            this.Email = InputUser.next();
            Verificar.VerificarInfoEmail();
            System.out.print("Digite sua senha: ");
            this.Senha = InputUser.next();
        }





    }

    protected void Login() throws SQLException {
        for(int i = 0; i < 1; i++) {
            System.out.println("Atenção! Caso seu Login não seja encontrado o programa irá encerrar!");
            System.out.println("Digite seu ID: ");
            this.IDLogin = InputUser.nextLine();
            System.out.println("Digite sua senha: ");
            this.SenhaLogin = InputUser.nextLine();
        }


    }







}
