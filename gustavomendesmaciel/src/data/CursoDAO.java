package data;

import logic.Curso;
import logic.Professor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO
{

    private Connection conexao;

    public CursoDAO()
    {
        this.conexao = FabricaDeConexao.obterInstancia().obterConexao();
    }

    public void insere(Curso curso)
    {
        String insertSQL =
            "INSERT INTO mac0439_exercicio13.Curso " +
            "VALUES(?, ?, ?, ?)";

        try
        {
            PreparedStatement stmt = this.conexao.prepareStatement(insertSQL);

            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getHorario());
            stmt.setString(3, curso.getSala());
            stmt.setLong(4, curso.getProfessor().getId());

            stmt.execute();
            stmt.close();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void altera(Curso curso)
    {
        String updateSQL =
            "UPDATE mac0439_exercicio13.Curso " +
            "SET horario = ?, sala = ?, idProf = ? " +
            "WHERE nome = ?";

        try
        {
            PreparedStatement stmt = this.conexao.prepareStatement(updateSQL);

            stmt.setString(1, curso.getHorario());
            stmt.setString(2, curso.getSala());
            stmt.setLong(3, curso.getProfessor().getId());
            stmt.setString(4, curso.getNome());

            stmt.execute();
            stmt.close();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void remove(Curso curso)
    {
        String deleteSQL =
            "DELETE FROM mac0439_exercicio13.Curso " +
            "WHERE nome = ?";

        try
        {
            PreparedStatement stmt = this.conexao.prepareStatement(deleteSQL);

            stmt.setString(1, curso.getNome());

            stmt.execute();
            stmt.close();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    private List<Curso> busca(String atributo, String valor)
    {
        valor = "%" + valor + "%";
        String querySQL =
            "SELECT * FROM mac0439_exercicio13.Curso " +
            "NATURAL LEFT OUTER JOIN mac0439_exercicio13.Professor " +
            "WHERE " + atributo + " LIKE ?";

        try
        {
            ResultSet rs;
            List<Curso> cursos = new ArrayList<Curso>();
            PreparedStatement stmt = this.conexao.prepareStatement(querySQL);

            stmt.setString(1, valor);

            rs = stmt.executeQuery();

            while (rs.next())
            {
                Curso curso = new Curso();
                Professor professor = new Professor();

                professor.setId(rs.getLong("idProf"));
                professor.setNome(rs.getString("nomeProf"));
                professor.setIdDepto(rs.getInt("idDepto"));

                curso.setNome(rs.getString("nome"));
                curso.setHorario(rs.getString("horario"));
                curso.setSala(rs.getString("sala"));
                curso.setProfessor(professor);

                cursos.add(curso);
            }

            rs.close();
            stmt.close();
            
            return cursos;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

    }

    public List<Curso> buscaPorCurso(String nomeCurso)
    {
        return busca("nome", nomeCurso);
    }

    public List<Curso> buscaPorProfessor(String nomeProf)
    {
        return busca("nomeProf", nomeProf);
    }

    public Curso obtem(String nome)
    {
        Curso curso = null;
        ProfessorDAO pdao = new ProfessorDAO();
        String querySQL =
            "SELECT * FROM mac0439_exercicio13.Curso " +
            "WHERE nome = ?";

        try
        {
            ResultSet rs;
            PreparedStatement stmt = conexao.prepareStatement(querySQL);

            stmt.setString(1, nome);

            rs = stmt.executeQuery();
            if (rs.next())
            {
                curso = new Curso();
                Professor professor = pdao.obtem(rs.getLong("idProf"));

                curso.setNome(rs.getString("nome"));
                curso.setHorario(rs.getString("horario"));
                curso.setSala(rs.getString("sala"));
                curso.setProfessor(professor);
            }

            rs.close();
            stmt.close();

            return curso;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
