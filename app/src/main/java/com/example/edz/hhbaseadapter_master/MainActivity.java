package com.example.edz.hhbaseadapter_master;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.recylevieadapter.OnItemClickListner;
import com.example.recylevieadapter.OnItemLongClickListner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Person> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyleview);


        initdata();
        TestAdapter testAdapter = new TestAdapter(MainActivity.this, R.layout.item, list,R.layout.header,R.layout.bottom);
        recyclerView.setAdapter(testAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, OrientationHelper.VERTICAL, false));

        testAdapter.setOnItemClickListner(new OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                Toast.makeText(MainActivity.this, "点击", Toast.LENGTH_SHORT).show();
            }
        });

        testAdapter.setOnItemLongClickListner(new OnItemLongClickListner() {
            @Override
            public void onItemLongClickListner(View v, int position) {
                Toast.makeText(MainActivity.this, "长按", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void initdata() {
        for (int i = 0; i < 50; i++) {
            Person person = new Person();
            person.age = i;
            person.name = "huhai" + i;
            person.type = i;
            list.add(person);
        }
    }
}
