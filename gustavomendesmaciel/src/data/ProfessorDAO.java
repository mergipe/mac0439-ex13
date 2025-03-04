package data;

import logic.Professor;

import java.sql.*;

public class ProfessorDAO
{

    private Connection conexao;

    public ProfessorDAO()
    {
        this.conexao = FabricaDeConexao.obterInstancia().obterConexao();
    }

    public void insere(Professor professor)
    {
        String insertSQL =
            "INSERT INTO mac0439_exercicio13.Professor " +
            "VALUES (?, ?, ?)";

        try
        {
            PreparedStatement stmt = this.conexao.prepareStatement(insertSQL);

            stmt.setLong(1, professor.getId());
            stmt.setString(2, professor.getNome());
            stmt.setInt(3, professor.getIdDepto());

            stmt.execute();
            stmt.close();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void altera(Professor professor)
    {
        String updateSQL =
            "UPDATE mac0439_exercicio13.Professor " +
            "SET nomeProf = ?, idDepto = ? " +
            "WHERE idProf = ?";

        try
        {
            PreparedStatement stmt = this.conexao.prepareStatement(updateSQL);

            stmt.setString(1, professor.getNome());
            stmt.setInt(2, professor.getIdDepto());
            stmt.setLong(3, professor.getId());

            stmt.execute();
            stmt.close();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void remove(Professor professor)
    {
        String deleteSQL =
            "DELETE FROM mac0439_exercicio13.Professor " +
            "WHERE idProf = ?";

        try
        {
            PreparedStatement stmt = this.conexao.prepareStatement(deleteSQL);

            stmt.setLong(1, professor.getId());

            stmt.execute();
            stmt.close();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public Professor obtem(long id)
    {
        Professor professor = null;
        String querySQL =
            "SELECT * FROM mac0439_exercicio13.Professor " +
            "WHERE idProf = ?";

        try
        {
            ResultSet rs;
            PreparedStatement stmt = conexao.prepareStatement(querySQL);

            stmt.setLong(1, id);

            rs = stmt.executeQuery();
            if (rs.next())
            {
                professor = new Professor();

                professor.setId(rs.getLong("idProf"));
                professor.setNome(rs.getString("nomeProf"));
                professor.setIdDepto(rs.getInt("idDepto"));
            }

            rs.close();
            stmt.close();

            return professor;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
