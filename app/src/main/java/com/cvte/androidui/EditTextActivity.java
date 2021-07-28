package com.cvte.androidui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EditTextActivity extends AppCompatActivity {
    private final String TAG = "EditTextActivity";
    private Button mBtnLogin;
    private EditText mUserName;
    private EditText mPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        mBtnLogin = findViewById(R.id.btn_login);
        mUserName = findViewById(R.id.editext_uersname);
        mPassword = findViewById(R.id.editext_password);

        mUserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "onTextChanged: "+s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void showToast(View view) {
        Toast.makeText(EditTextActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
    }
}
