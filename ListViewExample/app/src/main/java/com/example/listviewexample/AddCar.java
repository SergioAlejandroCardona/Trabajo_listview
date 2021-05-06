package com.example.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.listviewexample.Models.Car;
import com.ib.custom.toast.CustomToastView;

import java.io.Serializable;

public class AddCar extends AppCompatActivity implements View.OnClickListener {

    private EditText etNombre;
    private EditText etValor;
    private EditText etModelo;
    private EditText etCc;
    private EditText etUrl;
    private Button btAgregar;
    private Button btLista;

    MyDbHelper db = new MyDbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        etNombre = findViewById(R.id.txtNombre);
        etValor = findViewById(R.id.txtValor);
        etModelo = findViewById(R.id.txtModelo);
        etCc = findViewById(R.id.txtCc);
        etUrl = findViewById(R.id.txtUrl);
        btAgregar = findViewById(R.id.btnAgregar);
        btLista = findViewById(R.id.btnLista);

        btAgregar.setOnClickListener(this);
        btLista.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAgregar){

            String nombre = etNombre.getText().toString();
            String valor = etValor.getText().toString();
            String modelo = etModelo.getText().toString();
            String cc = etCc.getText().toString();
            String url = etUrl.getText().toString();

            if(nombre.isEmpty()){
                CustomToastView.makeInfoToast(this, "Error al validar el Nombre", R.layout.custom_toast).show();
                return;
            }
            if(valor.isEmpty()){
                CustomToastView.makeInfoToast(this, "Error al validar el Valor", R.layout.custom_toast).show();
                return;
            }
            if(modelo.isEmpty()){
                CustomToastView.makeInfoToast(this, "Error al validar el Modelo", R.layout.custom_toast).show();
                return;
            }
            if(cc.isEmpty()){
                CustomToastView.makeInfoToast(this, "Error al validar la Cilindrada", R.layout.custom_toast).show();
                return;
            }
            if(url.isEmpty()){
                CustomToastView.makeInfoToast(this, "Error al validar La Url", R.layout.custom_toast).show();
                return;
            }

            AgregarCarro();
            LimpiarCampos();
            CustomToastView.makeSuccessToast(this, "Carro agregado con éxito", R.layout.custom_toast).show();
        }

        if (v.getId() == R.id.btnLista){
            Intent IntentList = new Intent(this, MainActivity.class);
            //IntentList.putExtra("Cars", (Serializable) db.selectCar(db.getWritableDatabase()));
            startActivity(IntentList);
        }
    }


    public void LimpiarCampos(){
        etNombre.setText("");
        etValor.setText("");
        etModelo.setText("");
        etCc.setText("");
        etUrl.setText("");
        etNombre.requestFocus();
    }

    public void AgregarCarro(){

        Car carro = new Car(etNombre.getText().toString(),etValor.getText().toString(),
                etModelo.getText().toString(),etCc.getText().toString(),etUrl.getText().toString());

        db.insertCars(db.getWritableDatabase(),carro);

    }

}