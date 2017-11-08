package se.kth.roberto.boardgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout mLinearLayout = new LinearLayout(this);
        BoardView bw = new BoardView(this);

        mLinearLayout.addView(bw);
        setContentView(mLinearLayout);

        // setContentView(R.layout.activity_main);
    }
}
