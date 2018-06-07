package logic;

public class Professor
{

    private long id;
    private String nome;
    private int idDepto;

    public long getId()
    {
        return this.id;
    }

    public String getNome()
    {
        return this.nome;
    }

    public int getIdDepto()
    {
        return this.idDepto;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void setIdDepto(int idDepto)
    {
        this.idDepto = idDepto;
    }
}
