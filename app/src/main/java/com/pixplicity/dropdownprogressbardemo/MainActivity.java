package com.pixplicity.dropdownprogressbardemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.akexorcist.roundcornerprogressbar.TextRoundCornerProgressBar;

public class MainActivity extends AppCompatActivity implements Spinner.OnItemSelectedListener{

    TextRoundCornerProgressBar mProgressBarA, mProgressBarB;
    Spinner mSpinner;
    int aa=5, ab=12, ac = 16, ba=30, bb=65, bc=36;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBarA = (TextRoundCornerProgressBar) findViewById(R.id.progress_bar_a);
        mProgressBarB = (TextRoundCornerProgressBar) findViewById(R.id.progress_bar_b);
        mSpinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ages_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);
        mSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        if (position ==0){
            // 18-24
            mProgressBarA.setProgress(aa);
            mProgressBarA.setProgressText(aa+"%");
            mProgressBarB.setProgress(ba);
            mProgressBarB.setProgressText(ba+"%");
        }else if (position == 1){
            // 25-45
            mProgressBarA.setProgress(ab);
            mProgressBarA.setProgressText(ab+"%");
            mProgressBarB.setProgress(bb);
            mProgressBarB.setProgressText(bb+"%");
        }else {
            // 45+
            mProgressBarA.setProgress(ac);
            mProgressBarA.setProgressText(ac+"%");
            mProgressBarB.setProgress(bc);
            mProgressBarB.setProgressText(bc+"%");
        }
        Log.v("Position", String.valueOf(position));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
