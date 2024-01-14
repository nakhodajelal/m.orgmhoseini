package domain;

public class Bullet {
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if (score < 0) {
            this.score = 0;
        }

        else {
            this.score = score;
        }
    }
}


