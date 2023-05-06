package src;

public class Kesejahteraan{
    private int mood;
    private int hunger;
    private int health;

    public Kesejahteraan (){
        this.mood = 80;
        this.hunger =  80;
        this.health = 80;
    }

    public int getMood(){
        return mood;
    }

    public int getHunger(){
        return hunger;
    }

    public int getHealth(){
        return health;
    }

    public void setMood( int mood ){
        this.mood = this.mood + mood;
        if (this.mood > 100){
            this.mood = 100;
        }
        else if(this.mood < 0){
            this.mood =0;
        }
    }

    public void setHunger( int hunger ){
        this.hunger = this.hunger + hunger;
        if (this.hunger > 100){
            this.hunger = 100;
        }
        else if(this.hunger < 0){
            this.hunger =0;
        }
    }

    public void setHealth( int health ){
        this.health = this.health + health;
        if (this.health > 100){
            this.health = 100;
        }
        else if(this.health < 0){
            this.health =0;
        }
    }

    public boolean isAlive() throws DeadException{
        if (mood <= 0 ||  hunger <= 0 || health <= 0 ){
            throw new DeadException();
        }
        else {
            return false;
        }
    }

}