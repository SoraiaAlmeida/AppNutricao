package br.edu.fateczl.appnutriprojeto;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import br.edu.fateczl.appnutriprojeto.controller.UserController;
import br.edu.fateczl.appnutriprojeto.model.User;

public class ViewProfileActivity extends AppCompatActivity {
    private EditText etAltura, etIdade, etPeso;
    private Button btnSalvarPerfil;
    private UserController userController;
    private int userId;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);

        etAltura = findViewById(R.id.etAltura);
        etIdade = findViewById(R.id.etIdade);
        etPeso = findViewById(R.id.etPeso);
        btnSalvarPerfil = findViewById(R.id.btnSalvarPerfil);

        userController = new UserController(this);
        userId = getIntent().getIntExtra("user_id", -1);

        user = userController.getUserById(userId);

        if (user != null) {
            etAltura.setText(String.valueOf(user.getHeight()));
            etIdade.setText(String.valueOf(user.getAge()));
            etPeso.setText(String.valueOf(user.getWeight()));
        }

        btnSalvarPerfil.setOnClickListener(v -> {
            float height = Float.parseFloat(etAltura.getText().toString());
            int age = Integer.parseInt(etIdade.getText().toString());
            float weight = Float.parseFloat(etPeso.getText().toString());

            user.setHeight(height);
            user.setAge(age);
            user.setWeight(weight);

            userController.updateUser(user);

            Toast.makeText(this, "Perfil atualizado com sucesso", Toast.LENGTH_SHORT).show();
        });
    }
}

