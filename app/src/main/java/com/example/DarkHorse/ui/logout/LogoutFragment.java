package com.example.DarkHorse.ui.logout;


import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.DarkHorse.R;

public class LogoutFragment extends Fragment {


    public static interface FragmentListener {
        void onClickButton() ;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof FragmentListener))
            throw new ClassCastException();
    }






    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_logout, container, false);

        Button btn = v.findViewById(R.id.btnYes);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((FragmentListener) getActivity()).onClickButton();

            }
        });
        return v;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

}