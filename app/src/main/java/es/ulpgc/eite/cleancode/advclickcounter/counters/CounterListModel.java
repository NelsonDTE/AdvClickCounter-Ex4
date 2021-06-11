package es.ulpgc.eite.cleancode.advclickcounter.counters;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.advclickcounter.data.CounterData;

public class CounterListModel implements CounterListContract.Model {

  public static String TAG = CounterListModel.class.getSimpleName();


  private List<CounterData> data;
  private Integer values;


  public CounterListModel() {
    data= new ArrayList<>();
    values=0;

  }

  @Override
  public Integer getStoredData() {
    // Log.e(TAG, "getStoredData()");
    return values;
  }

  @Override
  public void onRestartScreen(List<CounterData> data, Integer values) {
    // Log.e(TAG, "onRestartScreen()");
    this.data = data;
    this.values = values;

  }

  @Override
  public void onDataFromNextScreen(CounterData data, Integer values) {
    // Log.e(TAG, "onDataFromNextScreen()");
    Log.e(TAG, "data: "+data);

    this.values=values;
    data.set(data.indexOf(data), data);
  }

  @Override
  public void onDataFromPreviousScreen(CounterData data, Integer values) {
    // Log.e(TAG, "onDataFromPreviousScreen()");
    Log.e(TAG, "data: "+data);

    this.values=values;
    data.set(data.indexOf(data), data);
  }
}
