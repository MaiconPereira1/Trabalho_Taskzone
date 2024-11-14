package com.example.taskzone;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText emailField, passwordField;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailField = findViewById(R.id.editTextEmail);
        passwordField = findViewById(R.id.editTextPassword);
        databaseHelper = new DatabaseHelper(this);

        findViewById(R.id.btnLogin).setOnClickListener(v -> loginUser());
        findViewById(R.id.btnCreateAccount).setOnClickListener(v ->
                startActivity(new Intent(LoginActivity.this, CadastroActivity.class)));
        findViewById(R.id.btnForgotPassword).setOnClickListener(v ->
                startActivity(new Intent(LoginActivity.this, RecuperarSenhaActivity.class)));
    }

    private void loginUser() {
        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();

        if (databaseHelper.loginUser(email, password)) {
            Toast.makeText(this, "Login bem-sucedido", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, DashboardActivity.class));
        } else {
            Toast.makeText(this, "Credenciais inválidas", Toast.LENGTH_SHORT).show();
        }
    }
}
