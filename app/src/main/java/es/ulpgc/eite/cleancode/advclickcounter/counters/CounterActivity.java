package es.ulpgc.eite.cleancode.advclickcounter.counters;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.eite.cleancode.advclickcounter.R;
import es.ulpgc.eite.cleancode.advclickcounter.app.CounterData;

public class CounterActivity
    extends AppCompatActivity implements CounterContract.View {

  public static String TAG = CounterActivity.class.getSimpleName();

  private CounterContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_counter);
    getSupportActionBar().setTitle(R.string.app_name);

    // do the setup
    CounterScreen.configure(this);

    if (savedInstanceState == null) {
      presenter.onStart();

    } else {
      presenter.onRestart();
    }
  }

  @Override
  protected void onResume() {
    super.onResume();

    // load the data
    presenter.onResume();
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();

    presenter.onBackPressed();
  }

  @Override
  protected void onPause() {
    super.onPause();

    presenter.onPause();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();

    presenter.onDestroy();
  }

  @Override
  public void onDataUpdated(CounterViewModel viewModel) {
    //Log.e(TAG, "onDataUpdated()");

    // deal with the datasource
    ((ListView) findViewById(R.id.counterList)).setAdapter(new CounterAdapter(
            this, viewModel.datasource, new View.OnClickListener() {

          @Override
          public void onClick(View view) {
            CounterData counter = (CounterData) view.getTag();

          }
        })
    );
  }

  @Override
  public void injectPresenter(CounterContract.Presenter presenter) {
    this.presenter = presenter;
  }

  public void onCounterButtonPressed(View view) {
    presenter.onCounterButtonPressed();
  }
}
