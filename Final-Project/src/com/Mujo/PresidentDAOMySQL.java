package com.Mujo;

import java.util.List;

 public class PresidentDAOMySQL implements PresidentDAO{

  private static List<President> presidents;
  @Override
  public void readInData() throws DataException {

  }

  @Override
  public void verifyPresidentList() throws DataException {

  }

  @Override
  public void createPresidentRecord(President president) {

  }

  public President getPresidentbyfirstName(String firstname) {
   President president = null;

   return president;

  }

  public President getPresidentbylastName(String lastname) {
   President president = null;

   return president;

  }

  @Override
  public List<President> getAllPresidents() throws DataException {
   List<President> pres = null;

   return pres;
  }

  @Override
  public void updatePresident(President original, President updated) throws DataException {

  }

  @Override
  public void deletePresident(President president) throws DataException {

  }
 }




