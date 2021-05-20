package server.model.summerhouses;

import shared.domain.SummerHouse;
import shared.transferobjects.User;
import shared.util.PropertyChangeSubject;

import java.util.ArrayList;

public interface ServerManageSummerhouses extends PropertyChangeSubject
{
  SummerHouse addSummerHouse(SummerHouse summerHouse);
  ArrayList<SummerHouse> getSummerHouses();
}
