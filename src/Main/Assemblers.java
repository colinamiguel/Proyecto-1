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
public class Assemblers extends Thread{
    private int plant_id;
    private int assembler_id;
    private float capacity;
    private int wage;
    private int cars_assembled;
    private boolean hired;
    private boolean working;
    private String status;
    private Warehouse chasis_warehouse;
    private Warehouse wheels_warehouse;
    private Warehouse bodywork_warehouse;
    private Warehouse accesory_warehouse;
    private Warehouse engine_warehouse;
    private int days;
    private int workday_duration;
    private double sleep;
    private Counter counter;
    private Semaphore semaphore;
    public Logs interfaz;
    
    public Assemblers(int assembler_id, float capacity, int wage, int cars_assembled, boolean hired, boolean working, String status, 
                      Warehouse chasis_warehouse, Warehouse wheels_warehouse, Warehouse bodywork_warehouse, Warehouse accesory_warehouse, 
                      Warehouse engine_warehouse,int days, int workday_duration, Counter counter, Logs interfaz, int plant_id){
        
        this.assembler_id = assembler_id;
        this.capacity = capacity;
        this.hired = hired;
        this.wage = wage;
        this.working = working;
        this.status = status;
        this.chasis_warehouse = chasis_warehouse;
        this.bodywork_warehouse = bodywork_warehouse;
        this.accesory_warehouse = accesory_warehouse;
        this.wheels_warehouse = wheels_warehouse;
        this.engine_warehouse = engine_warehouse;
        this.workday_duration = workday_duration;
        this.days = days;
        this.sleep = sleep;
        this.counter = counter;
        this.interfaz = interfaz;
        this.plant_id = plant_id;
        
    };

    public Warehouse getChasis_warehouse() {
        return chasis_warehouse;
    };

    public void setChasis_warehouse(Warehouse chasis_warehouse) {
        this.chasis_warehouse = chasis_warehouse;
    };

    public Warehouse getWheels_warehouse() {
        return wheels_warehouse;
    };

    public void setWheels_warehouse(Warehouse wheels_warehouse) {
        this.wheels_warehouse = wheels_warehouse;
    };

    public Warehouse getBodywork_warehouse() {
        return bodywork_warehouse;
    };

    public void setBodywork_warehouse(Warehouse bodywork_warehouse) {
        this.bodywork_warehouse = bodywork_warehouse;
    };

    public Warehouse getAccesory_warehouse() {
        return accesory_warehouse;
    };

    public void setAccesory_warehouse(Warehouse accesory_warehouse) {
        this.accesory_warehouse = accesory_warehouse;
    };   

    public int getAssembler_id() {
        return assembler_id;
    };

    public void setAssembler_id(int assembler_id) {
        this.assembler_id = assembler_id;
    };

