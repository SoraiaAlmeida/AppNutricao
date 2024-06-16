package br.edu.fateczl.appnutriprojeto;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import br.edu.fateczl.appnutriprojeto.controller.UserController;
import br.edu.fateczl.appnutriprojeto.model.User;

public class RegisterActivity extends AppCompatActivity {
    private EditText etLogin, etSenha, etAltura, etIdade, etPeso;
    private Button btnInserir;
    private UserController userController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etLogin = findViewById(R.id.etLogin);
        etSenha = findViewById(R.id.etSenha);
        etAltura = findViewById(R.id.etAltura);
        etIdade = findViewById(R.id.etIdade);
        etPeso = findViewById(R.id.etPeso);
        btnInserir = findViewById(R.id.btnInserir);

        userController = new UserController(this);

        btnInserir.setOnClickListener(v -> {
            try {
                String login = etLogin.getText().toString();
                String password = etSenha.getText().toString();
                float height = Float.parseFloat(etAltura.getText().toString());
                int age = Integer.parseInt(etIdade.getText().toString());
                float weight = Float.parseFloat(etPeso.getText().toString());

                User user = new User();
                user.setLogin(login);
                user.setPassword(password);
                user.setHeight(height);
                user.setAge(age);
                user.setWeight(weight);

                userController.registerUser(user);

                finish();
            } catch (Exception e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
