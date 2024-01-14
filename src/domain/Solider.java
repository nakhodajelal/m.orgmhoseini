package domain;
public class Solider {
    private int id;
    private int rank;//1 is max, 3 is min
    private Bullet[] bullets;

    public Solider(int id, int rank, Bullet[] bullets) {
        this.id = id;
        this.rank = rank;
        this.bullets = bullets;
    }

    public void shoot(Bullet bullet) {
        bullet.setScore((int) (Math.random() * 10));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Bullet[] getBullets() {
        return bullets;
    }

    public void setBullets(Bullet[] bullets) {
        this.bullets = bullets;
    }
}
