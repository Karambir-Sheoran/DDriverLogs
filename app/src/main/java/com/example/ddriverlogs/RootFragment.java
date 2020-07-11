package com.example.ddriverlogs;


import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class RootFragment extends Fragment {

    private String loc = "";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.root_fragment, container, false);
        Button carr =  view.findViewById(R.id.car);
        Button t5truck = view.findViewById(R.id.t5truck);
        Button t10truck =  view.findViewById(R.id.t10truck);
        Button tipper =  view.findViewById(R.id.tipper);
        Button articulated =  view.findViewById(R.id.articulated);
        final car_fragment obj = new car_fragment();

        if (getArguments() != null) {
            loc = getArguments().getString("karam");
        }

        carr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("karamb", "Car&"+ loc);
                obj.setArguments(args);
                assert getFragmentManager() != null;
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.main_frag, obj,"car_frag").addToBackStack(null);
                ft.commit();
            }
        });

        t5truck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("karamb", "5T Truck&"+ loc);
                obj.setArguments(args);
                assert getFragmentManager() != null;
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.main_frag, obj).addToBackStack(null);
                ft.commit();
            }
        });
        t10truck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("karamb", "10T Truck&"+ loc);
                obj.setArguments(args);
                assert getFragmentManager() != null;
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.main_frag, obj).addToBackStack(null);
                ft.commit();
            }
        });
        tipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("karamb", "Tipper&"+ loc);
                obj.setArguments(args);
                assert getFragmentManager() != null;
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.main_frag, obj).addToBackStack(null);
                ft.commit();
            }
        });
        articulated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("karamb", "Articulated&"+ loc);
                obj.setArguments(args);
                assert getFragmentManager() != null;
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.main_frag, obj).addToBackStack(null);
                ft.commit();
            }
        });
        return view;
    }

}
