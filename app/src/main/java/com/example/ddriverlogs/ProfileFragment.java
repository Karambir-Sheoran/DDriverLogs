package com.example.ddriverlogs;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Objects;


/**
 * A simple koo7 {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        final EditText password = Objects.requireNonNull(getActivity()).findViewById(R.id.editText4);
        final EditText rep_password = getActivity().findViewById(R.id.editText5);
        final EditText name = getActivity().findViewById(R.id.editText3);
        Button Cancel = getActivity().findViewById(R.id.button2);
        Button save_profile = getActivity().findViewById(R.id.button);
        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assert getFragmentManager() != null;
                getFragmentManager().popBackStack();
            }
        });

        save_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (password.getText().toString().equals(rep_password.getText().toString()) && !(password.getText().toString().isEmpty()
                        || rep_password.getText().toString().isEmpty() || name.getText().toString().isEmpty())) {
                    Toast.makeText(getActivity(), "data saved successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getActivity(), "password not matched", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
