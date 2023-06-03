package Main;


import Interfaces.Logs;
import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author luism
 */
public class Plant {
    public String name;
    public int chasisPartsRequired;
    public int enginePartsRequired;
    public int bodyWorkPartsRequired;
    public int accesoriesPartsRequired;
    public int wheelsPartsRequired;
    public float standardCarPrice;
    public float accesoriesCarPrice;
    public int standardCarsBeforeAccesories;
    public Generator generatedValues;
    public Counter counter;
    public Logs interfaz;
    public int id;

    public Plant(String name, int chasisPartsRequired, int enginePartsRequired, int bodyWorkPartsRequired, int accesoriesPartsRequired, int wheelsPartsRequired, float standardCarPrice, float accesoriesCarPrice, int standardCarsBeforeAccesories, Generator generatedValues, int id) {
        this.name = name;
        this.chasisPartsRequired = chasisPartsRequired;
        this.enginePartsRequired = enginePartsRequired;
        this.bodyWorkPartsRequired = bodyWorkPartsRequired;
        this.accesoriesPartsRequired = accesoriesPartsRequired;
        this.wheelsPartsRequired = wheelsPartsRequired;
        this.standardCarPrice = standardCarPrice;
        this.accesoriesCarPrice = accesoriesCarPrice;
        this.standardCarsBeforeAccesories = standardCarsBeforeAccesories;
        this.generatedValues = generatedValues;
        this.id = id;
    }
    
    public void start(){
        if (this.id == 0) {
            this.interfaz.plantName.setText((this.name));
        } else {
            this.interfaz.plantName1.setText((this.name));
        }
        
        String[] works = {"chasis", "motor", "rueda", "carroceria", "accesorio"};
        int[] capacities = {25, 55, 35, 20, 10};
        int[] wages = {10, 20, 8, 13, 17};
        
        int quotient = this.generatedValues.workers / (works.length + 1);
        int remainder = generatedValues.workers % (works.length + 1);
        
        Warehouse[] wareHouses = new Warehouse[works.length];
        this.counter = new Counter(5, this.generatedValues.workers - quotient - remainder , quotient + remainder);
        
        for (int i = 0; i < works.length; i++) {
            Semaphore semaphore = new Semaphore(1);
            Warehouse warehouse = new Warehouse(capacities[i], works[i], this.counter, this.interfaz);
            warehouse.semaphore = semaphore;
            wareHouses[i] = warehouse;
        }
        
        
        
        int section = 0;
        int workersInSection = 0;
        for (int i = 1; i <= this.generatedValues.workers; i++ ) {
            if (workersInSection < quotient) {
                Producers producer = new Producers(i,this.generatedValues.getWorkCapacity(works[section]),wages[section],0,works[section],true, wareHouses[section], "TRABAJANDO", true,24,2, this.counter, this.interfaz, this.id);
                producer.start();
                workersInSection += 1;
            } else {
                section += 1;
                workersInSection = 0;
            }
        }
        for (int i=1; i < quotient + remainder; i++) {
            Assemblers assembler = new Assemblers(this.generatedValues.getGeneratorNumber() - quotient + i,1,50,0,true, true, "TRABAJANDO", wareHouses[0], 
                                                    wareHouses[2], wareHouses[3], wareHouses[1], wareHouses[4], 2, 24, this.counter, this.interfaz, this.id);
            assembler.start();
        }
        
        
        Manager manager = new Manager(1, 40, "", 24.0, 0, this.counter, 2,2,2,2, this.interfaz, this.id);
        Supervisor supervisor = new Supervisor(5, manager,40, 24, "", this.counter, (int) Math.round(this.standardCarPrice), this.interfaz, this.id);
        
        manager.start();
        supervisor.start();
    }
    
    
}
