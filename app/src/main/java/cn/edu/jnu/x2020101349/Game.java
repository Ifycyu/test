package cn.edu.jnu.x2020101349;

public class Game {
    private int[] rolls = new int[21]; // 用于存储每次投球击倒的瓶数的数组
    private int currentRoll = 0; // 用于跟踪当前投球的索引

    // 记录每次投球击倒的瓶数的方法
    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    // 计算并返回游戏总分的方法
    public int score() {
        int score = 0;
        int frameIndex = 0;

        // 遍历所有10个框架
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(frameIndex)) { // 如果是全中
                score += 10 + strikeBonus(frameIndex);
                frameIndex++;
            } else if (isSpare(frameIndex)) { // 如果是补中
                score += 10 + spareBonus(frameIndex);
                frameIndex += 2;
            } else { // 如果既不是全中也不是补中
                score += sumOfPinsInFrame(frameIndex);
                frameIndex += 2;
            }
        }
        return score;
    }

    // 辅助方法，判断当前框架是否为全中
    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }

    // 辅助方法，判断当前框架是否为补中
    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }

    // 辅助方法，计算当前框架全中的奖励分
    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    // 辅助方法，计算当前框架补中的奖励分
    private int spareBonus(int frameIndex) {
        return rolls[frameIndex + 2];
    }

    // 辅助方法，计算当前框架中击倒的瓶数之和
    private int sumOfPinsInFrame(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }
}
