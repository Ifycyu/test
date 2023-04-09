package cn.edu.jnu.x2020101349;
public class Game {
    int score=0;
    public void roll(int pin)
    {
        score+=pin;
    }

    public int score() {
    return score;
    }
}
