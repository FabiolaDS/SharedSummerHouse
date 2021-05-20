package server.model.summerhouses;

import shared.domain.SummerHouse;
import shared.transferobjects.User;
import shared.util.PropertyChangeSubject;

public interface ServerManageSummerhouses extends PropertyChangeSubject
{
  SummerHouse addSummerHouse(SummerHouse summerHouse);
}
