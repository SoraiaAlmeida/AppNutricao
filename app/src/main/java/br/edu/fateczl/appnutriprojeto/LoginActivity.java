package br.edu.fateczl.appnutriprojeto;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import br.edu.fateczl.appnutriprojeto.controller.UserController;
import br.edu.fateczl.appnutriprojeto.model.User;

public class LoginActivity extends AppCompatActivity {
    private EditText etLogin, etSenha;
    private Button btnLogin, btnInserir;
    private UserController userController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLogin = findViewById(R.id.etLogin);
        etSenha = findViewById(R.id.etSenha);
        btnLogin = findViewById(R.id.btnLogin);
        btnInserir = findViewById(R.id.btnInserir);

        userController = new UserController(this);

        btnLogin.setOnClickListener(v -> {
            try {
                String login = etLogin.getText().toString();
                String password = etSenha.getText().toString();
                User user = userController.loginUser(login, password);
                if (user != null) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("user_id", user.getId());
                    startActivity(intent);
                    finish();
                }
            } catch (Exception e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        btnInserir.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}
