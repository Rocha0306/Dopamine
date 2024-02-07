import java.sql.SQLException;
import java.util.Scanner;

public class ClasseDeVerificacao {
    Scanner InputUser = new Scanner(System.in);
    Dados dados = new Dados();

    public void VerificarInfoEmail() {
        String email;
        while(dados.getEmail().contains("@gmail.com") && !dados.getEmail().contains("@outlook.com") && !dados.getEmail().contains("@hotmail.com")) {
            System.out.println("\nEmail Invalido");
            System.out.println("Digite seu email");
             email = InputUser.nextLine();
             dados.setEmail(email);
        }

    }

    public void VerificarInfoID() {
        while (dados.getId().length() != 2) {
            String ID;
            System.out.println("Voce foi avisado, ID digitado de maneira incorreta");
            System.out.println("Digite seu Id: ");
            ID = InputUser.nextLine();
            dados.setId(ID);


        }
    }

    public void VerificadorDeLogin() throws SQLException {
        if(dados.isIDExiste() == true && dados.isSenhaExiste() == true) {
            FuncionalidadesCalculadoraDeDopamina AbrirApp = new FuncionalidadesCalculadoraDeDopamina();
            AbrirApp.FuncionalidadeDoAplicativo();
        }

        else {
            System.out.println("ID ou senha incorretos");
            Conexao ConexaoBD = new Conexao();
            ConexaoBD.LoginUsuarioNoDB();

        }
    }




}
