package e.otatt.cs3270a3;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements Game.OnItemSelectedListener{
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Game game = new Game();
        Result result = new Result();
        fragmentTransaction.add(R.id.frameContainerA, game);
        fragmentTransaction.add(R.id.frameContainerB, result);
        fragmentTransaction.commit();

    }

    @Override
    public void onGamePlayed(int i) {

        Result result = (Result) getSupportFragmentManager().
                findFragmentById(R.id.frameContainerB);
        result.gameResult(i);
    }
}
