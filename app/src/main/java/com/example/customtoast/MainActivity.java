package com.example.customtoast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button containerButton = findViewById(R.id.container_button);
        Button inactiveIconButton = findViewById(R.id.inactive_icon_button);
        Button inactiveTextButton = findViewById(R.id.inactive_text_button);
        Button activeIconButton = findViewById(R.id.active_icon_button);
        Button activeTextButton = findViewById(R.id.active_text_button);

        containerButton.setOnClickListener(new ContainerButtonHandler());
        inactiveIconButton.setOnClickListener(new InactiveIconHndler());
        inactiveTextButton.setOnClickListener(new InactiveTextHandler());
        activeIconButton.setOnClickListener(new ActiveIconHandler());
        activeTextButton.setOnClickListener(new ActiveTextHandler());
    }

    private void generateToast(String number, String description){
        LayoutInflater li = getLayoutInflater();
        View v = li.inflate(R.layout.toast, null);
        TextView numberView = v.findViewById(R.id.digit_display);
        TextView descriptionView = v.findViewById(R.id.description);
        numberView.setText(number);
        descriptionView.setText(description);

        Toast t = new Toast(getApplicationContext());
        t.setDuration(Toast.LENGTH_LONG);
        t.setView(v);
        t.show();
    }

    private class ContainerButtonHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            generateToast("1", "Container of bottom navigation");
        }
    }

    private class InactiveIconHndler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            generateToast("2", "View for icon where is not active");
        }
    }

    private class InactiveTextHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            generateToast("3", "View for text where is not active");
        }
    }

    private class ActiveIconHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            generateToast("4", "View for icon where is active");
        }
    }

    private class ActiveTextHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            generateToast("5", "View for text where is active");
        }
    }
}
