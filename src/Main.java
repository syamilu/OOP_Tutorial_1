public class Main {
    public static void main(String[] args)
    {

        Player playerOne = new Player("John",100);
        Player playerTwo = new Player("Wahed Shawarma",100);
        System.out.println(playerOne.showHealth());
        // 1) infinite loop that ends when 1 player wins
        // 2) 1 player can attack per move
        // 3) An attack reduces health by a random number between 1 and 10
        // 4) Game ends when 1 player's health is reduced to zero first


    }
}