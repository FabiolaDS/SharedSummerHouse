package client.view.manageSummerhouseView.viewsummerhouse;

import client.core.ViewHandler;
import client.core.ViewModelFactory;

public class MainViewController
{
  private ViewHandler viewHandler;
  private ViewModelFactory vmf;
  private  MainViewModel mvm;

  public MainViewController(){}

  public void init(ViewHandler viewHandler, ViewModelFactory vmf)
  {
    this.viewHandler = viewHandler;
    this.vmf = vmf;

  }
}
