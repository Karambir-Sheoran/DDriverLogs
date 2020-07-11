package com.example.ddriverlogs;




import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Objects;


/**
 * A simple k007 {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    private String table, vc_val;

    private OnHeadlineSelectedListener callback;
    void setOnHeadlineSelectedListener(OnHeadlineSelectedListener callback) {
        this.callback = callback;
    }

    public interface OnHeadlineSelectedListener {
        void onArticleSelected(ArrayList<String> position, String name);
    }




    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        MyHelper db = new MyHelper(getActivity());


        if(getArguments() != null){
            table = getArguments().getString("karama");
        }

        final Button back = view.findViewById(R.id.back);

        if(table != null) {
            vc_val = table;
        }
        back.setText("Return to "+vc_val);
        ArrayList<String> values = db.getAllUsers(vc_val);

        if(values.size() > 0) {
            callback.onArticleSelected(values,vc_val);
            StringBuilder s = new StringBuilder("Yours " + vc_val + " Log Entry: ");
            for (int i = 0; i < values.size(); i++) {
                s.append("&").append(values.get(i));

            }

            String[] items = s.toString().split("&");
            ListView listView = view.findViewById(R.id.listView);

            ArrayAdapter<String> itemAdapt = new ArrayAdapter<>(
                    Objects.requireNonNull(getActivity()), android.R.layout.simple_list_item_1, items
            );
            listView.setAdapter(itemAdapt);
        }
        else{
            values.add("null");
            callback.onArticleSelected(values,vc_val);
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assert getFragmentManager() != null;
                getFragmentManager().popBackStack();

            }
        });

        return view;
    }


}
