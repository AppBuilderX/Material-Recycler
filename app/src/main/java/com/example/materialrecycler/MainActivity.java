package com.example.materialrecycler;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ModleSheet[] myListData = new ModleSheet[] {
                new ModleSheet("Email", android.R.drawable.ic_dialog_email),
                new ModleSheet("Audio", R.drawable.baseline_audiotrack_24),
                new ModleSheet("Battery", R.drawable.baseline_battery_charging_full_24),
                new ModleSheet("Done", R.drawable.baseline_download_done_24),
                new ModleSheet("Duo", R.drawable.baseline_duo_24),
                new ModleSheet("Emoji", R.drawable.baseline_emoji_emotions_24),
                new ModleSheet("Extension", R.drawable.baseline_extension_24),
                new ModleSheet("Download", R.drawable.baseline_file_download_24),
                new ModleSheet("Filter", R.drawable.baseline_filter_alt_24),
                new ModleSheet("Android", R.drawable.ic_launcher_foreground),

        };

        recyclerView = findViewById(R.id.recycle_view);
      MyAdapter adapter = new MyAdapter(myListData);
      recyclerView.setHasFixedSize(true);
      GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
      layoutManager.setOrientation(RecyclerView.VERTICAL);
      recyclerView.setLayoutManager(layoutManager);
      recyclerView.setAdapter(adapter);

        }
}