package server.model.summerhouses;

import shared.domain.SummerHouse;
import shared.util.PropertyChangeSubject;

import java.util.ArrayList;

public interface ServerManageSummerhouses extends PropertyChangeSubject
{
  SummerHouse addSummerHouse(SummerHouse summerHouse);
  ArrayList<SummerHouse> getSummerHouses();
}
