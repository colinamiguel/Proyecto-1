package Main;


import Interfaces.Logs;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class Manager extends Thread{
    private int plant_id;
    private int managers_id;
    private int days_counter;
    private int wage;
    public String status;
    private double workday_duration;
    public int days;
    public double current_time;
    private boolean hired;
    public Semaphore semaphore;
    public Counter counter;
    private int assemblers_wage;
    private int producers_wage;
    private int managers_wage;
    private int supervisors_wage;
    public Logs interfaz;
        
    public Manager(int managers_id, int wage, String status, double workday_duration, int days, Counter counter, int assemblers_wage, 
                    int producers_wage, int managers_wage, int supervisors_wage, Logs interfaz, int plant_id){
        this.managers_id = managers_id;
        this.days_counter = days_counter;
        this.wage = wage;
        this.status = status;
        this.workday_duration = workday_duration;
        this.days = days;
        this.current_time = 0;
        this.hired = true;
        this.semaphore = new Semaphore(1);
        this.counter = counter;
        this.assemblers_wage = assemblers_wage;
        this.producers_wage = producers_wage;
        this.managers_wage = managers_wage;
        this.supervisors_wage = supervisors_wage;
        this.interfaz = interfaz;
        this.plant_id = plant_id;
    };

    public boolean isHired() {
        return hired;
    };

    public void setHired(boolean hired) {
        this.hired = hired;
    };

    public int getManagers_id() {
        return managers_id;
    };

    public void setManagers_id(int managers_id) {
        this.managers_id = managers_id;
    };

    public int getDays_counter() {
        return days_counter;
    };

    public void setDays_counter(int days_counter) {
        this.days_counter = days_counter;
    };

    public int getWage() {
        return wage;
    };

    public void setWage(int wage) {
        this.wage = wage;
    };

    public String getStatus() {
        return status;
    };

    public void setStatus(String status) {
        this.status = status;
    };

    public double getWorkday_duration() {
        return workday_duration;
    };

    public void setWorkday_duration(double workday_duration) {
        this.workday_duration = workday_duration;
    };

    public double getCurrent_time() {
        return current_time;
    }

    public void setCurrent_time(double current_time) {
        this.current_time = current_time;
    }
      
    @Override
    public void run(){
        
        while(this.hired){
            while(this.current_time < (this.workday_duration/2)*1000){
                try {
                    sleep((long) ((this.workday_duration/48)*1000));

                    this.status = "VIENDO CARRERAS";
                    if (this.plant_id == 0) {
                        this.interfaz.managerlabel.setText(this.status);
                    } else {
                        this.interfaz.managerlabel1.setText(this.status);
                    }
                    
                    System.out.println("El gerente esta: " + this.status);
                    this.current_time = this.current_time + (this.workday_duration/48)*1000;

                    sleep((long) ((this.workday_duration/48)*1000));
                    this.status = "REVISANDO CONTABILIDAD";
                    if (this.plant_id == 0) {
                        this.interfaz.managerlabel.setText(this.status);
                    } else {
                        this.interfaz.managerlabel1.setText(this.status);
                    }
                    System.out.println("El gerente esta: " + this.status);
                    this.current_time = this.current_time + ((this.workday_duration/48*1000));
                } catch (InterruptedException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                }
            };
                try {
                    this.status = "ACTUALIZANDO CONTADOR";
                    if (this.plant_id == 0) {
                        this.interfaz.managerlabel.setText(this.status);
                    } else {
                        this.interfaz.managerlabel1.setText(this.status);
                    }
                    System.out.println("El gerente esta " + this.status);
                    sleep((long) (((this.workday_duration)/2)*1000));
                    this.current_time = this.current_time + ((this.workday_duration/2*1000));
                    System.out.println(this.current_time);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                };

            if(this.current_time == this.workday_duration*1000){
                days = days + 1;
                this.current_time = 0;
                System.out.println("SE HA ACABADO EL DÍA");
                System.out.println(this.days);
                this.interfaz.jLabel10.setText(Integer.toString(days));
                
                this.counter.update_assemblers_expenses(this.assemblers_wage);
                this.counter.update_producers_expenses(this.producers_wage);
                this.counter.update_managers_expenses(managers_wage);
                this.counter.update_supervisors_expenses(supervisors_wage);
                
                
                System.out.println(this.counter.getWage_expenses());
                System.out.println(this.counter.getCars_assembled());
            };
        };
    };
};
