public class Player {

    //data of a player
    private  String name;
    private int health;

    public Player(String name,int health){
        this.name = name;
        this.health = health;
    }
    //behaviour of a player
    public  String getName(){
        return this.name;
    }
    public void setHealth(int num){
        this.health = health + num;
    }
    public int getHealth(){
        return health;
    }
//    public int attackPlayer(Player player){
//        //generate a random number
//        player.setHealth(randomNumber);
//        //get current health of attacked player
//
//        return player.getHealth();
//    }
    public String showHealth(){
        String healthBar = "";
        for (int i = 0; i < this.health ; i++){
            healthBar = healthBar + "|";
        }
        return healthBar;
    }

}
