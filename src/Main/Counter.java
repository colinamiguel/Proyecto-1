package Main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class Counter {
    
    public int wage_expenses;
    public int material_expenses;
    public int days_to_shipment;
    public int cars_assembled;
    public int numberof_producers;
    public int numberof_assemblers;
    public int wage_discount;
    public int income;
    
    public Counter(int days_to_shipment, int numberof_producers, int numberof_assemblers){
        this.wage_expenses = 0;
        this.material_expenses = 0;
        this.days_to_shipment = days_to_shipment;
        this.cars_assembled = 0;
        this.numberof_assemblers = numberof_assemblers;
        this.numberof_producers = numberof_producers;
        this.income = 0;
    };

    public int getWage_expenses() {
        return wage_expenses;
    };

    public void setWage_expenses(int wage_expenses) {
        this.wage_expenses = wage_expenses;
    };

    public int getMaterial_expenses() {
        return material_expenses;
    };

    public void setMaterial_expenses(int material_expenses) {
        this.material_expenses = material_expenses;
    };

    public int getDays_to_shipment() {
        return days_to_shipment;
    };

    public void setDays_to_shipment(int days_to_shipment) {
        this.days_to_shipment = days_to_shipment;
    };

    public int getCars_assembled() {
        return cars_assembled;
    };

    public void setCars_assembled(int cars_assembled) {
        this.cars_assembled = cars_assembled;
    };
    
    public void update_producers_expenses(int producer_wage){
        this.wage_expenses = this.wage_expenses + (producer_wage*this.numberof_producers);
    };
    
    public void update_assemblers_expenses(int assembler_wage){
        this.wage_expenses = this.wage_expenses + (assembler_wage*this.numberof_producers);
    };
    
    public void update_managers_expenses(int manager_wage){
        this.wage_expenses = this.wage_expenses + (manager_wage*this.numberof_producers);
    };
    
    public void update_supervisors_expenses(int supervisor_wage){
        this.wage_expenses = this.wage_expenses + (supervisor_wage*this.numberof_producers);
    };
    
    public void update_sales_income(int price){
        this.income = this.income + this.cars_assembled*price;
    };
           
};
