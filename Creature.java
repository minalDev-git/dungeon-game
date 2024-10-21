public abstract class Creature extends Characters{
    protected int attackPower;
    Creature(String name,int attackPower, int health){
        this.name = name;
        this.attackPower = attackPower;
        this.health = health;
    }
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
    public int getAttackPower() {
        return attackPower;
    }
    public abstract void attack(Player p);

}
class Goblin extends Creature{

    Goblin(){
        super("goblin",20,50);
    }
    @Override
    public void attack(Player p){
        p.takeDamage(this.attackPower);
        System.out.println("The Goblin attacks for " + attackPower + " damage!");
    }
}
/**
 * Dragon
 */
class Dragon extends Creature{

    Dragon(){
        super("Dragon", 25, 50);
    }
    @Override
    public void attack(Player p){
        p.takeDamage(this.attackPower);
        System.out.println("The Dragon attacks for " + attackPower + " damage!");
    }
}
