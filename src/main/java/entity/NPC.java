package entity;

import utils.Random;

/**
 * Represents an Non-Player Character
 */
public class NPC extends Entity
{
    public Gesture randomGesture() {
        return Gesture.values()[Random.randomValue(0, Gesture.values().length)];
    }
}
