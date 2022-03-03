package com.example.DarkHorse.ui.logout;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.DarkHorse.databinding.FragmentLogoutBinding;

public class LogoutFragment extends Fragment {



    private FragmentLogoutBinding binding;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentLogoutBinding.inflate(inflater, container, false);


        return binding.getRoot();
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }

}