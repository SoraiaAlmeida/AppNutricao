package br.edu.fateczl.appnutriprojeto;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import br.edu.fateczl.appnutriprojeto.controller.PlanController;
import br.edu.fateczl.appnutriprojeto.model.Plan;

public class AddFoodActivity extends AppCompatActivity {
    private Spinner spinnerTipoPlano, spinnerTipoRef;
    private EditText etDescricaoRef;
    private Button btnSalvarRef;
    private PlanController planController;
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        spinnerTipoPlano = findViewById(R.id.spinnerTipoPlano);
        spinnerTipoRef = findViewById(R.id.spinnerTipoRef);
        etDescricaoRef = findViewById(R.id.etDescricaoRef);
        btnSalvarRef = findViewById(R.id.btnSalvarRef);

        planController = new PlanController(this);
        userId = getIntent().getIntExtra("user_id", -1);

        // Configurar os Spinners
        ArrayAdapter<CharSequence> planTypeAdapter = ArrayAdapter.createFromResource(this,
                R.array.plan_types, android.R.layout.simple_spinner_item);
        planTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipoPlano.setAdapter(planTypeAdapter);

        ArrayAdapter<CharSequence> mealTypeAdapter = ArrayAdapter.createFromResource(this,
                R.array.meal_types, android.R.layout.simple_spinner_item);
        mealTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipoRef.setAdapter(mealTypeAdapter);

        btnSalvarRef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String planType = spinnerTipoPlano.getSelectedItem().toString();
                String mealType = spinnerTipoRef.getSelectedItem().toString();
                String mealDescription = etDescricaoRef.getText().toString();

                Plan plan = new Plan(planType, mealType, mealDescription, userId);
                planController.addPlan(plan);
                Toast.makeText(AddFoodActivity.this, "Plano adicionado com sucesso!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}