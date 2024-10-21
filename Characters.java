public abstract class Characters {
    protected String name;
    protected int health;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public boolean isAlive(){
        return this.health > 0;
    }
    public void takeDamage(int damage){
        this.health -= damage;
        System.out.println(this.name + " takes damage!");
    }
}
