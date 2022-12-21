package Model;

import java.io.Serializable;

public class ServiceDesk implements Serializable {
    
    private int phoneNumber;
    
    private String email;
    
    private ServiceDesk INSTANCE;
    
    
    //                          Operations                                  
    
    public boolean fixPrinter() {
        //TODO
        return false;
    }
    
    public boolean fixProjector() {
        //TODO
        return false;
    }
    
    public ServiceDesk getInstance() {
        //TODO
        return null;
    }
    
    
}
