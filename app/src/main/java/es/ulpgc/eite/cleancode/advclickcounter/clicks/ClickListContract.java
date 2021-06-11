package es.ulpgc.eite.cleancode.advclickcounter.clicks;

import java.lang.ref.WeakReference;



import es.ulpgc.eite.cleancode.advclickcounter.data.CounterData;

public interface ClickListContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void onDataUpdated(ClickListViewModel viewModel);
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

    void onClickButtonPressed();
  }

  interface Model {
    CounterData getStoredData();
    void onDataFromNextScreen(CounterData data, Integer number);
    void onRestartScreen(CounterData data, Integer values);
    void onDataFromPreviousScreen(CounterData data, Integer values);
  }

}
