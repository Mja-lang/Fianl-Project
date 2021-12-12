package com.Mujo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


class PresidentTest {
    public President pres;

    @BeforeEach
    void setUp() {
        pres = new President("Muj", "Syg", LocalDate.of(1950, 01, 01)
                , 2000, 40);
    }

    @Test
    void getInaugurationAge_Years() {
        int expected = 2000;
        int actual = pres.getInaugurationAge_Years();
        assertEquals(expected, actual);
    }

    @Test
    void setInaugurationAge_YearsByBigNumber() {
        int badValue = 1950;
        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                pres.setInaugurationAge_Years(badValue);
            }
        });
        String expectedMessage = "inaugurationAge_Years not valid";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void setInaugurationAge_YearsByMinNumber() {
        int badValue = 25;
        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                pres.setInaugurationAge_Years(badValue);
            }
        });
        String expectedMessage = "inaugurationAge_Years not valid";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void setInaugurationAge_YearsGoodNumber() {
        int expected = 35;
        pres.setInaugurationAge_Years(expected);
        int actual = pres.getInaugurationAge_Years();
        assertEquals(expected, actual);
    }

    @Test
    void getInaugurationAge_Days() {
        int expected = 40;
        int actual = pres.getInaugurationAge_Days();
        assertEquals(expected, actual);
    }

    @Test
    void setInaugurationAge_Big_Days() {
        int badValue = 366;
        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                pres.setInaugurationAge_Days(badValue);
            }
        });
        String expectedMessage = "inaugurationAge_Days not valid";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void setInaugurationAge_Min_Days() {
        int badValue = 0;
        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                pres.setInaugurationAge_Days(badValue);
            }
        });
        String expectedMessage = "inaugurationAge_Days not valid";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void setInaugurationAge_Good_Days() {
        int expected = 360;
        pres.setInaugurationAge_Days(expected);
        int actual = pres.getInaugurationAge_Days();
        assertEquals(expected, actual);
    }
    @Test
    void getFirstname() {
        String expected = "Muj";
        String actual = pres.getFirstName();
        assertEquals(expected, actual);
    }
    @Test
    void setFirstname_Null() {
        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                pres.setFirstName(null);
            }
        });
        String expectedMessage = "first name can not be null";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
    @Test
    void setFirstname_Good() {
        String expected = "MG";
        pres.setFirstName(expected);
        String actual = pres.getFirstName();
        assertEquals(expected, actual);
    }
    @Test
    void getLastname() {
        String expected = "Syg";
        String actual = pres.getLastName();
        assertEquals(expected, actual);
    }
    @Test
    void setLastname_Null() {
        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                pres.setLastName(null);
            }
        });
        String expectedMessage = "Last name can not be null";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
    @Test
    void setLastname_Good() {
        String expected = "SSYY";
        pres.setLastName(expected);
        String actual = pres.getLastName();
        assertEquals(expected, actual);
    }
    @Test
    void getBirthday(){
        LocalDate expected = LocalDate.of(1950, 01, 01);
        LocalDate actual = pres.getBirthday();
        assertEquals(expected,actual);
    }
    @Test
    void setBirthday_Good(){
        LocalDate expected = LocalDate.of(1951, 01, 01);
        pres.setBirthday(expected);
        LocalDate actual = pres.getBirthday();
        assertEquals(expected,actual);
    }

    @Test
    void setBirthday_After_current_day() {
        Exception exception = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                pres.setBirthday(LocalDate.now().plusDays(3));
            }
        });
        String expectedMessage = "Data of birth not valid";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
    @Test
    void compareTo_same() {
        //String firstName, String lastName, LocalDate birthday,int inaugurationAge_Years, int inaugurationAge_Days
        President pres2 = new President("Muj", "Syg", LocalDate.of(1950, 01, 01)
                , 2000, 40);
        assertTrue(pres.compareTo(pres2) == 0);
    }
    @Test
    void compareTo_inaugurationAge_Years_A_Bigger() {
        //String firstName, String lastName, LocalDate birthday,int inaugurationAge_Years, int inaugurationAge_Days
        President pres2 = new President("Muj", "Syg", LocalDate.of(1950, 01, 01)
                , 2002, 40);
        assertTrue(pres.compareTo(pres2) > 0);
    }
    @Test
    void compareTo_inaugurationAge_Years_A_Smaller() {
        //String firstName, String lastName, LocalDate birthday,int inaugurationAge_Years, int inaugurationAge_Days
        President pres2 = new President("Muj", "Syg", LocalDate.of(1950, 01, 01)
                , 1999, 40);
        assertTrue(pres.compareTo(pres2) < 0);
    }
    @Test
    void compareTo_inaugurationAge_Days_A_Bigger() {
        //String firstName, String lastName, LocalDate birthday,int inaugurationAge_Years, int inaugurationAge_Days
        President pres2 = new President("Muj", "Syg", LocalDate.of(1950, 01, 01)
                , 2000, 44);
        assertTrue(pres.compareTo(pres2) > 0);
    }
    @Test
    void compareTo_inaugurationAge_Days_A_Smaller() {
        //String firstName, String lastName, LocalDate birthday,int inaugurationAge_Years, int inaugurationAge_Days
        President pres2 = new President("Muj", "Syg", LocalDate.of(1950, 01, 01)
                , 2000, 39);
        assertTrue(pres.compareTo(pres2) < 0);
    }
}