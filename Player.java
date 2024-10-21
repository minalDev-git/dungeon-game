public class Player extends Characters {
    
    private static int score = 0;
    Player(String name){
        this.name = name;
        this.health = 50;
    }
    public static int getScore() {
        return score;
    }
    public static void increaseScore(int points) {
        Player.score += points;
    }
}