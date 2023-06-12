import Player.Player;

import java.util.Scanner;

public class Game {
    public static Player player;

    public static Scanner scan = new Scanner(System.in);

    public static void start(){
        System.out.println("##########################################");
        System.out.println("####### Welcome The Adventure Game #######");
        System.out.println("##########################################");
        System.out.print("Please enter your name: ");
        String name = scan.next();

        player = new Player(name);
        player.selectChar();
        player.selectLocation();
    }
}
