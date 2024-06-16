package br.edu.fateczl.appnutriprojeto;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import br.edu.fateczl.appnutriprojeto.controller.PlanController;
import br.edu.fateczl.appnutriprojeto.model.Plan;

import java.util.List;

public class ViewDietPlanActivity extends AppCompatActivity {
    private ListView plansListView;
    private PlanController planController;
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_diet_plan);

        plansListView = findViewById(R.id.plansListView);
        planController = new PlanController(this);
        userId = getIntent().getIntExtra("user_id", -1);

        List<Plan> plans = planController.getPlans(userId);

        if (plans.isEmpty()) {
            Toast.makeText(this, R.string.no_plan_message, Toast.LENGTH_SHORT).show();
        } else {
            ArrayAdapter<Plan> adapter = new ArrayAdapter<Plan>(this, R.layout.item_diet_plan, plans) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    Plan plan = getItem(position);
                    if (convertView == null) {
                        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_diet_plan, parent, false);
                    }

                    TextView planInfoTextView = convertView.findViewById(R.id.planInfoTextView);
                    planInfoTextView.setText(plan.getName() + " - " + plan.getType() + "\n" + plan.getDescription());

                    Button editButton = convertView.findViewById(R.id.btnEditarPlano);
                    editButton.setOnClickListener(v -> {
                        Intent intent = new Intent(ViewDietPlanActivity.this, EditPlanActivity.class);
                        intent.putExtra("plan_id", plan.getId());
                        intent.putExtra("user_id", userId);
                        startActivity(intent);
                    });

                    Button deleteButton = convertView.findViewById(R.id.btnExcluirPlano);
                    deleteButton.setOnClickListener(v -> deletePlan(plan));

                    return convertView;
                }
            };
            plansListView.setAdapter(adapter);
        }
    }

    private void deletePlan(Plan plan) {
        planController.deletePlan(plan.getId());
        Toast.makeText(this, "Plano " + plan.getName() + " excluído.", Toast.LENGTH_SHORT).show();
        recreate(); // Recria a atividade para atualizar a lista
    }
}
