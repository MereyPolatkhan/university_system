package Model;

import java.util.Vector;


import Config.*;


public class Request {
    
	public String header;
	public String definition;
	public User sender;
	public User recipient;
	public boolean signedByDean;
	public boolean signedByRector;
    
	public Request() {
		
	}
	
	public Request(String header, String definition, User sender, User recipient) {
		this.header = header;
		this.definition = definition;
		this.sender = sender;
		this.recipient = recipient;
	}
	
	public Request(String header, String definition, User sender, User recipient, 
			boolean signedByDean, boolean signedByRector) {
		this(header, definition, sender, recipient);
		this.signedByDean = signedByDean;
		this.signedByRector = signedByRector;
	}
	
    
    //                          Operations                                  
    
    public boolean sign(User deanOrRector, boolean isAccepted) {
    	if (deanOrRector instanceof Manager) {
    		Manager dr = (Manager)deanOrRector;
    		if (dr.type == ManagerTypes.DEAN) {
    			this.signedByDean = isAccepted;
    			return isAccepted;
    		}
    		else if (dr.type == ManagerTypes.RECTOR) {
    			this.signedByRector = isAccepted;
    			return isAccepted;
    		}
    	}
    	return false;
    }
    
    public Vector<Request> getRequests() {
        return Database.requests;
    }
    
    
}
