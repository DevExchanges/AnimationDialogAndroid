package devexchanges.info.animationdialog;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        View btnShowDialog = findViewById(R.id.btn_show_dialog);
        View btnShowDialog2 = findViewById(R.id.btn_show_dialog_2);
        View btnShowDialog3 = findViewById(R.id.btn_show_dialog_3);
        View btnShowDialog4 = findViewById(R.id.btn_show_dialog_4);

        btnShowDialog.setOnClickListener(onClickListener(1));
        btnShowDialog2.setOnClickListener(onClickListener(2));
        btnShowDialog3.setOnClickListener(onClickListener(3));
        btnShowDialog4.setOnClickListener(onClickListener(4));
    }

    private View.OnClickListener onClickListener(final int style) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (style == 1) {
                    buildDialog(R.style.DialogTheme, "Left - Right Animation!");
                } else if (style == 2) {
                    buildDialog(R.style.DialogAnimation, "Fade In - Fade Out Animation!");
                } else if (style == 3) {
                    buildDialog(R.style.DialogAnimation_2, "Up - Down Animation!");
                } else {
                    buildDialog(0, "Normal Dialog (no animation)");
                }
            }
        };
    }

    private void buildDialog(int animationSource, String type) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Animation Dialog");
        builder.setMessage(type);
        builder.setNegativeButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.getWindow().getAttributes().windowAnimations = animationSource;
        dialog.show();
    }
}
