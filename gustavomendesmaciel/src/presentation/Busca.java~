package presentation;

import data.*;
import logic.*;

import java.util.List;
import java.util.ArrayList;

public class Busca
{
    public void curso(String arg)
    {
        List<Curso> cursos;
        List<List<Matricula>> matriculas;
        CursoDAO dao;
        MatriculaDAO mdao;
        String op;
        boolean query = true;

        while (query)
        {
            int maxNome = 0, maxHorario = 0, maxSala = 0, maxNomeProf = 0,
                maxNomeAluno = 6;
            op = "";
            matriculas = new ArrayList<List<Matricula>>();

            System.out.println("[BUSCAR CURSO POR NOME DO " + arg + "]");
            System.out.print("Nome: ");

            dao = new CursoDAO();
            mdao = new MatriculaDAO();

            if (arg.equals("CURSO"))
                cursos = dao.buscaPorCurso(System.console().readLine());
            else
                cursos = dao.buscaPorProfessor(System.console().readLine());

            if (!cursos.isEmpty())
            {
                for (Curso curso : cursos)
                {
                    List<Matricula> m = mdao.buscaPorCurso(curso);
                    matriculas.add(m);

                    if (curso.getNome().length() > maxNome)
                        maxNome = curso.getNome().length();
                    if (curso.getHorario().length() > maxHorario)
                        maxHorario = curso.getHorario().length();
                    if (curso.getSala().length() > maxSala)
                        maxSala = curso.getSala().length();
                    if (curso.getProfessor().getNome().length() > maxNomeProf)
                        maxNomeProf = curso.getProfessor().getNome().length();

                    for (Matricula matricula : m)
                    {
                        if (matricula.getAluno().getNome().length() > maxNomeAluno)
                            maxNomeAluno = matricula.getAluno().getNome().length();
                    }
                }

                String format =
                    " %-" + maxNome + "s  " +
                    " %-" + maxHorario + "s  " +
                    " %-" + maxSala + "s  " +
                    " %-" + maxNomeProf + "s  " +
                    " %-" + maxNomeAluno + "s\n";

                System.out.println();
                System.out.printf(format, "Curso", "Horário", "Sala",
                        "Professor", "Alunos");

                int limit = maxNome + maxHorario + maxSala + maxNomeProf +
                    maxNomeAluno + 14;

                for (int i = 0; i < limit; i++)
                    System.out.print("-");
                System.out.println();

                int i = 0;
                for (Curso curso : cursos)
                {
                    String nomeAluno = "";

                    if (!matriculas.get(i).isEmpty())
                        nomeAluno = matriculas.get(i).get(0).getAluno().getNome();

                    System.out.printf(format, curso.getNome(),
                            curso.getHorario(), curso.getSala(),
                            curso.getProfessor().getNome(),
                            nomeAluno);

                    for (int j = 1; j < matriculas.get(i).size(); j++)
                    {
                        System.out.printf(format, "", "", "", "",
                                matriculas.get(i).get(j).getAluno().getNome());
                    }

                    i++;
                }
            }
            else
            {
                System.out.println("\nNenhum curso encontrado.");
            }

            while (!op.equals("s") && !op.equals("n"))
            {
                System.out.print("\nDeseja fazer outra busca? (s ou n) ");
                op = System.console().readLine();
            }

            if (op.equals("n")) query = false;
            else Terminal.clearScreen();
        }
    }
}
