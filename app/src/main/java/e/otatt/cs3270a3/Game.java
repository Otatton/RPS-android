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

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class Game extends Fragment {
    private OnItemSelectedListener listener;

    public Game() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_game, container, false);


        Button btnRock = view.findViewById(R.id.btnRock);
        btnRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.d("Button Click: Rock", "Rock");
                runGame(0, getComputer());
                changeColor(0);
            }
        });

        Button btnPaper = view.findViewById(R.id.btnPaper);
        btnPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.d("Button Click: Paper", "Paper");

                runGame(1, getComputer());
                changeColor(1);
            }
        });

        Button btnScissors = view.findViewById(R.id.btnScissors);
        btnScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.d("Button Click: Scissors", "Scissors");
                runGame(2, getComputer());
                changeColor(2);
            }
        });

        return view;

    }

    public interface OnItemSelectedListener {
        public void onGamePlayed(int result);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement MyListFragment.OnItemSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public void runGame(int p, int c){
        TextView txtResult = getView().findViewById(R.id.txtResult);
        TextView txtPhone = getView().findViewById(R.id.txtPhonePick);
        String s[] = {"Rock", "Paper", "Scissors"};
        txtPhone.setText(s[c]);

        if(p == c){
            txtResult.setText("Its a Tie...");
            listener.onGamePlayed(0);
        }
        else if((p == 0 && c == 1) || (p == 1 && c == 2) || (p == 2 && c == 0)){
            txtResult.setText("Phone Wins...");
            listener.onGamePlayed(1);
        }
        else{
            txtResult.setText("You Win!");
            listener.onGamePlayed(2);
        }
    }

    public int getComputer(){
        Random rand = new Random();
        return rand.nextInt(3);
    }

    public void changeColor(int i){
        Button btn;
        btn = getView().findViewById(R.id.btnRock);
        btn.setBackgroundColor(getResources().getColor(R.color.button_material_light));
        btn.setTextColor(getResources().getColor(android.R.color.black));
        btn = getView().findViewById(R.id.btnPaper);
        btn.setBackgroundColor(getResources().getColor(R.color.button_material_light));
        btn.setTextColor(getResources().getColor(android.R.color.black));
        btn = getView().findViewById(R.id.btnScissors);
        btn.setBackgroundColor(getResources().getColor(R.color.button_material_light));
        btn.setTextColor(getResources().getColor(android.R.color.black));

        Button tmp;
        switch(i){
            case 0:
                tmp = getView().findViewById(R.id.btnRock);
                tmp.setBackgroundColor(getResources().getColor(R.color.button_material_dark));
                tmp.setTextColor(getResources().getColor(android.R.color.white));
                break;
            case 1:
                tmp = getView().findViewById(R.id.btnPaper);
                tmp.setBackgroundColor(getResources().getColor(R.color.button_material_dark));
                tmp.setTextColor(getResources().getColor(android.R.color.white));
                break;
            case 2:
                tmp = getView().findViewById(R.id.btnScissors);
                tmp.setBackgroundColor(getResources().getColor(R.color.button_material_dark));
                tmp.setTextColor(getResources().getColor(android.R.color.white));
                break;
            default:
                break;
        }
    }

}
