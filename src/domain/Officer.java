package domain;

public class Officer {

    public void exam(Solider[] soliders) {

        int newRankCount ;

        do {
            newRankCount = 0;
            for (int i = 0; i < 15; i++) {

                System.out.println("ID:" + soliders[i].getId());

                Bullet bullet0 = new Bullet();
                Bullet bullet1 = new Bullet();
                Bullet bullet2 = new Bullet();
                Bullet bullet3 = new Bullet();

                soliders[i].shoot(bullet0);
                soliders[i].shoot(bullet1);
                soliders[i].shoot(bullet2);
                soliders[i].shoot(bullet3);


                System.out.println("score1:" + bullet0.getScore());
                System.out.println("score2:" + bullet1.getScore());
                System.out.println("score3:" + bullet2.getScore());
                System.out.println("score4:" + bullet3.getScore());

                int totalScore = bullet0.getScore() + bullet1.getScore() + bullet2.getScore() + bullet3.getScore();
                System.out.println("Final Score:" + totalScore);
                System.out.println("Initial Rank:" + soliders[i].getRank());

                if (totalScore < 28 && soliders[i].getRank() == 1) {
                    soliders[i].setRank(2);
                    System.out.println("Final Rank:" + soliders[i].getRank());

                } else if (totalScore >= 28 && soliders[i].getRank() == 1) {
                    soliders[i].setRank(1);
                    System.out.println("Final Rank:" + soliders[i].getRank());

                } else if (totalScore < 28 && soliders[i].getRank() == 2) {
                    soliders[i].setRank(3);
                    System.out.println("Final Rank:" + soliders[i].getRank());

                } else if (totalScore >= 28 && soliders[i].getRank() == 2) {
                    soliders[i].setRank(1);
                    System.out.println("Final Rank:" + soliders[i].getRank());

                } else if (totalScore < 28 && soliders[i].getRank() == 3) {
                    soliders[i].setRank(3);
                    System.out.println("Final Rank:" + soliders[i].getRank());

                } else if (totalScore >= 28 && soliders[i].getRank() == 3) {
                    soliders[i].setRank(2);
                    System.out.println("Final Rank:" + soliders[i].getRank());
                }
                if (soliders[i].getRank() == 3) {
                    newRankCount++;
                }

                System.out.println("--------------------------------------");
            }
        } while (newRankCount > 9);
        System.out.println("تعداد اعضای رنک با مقدار ۳ بعد از تغییر: " + newRankCount);
    }
}








