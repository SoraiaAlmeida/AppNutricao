package br.edu.fateczl.appnutriprojeto;

import android.content.Intent;
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

public class EditPlanActivity extends AppCompatActivity {
    private EditText etDescricaoRef;
    private Spinner spinnerTipoPlano, spinnerTipoRef;
    private Button btnSalvarRef;
    private PlanController planController;
    private int planId, userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_plan);

        spinnerTipoPlano = findViewById(R.id.spinnerTipoPlano);
        spinnerTipoRef = findViewById(R.id.spinnerTipoRef);
        etDescricaoRef = findViewById(R.id.etDescricaoRef);
        btnSalvarRef = findViewById(R.id.btnSalvarRef);

        planController = new PlanController(this);

        Intent intent = getIntent();
        planId = intent.getIntExtra("plan_id", -1);
        userId = intent.getIntExtra("user_id", -1);

        Plan plan = planController.getPlanById(planId);
        if (plan != null) {
            etDescricaoRef.setText(plan.getDescription());

            ArrayAdapter<CharSequence> planTypeAdapter = ArrayAdapter.createFromResource(this,
                    R.array.plan_types, android.R.layout.simple_spinner_item);
            planTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerTipoPlano.setAdapter(planTypeAdapter);
            if (plan.getName() != null) {
                int spinnerPosition = planTypeAdapter.getPosition(plan.getName());
                spinnerTipoPlano.setSelection(spinnerPosition);
            }

            ArrayAdapter<CharSequence> mealTypeAdapter = ArrayAdapter.createFromResource(this,
                    R.array.meal_types, android.R.layout.simple_spinner_item);
            mealTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerTipoRef.setAdapter(mealTypeAdapter);
            if (plan.getType() != null) {
                int spinnerPosition = mealTypeAdapter.getPosition(plan.getType());
                spinnerTipoRef.setSelection(spinnerPosition);
            }
        } else {
            Toast.makeText(this, "Plano não encontrado", Toast.LENGTH_SHORT).show();
            finish();
        }

        btnSalvarRef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String planName = spinnerTipoPlano.getSelectedItem().toString();
                String mealType = spinnerTipoRef.getSelectedItem().toString();
                String mealDescription = etDescricaoRef.getText().toString();

                plan.setName(planName);
                plan.setType(mealType);
                plan.setDescription(mealDescription);

                planController.updatePlan(plan);
                Toast.makeText(EditPlanActivity.this, "Plano atualizado com sucesso!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
