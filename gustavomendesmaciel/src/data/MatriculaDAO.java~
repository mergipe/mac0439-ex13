package data;

import logic.Aluno;
import logic.Curso;
import logic.Matricula;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAO
{

    private Connection conexao;

    public MatriculaDAO()
    {
        this.conexao = FabricaDeConexao.obterInstancia().obterConexao();
    }

    public void insere(List<Matricula> matriculas)
    {
        String insertSQL =
            "INSERT INTO mac0439_exercicio13.Matriculado ";

        for (Matricula matricula : matriculas)
            insertSQL += "VALUES(?, ?)";

        try
        {
            PreparedStatement stmt = this.conexao.prepareStatement(insertSQL);

            int i = 0;
            for (Matricula matricula : matriculas)
            {
                stmt.setLong(i, matricula.getAluno().getNro());
                stmt.setString(i + 1, matricula.getCurso().getNome());
                i += 2;
            }

            stmt.execute();
            stmt.close();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }    
    }

    public List<Matricula> buscaPorCurso(Curso curso)
    {
        String querySQL =
            "SELECT * FROM mac0439_exercicio13.Matriculado " +
            "NATURAL JOIN mac0439_exercicio13.Aluno " +
            "WHERE nomeCurso = ?";

        try
        {
            List<Matricula> matriculas = new ArrayList<Matricula>();
            PreparedStatement stmt = this.conexao.prepareStatement(querySQL);

            stmt.setString(1, curso.getNome());

            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                Aluno aluno = new Aluno();
                Matricula matricula = new Matricula();

                aluno.setNro(rs.getLong("nroAluno"));
                aluno.setNome(rs.getString("nomeAluno"));
                aluno.setFormacao(rs.getString("formacao"));
                aluno.setNivel(rs.getString("nivel"));
                aluno.setIdade(rs.getInt("idade"));

                matricula.setAluno(aluno);
                matricula.setCurso(curso);

                matriculas.add(matricula);
            }

            rs.close();
            stmt.close();

            return matriculas;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
