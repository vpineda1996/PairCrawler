package me.vpineda.database;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by vpineda1996 on 2015-05-20.
 */
public class Grades implements Serializable, Iterable<Integer> {
    private int[] grades = new int[10];
    private float average, standardDeviation;
    private int high, low, pass, fail, withdrew;

    public Grades() {
        int i;
        for(i = 0; i < grades.length; i++){
            grades[i] = 0;
        }
    }

    public enum Percentages{
        ZERO_NINE(0),TEN_NINETEEN(1),TWENTY_TWENTYNINE(2),THRTY_THRTYNINE(3),
        FOURTY_FOURTYNINE(4),FIFTY_FIFTYFOUR(5),FIFTYFIVE_FIFTYNINE(6),
        SIXTY_SIXTYTHREE(7),SIXTYFOUR_SIXTYSEVEN(8),SIXTYEIGHT_SEVENTYONE(9),
        SEVENTYTWO_SEVENTYFIVE(10), SEVENTYSIX_SEVENTYNINE(11), EIGHTY_EIGHTYFOUR(12),
        EIGHTYFIVE_EIGHTYNINE(13), NINETY_HUNDRED(14);

        private int arrayValue;
        Percentages(int arrayValue){
            this.arrayValue = arrayValue;
        }

        public int getArrayValue() {
            return arrayValue;
        }
    }

    public void set(Percentages position, int count) {
        switch (position.getArrayValue()){
            case 0: case 1: case 2: case 3: case 4:
                grades[position.getArrayValue()] = count;
                break;
            case 5: case 6:
                grades[5] += count;
                break;
            case 7: case 8: case 9:
                grades[6] += count;
                break;
            case 10: case 11:
                grades[7] += count;
                break;
            case 12: case 13:
                grades[8] += count;
                break;
            case 14:
                grades[9] = count;
                break;
        }
    }
    public void setAll(int array[]){
        int i = 0;
        for(int a : array){
            set(Percentages.values()[i++],a);
        }
    }

    public int get(Percentages position){
        int temp = 0;
        switch (position.getArrayValue()){
            case 0: case 1: case 2: case 3: case 4:
                temp = grades[position.getArrayValue()];
                break;
            case 5: case 6:
                temp = grades[5];
                break;
            case 7: case 8: case 9:
                temp = grades[6];
                break;
            case 10: case 11:
                temp = grades[7];
                break;
            case 12: case 13:
                temp = grades[8];
                break;
            case 14:
                temp = grades[9];
                break;
        }
        return temp;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public float getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(float standardDeviation) {
        this.standardDeviation = standardDeviation;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public int getFail() {
        return fail;
    }

    public void setFail(int fail) {
        this.fail = fail;
    }

    public int getWithdrew() {
        return withdrew;
    }

    public void setWithdrew(int withdrew) {
        this.withdrew = withdrew;
    }

    @Override
    public String toString() {
        return "Grades{" +
                "grades=" + Arrays.toString(grades) +
                ", average=" + average +
                ", standardDeviation=" + standardDeviation +
                ", high=" + high +
                ", low=" + low +
                ", pass=" + pass +
                ", fail=" + fail +
                ", withdrew=" + withdrew +
                '}';
    }

    @Override
    public Iterator<Integer> iterator() {
        return new GradesIterator(grades);
    }
    private static class GradesIterator implements Iterator<Integer>{

        private int currentPos;
        private int grades[];

        public GradesIterator(int[] grades) {
            this.grades = grades;
        }

        @Override
        public boolean hasNext() {
            return currentPos <= (grades.length - 1);
        }

        @Override
        public Integer next() {
            return grades[currentPos++];
        }
    }
}
