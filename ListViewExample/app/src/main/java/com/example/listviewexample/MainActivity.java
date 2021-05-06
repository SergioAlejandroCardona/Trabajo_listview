package com.example.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listviewexample.Models.Car;
import com.ib.custom.toast.CustomToastView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    private ListView LvNames;
    private Button btAgragarOtro;
    private Button btEliminar;

    MyDbHelper db1 = new MyDbHelper(this);

    private ArrayList<Car> listCars = new ArrayList<Car>();
   // private String[] Names = {"Sergio", "Alejandro", "Yohana"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LvNames = findViewById(R.id.lvNames);
        btAgragarOtro = findViewById(R.id.btnAgregarOtro);
        btEliminar = findViewById(R.id.BtnDelete);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Names);

//        Car c = new Car("Ford Mustang", "2000", "2021", "140000000",null);
//        listCars.add(new Car("Ford Mustang", "2000", "2021", "140000000",null));
//        listCars.add(new Car("Camaro", "2000", "2021", "140000000",null));
//        listCars.add(new Car("Cobra", "2000", "1996", "140000000",null));

//        Intent intent = getIntent();
//        listCars = (ArrayList<Car>) intent.getSerializableExtra("Cars");
        listCars = db1.selectCar(db1.getWritableDatabase());

        AdapterCar adapter = new AdapterCar(this, listCars);
        LvNames.setAdapter(adapter);
        LvNames.setOnItemClickListener(this);

        btAgragarOtro.setOnClickListener(this);
        btEliminar.setOnClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        CustomToastView.makeInfoToast(this, "Ha pulsado el carro " + listCars.get(position).getName(), R.layout.custom_toast).show();
        return;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAgregarOtro){
            Intent MyIntent = new Intent(this, AddCar.class);
            startActivity(MyIntent);
        }

        if (v.getId() == R.id.BtnDelete){
            db1.deleteAll();
            CustomToastView.makeInfoToast(this, "Lista Eliminada ", R.layout.custom_toast).show();
        }
    }
}