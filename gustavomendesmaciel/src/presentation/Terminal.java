package presentation;

public class Terminal
{
    public static void clearScreen()
    {
        System.out.print("\033[H\033[2J");
    }
}
