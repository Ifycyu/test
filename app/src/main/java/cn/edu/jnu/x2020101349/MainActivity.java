package cn.edu.jnu.x2020101349;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button button=this.findViewById(R.id.button_calculate);
        EditText textView_frame=this.findViewById(R.id.textView_frame);
        TextView textView_total=this.findViewById(R.id.textView_total);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = textView_frame.getText().toString();
                String[] split = s.split(",");
                Game game=new Game();
                for (int i = 0; i < split.length; i++) {
                    game.roll(Integer.parseInt(split[i]));
                }
                textView_total.setText("Total score is:"+game.score());

            }
        });
    }
}