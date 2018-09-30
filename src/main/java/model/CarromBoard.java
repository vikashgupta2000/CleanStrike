package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vikashgupta on 29/09/18.
 */
public class CarromBoard {
    private Map<CoinType, Coin> coins;

    public CarromBoard(Coin blackCoin, Coin redCoin) {
        coins = new HashMap<>();
        coins.put(CoinType.BLACK, blackCoin);
        coins.put(CoinType.RED, redCoin);
    }

    public void addCoin(int coinCount, CoinType coinType) {
        this.coins.get(coinType).addCoin(coinCount);
    }

    public void removeCoin(CoinType coinType) {
        this.coins.get(coinType).removeCoin();
    }

    public boolean coinsPresent (CoinType coinType) {
        return this.coins.get(coinType).isAvailable();
    }

    public boolean anyCoinOnBoard () {
        for (Coin coin : this.coins.values()) {
            if (coin.isAvailable()) {
                return true;
            }
        }
        return false;
    }
}
