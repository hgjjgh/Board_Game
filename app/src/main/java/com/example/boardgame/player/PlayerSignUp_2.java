package com.example.boardgame.player;


import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.boardgame.R;

public class PlayerSignUp_2 extends Fragment {
    private static final String TAG = "TAG_PlayerSignUp_2";
    private Activity activity;
    EditText etAccount, etPassword, etConfirm;
    Button btNext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity.setTitle("玩家註冊");
        return inflater.inflate(R.layout.fragment_player_sign_up_2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etAccount = view.findViewById(R.id.etAccount);
        etPassword = view.findViewById(R.id.etPassword);
        etConfirm = view.findViewById(R.id.etConfirm);

        btNext = view.findViewById(R.id.btNext);
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = etAccount.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String passwordConfirm = etConfirm.getText().toString().trim();

                Boolean valid = true;
                if (account.isEmpty()) {
                    valid = false;
                    etAccount.setError(getString(R.string.txCanNotBeEmpty));
                }
                if (password.isEmpty()) {
                    valid = false;
                    etPassword.setError(getString(R.string.txCanNotBeEmpty));
                }
                if (passwordConfirm.isEmpty()) {
                    valid = false;
                    etConfirm.setError(getString(R.string.txCanNotBeEmpty));
                }
                if (!valid) {
                    return;
                }else if (password.trim().equals(passwordConfirm)) {
                        Bundle bundle = new Bundle();
                        bundle.putString("account", account);
                        bundle.putString("account", password);
                        Navigation.findNavController(btNext).navigate(R.id.action_playerSignUp_2_to_signUp_3, bundle);
                } else {
                    etConfirm.setError(getString(R.string.txConfirmDifferent));
                }
            }
        });
    }
}
