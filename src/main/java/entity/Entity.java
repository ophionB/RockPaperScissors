package entity;

public abstract class Entity
{
    private int wins, loss, ties;
    private Gesture lastGesture;

    public enum Gesture {
        PAPER(1),
        SCISSORS(2),
        ROCK(0);

        private final int id;

        Gesture(int id) {
            this.id = id;
        }

        public static Gesture fromValue(int id) {
            for (Gesture gesture : Gesture.values()) {
                if (gesture.getId() == id) {
                    return gesture;
                }
            }
            return null;

        }

        public int getId() {
            return id;
        }
    }
    public final void setGesture(Gesture gesture) {
        lastGesture = gesture;
    }

    public final Gesture getGesture() {
        return lastGesture;
    }

    public final int getWins() {
        return wins;
    }

    public final void setWins(int wins) {
        this.wins = wins;
    }

    public final int getLoss() {
        return loss;
    }

    public final void setLoss(int loss) {
        this.loss = loss;
    }

    public final int getTies() {
        return ties;
    }

    public final void setTies(int ties) {
        this.ties = ties;
    }

}

