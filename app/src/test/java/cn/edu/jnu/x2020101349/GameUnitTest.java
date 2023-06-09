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


    public void testAll2socres() // 10次都是2分
    {
        rollSame(1,20);
        assertEquals(20,game.score());
    }

    @Test
    public void testOneStrike() // 10+5+5  +5+5 一次全中
    {
        rollStrike();
        game.roll(5);
        game.roll(5);
        rollSame(0,16);
        assertEquals(30, game.score());
    }
    @Test
    public void testOneSpare() //10+5 +5 一次补中
    {
        rollSpare();
        game.roll(5);
        rollSame(0,17);
        assertEquals(20, game.score());
    }
    @Test
    public void testTwoStrike() // 10+10+5  +10+5+0  +5
    {
        rollStrike();
        rollStrike();
        game.roll(5);
        rollSame(0,14);
        assertEquals(45, game.score());
    }

    @Test
    public void testAllStrike() // 9*(10+10+10)=270  +10+10+10=30
    {
        rollSame(10,12);
        assertEquals(300, game.score());
    }
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

}