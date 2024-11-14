package com.example.taskzone;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RecuperarSenhaActivity extends AppCompatActivity {

    private EditText emailField;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_senha);

        emailField = findViewById(R.id.editTextEmail);
        databaseHelper = new DatabaseHelper(this);

        findViewById(R.id.btnRecoverPassword).setOnClickListener(v -> recoverPassword());
    }

    private void recoverPassword() {
        String email = emailField.getText().toString();

        if (databaseHelper.checkEmailExists(email)) {
            Toast.makeText(this, "Email encontrado. Enviar instruções.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Email não cadastrado", Toast.LENGTH_SHORT).show();
        }
    }
}
