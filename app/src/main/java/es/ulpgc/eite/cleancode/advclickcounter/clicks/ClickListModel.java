package es.ulpgc.eite.cleancode.advclickcounter.clicks;

import android.util.Log;


import es.ulpgc.eite.cleancode.advclickcounter.data.CounterData;


public class ClickListModel implements ClickListContract.Model {

  public static String TAG = ClickListModel.class.getSimpleName();



  private CounterData data;
  private Integer values;



  @Override
  public CounterData getStoredData() {
    // Log.e(TAG, "getStoredData()");
    return data;
  }


  @Override
  public void onDataFromNextScreen(CounterData data, Integer values) {
    this.data = data;
    this.values = values;


  }

  @Override
  public void onRestartScreen(CounterData data, Integer values) {

    this.data = data;
    this.values = values;
  }

  @Override
  public void onDataFromPreviousScreen(CounterData data , Integer values) {
    this.data = data;
    this.values = values;

  }
}
