package utils;

import java.util.concurrent.ThreadLocalRandom;

public class Random
{
    public static int randomValue(int start, int end) {
        return ThreadLocalRandom.current().nextInt(start, end);
    }
}
