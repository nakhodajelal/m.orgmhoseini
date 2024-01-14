package domain;

public class Camp {
    public static void main(String[] args) {
        Officer officer = new Officer();
        Solider[] soliders = new Solider[15];

        for (int i = 0; i < 15; i++) {
            Bullet[] soloiderCup = new Bullet[4];
            int randomRank = (int) (Math.random() * 3) + 1;
            soliders[i] = new Solider(i, randomRank, soloiderCup);

            for (int j = 0; j < 4; j++) {
                Bullet bullet = new Bullet();
                soloiderCup[j] = bullet;
            }
        }

        officer.exam(soliders);

    }
}
