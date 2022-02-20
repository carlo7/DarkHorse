package com.example.DarkHorse.ui.logout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.DarkHorse.R;
import com.example.DarkHorse.databinding.FragmentLogoutBinding;
import com.google.firebase.auth.FirebaseAuth;

public class LogoutFragment extends Fragment {

    FirebaseAuth mAuth;
    private Button okLog, btnCancel;

    private FragmentLogoutBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentLogoutBinding.inflate(inflater, container, false);


        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth=FirebaseAuth.getInstance();

        okLog= okLog.findViewById(R.id.okLog);
        btnCancel= btnCancel.findViewById(R.id.cancelLog);

        okLog.setOnClickListener(view ->
            mAuth.signOut()

        );

        btnCancel.setOnClickListener(view ->{

        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }

}