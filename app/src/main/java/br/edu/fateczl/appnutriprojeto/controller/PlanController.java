package br.edu.fateczl.appnutriprojeto.controller;

import android.content.Context;
import br.edu.fateczl.appnutriprojeto.model.Plan;
import br.edu.fateczl.appnutriprojeto.persistence.PlanDAO;

import java.util.List;

public class PlanController {
    private PlanDAO planDAO;

    public PlanController(Context context) {
        planDAO = new PlanDAO(context);
    }

    public void addPlan(Plan plan) {
        planDAO.addPlan(plan);
    }

    public List<Plan> getPlans(int userId) {
        return planDAO.getPlans(userId);
    }

    public Plan getPlanById(int planId) {
        return planDAO.getPlanById(planId);
    }

    public void updatePlan(Plan plan) {
        planDAO.updatePlan(plan);
    }

    public void deletePlan(int planId) {
        planDAO.deletePlan(planId);
    }
}
