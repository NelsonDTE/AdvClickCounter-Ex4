package es.ulpgc.eite.cleancode.advclickcounter.counters;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.advclickcounter.data.CounterData;

public interface CounterListContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void onDataUpdated(CounterListViewModel viewModel);
    void navigateToNextScreen();

  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);

    void onResume();
    void onStart();
    void onRestart();
    void onBackPressed();
    void onPause();
    void onDestroy();
    void onCounterButtonPressed();
  }

  interface Model {
    Integer getStoredData();

    void onDataFromNextScreen(CounterData data, Integer values);
    void onRestartScreen(List<CounterData> data, Integer values);
    void onDataFromPreviousScreen(CounterData data, Integer values);
  }

}
