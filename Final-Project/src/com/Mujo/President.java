package com.Mujo;

import java.time.LocalDate;

public class President extends Person {
    private int inaugurationAge_Years;
    private int inaugurationAge_Days;
    public static final int MAXIMUM_YEARS = 100;
    public static final int MINIMUM_YEARS = 35;
    public static final int MAXIMUM_DAYS = 365;
    public static final int MINIMUM_DAYS = 1;

    public President(String firstName, String lastName, LocalDate bday) {
        inaugurationAge_Years = 35;
        inaugurationAge_Days = 1;
        setFirstName(firstName);
        setLastName(lastName);
        setBirthday(bday);
    }

    public President(String firstName, String lastName, LocalDate birthday, int inaugurationAge_Years, int inaugurationAge_Days) {
        setFirstName(firstName);
        setLastName(lastName);
        setBirthday(birthday);
        setInaugurationAge_Years(inaugurationAge_Years);
        setInaugurationAge_Days(inaugurationAge_Days);
    }
    private boolean validateYearsAge(int years){
        if(years > MAXIMUM_YEARS || years < MINIMUM_YEARS )
        {
            return false;
        }
        return true;
    }
    private boolean validateDaysAge(int days){
        if( days > MAXIMUM_DAYS || days <  MINIMUM_DAYS)
        {
            return false;
        }
        return true;
    }
    public int getInaugurationAge_Years() {
        return inaugurationAge_Years;
    }

    public void setInaugurationAge_Years(int inaugurationAge_Years) {
        if (validateYearsAge(inaugurationAge_Years)){
            this.inaugurationAge_Years = inaugurationAge_Years;
        }else{
            throw new IllegalArgumentException("inaugurationAge_Years not valid");
        }

    }

    public int getInaugurationAge_Days() {
        return inaugurationAge_Days;
    }

    public void setInaugurationAge_Days(int inaugurationAge_Days) {
        if (validateDaysAge(inaugurationAge_Days)){
            this.inaugurationAge_Days = inaugurationAge_Days;
        }else{
            throw new IllegalArgumentException("inaugurationAge_Days not valid");
        }

    }

    @Override
    public String toString() {
        return "President{firstname=" + getFirstName() +
                ", lastname=" + getLastName() +
                ", birthday=" + getBirthday() +
                ", inaugurationAge_Years=" + inaugurationAge_Years +
                ", inaugurationAge_Days=" + inaugurationAge_Days +
                '}';
    }
    public int compareTo(President other) {
        // Order first by inaugurationAge_Years in descending order
        int result = (this.inaugurationAge_Years - other.inaugurationAge_Years) * -1;
        if(result == 0) {
            // Order second by inaugurationAge_Days in descending order
            result = (this.inaugurationAge_Days - other.inaugurationAge_Days) * -1;
            if(result == 0) {
                // Order third by lastName in ascending order
                result = getLastName().compareToIgnoreCase(other.getLastName());
            }
        }
        return result;
    }
}