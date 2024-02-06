import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;


public class Dados {
    Scanner InputUser = new Scanner(System.in);

    // Dados para o Cadastro
    private String Id;
    private String Nome;
    private int Idade;

    private String Email;

    private String Senha;

    private String IDLogin;

    private String SenhaLogin;








    private Boolean Vef;

    protected void Usuarios() throws SQLException {
        Guia Usuario = new Guia();
        Usuario.getVerifyCadastro();
        Usuario.setVerifyCadastro(Vef);
        if(Vef == true) {
            Login();
        }

        else {
            Cadastro();
        }


    }

    protected void Cadastro() throws SQLException {
        // Nesse metodo irei fazer a conexão com o banco de dados e preenchimento das Informacoes por parte do Usuario

        for(int i = 0; i < 1; i++) {
            System.out.println("\nCerto voce não possui cadastro, logo preencha as informaçoes abaixo para utilizar o programa!");
            System.out.println("O id deve conter no maximo 2 digitos sendo eles numeros!");
            System.out.print("Digite seu Id: ");
            this.Id = InputUser.next();
            VerificarInfoID();
            System.out.print("Digite seu Nome: ");
            this.Nome = InputUser.next();
            System.out.print("Digite sua Idade: ");
            this.Idade= InputUser.nextInt();
            System.out.print("Digite seu email: ");
            this.Email = InputUser.next();
            VerificarInfoEmail();
            System.out.print("Digite sua senha: ");
            this.Senha = InputUser.next();
        }

        Connection Conexao;
        try {
            Conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/CALCULADORADEDOPAMINA", "root", "Lorenzo05*");
            String ComandoSQL = String.format("INSERT INTO CADASTRO(ID, NOME, IDADE, EMAIL, SENHA) VALUES('%s', '%s', '%s', '%s', '%s')", this.Id, this.Nome, this.Idade, this.Email, this.Senha);
            int NumDeLinhas = Conexao.createStatement().executeUpdate(ComandoSQL);
            System.out.println("Informacoes Cadastradas com sucesso!");
        } // fechamento do Try


        catch (SQLException e) {
            throw new RuntimeException(e);
            //System.out.println("Erro no cadastro de informaçoes, preencha novamente");
        }

        FuncionalidadesCalculadoraDeDopamina Func = new FuncionalidadesCalculadoraDeDopamina();
        Func.MensagensAposCadastro();
        Func.FuncionalidadeUsuarioPosCadastro();



    }

    protected void Login() throws SQLException {
        for(int i = 0; i < 1; i++) {
            System.out.println("Atenção! Caso seu Login não seja encontrado o programa irá encerrar!");
            System.out.println("Digite seu ID: ");
            this.IDLogin = InputUser.nextLine();
            System.out.println("Digite sua senha: ");
            this.SenhaLogin = InputUser.nextLine();
        }

        Connection Conexao = null;
        try {
            Conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/CALCULADORADEDOPAMINA", "127.0.0.1", "Lorenzo05*");
            String ComandoSQL = "SELECT ID FROM LOGIN";
            String ComandoSQL2 = "SELECT SENHA FROM LOGIN";
            ResultSet ObjetoResultSet = Conexao.createStatement().executeQuery(ComandoSQL);
            ResultSet ObjetoResultSet2 = Conexao.createStatement().executeQuery(ComandoSQL);
            while(ObjetoResultSet.next()) {
                String ID = ObjetoResultSet.getNString("ID");
                String Senha = ObjetoResultSet2.getNString("SENHA");
                String [] VetorID = new String[]{ID};
                String [] VetorSenha = new String[]{Senha};
                for(String i : VetorID) {
                    for(String J : VetorSenha) {
                        if(Objects.equals(i, this.IDLogin) && Objects.equals(i, this.SenhaLogin)) {
                            System.out.println("top");
                        }

                        else {
                            System.out.println("hey");
                        }
                    }
                }

            }
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        finally {
            assert Conexao != null;
            Conexao.close();
        }


    }


    private void VerificarInfoEmail() {
        while(!this.Email.contains("@gmail.com") && !this.Email.contains("@outlook.com") && !this.Email.contains("@hotmail.com")) {
            System.out.println("\nEmail Invalido");
            System.out.println("Digite seu email");
            this.Email = InputUser.nextLine();
        }

    }

    private void VerificarInfoID() {
        while (this.Id.length() != 2) {
            System.out.println("Voce foi avisado, ID digitado de maneira incorreta");
            System.out.println("Digite seu Id: ");
            this.Id = InputUser.nextLine();

        }
    }




}
