import java.util.Random;
import java.util.Scanner;


public class App 
{
    public static void main(String[] args) 
    {
        Jogo jogadores = new Jogo();
        Random r = new Random();
        Scanner in = new Scanner(System.in);
        boolean breakloop;
        int escolhaNumJogador;
        int escolhaNumMaquina;
        boolean isEven;
        do
        {
            System.out.println("Escolha qual voce deseja? ");
            System.out.println("P - Par \nI - Impar ");
            System.out.print("Escolha: ");
            String escolha = in.nextLine().trim().toLowerCase();
            System.out.println();
            char escolhaChar = escolha.charAt(0);
            
            
            breakloop = escolhaParImpar(escolhaChar, jogadores);
        }while(breakloop == false);

        System.out.println();
        System.out.println("Escolha um numero para jogar: ");
        System.out.print("Escolha: ");
        escolhaNumJogador = in.nextInt();

        escolhaNumMaquina = numRandomMaquina(r);

        System.out.println();
        System.out.println("Voce jogou " + escolhaNumJogador);
        System.out.println("Maquina jogou " + escolhaNumMaquina);

        isEven = ePar(escolhaNumJogador, escolhaNumMaquina);

        vencedor(isEven, jogadores);

        //in.close();

    }

    public static void vencedor(boolean isEven, Jogo jogadores)
    {
        char par;
        if(isEven)
        {par = 'p';}

        else
        {par = 'i';}

        if(jogadores.getJogador() == par)
        {System.out.println("\nVOCE FOI O VENCEDOR!!!!");}

        else
        {System.out.println("\nVOCE PERDEU!!!\nA MAQUINA FOI A VENCEDORA");}
    }

    public static boolean escolhaParImpar(char escolhaChar, Jogo jogadores)
    {
        switch(escolhaChar)
        {
            case 'p': 
            {
                jogadores.setJogador('p');
                jogadores.setMaquina('i');
                System.out.println("Voce escolheu Par\nMaquina ficou com Impar");
                return true;
            }

            case 'i': 
            {
                jogadores.setJogador('i');
                jogadores.setMaquina('p');
                System.out.println("Voce escolheu Impar\nMaquina ficou com Par");
                return true;
            }
            default:
            {
                System.out.println("Opcao invalida");
                return false;
            }
        }
    }

    public static int numRandomMaquina(Random r)
    {
        int numMaquina;
        do
        {
            numMaquina = r.nextInt();
        }while(numMaquina < 0 || numMaquina > 100);
        return numMaquina;
    }

    public static boolean ePar(int escolhaNumJogador, int escolhaNumMaquina)
    {
        int resultado = escolhaNumJogador + escolhaNumMaquina;
        System.out.println("O resultado deu " + resultado);
        if(resultado%2 == 0)
        {
            return true;
        }
        
        else
        {return false;}
    }
}
