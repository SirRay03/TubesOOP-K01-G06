import java.lang.Math;
import java.sql.Time;

public class Kesejahteraan{
    private int mood;
    private int hunger;
    private int health;
    private boolean isSleep;
    private boolean isBuangAir;

    public Kesejahteraan (){
        this.mood = 100;
        this.hunger =  100;
        this.health = 100;
        this.isSleep  = true;
        this.isBuangAir = true;
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

    public boolean getIsSleep(){
        return isSleep;
    }

    public boolean getIsBuangAir(){
        return isBuangAir;
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

    public void setIsSleep( Boolean isSleep ){
        this.isSleep  = isSleep;
    }

    public void setIsBuangAir( Boolean isBuangAir ){
        this.isBuangAir = isBuangAir;
    }

    public boolean isAlive() throws DeadException{
        if (mood <= 0 ||  hunger <= 0 || health <= 0 ){
            throw new DeadException();
        }
        else {
            return false;
        }
    }

    public void olahRaga (Time time){
        long timeLong = time.getTime()/ 1000; 
        long pengali = Math.floorDiv(timeLong, 20);
        long pengali = Math.floorDiv(timeLong, timeLong);
        int pengaliInt = ((int)pengali);
        setMood(pengaliInt * 10);
        setHealth(pengaliInt * -5);
        setHealth(pengaliInt * 5);
    }
}