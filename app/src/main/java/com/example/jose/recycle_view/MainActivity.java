package com.example.jose.recycle_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCantante;
    private RecyclerViewAdaptador adaptadorCantante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCantante = (RecyclerView)findViewById(R.id.recyclerCantante);
        recyclerViewCantante.setLayoutManager(new LinearLayoutManager(this));

        adaptadorCantante = new RecyclerViewAdaptador(obtenerCantante());
        recyclerViewCantante.setAdapter(adaptadorCantante);

        final GestureDetector mGestureDetector = new GestureDetector(MainActivity.this, new GestureDetector.SimpleOnGestureListener() {
            @Override public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });

        recyclerViewCantante.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                try {
                    View child = rv.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && mGestureDetector.onTouchEvent(e)) {
                        int posicion = rv.getChildAdapterPosition(child);
                        Toast.makeText(MainActivity.this, "Clicado " + posicion, Toast.LENGTH_LONG).show();
                        return true;
                    }
                }catch (Exception ex){
                        ex.printStackTrace();
                    }


                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
    }



    public List<CantanteModelo> obtenerCantante(){
        List<CantanteModelo> cantante = new ArrayList<>();
        cantante.add(new CantanteModelo("stewie","majo",R.drawable.stewie));
        cantante.add(new CantanteModelo("peter","gordo",R.drawable.peter));
        cantante.add(new CantanteModelo("stewie","majo",R.drawable.stewie));
        cantante.add(new CantanteModelo("peter","gordo",R.drawable.peter));

        return cantante;
    }
}
