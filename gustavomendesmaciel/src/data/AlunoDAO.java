package data;

import logic.Aluno;

import java.sql.*;

public class AlunoDAO
{

    private Connection conexao;

    public AlunoDAO()
    {
        this.conexao = FabricaDeConexao.obterInstancia().obterConexao();
    }

    public void insere(Aluno aluno)
    {
        String insertSQL =
            "INSERT INTO mac0439_exercicio13.Aluno " +
            "VALUES(?, ?, ?, ?, ?)";

        try
        {
            PreparedStatement stmt = this.conexao.prepareStatement(insertSQL);

            stmt.setLong(1, aluno.getNro());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getFormacao());
            stmt.setString(4, aluno.getNivel());
            stmt.setInt(5, aluno.getIdade());

            stmt.execute();
            stmt.close();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void altera(Aluno aluno)
    {
        String updateSQL =
            "UPDATE mac0439_exercicio13.Aluno " +
            "SET nomeAluno = ?, formacao = ?, nivel = ?, idade = ? " +
            "WHERE nroAluno = ?";

        try
        {
            PreparedStatement stmt = this.conexao.prepareStatement(updateSQL);

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getFormacao());
            stmt.setString(3, aluno.getNivel());
            stmt.setInt(4, aluno.getIdade());
            stmt.setLong(5, aluno.getNro());

            stmt.execute();
            stmt.close();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void remove(Aluno aluno)
    {
        String deleteSQL =
            "DELETE FROM mac0439_exercicio13.Aluno " +
            "WHERE nroAluno = ?";

        try
        {
            PreparedStatement stmt = this.conexao.prepareStatement(deleteSQL);

            stmt.setLong(1, aluno.getNro());

            stmt.execute();
            stmt.close();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public Aluno obtem(long nro)
    {
        Aluno aluno = null;
        String querySQL =
            "SELECT * FROM mac0439_exercicio13.Aluno " +
            "WHERE nroAluno = ?";

        try
        {
            ResultSet rs;
            PreparedStatement stmt = conexao.prepareStatement(querySQL);

            stmt.setLong(1, nro);

            rs = stmt.executeQuery();
            if (rs.next())
            {
                aluno = new Aluno();

                aluno.setNro(rs.getLong("nroAluno"));
                aluno.setNome(rs.getString("nomeAluno"));
                aluno.setFormacao(rs.getString("formacao"));
                aluno.setNivel(rs.getString("nivel"));
                aluno.setIdade(rs.getInt("idade"));
            }

            rs.close();
            stmt.close();

            return aluno;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
