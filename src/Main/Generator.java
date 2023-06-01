package Main;

/**
 *
 * @author luism
 */
public class Generator {
    private int generatorNumber;
    public int workers;
    public int wheelGenerationCapacity;
    public int engineGenerationCapacity;
    public int bodyWorkGenerationCapacity;
    public int chasisGenerationCapacity;
    public int accesoriesGenerationCapacity;

    public Generator(int generatorNumber) {
        if ( generatorNumber >= 0 && generatorNumber <= 9) {
            this.generatorNumber = generatorNumber;
            this.workers = 10 + generatorNumber;
            this.setWheelGenerationCapacity(generatorNumber);
            this.setEngineGenerationCapacity(generatorNumber);
            this.setChasisGenerationCapacity(generatorNumber);
            this.setBodyWorkGenerationCapacity(generatorNumber);
            this.setAccesoriesGenerationCapacity(generatorNumber);
        } else {
            System.exit(1);
        }
        
    }
    
    private void setWheelGenerationCapacity(int generator) {
        if (generator >= 0 && generator < 5) {
            this.wheelGenerationCapacity = 3;
        } else if (generator >= 5 && generator <= 9) {
            this.wheelGenerationCapacity = 5;
        }
   
    }
    
    private void setEngineGenerationCapacity(int generator) {
        if (generator >= 0 && generator < 3) {
            this.engineGenerationCapacity = 3;
        } else if (generator >= 3 && generator < 6) {
            this.engineGenerationCapacity = 2;
        } else if (generator >= 6 && generator <= 9) {
            this.engineGenerationCapacity = 1;
        }
   
    }
    
    private void setChasisGenerationCapacity(int generator) {
        if (generator >= 0 && generator < 3) {
            this.chasisGenerationCapacity = 2;
        } else if (generator >= 3 && generator < 6) {
            this.chasisGenerationCapacity = 3;
        } else if (generator >= 6 && generator <= 9) {
            this.chasisGenerationCapacity = 4;
        }
    }
   
    
    private void setBodyWorkGenerationCapacity(int generator) {
        if (generator >= 0 && generator < 3) {
            this.bodyWorkGenerationCapacity = 2;
        } else if (generator >= 3 && generator < 6) {
            this.bodyWorkGenerationCapacity = 3;
        } else if (generator >= 6 && generator <= 9) {
            this.bodyWorkGenerationCapacity = 4;
        }
   
    }
    
    private void setAccesoriesGenerationCapacity(int generator) {
        if (generator >= 0 && generator < 5) {
            this.wheelGenerationCapacity = 3;
        } else if (generator >= 5 && generator <= 9) {
            this.wheelGenerationCapacity = 2;
        }
   
    }

    public int getGeneratorNumber() {
        return generatorNumber;
    }
    

    
    public int getWorkCapacity(String work) {
        switch (work) {
            case "chasis":
                return this.chasisGenerationCapacity;
            case "wheels":
                return this.wheelGenerationCapacity;
            case "engines":
                return this.engineGenerationCapacity;
            case "bodyWork":
                return this.bodyWorkGenerationCapacity;
            case "accesories":
                return this.accesoriesGenerationCapacity;
            default:
                return 0;
        }
    }

    
    
}
