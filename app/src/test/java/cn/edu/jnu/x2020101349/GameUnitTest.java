package cn.edu.jnu.x2020101349;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class GameUnitTest {
    Game game;
    @Before
    public void setUp(){
        game=new Game();
    }
    @Test

    private void rollSame(int pins, int n) //连续投掷一样的
    {
        for (int i = 0; i < n; i++) {
            game.roll(pins);
        }
    }
    private void rollSpare() //补中
    {
        game.roll(5);
        game.roll(5);
    }
    private void rollStrike() //全中
    {
        game.roll(10);
    }
    public void testAll2socres() // 10次都是2分
    {
        rollSame(1,20);
        assertEquals(20,game.score());
    }

    public void testOneStrike()
    {
        rollStrike();
        game.roll(5);
        game.roll(5);
        rollSame(0,16);
        assertEquals(30, game.score());
    }

}