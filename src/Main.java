/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */

import java.util.concurrent.Semaphore;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Counter counter = new Counter(5, 1, 1);
        
        Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(1);
        Semaphore semaphore3 = new Semaphore(1);
        Semaphore semaphore4 = new Semaphore(1);
        Semaphore semaphore5 = new Semaphore(1);
        
        
        Warehouse chasis_warehouse = new Warehouse(10, "chasis", counter);
        chasis_warehouse.semaphore = semaphore1;
        Warehouse engine_warehouse = new Warehouse(10, "motor", counter);
        engine_warehouse.semaphore = semaphore2;
        Warehouse wheels_warehouse = new Warehouse(10, "rueda", counter);
        wheels_warehouse.semaphore = semaphore3;
        Warehouse bodywork_warehouse = new Warehouse(10, "carroceria", counter);
        bodywork_warehouse.semaphore = semaphore4;
        Warehouse accesory_warehouse = new Warehouse(10, "accesorios", counter);
        accesory_warehouse.semaphore = semaphore5;
        
// Producers(Integer id, int capacity, Integer wage, Integer parts_produced, String type, boolean working, Warehouse warehouse, String status, boolean hired, int workday_duration, int days)
        

// Assemblers(int assembler_id, float capacity, int wage, int cars_assembled, boolean hired, boolean working, String status, 
//            Warehouse chasis_warehouse, Warehouse wheels_warehouse, Warehouse bodywork_warehouse, Warehouse accesory_warehouse, Warehouse engine_warehouse)

// Manager(int managers_id, int wage, String status, int workday_duration, int days)
        
// Supervisor(int days_to_shipment, Manager manager, int wage, int workday_duration, String status)

        
        Producers producer = new Producers(1,1,3,0,"chasis",true, chasis_warehouse, "TRABAJANDO", true,24,2, counter);
        Producers producer1 = new Producers(2,1,3,0,"motor",true, engine_warehouse, "TRABAJANDO", true,24,2, counter);
        Producers producer2 = new Producers(3,1,3,0,"carroceria",true, bodywork_warehouse, "TRABAJANDO", true,24,2, counter);
        Producers producer3 = new Producers(4,1,3,0,"rueda",true, wheels_warehouse, "TRABAJANDO", true,24,2, counter);
        Producers producer4 = new Producers(5,1,3,0,"accesorio",true, accesory_warehouse, "TRABAJANDO", true,24,2, counter);
        Assemblers assembler = new Assemblers(6,1,50,0,true, true, "TRABAJANDO", chasis_warehouse, wheels_warehouse, bodywork_warehouse, engine_warehouse, accesory_warehouse, 2, 24, counter);
        
        Manager manager = new Manager(1, 40, "", 24.0, 0, counter, 2,2,2,2);
        
        Supervisor supervisor = new Supervisor(5, manager,40, 24, "", counter);
        
        producer.start();
        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();
        manager.start();
        supervisor.start();
        assembler.start();
        
    };
    
};
