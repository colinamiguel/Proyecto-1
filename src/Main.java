
/**
 *
 * @author USER
 */

import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Default values
        String[] works = {"chasis", "engines", "wheels", "bodyWork", "accesories"};
        int[] capacities = {25, 55, 35, 20, 10};
        int[] wages = {10, 20, 8, 13, 17};
        
        int generator = Integer.parseInt(JOptionPane.showInputDialog(null,"dveloper id last digit: "));
        Generator generatedValues = new Generator(generator);
        
        Warehouse[] wareHouses = new Warehouse[works.length];
        Counter counter = new Counter(5, 1, 1);
        
        for (int i = 0; i < works.length; i++) {
            Semaphore semaphore = new Semaphore(1);
            Warehouse warehouse = new Warehouse(capacities[i], works[i], counter);
            warehouse.semaphore = semaphore;
            wareHouses[i] = warehouse;
        }
        
        int quotient = generatedValues.workers / (works.length + 1);
        int remainder = generatedValues.workers % (works.length + 1);
        
        int section = 0;
        int workersInSection = 0;
        for (int i = 1; i <= generatedValues.workers; i++ ) {
            if (workersInSection < quotient) {
                Producers producer = new Producers(i,generatedValues.getWorkCapacity(works[section]),wages[section],0,works[section],true, wareHouses[section], "TRABAJANDO", true,24,2, counter);
                producer.start();
                workersInSection += 1;
            } else {
                section += 1;
                workersInSection = 0;
            }
        }
        for (int i=1; i < quotient + remainder; i++) {
            Assemblers assembler = new Assemblers(generator - quotient + i,1,50,0,true, true, "TRABAJANDO", wareHouses[0], wareHouses[2], wareHouses[3], wareHouses[1], wareHouses[4], 2, 24, counter);
            assembler.start();
        }
        
        
        Manager manager = new Manager(1, 40, "", 24.0, 0, counter, 2,2,2,2);
        Supervisor supervisor = new Supervisor(5, manager,40, 24, "", counter);
        
        manager.start();
        supervisor.start();
        
        
    };
    
};

