package com.pavelsikun.materialdesignicons.sample;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel Sikun on 07.06.16.
 */

public class MainActivity extends AppCompatActivity implements MenuItem.OnMenuItemClickListener {

    private RecyclerView recycler;
    private List<Pair<Integer, String>> items;
    private R.drawable drawableRes = new R.drawable();

    private IconGridAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();
        adapter = new IconGridAdapter(items);

        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setLayoutManager(new GridLayoutManager(this, 3));
        recycler.setAdapter(adapter);

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                for(Field f : R.drawable.class.getDeclaredFields()) {
                    if (f.getName().startsWith("zzz_")) {
                        try {
                            adapter.add(new Pair<>(f.getInt(drawableRes), f.getName()));
                        }
                        catch (Exception e) {
                            Log.e(getClass().getSimpleName(), "exception! " + e.getMessage());
                        }
                    }
                }
                return null;
            }
        }.execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Drawable icon = ContextCompat.getDrawable(this, R.drawable.zzz_github);
        icon.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP); //manual tinting

        MenuItem item = menu.add("View on github")
                .setIcon(icon)
                .setOnMenuItemClickListener(this);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        String url = "https://github.com/MrBIMC/MaterialDesignIcons/";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
        return true;
    }
}
