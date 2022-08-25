package Lotto;

import java.util.ArrayList;
import java.util.Scanner;

public class LottoTicket {
    //Class Attributes
    private int numberOfValues;
    private int maxValue;
    ArrayList<Integer> lottoNumberList;
    //Constructor
    public LottoTicket(int numberOfValues, int maxValue) {
        setNumberOfValues(numberOfValues);
        setMaxValue(maxValue);
        //Create an Array List for the random lotto numbers
        lottoNumberList = new ArrayList<>();
        int randomValue;
        //Get random numbers and populate lottoNumberList
        for(int index = 1; index <=numberOfValues; index++){
            //Get random value
            randomValue = getRandomNumber(1,maxValue);
            //Add Random value to arrayList
            lottoNumberList.add(randomValue);
        }
    }
    //Setters
    public void setNumberOfValues(int numberOfValues) {
        this.numberOfValues = numberOfValues;
    }
    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }
    //Getters
    public int getNumberOfValues() {
        return numberOfValues;
    }
    public int getMaxValue() {
        return maxValue;
    }
    //Other Values
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    public void printLottoArray()
    {

        for(int lottoNumber: lottoNumberList)
        {
            System.out.println(lottoNumber);
        }

    }
    public boolean isWinner(LottoTicket testTicket)
    {
        // compare ArrayList1 with ArrayList2
        if (this.lottoNumberList.equals(testTicket.lottoNumberList) == true) {
            return true;
        }
        else
        {
            return false;
        }
    }
} //End class LottoTicket


