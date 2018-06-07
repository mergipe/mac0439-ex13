package data;

import java.sql.*;
import java.util.Properties;

public class FabricaDeConexao
{

    public static final String NOME_DRIVER = "org.postgresql.Driver";
    public static final String URL_BD = "jdbc:postgresql://postgresql.linux.ime.usp.br:5432/mergipe";
    public static final String USUARIO_BD = "mergipe";
    public static final String SENHA_BD = "gmmspmg0609960810";

    private static FabricaDeConexao fabricaDeConexao = null;

    private FabricaDeConexao()
    {
        try
        {
            Class.forName(NOME_DRIVER);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public Connection obterConexao()
    {
        Properties properties = new Properties();

        properties.setProperty("ssl", "true");
        properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
        properties.setProperty("user", USUARIO_BD);
        properties.setProperty("password", SENHA_BD);

        try
        {
            return DriverManager.getConnection(URL_BD, properties);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static FabricaDeConexao obterInstancia()
    {
        if (fabricaDeConexao == null)
            fabricaDeConexao = new FabricaDeConexao();
        return fabricaDeConexao;
    }
}
