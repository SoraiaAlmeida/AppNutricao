package br.edu.fateczl.appnutriprojeto;



import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnInserirAl, btnVerPlano, btnVerPerfil, btnLogout;
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userId = getIntent().getIntExtra("user_id", -1);

        btnInserirAl = findViewById(R.id.btnInserirAl);
        btnVerPlano = findViewById(R.id.btnVerPlano);
        btnVerPerfil = findViewById(R.id.btnVerPerfil);
        btnLogout = findViewById(R.id.btnLogout);

        btnInserirAl.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddFoodActivity.class);
            intent.putExtra("user_id", userId);
            startActivity(intent);
        });

        btnVerPlano.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ViewDietPlanActivity.class);
            intent.putExtra("user_id", userId);
            startActivity(intent);
        });

        btnVerPerfil.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ViewProfileActivity.class);
            intent.putExtra("user_id", userId);
            startActivity(intent);
        });

        btnLogout.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_add_food) {
            Intent intent = new Intent(MainActivity.this, AddFoodActivity.class);
            intent.putExtra("user_id", userId);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_view_diet_plan) {
            Intent intent = new Intent(MainActivity.this, ViewDietPlanActivity.class);
            intent.putExtra("user_id", userId);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_view_profile) {
            Intent intent = new Intent(MainActivity.this, ViewProfileActivity.class);
            intent.putExtra("user_id", userId);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_logout) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
