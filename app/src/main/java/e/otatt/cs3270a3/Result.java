package e.otatt.cs3270a3;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Result extends Fragment {
    private int gameCount, phoneWins, playerWins, ties;


    public Result() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        Button reset = view.findViewById(R.id.btnReset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.d("Button Click: Reset", "Reset");
                resetCounts();
                Context context = getContext().getApplicationContext();
                CharSequence text = "Counts are reset";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        return view;
    }

    public void gameResult(int i){
//        Log.d("games played", "Games: " + gameCount);
        gameCount = gameCount + 1;
        TextView txtGamesPlayed = getView().findViewById(R.id.txtGamesPlayed);
        txtGamesPlayed.setText(String.valueOf(gameCount));
        if (i == 0){
            ties = ties + 1;
            TextView txt = getView().findViewById(R.id.txtTies);
            txt.setText(String.valueOf(ties));
        }
        else if(i == 1){
            phoneWins = phoneWins + 1;
            TextView txt = getView().findViewById(R.id.txtPhoneWins);
            txt.setText(String.valueOf(phoneWins));
        }
        else{
            playerWins = playerWins + 1;
            TextView txt = getView().findViewById(R.id.txtMyWins);
            txt.setText(String.valueOf(playerWins));
        }

    }

    public void resetCounts(){
        TextView txt;
        txt = getView().findViewById(R.id.txtTies);
        txt.setText("0");
        txt = getView().findViewById(R.id.txtPhoneWins);
        txt.setText("0");
        txt = getView().findViewById(R.id.txtMyWins);
        txt.setText("0");
        txt = getView().findViewById(R.id.txtGamesPlayed);
        txt.setText("0");
        gameCount = 0;
        phoneWins = 0;
        playerWins = 0;
        ties = 0;
    }



}
