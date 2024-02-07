
import java.sql.*;
import java.util.Objects;
import java.util.Scanner;


public class Conexao {
    Dados dados = new Dados();
    // Objeto de Conexão com o DataBase;
    Connection Conexao;

    private void PegarConexao() throws SQLException {

        try {
            Conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/CALCULADORADEDOPAMINA", "root", "Lorenzo05*");
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }

    protected void CadastroUsuarioNoDB() throws SQLException {

        dados.Cadastro();

        try {
            PegarConexao();
            String ComandoSQL = String.format("INSERT INTO CADASTRO(ID, NOME, IDADE, EMAIL, SENHA) VALUES('%s', '%s', '%s', '%s', '%s')", dados.getId(), dados.getNome(), dados.getIdade(), dados.getEmail(), dados.getSenha());
            int NumDeLinhas = Conexao.createStatement().executeUpdate(ComandoSQL);
            System.out.println("Informacoes cadastradas com sucesso!");

        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        finally {
            if(Conexao != null) {
                Conexao.close();
            }
        }
    }


    protected void LoginUsuarioNoDB() throws SQLException {
        try {
            dados.Login();
            PegarConexao();
            String ComandoSQL = "SELECT ID FROM CADASTRO";
            String ComandoSQL2 = "SELECT SENHA FROM CADASTRO";
            ResultSet ObjetoResultSet = Conexao.createStatement().executeQuery(ComandoSQL);
            ResultSet ObjetoResultSet2 = Conexao.createStatement().executeQuery(ComandoSQL2);
            while(ObjetoResultSet.next()) {
                String ID = ObjetoResultSet.getString("ID");
                String [] VetorID = new String[]{ID};
                for(String i : VetorID) {
                    if(Objects.equals(i, dados.getIDLogin())) {
                        boolean IDExiste = true;
                        dados.setIDExiste(IDExiste);

                    }
                }


            }

            while(ObjetoResultSet2.next()) {
                String Senha = ObjetoResultSet2.getString("SENHA");
                String [] VetorSenha = new String[]{Senha};
                for(String i : VetorSenha) {
                    if(Objects.equals(i, dados.getSenhaLogin())) {
                        boolean SenhaExiste = true;
                        dados.setSenhaExiste(SenhaExiste);
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




}
