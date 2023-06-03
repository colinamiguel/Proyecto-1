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

import Interfaces.Logs;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Supervisor extends Thread{
    public int plant_id;
    public int standardCarPrice;
    public int days_to_shipment;
    private Manager manager;
    private int wage;
    private int workday_duration;
    private String status;
    private boolean hired;
    private boolean supervised;
    private int time;
    private boolean chose_time;
    private Counter counter;
    public Logs interfaz;
    
    public Supervisor(int days_to_shipment, Manager manager, int wage, int workday_duration, String status, Counter counter, int standardCarPrice, Logs interfaz,int  plant_id){
        this.days_to_shipment = days_to_shipment;
        this.manager = manager;
        this.workday_duration = workday_duration;
        this.status = status;
        this.hired = true;
        this.supervised = false;
        this.time = 0;
        this.chose_time = false;
        this.counter = counter;
        this.standardCarPrice = standardCarPrice;
        this.interfaz = interfaz;
        this.plant_id = plant_id;
    };

    public int getDays_to_shipment() {
        return days_to_shipment;
    };

    public void setDays_to_shipment(int days_to_shipment) {
        this.days_to_shipment = days_to_shipment;
    };
    
    @Override
    public void run(){
        
        while(hired){
            
            
            //System.out.println(this.status);
            
            
            if(this.manager.days == this.days_to_shipment){
                this.status = "PREPARANDO ENVÍO A CONCESIONARIO";
                if (this.plant_id == 0) {
                    this.interfaz.supervisorlabel.setText(this.status);
                } else {
                    this.interfaz.supervisorlabel1.setText(this.status);
                }
                System.out.println(this.status);
                try {
                    sleep(this.workday_duration);
                    this.manager.days = 0;
                    this.counter.update_sales_income(this.standardCarPrice);
                    System.out.println(this.counter.income);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Supervisor.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else{
                
                this.status = "TAREAS ADMINISTRATIVAS";
                if (this.plant_id == 0) {
                    this.interfaz.supervisorlabel.setText(this.status);
                } else {
                    this.interfaz.supervisorlabel1.setText(this.status);
                }
                                                
                if(this.supervised == false){
                    
                    if (chose_time == false) {
                         time = (int) (Math.random()*(this.workday_duration/2))*1000;
                         chose_time = true;
                    };              
                   
                    if (Double.valueOf(this.time) == this.manager.current_time) {
                        
                        try {
                            sleep(400);
                            if(this.manager.status == "VIENDO CARRERAS"){                          
                                //System.out.println("CAGASTE");
                                System.out.println("El director ha encontrado al gerente viendo carreras.");
                                if (this.plant_id == 0) {
                    this.interfaz.msgcenter.append("El director ha encontrado al gerente viendo carreras. \n");
                } else {
                    this.interfaz.msgcenter.append("El director ha encontrado al gerente viendo carreras. \n");
                }
                                
                                this.counter.wage_discount = this.counter.wage_discount + 50;
                            }
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Supervisor.class.getName()).log(Level.SEVERE, null, ex);
                        };
                    }
                    };
                    //System.out.println("supervisando al guevon");                   
                };
                               
            if(this.manager.current_time == this.workday_duration*1000){
                this.supervised = false;
                this.chose_time = false;
            };
        };
    };
        
};
    

