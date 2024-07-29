package com.example.last_home_work;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.last_home_work.scrol1.SKROL1;
import com.example.last_home_work.scrol2.SKROL2;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    private ArrayList<Container2> container2List;
    private SKROL2 adapter2;
    private RecyclerView recyclerView2;
    private RecyclerView recyclerView;
    private SKROL1 adapter;
    private ArrayList<Container1> containerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

        recyclerView2 = findViewById(R.id.recyclerView2);
        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(layoutManager2);

        ArrayList<Container1> data1 = new ArrayList<>();
        ArrayList<Container2> data2 = new ArrayList<>();
        data1.add(new Container1("ChickenBurger", "20$", "https://vkusnotochkamenu.ru/image/cache/catalog/photo/799220868-skandinavskij-burger-600x600.png", "https://pngicon.ru/file/uploads/zvezda.png", "https://pngicon.ru/file/uploads/zvezda.png", "https://pngicon.ru/file/uploads/zvezda.png", "https://pngicon.ru/file/uploads/zvezda.png", "https://pngicon.ru/file/uploads/zvezda.png"));
        data1.add(new Container1("Base Burger", "10$", "https://vkusnotochkamenu.ru/image/cache/catalog/photo/799220868-skandinavskij-burger-600x600.png", "https://pngicon.ru/file/uploads/zvezda.png", "https://pngicon.ru/file/uploads/zvezda.png", "https://pngicon.ru/file/uploads/zvezda.png", "https://pngicon.ru/file/uploads/zvezda.png", "https://pngicon.ru/file/uploads/zvezda.png"));
        data1.add(new Container1("Base Burger1", "30$", "https://vkusnotochkamenu.ru/image/cache/catalog/photo/799220868-skandinavskij-burger-600x600.png", "https://pngicon.ru/file/uploads/zvezda.png", "https://pngicon.ru/file/uploads/zvezda.png", "https://pngicon.ru/file/uploads/zvezda.png", "https://pngicon.ru/file/uploads/zvezda.png", "https://pngicon.ru/file/uploads/zvezda.png"));
        data1.add(new Container1("Base Burger2", "25$", "https://vkusnotochkamenu.ru/image/cache/catalog/photo/799220868-skandinavskij-burger-600x600.png", "https://pngicon.ru/file/uploads/zvezda.png", "https://pngicon.ru/file/uploads/zvezda.png", "https://pngicon.ru/file/uploads/zvezda.png", "https://pngicon.ru/file/uploads/zvezda.png", "https://pngicon.ru/file/uploads/zvezda.png"));

        data2.add(new Container2("https://cdn-icons-png.flaticon.com/512/6488/6488946.png", "Hamburger"));
        data2.add(new Container2("https://cdn-icons-png.flaticon.com/512/1046/1046873.png", "Pizza"));
        data2.add(new Container2("https://cdn-icons-png.flaticon.com/512/4327/4327337.png", "Chicken"));

        adapter2 = new SKROL2(data2);
        adapter = new SKROL1(data1);

        recyclerView.setAdapter(adapter);
        recyclerView2.setAdapter(adapter2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}