package presentation;

import data.*;
import logic.*;

public class Insercao extends IUD
{
    @Override
    public void aluno()
    {
        AlunoDAO dao;
        String op;
        boolean insert = true;

        while (insert)
        {
            op = "";
            Aluno aluno = new Aluno();

            System.out.println("[INSERIR ALUNO]");
            System.out.print("Número: ");
            aluno.setNro(Long.parseLong(System.console().readLine()));
            System.out.print("Nome: ");
            aluno.setNome(System.console().readLine());
            System.out.print("Formação: ");
            aluno.setFormacao(System.console().readLine());
            System.out.print("Nível: ");
            aluno.setNivel(System.console().readLine());
            System.out.print("Idade: ");
            aluno.setIdade(Integer.parseInt(System.console().readLine()));

            dao = new AlunoDAO();
            dao.insere(aluno);
            System.out.println("Aluno inserido com sucesso.\n");

            while (!op.equals("s") && !op.equals("n"))
            {
                System.out.print("Deseja inserir outro aluno? (s ou n) ");
                op = System.console().readLine();
            }

            if (op.equals("n")) insert = false;
            else Terminal.clearScreen();
        }
    }

    @Override
    public void professor()
    {
        ProfessorDAO dao;
        String op;
        boolean insert = true;

        while (insert)
        {
            op = "";
            Professor professor = new Professor();

            System.out.println("[INSERIR PROFESSOR]");
            System.out.print("ID: ");
            professor.setId(Long.parseLong(System.console().readLine()));
            System.out.print("Nome: ");
            professor.setNome(System.console().readLine());
            System.out.print("ID do departamento: ");
            professor.setIdDepto(Integer.parseInt(System.console().readLine()));

            dao = new ProfessorDAO();
            dao.insere(professor);
            System.out.println("Professor inserido com sucesso.\n");

            while (!op.equals("s") && !op.equals("n"))
            {
                System.out.print("Deseja inserir outro professor? (s ou n) ");
                op = System.console().readLine();
            }

            if (op.equals("n")) insert = false;
            else Terminal.clearScreen();
        }
    }

    @Override
    public void curso()
    {
        CursoDAO cdao;
        ProfessorDAO pdao;
        Professor professor;
        String op;
        boolean insert = true;

        while (insert)
        {
            op = "";
            Curso curso = new Curso();

            System.out.println("[INSERIR CURSO]");
            System.out.print("Nome: ");
            curso.setNome(System.console().readLine());
            System.out.print("Horário: ");
            curso.setHorario(System.console().readLine());
            System.out.print("Sala: ");
            curso.setSala(System.console().readLine());
            System.out.print("ID do professor: ");
            pdao = new ProfessorDAO();
            professor = pdao.obtem(Long.parseLong(System.console().readLine()));
            if (professor != null)
            {
                curso.setProfessor(professor);

                cdao = new CursoDAO();
                cdao.insere(curso);
                System.out.println("Curso inserido com sucesso.\n");
            }
            else
            {
                System.out.println("Professor não encontrado. Curso não inserido.\n");
            }

            while (!op.equals("s") && !op.equals("n"))
            {
                System.out.print("Deseja inserir outro curso? (s ou n) ");
                op = System.console().readLine();
            }

            if (op.equals("n")) insert = false;
            else Terminal.clearScreen();
        }
    }

    public void matricula()
    {
        MatriculaDAO mdao;
        AlunoDAO adao;
        Matricula matricula;
        Aluno aluno;
        String op;
        boolean insert = true;

        while (insert)
        {
            op = "";

            System.out.println("[MATRICULAR ALUNO]");
            System.out.print("Número do aluno: ");
            long nro = Long.parseLong(System.console().readLine());

            adao = new AlunoDAO();
            aluno = adao.obtem(nro);

            if (aluno != null)
            {
                System.out.print
                (
                    "Nome: " + aluno.getNome() + "\n" +
                    "Formação: " + aluno.getFormacao() + "\n" +
                    "Nível: " + aluno.getNivel() + "\n" +
                    "Idade: " + aluno.getIdade() + "\n\n"
                );
            }
            else
            {
                System.out.println("Aluno não encontrado. Operação não concluída.\n");
            }

            while (!op.equals("s") && !op.equals("n"))
            {
                System.out.print("Deseja inserir outro aluno? (s ou n) ");
                op = System.console().readLine();
            }

            if (op.equals("n")) insert = false;
            else Terminal.clearScreen();
        }
    }
}
