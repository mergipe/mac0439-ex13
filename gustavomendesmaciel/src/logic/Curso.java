package logic;

public class Curso
{

    private String nome;
    private String horario;
    private String sala;
    private Professor professor;

    public String getNome()
    {
        return this.nome;
    }

    public String getHorario()
    {
        return this.horario;
    }

    public String getSala()
    {
        return this.sala;
    }
    
    public Professor getProfessor()
    {
        return this.professor;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void setHorario(String horario)
    {
        this.horario = horario;
    }

    public void setSala(String sala)
    {
        this.sala = sala;
    }

    public void setProfessor(Professor professor)
    {
        this.professor = professor;
    }
}
