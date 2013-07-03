package ua.kpi_java_training5.alekseenko.src.module3;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Aleksey Alekseenko
 * Date: 15.06.13
 */
public class HurdleFactory {
    private List<Hurdle> hurdleList;

    public HurdleFactory() {
        hurdleList = new ArrayList<Hurdle>();
        for (int i = 0; i < Initialization.numberHurdles; i++) {
            hurdleList.add(new Hurdle());
        }
    }

    public int getQuantityOfHurdles() {
        return hurdleList.size();
    }

    public Hurdle getHurdle(int index) {
        return hurdleList.get(index);
    }

    public void addHurdle(Hurdle hurdle) {
        hurdleList.add(hurdle);
    }
}
