public class Player {

    // data of a player
    private String name;
    private int health;
    private int damage;
    private int heal;
    private Item[] items;// not yet developed
    private int score;// not yet developed

    public Player(String name) {
        this.name = name;
        this.health = 100;
    }

    // behaviour of a player
    public String getName() {
        return this.name;
    }

    public void setHealth(int num) {
        this.health = health - num;
        if (this.health > 100) {
            this.health = 100;
        } else if (this.health < 0) {
            this.health = 0;
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHeal(int num) {
        this.heal = num;
    }

    public int getHeal() {
        return this.heal;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return this.damage;
    }

    public int attackPlayer(Player player) {
        int randomNumber = (int) (Math.random() * 15) + 1;
        player.setHealth(randomNumber);
        player.setDamage(randomNumber);
        return player.getHealth();
    }

    public int healPlayer(Player player) {
        int randomNumber = (int) (Math.random() * 10) + 1;
        player.setHealth(-randomNumber);
        player.setHeal(randomNumber);
        return player.getHealth();
    }

    public String showHealth() {
        String healthBar = "";
        int i;
        for (i = 0; i < this.health; i++) {
            healthBar = healthBar + "|";
        }
        return healthBar + "@" + i + "%";
    }

}
