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
import java.util.concurrent.Semaphore;

public class Warehouse {
    
    public int capacity;
    public String type;
    public int available_parts;
    public String status;
    public Semaphore semaphore;
    public Counter counter;
    public Semaphore s;
    public Logs interfaz;
    
    public Warehouse(int capacity, String type, Counter counter, Logs interfaz){
        this.capacity = capacity;
        this.type = type;
        this.status = status;
        this.available_parts = available_parts;
        this.semaphore = semaphore;
        this.counter = counter;
        this.s = new Semaphore(4);
        this.interfaz = interfaz;
    };

    public int getAvailable_parts() {
        return available_parts;
    };

    public void setAvailable_parts(int available_parts) {
        this.available_parts = available_parts;
    };
    
    public int getCapacity() {
        return capacity;
    };

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    };

    public String getType() {
        return type;
    };

    public void setType(String type) {
        this.type = type;
    };
    
    public void withdraw_parts(int number){
        this.available_parts = this.available_parts - number;
    };
    
    public void store_parts(int number){
        this.available_parts = this.available_parts + number;
    };
    
    public void update_status(String new_status){
        this.status = new_status;
    };
    
    public void update_costs(int costs){
        this.counter.material_expenses = this.counter.material_expenses + costs;
    }
};
