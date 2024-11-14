package com.example.taskzone;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    private EditText nameField, emailField, passwordField;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nameField = findViewById(R.id.editTextName);
        emailField = findViewById(R.id.editTextEmail);
        passwordField = findViewById(R.id.editTextPassword);
        databaseHelper = new DatabaseHelper(this);

        findViewById(R.id.btnRegister).setOnClickListener(v -> registerUser());
    }

    private void registerUser() {
        String name = nameField.getText().toString();
        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();

        if (databaseHelper.checkEmailExists(email)) {
            Toast.makeText(this, "Email já cadastrado", Toast.LENGTH_SHORT).show();
        } else if (databaseHelper.registerUser(name, email, password)) {
            Toast.makeText(this, "Cadastro bem-sucedido", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Erro ao cadastrar", Toast.LENGTH_SHORT).show();
        }
    }
}
