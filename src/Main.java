import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 1) infinite loop that ends when 1 player wins
        // 2) 1 player can attack per move
        // 3) An attack reduces health by a random number between 1 and 10
        // 4) Game ends when 1 player's health is reduced to zero first
        System.out.println("Welcome to the game!");
        System.out.print("Insert player 1 name : ");
        String playerOneName = input.nextLine();
        System.out.print("Insert player 2 name : ");
        String playerTwoName = input.nextLine();
        Player playerOne = new Player(playerOneName);
        Player playerTwo = new Player(playerTwoName);

        ConnectDB.addPlayer(playerOneName, playerTwoName);
        // starting the game
        for (int i = 3; i > 0; i--) {
            System.out.println("Starting game in " + i + " seconds...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Game started!");
        int turn = 1;
        int clearScreen = 0;
        do {
            System.out.println(((turn == 1) ? playerOne.getName() : playerTwo.getName()) + "'s turn!");
            System.out.println("Choose your move : ");
            System.out.println("1) Attack");
            System.out.println("2) Heal");
            System.out.print("Your move : ");
            int move = input.nextInt();
            while (move != 1 && move != 2) {
                System.out.println("Invalid move!");
                System.out.print("Your move : ");
                move = input.nextInt();
            }

            // clear screen
            if (clearScreen == 2) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                clearScreen = 0;
            }
            clearScreen++;

            switch (move) {
                case 1:
                    if (turn == 1) {
                        playerOne.attackPlayer(playerTwo);
                        System.out.println(playerOne.getName() + " attacks " + playerTwo.getName() + " for "
                                + playerTwo.getDamage() + " damage!");
                    } else {
                        playerTwo.attackPlayer(playerOne);
                        System.out.println(playerTwo.getName() + " attacks " + playerOne.getName() + " for "
                                + playerOne.getDamage() + " damage!");

                    }
                    break;
                case 2:
                    if (turn == 1) {
                        playerOne.healPlayer(playerOne);
                        System.out.println(playerOne.getName() + " heals for " + playerOne.getHeal() + " health!");
                    } else {
                        playerTwo.healPlayer(playerTwo);
                        System.out.println(playerTwo.getName() + " heals for " + playerTwo.getHeal() + " health!");
                    }
                    break;
            }

            System.out.println(playerOne.getName() + "'s health : " + playerOne.showHealth());
            System.out.println(playerTwo.getName() + "'s health : " + playerTwo.showHealth());
            System.out.println();
            // change the turn
            if (turn == 1) {
                turn = 2;
            } else {
                turn = 1;
            }

        } while (playerOne.getHealth() > 0 && playerTwo.getHealth() > 0);

        if (playerOne.getHealth() <= 0) {
            System.out.println(playerTwo.getName() + " wins!");
        } else {
            System.out.println(playerOne.getName() + " wins!");
        }

        input.close();
    }
}