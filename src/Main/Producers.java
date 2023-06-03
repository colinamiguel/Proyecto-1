package Main;

import Interfaces.Logs;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */

public class Producers extends Thread {
    
    private int plant_id;
    private int producer_id;
    private int capacity;
    private Integer wage;
    private Integer parts_produced;
    private String type;
    private boolean working;
    private Warehouse warehouse;
    private boolean hired;
    private String status;
    private int workday_duration;
    private double sleep;
    private int days;
    private Counter counter;
    public Logs interfaz;
    public JLabel label;
    
    public Producers(Integer id, int capacity, Integer wage, Integer parts_produced, String type, boolean working, Warehouse warehouse, String status, boolean hired, int workday_duration, int days, Counter counter, Logs interfaz, int plant_id){
        this.producer_id = id;
        this.capacity = capacity;
        this.wage = wage;
        this.parts_produced = parts_produced;
        this.type = type;
        this.working = working;
        this.warehouse = warehouse;
        this.hired = hired;
        this.status = status;
        this.workday_duration = workday_duration;
        this.days = days;
        this.counter = counter;
        this.interfaz = interfaz;
        this.label = label;
        this.plant_id = plant_id;
    };

    public int getWorkday_duration() {
        return workday_duration;
    };

    public void setWorkday_duration(int workday_duration) {
        this.workday_duration = workday_duration;
    };
    
    public String getStatus() {
        return status;
    };

    public void setStatus(String status) {
        this.status = status;
    };
    
    public boolean isHired() {
        return hired;
    };

    public void setHired(boolean hired) {
        this.hired = hired;
    };

    public Warehouse getWarehouse() {
        return warehouse;
    };

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    };
    

    public int getProducer_Id() {
        return producer_id;
    };

    public void setProducer_Id(int id) {
        this.producer_id = id;
    };

    public float getCapacity() {
        return capacity;
    };

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    };

    public Integer getWage() {
        return wage;
    };

    public void setWage(Integer wage) {
        this.wage = wage;
    };

    public Integer getParts_produced() {
        return parts_produced;
    };

    public void setParts_produced(Integer parts_produced) {
        this.parts_produced = parts_produced;
    };

    public String getType() {
        return type;
    };

    public void setType(String type) {
        this.type = type;
    };

    public boolean isWorking() {
        return working;
    };

    public void setWorking(boolean working) {
        this.working = working;
    };
    
    @Override
    public void run(){
        switch(this.type){
            case "chasis":
                this.producer_id = producer_id;
                this.wage = wage;
                this.capacity = capacity;
                this.parts_produced = 0;
                this.type = "chasis";
                this.working = working;
                this.days = days;
                this.warehouse = warehouse;
                this.hired = hired;
                this.status = "TRABAJANDO";
                this.workday_duration = workday_duration;
                this.sleep = (24000);
                if (this.plant_id == 0) {
                    this.label = this.interfaz.chasislabel;
                } else {
                    this.label = this.interfaz.chasislabel1;
                }
                
                break;
            case "carroceria":
                this.producer_id = producer_id;
                this.wage = wage;
                this.capacity = capacity;
                this.parts_produced = 0;
                this.type = "carroceria";
                this.working = working;
                this.warehouse = warehouse;
                this.hired = hired;
                this.status = "TRABAJANDO";
                this.workday_duration = workday_duration;
                this.days = days;
                this.sleep = (24000);
                if (this.plant_id == 0) {
                    this.label = this.interfaz.bodyworklabel;
                } else {
                    this.label = this.interfaz.bodyworklabel1;
                }
                break;
            case "motor":
                this.producer_id = producer_id;
                this.days = days;
                this.wage = wage;
                this.capacity = capacity;
                this.parts_produced = 0;
                this.type = "motor";
                this.working = working;
                this.warehouse = warehouse;
                this.hired = hired;
                this.status = "TRABAJANDO";
                this.workday_duration = workday_duration;
                this.sleep = (24000);
                if (this.plant_id == 0) {
                    this.label = this.interfaz.enginelabel;
                } else {
                    this.label = this.interfaz.enginelabel1;
                }
                break;
            case "rueda":
                this.producer_id = producer_id;
                this.days = days;
                this.wage = wage;
                this.capacity = capacity;
                this.parts_produced = 0;
                this.type = "rueda";
                this.working = working;
                this.warehouse = warehouse;
                this.hired = hired;
                this.status = "TRABAJANDO";
                this.workday_duration = workday_duration;
                this.sleep = (24000);
                if (this.plant_id == 0) {
                    this.label = this.interfaz.wheelslabel;
                } else {
                    this.label = this.interfaz.wheelslabel1;
                }
                break;
            case "accesorio":
                this.producer_id = producer_id;
                this.days = days;
                this.wage = wage;
                this.capacity = capacity;
                this.parts_produced = 0;
                this.type = "accesorio";
                this.working = working;
                this.warehouse = warehouse;
                this.hired = hired;
                this.status = "TRABAJANDO";
                this.workday_duration = workday_duration;
                this.sleep = (24000);
                if (this.plant_id == 0) {
                    this.label = this.interfaz.accesorieslabel;
                } else {
                    this.label = this.interfaz.accesorieslabel1;
                }
                break;
        };
        
        
        while(this.hired){
            try {
                System.out.println("El trabajador " + this.producer_id + " está " + this.status);
                
                this.interfaz.msgcenter.append("El trabajador " +Integer.toString(this.producer_id) + " está "  + this.status + "\n");
                sleep((long) this.sleep);
                this.warehouse.semaphore.acquire(1);
                if(this.warehouse.capacity - this.warehouse.available_parts >= 1){
                    this.warehouse.store_parts(1);
                    this.label.setText(Integer.toString(this.warehouse.available_parts));
                    System.out.println("Se ha agregado una parte al almacén de " + this.type);
                    if (this.plant_id == 0) {
                        this.interfaz.msgcenter.append("Se ha agregado una parte al almacén de " + this.type + "\n");
                    } else {
                        this.interfaz.msgcenter1.append("Se ha agregado una parte al almacén de " + this.type + "\n");
                    }
                    
                    System.out.println("Las partes disponibles en el almacén de " + this.type + " es de " + this.warehouse.available_parts);
                    
                    this.warehouse.update_status("La capacidad disponible del almacén de " + this.warehouse.type + " es de " + String.valueOf(this.warehouse.capacity - this.warehouse.available_parts) + " partes.");
                    
                    if (this.plant_id == 0) {
                        this.interfaz.msgcenter.append(this.warehouse.status + "\n");
                    } else {
                        this.interfaz.msgcenter1.append(this.warehouse.status + "\n");
                    }
                    this.warehouse.semaphore.release();
                }else{
                    this.status = "OCIOSO";
                   if (this.plant_id == 0) {
                        this.interfaz.msgcenter.append("El trabajador " +Integer.toString(this.producer_id) + " está " + this.status  + "\n");
                    } else {
                        this.interfaz.msgcenter1.append("El trabajador " +Integer.toString(this.producer_id) + " está " + this.status  + "\n");
                    }
                    //System.out.println("No se pudo almacenar una nueva parte en el alacén de: " + this.warehouse.type);
                    this.warehouse.semaphore.release();
                
            };
            } catch (InterruptedException ex) {
                Logger.getLogger(Producers.class.getName()).log(Level.SEVERE, null, ex);
            };
            
        };
    };
    
};
