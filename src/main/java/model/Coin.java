package model;

/**
 * Created by vikashgupta on 29/09/18.
 */
public class Coin {
    private int count;
    private int faceValue;

    public Coin(int count, int faceValue) {
        this.count = count;
        this.faceValue = faceValue;
    }

    public boolean isAvailable() {
        return this.count > 0;
    }

    public void addCoin(int count) {
        this.count += count;
    }

    public void removeCoin() {
        if (this.isAvailable()) {
            --this.count;
        }
    }
}
