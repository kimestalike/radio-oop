package ru.netology.radio;

public class Radio {
    private int station = 0;
    private int volume = 0;

    public int getStation() {
        return station;
    }

    public void setStation(int newStation) {
        if (newStation < 0) {
            return;
        }

        if (newStation > 9) {
            return;
        }

        station = newStation;
    }

    public void nextStation() {
        int next = station + 1;

        if (next > 9) {
            next = 0;
        }

        setStation(next);
    }

    public void prevStation() {
        int prev = station - 1;

        if (prev < 0) {
            prev = 9;
        }

        setStation(prev);
    }
}