    public float getCapacity() {
        return capacity;
    };

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    };

    public int getWage() {
        return wage;
    };

    public void setWage(int wage) {
        this.wage = wage;
    };

    public int getCars_assembled() {
        return cars_assembled;
    };

    public void setCars_assembled(int cars_assembled) {
        this.cars_assembled = cars_assembled;
    };

    public boolean isHired() {
        return hired;
    };

    public void setHired(boolean hired) {
        this.hired = hired;
    };

    public boolean isWorking() {
        return working;
    };

    public void setWorking(boolean working) {
        this.working = working;
    };

    public String getStatus() {
        return status;
    };

    public void setStatus(String status) {
        this.status = status;
    };
    
    @Override
    public void run(){

        while(this.hired){
            try {
                this.accesory_warehouse.semaphore.acquire();
                this.bodywork_warehouse.semaphore.acquire();
                this.chasis_warehouse.semaphore.acquire();
                this.wheels_warehouse.semaphore.acquire();
                
                if(this.bodywork_warehouse.available_parts >= 1 & this.chasis_warehouse.available_parts >= 1 & this.wheels_warehouse.available_parts >= 4 & this.engine_warehouse.available_parts >= 1){

                    this.bodywork_warehouse.withdraw_parts(1);
                    this.bodywork_warehouse.update_status("Se ha retirado una parte del almacén, partes disponibles actualmente: " + this.bodywork_warehouse.available_parts);
                    if (this.plant_id == 0) {
                        this.interfaz.msgcenter.append(this.bodywork_warehouse.status + "\n");
                    } else {
                        this.interfaz.msgcenter1.append(this.bodywork_warehouse.status + "\n");
                    }
                    this.chasis_warehouse.withdraw_parts(1);
                    this.chasis_warehouse.update_status("Se ha retirado una parte del almacén, partes disponibles actualmente: " + this.chasis_warehouse.available_parts);
                    if (this.plant_id == 0) {
                        this.interfaz.msgcenter.append(this.chasis_warehouse.status + "\n");
                    } else {
                        this.interfaz.msgcenter1.append(this.chasis_warehouse.status + "\n");
                    }
                    this.wheels_warehouse.withdraw_parts(4);
                    this.wheels_warehouse.update_status("Se ha retirado una parte del almacén, partes disponibles actualmente: " + this.wheels_warehouse.available_parts);
                    if (this.plant_id == 0) {
                        this.interfaz.msgcenter.append(this.wheels_warehouse.status + "\n");
                    } else {
                        this.interfaz.msgcenter1.append(this.wheels_warehouse.status + "\n");
                    }
                    this.engine_warehouse.withdraw_parts(1);
                    this.engine_warehouse.update_status("Se ha retirado una parte del almacén, partes disponibles actualmente: " + this.engine_warehouse.available_parts);
                    if (this.plant_id == 0) {
                        this.interfaz.msgcenter.append(this.engine_warehouse.status + "\n");
                    } else {
                        this.interfaz.msgcenter1.append(this.engine_warehouse.status + "\n");
                    }
                    this.accesory_warehouse.semaphore.release();
                    this.bodywork_warehouse.semaphore.release();
                    this.chasis_warehouse.semaphore.release();
                    this.wheels_warehouse.semaphore.release();
                    
                    this.engine_warehouse.update_status("Se ha retirado una parte del almacén, partes disponibles actualmente: " + this.engine_warehouse.available_parts);
                    this.status = "TRABAJANDO";
                    
                    if (this.plant_id == 0) {
                        this.interfaz.msgcenter.append(this.status + "\n");
                    } else {
                        this.interfaz.msgcenter1.append(this.status + "\n");
                    }
                    
                    System.out.println(this.status);
                    System.out.println("Se han retirado las partes del almacén.");
                    if (this.plant_id == 0) {
                        this.interfaz.msgcenter.append("Se han retirado las partes del almacén.\n");
                    } else {
                        this.interfaz.msgcenter1.append("Se han retirado las partes del almacén.\n");
                    }
                    sleep(48000);
                    
                    this.cars_assembled = this.cars_assembled + 1;
                    
                    System.out.println("El trabajador " + this.assembler_id + " ha ensamblado un carro.");
                    if (this.plant_id == 0) {
                        this.interfaz.msgcenter.append("El trabajador " + this.assembler_id + " ha ensamblado un carro.\n");
                    } else {
                        this.interfaz.msgcenter1.append("El trabajador " + this.assembler_id + " ha ensamblado un carro.\n");
                    }
                    System.out.println("Numero de carros ensamblados por el ensamblador " + this.assembler_id + " " + this.cars_assembled);
                    if (this.plant_id == 0) {
                        this.interfaz.msgcenter.append("Numero de carros ensamblados por el ensamblador " + this.assembler_id + " " + this.cars_assembled + "\n");
                    } else {
                        this.interfaz.msgcenter1.append("Numero de carros ensamblados por el ensamblador " + this.assembler_id + " " + this.cars_assembled + "\n");
                    }
                    this.counter.cars_assembled = this.counter.cars_assembled + 1;
                   
                }else{
                     
                    this.accesory_warehouse.semaphore.release();
                    this.bodywork_warehouse.semaphore.release();
                    this.chasis_warehouse.semaphore.release();
                    this.wheels_warehouse.semaphore.release();
                    
                    this.status = "OCIOSO";
                    if (this.plant_id == 0) {
                        this.interfaz.msgcenter.append("El ensamblador " + this.assembler_id + " esta :" + this.status + "\n");
                    } else {
                        this.interfaz.msgcenter1.append("El ensamblador " + this.assembler_id + " esta :" + this.status + "\n");
                    }
                    
                };
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Assemblers.class.getName()).log(Level.SEVERE, null, ex);
            };
        };
    };  
};
