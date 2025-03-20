package ru.netology.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    @Test
    void shouldReturnInitialStation() {
        Radio radio = new Radio();

        long expected = 0;
        long actual = radio.getStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldSetCurrentStation() {
        Radio radio = new Radio();
        long expected = 8;

        radio.setStation(8);
        long actual = radio.getStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void tooLowStationSetsMaxStation() {
        Radio radio = new Radio();

        long expected = 0;
        radio.setStation(-1);
        long actual = radio.getStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void tooHighStationSetsMinStation() {
        Radio radio = new Radio();
        radio.setStation(9);

        long expected = 9;

        radio.setStation(10);
        long actual = radio.getStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void nextStationShouldSetNext() {
        Radio radio = new Radio();
        long expected = 1;

        radio.nextStation();
        long actual = radio.getStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void nextStationCurrentStationIsMaxShouldSetMin() {
        Radio radio = new Radio();
        radio.setStation(9);

        long expected = 0;
        radio.nextStation();
        long actual = radio.getStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void prevStationShouldSetNext() {
        Radio radio = new Radio();
        radio.setStation(5);

        long expected = 4;

        radio.prevStation();
        long actual = radio.getStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void prevStationCurrentStationIsMinShouldSetMax() {
        Radio radio = new Radio();
        radio.setStation(0);

        long expected = 9;
        radio.prevStation();
        long actual = radio.getStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldReturnInitialVolume() {
        Radio radio = new Radio();

        long expected = 0;
        long actual = radio.getVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void incVolumeShouldIncreaseVolumeBy1() {
        Radio radio = new Radio();

        long expected = 1;
        radio.increaseVolume();
        long actual = radio.getVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void incVolume101TimesVolumeShouldBe100() {
        Radio radio = new Radio();

        long expected = 100;

        for (int i = 0; i < 101; i++) {
            radio.increaseVolume();
        }

        long actual = radio.getVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void decVolumeShouldDecreaseVolumeBy1() {
        Radio radio = new Radio();

        // Увеличить громкость, чтобы проверить уменьшение в пределах допустимых значений
        radio.increaseVolume();
        radio.increaseVolume();


        long expected = 1;
        radio.decreaseVolume();
        long actual = radio.getVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void DecVolumeIfCurrentVolumeIs0ShouldBe0() {
        Radio radio = new Radio();

        long expected = 0;
        radio.decreaseVolume();
        long actual = radio.getVolume();

        Assertions.assertEquals(expected, actual);
    }
}
