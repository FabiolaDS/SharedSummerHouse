package server.model.summerhouses;

import shared.domain.SummerHouse;
import shared.util.PropertyChangeSubject;

public interface ServerManageSummerhouses extends PropertyChangeSubject
{
  SummerHouse addSummerHouse(SummerHouse summerHouse);
}
