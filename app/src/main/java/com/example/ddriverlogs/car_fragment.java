package com.example.ddriverlogs;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.provider.Settings;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Objects;


/**
 * A simple k007 {@link  Fragment} subclass.
 */
public class car_fragment extends Fragment {
    private String value;
    private String location = "";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_car_fragment, container, false);


        if (getArguments() != null) {
            value = getArguments().getString("karama");
            location = getArguments().getString("karamb");
        }
        assert location != null;
        String[] arr = location.split("&");
        location = arr[1];
        value = arr[0];

        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        final ListFragment list_obj = new ListFragment();
        final Button saveData = Objects.requireNonNull(getActivity()).findViewById(R.id.button4);
        final Button showData = getActivity().findViewById(R.id.button5);
        final Button startTime = getActivity().findViewById(R.id.button);
        final Button first_break = getActivity().findViewById(R.id.button1);
        final Button second_break = getActivity().findViewById(R.id.button2);
        final Button end_time = getActivity().findViewById(R.id.button3);
        final TextView start = getActivity().findViewById(R.id.textView);
        final EditText regoNo = getActivity().findViewById(R.id.editText1);
        final TextView first = getActivity().findViewById(R.id.textView1);
        final TextView second = getActivity().findViewById(R.id.textView2);
        final TextView end = getActivity().findViewById(R.id.textView3);
        final EditText driverName = getActivity().findViewById(R.id.editText);
        final TextView cat = getActivity().findViewById(R.id.carTitle);
        final Button next = getActivity().findViewById(R.id.button7);
        final Button previous = getActivity().findViewById(R.id.button6);

        if (value != null) {
            cat.setText(value);
        }
        next.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                String name = cat.getText().toString();
                switch (name) {
                    case "Car":
                        driverName.setText("");
                        regoNo.setText("");
                        cat.setText("5T Truck");
                        startTime.setText("Start Time");
                        startTime.setVisibility(View.VISIBLE);
                        first_break.setVisibility(View.VISIBLE);
                        second_break.setVisibility(View.VISIBLE);
                        end_time.setVisibility(View.VISIBLE);
                        start.setText("");
                        first.setText("");
                        second.setText("");
                        end.setText("");
                        break;
                    case "5T Truck":
                        driverName.setText("");
                        regoNo.setText("");
                        cat.setText("10T Truck");
                        startTime.setText("Start Time");
                        startTime.setVisibility(View.VISIBLE);
                        first_break.setVisibility(View.VISIBLE);
                        second_break.setVisibility(View.VISIBLE);
                        end_time.setVisibility(View.VISIBLE);
                        start.setText("");
                        first.setText("");
                        second.setText("");
                        end.setText("");
                        break;
                    case "10T Truck":
                        driverName.setText("");
                        regoNo.setText("");
                        cat.setText("Tipper");
                        startTime.setText("Start Time");
                        startTime.setVisibility(View.VISIBLE);
                        first_break.setVisibility(View.VISIBLE);
                        second_break.setVisibility(View.VISIBLE);
                        end_time.setVisibility(View.VISIBLE);
                        start.setText("");
                        first.setText("");
                        second.setText("");
                        end.setText("");
                        break;
                    case "Tipper":
                        driverName.setText("");
                        regoNo.setText("");
                        cat.setText("Articulated");
                        startTime.setText("Start Time");
                        startTime.setVisibility(View.VISIBLE);
                        first_break.setVisibility(View.VISIBLE);
                        second_break.setVisibility(View.VISIBLE);
                        end_time.setVisibility(View.VISIBLE);
                        start.setText("");
                        first.setText("");
                        second.setText("");
                        end.setText("");
                        break;
                    case "Articulated":
                        driverName.setText("");
                        regoNo.setText("");
                        cat.setText("Car");
                        startTime.setText("Start Time");
                        startTime.setVisibility(View.VISIBLE);
                        first_break.setVisibility(View.VISIBLE);
                        second_break.setVisibility(View.VISIBLE);
                        end_time.setVisibility(View.VISIBLE);
                        start.setText("");
                        first.setText("");
                        second.setText("");
                        end.setText("");
                        break;
                }
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                String name = cat.getText().toString();
                switch (name) {
                    case "Car":
                        driverName.setText("");
                        regoNo.setText("");
                        cat.setText("Articulated");
                        startTime.setText("Start Time");
                        startTime.setVisibility(View.VISIBLE);
                        first_break.setVisibility(View.VISIBLE);
                        second_break.setVisibility(View.VISIBLE);
                        end_time.setVisibility(View.VISIBLE);
                        start.setText("");
                        first.setText("");
                        second.setText("");
                        end.setText("");
                        break;
                    case "5T Truck":
                        driverName.setText("");
                        regoNo.setText("");
                        cat.setText("Car");
                        startTime.setText("Start Time");
                        startTime.setVisibility(View.VISIBLE);
                        first_break.setVisibility(View.VISIBLE);
                        second_break.setVisibility(View.VISIBLE);
                        end_time.setVisibility(View.VISIBLE);
                        start.setText("");
                        first.setText("");
                        second.setText("");
                        end.setText("");
                        break;
                    case "10T Truck":
                        driverName.setText("");
                        regoNo.setText("");
                        cat.setText("5T Truck");
                        startTime.setText("Start Time");
                        startTime.setVisibility(View.VISIBLE);
                        first_break.setVisibility(View.VISIBLE);
                        second_break.setVisibility(View.VISIBLE);
                        end_time.setVisibility(View.VISIBLE);
                        start.setText("");
                        first.setText("");
                        second.setText("");
                        end.setText("");
                        break;
                    case "Tipper":
                        driverName.setText("");
                        regoNo.setText("");
                        cat.setText("10T Truck");
                        startTime.setText("Start Time");
                        first_break.setVisibility(View.VISIBLE);
                        second_break.setVisibility(View.VISIBLE);
                        end_time.setVisibility(View.VISIBLE);
                        startTime.setVisibility(View.VISIBLE);
                        start.setText("");
                        first.setText("");
                        second.setText("");
                        end.setText("");
                        break;
                    case "Articulated":
                        driverName.setText("");
                        regoNo.setText("");
                        cat.setText("Tipper");
                        startTime.setText("Start Time");
                        startTime.setVisibility(View.VISIBLE);
                        first_break.setVisibility(View.VISIBLE);
                        second_break.setVisibility(View.VISIBLE);
                        end_time.setVisibility(View.VISIBLE);
                        start.setText("");
                        first.setText("");
                        second.setText("");
                        end.setText("");
                        break;
                }
            }
        });

        Button Home = getActivity().findViewById(R.id.button8);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assert getFragmentManager() != null;
                getFragmentManager().popBackStack();

            }
        });

        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyHelper db = new MyHelper(getActivity());
                if (driverName.getText().toString().isEmpty() || regoNo.getText().toString().isEmpty() ||
                        start.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Entry not saved as not all data entered.\n" +
                            "Complete all entries and try again.", Toast.LENGTH_SHORT).show();
                } else {
                    db.addUser(driverName.getText().toString() + " ",
                            regoNo.getText().toString() + " ", start.getText().toString(), first.getText().toString(),
                            second.getText().toString(), end.getText().toString(), cat.getText().toString());
                    Toast.makeText(getActivity(), driverName.getText() + ": Data Saved!", Toast.LENGTH_SHORT).show();
                    saveData.setClickable(false);
                }
            }
        });


        showData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("karama", cat.getText().toString());
                list_obj.setArguments(args);
                assert getFragmentManager() != null;
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.main_frag, list_obj,"list_frag").addToBackStack("root_f");
                ft.commit();
            }
        });

        startTime.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"ResourceAsColor", "SetTextI18n"})
            @Override
            public void onClick(View v) {
                assert location != null;
                if(location.equals("null")){
                    final AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
                    builder.setTitle("Location Permission");
                    builder.setMessage("The app needs location permissions. Please grant this permission to continue using the features of the app.");
                    builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            startActivity(intent);
                        }
                    });
                    builder.setNegativeButton(android.R.string.no, null);
                    builder.show();
                }else {
                    start.setText(" Start: " + DateFormat.format("dd/MM/yyyy kk:mm", System.currentTimeMillis()) + location);
                    startTime.setVisibility(View.GONE);
                }
                closekeyboard();
            }
        });


        first_break.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"ResourceAsColor", "SetTextI18n"})
            @Override
            public void onClick(View v) {
                if (startTime.getVisibility() == View.GONE) {
                    first.setText(" 1st break: " + DateFormat.format("dd/MM/yyyy kk:mm", System.currentTimeMillis()) + location);
                    first_break.setVisibility(View.GONE);
                    closekeyboard();
                }
            }
        });

        second_break.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"ResourceAsColor", "SetTextI18n"})
            @Override
            public void onClick(View v) {
                if (first_break.getVisibility() == View.GONE) {
                    second.setText(" 2nd break: " + DateFormat.format("dd/MM/yyyy kk:mm", System.currentTimeMillis()) + location);
                    second_break.setVisibility(View.GONE);
                    closekeyboard();
                }
            }
        });

        end_time.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"ResourceAsColor", "SetTextI18n"})
            @Override
            public void onClick(View v) {
                if (second_break.getVisibility() == View.GONE) {
                    end.setText(" End: " + DateFormat.format("dd/MM/yyyy kk:mm", System.currentTimeMillis()) + location);
                    end_time.setVisibility(View.GONE);
                    closekeyboard();
                }
            }
        });
    }

    private void closekeyboard() {
        View view = this.getView();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) Objects.requireNonNull(getActivity()).getSystemService(Context.INPUT_METHOD_SERVICE);
            assert imm != null;
            imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
        }
    }

}

