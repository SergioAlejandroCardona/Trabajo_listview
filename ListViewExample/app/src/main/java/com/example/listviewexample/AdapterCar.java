package com.example.listviewexample;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listviewexample.Models.Car;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterCar extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<Car> Cars;

    public AdapterCar(Activity activity, ArrayList<Car> cars) {
        this.activity = activity;
        Cars = cars;
    }

    public void AddCar(Car car){
        Cars.add(car);
    }

    public void AddCar(ArrayList<Car> carsElements){
        Cars.addAll(carsElements);
    }

    @Override
    public int getCount() {
        return Cars.size();
    }

    @Override
    public Object getItem(int position) {
        return Cars.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if (convertView == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.car_item,null);
        }

        Car carElement = Cars.get(position);

        TextView nameCar = v.findViewById(R.id.CarName);
        nameCar.setText(carElement.getName());

        TextView ccCar = v.findViewById(R.id.CarCC);
        ccCar.setText(carElement.getCC());

        TextView modelCar = v.findViewById(R.id.CarModel);
        modelCar.setText(carElement.getModel());

        TextView valueCar = v.findViewById(R.id.CarValue);
        valueCar.setText(carElement.getValue());


        ImageView imageCar = v.findViewById(R.id.CarImageView);

        Picasso.get()
                .load(carElement.getUrl())
                //.resize(10,10)
                .error(R.mipmap.ic_launcher_round)
                .into(imageCar);

        return v;
    }
}
