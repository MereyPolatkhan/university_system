package intranet;


/**
* @generated
*/
public class Request {
    
    /**
    * @generated
    */
    private Vector<Request> requests;
    
    /**
    * @generated
    */
    private String header;
    
    /**
    * @generated
    */
    private String definition;
    
    /**
    * @generated
    */
    private BasicUser sender;
    
    /**
    * @generated
    */
    private  attribute;
    
    /**
    * @generated
    */
    private BasicUser recipient;
    
    /**
    * @generated
    */
    private boolean signedByDean;
    
    /**
    * @generated
    */
    private boolean signedByRector;
    
    
    /**
    * @generated
    */
    private Database database;
    
    

    /**
    * @generated
    */
    private Vector<Request> getRequests() {
        return this.requests;
    }
    
    /**
    * @generated
    */
    private Vector<Request> setRequests(Vector<Request> requests) {
        this.requests = requests;
    }
    
    
    /**
    * @generated
    */
    public String getHeader() {
        return this.header;
    }
    
    /**
    * @generated
    */
    public String setHeader(String header) {
        this.header = header;
    }
    
    
    /**
    * @generated
    */
    public String getDefinition() {
        return this.definition;
    }
    
    /**
    * @generated
    */
    public String setDefinition(String definition) {
        this.definition = definition;
    }
    
    
    /**
    * @generated
    */
    public BasicUser getSender() {
        return this.sender;
    }
    
    /**
    * @generated
    */
    public BasicUser setSender(BasicUser sender) {
        this.sender = sender;
    }
    
    
    /**
    * @generated
    */
    public  getAttribute() {
        return this.attribute;
    }
    
    /**
    * @generated
    */
    public  setAttribute(invalid attribute) {
        this.attribute = attribute;
    }
    
    
    /**
    * @generated
    */
    public BasicUser getRecipient() {
        return this.recipient;
    }
    
    /**
    * @generated
    */
    public BasicUser setRecipient(BasicUser recipient) {
        this.recipient = recipient;
    }
    
    
    /**
    * @generated
    */
    public boolean getSignedByDean() {
        return this.signedByDean;
    }
    
    /**
    * @generated
    */
    public boolean setSignedByDean(Boolean signedByDean) {
        this.signedByDean = signedByDean;
    }
    
    
    /**
    * @generated
    */
    public boolean getSignedByRector() {
        return this.signedByRector;
    }
    
    /**
    * @generated
    */
    public boolean setSignedByRector(Boolean signedByRector) {
        this.signedByRector = signedByRector;
    }
    
    
    
    /**
    * @generated
    */
    public Database getDatabase() {
        return this.database;
    }
    
    /**
    * @generated
    */
    public Database setDatabase(Database database) {
        this.database = database;
    }
    
    
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public boolean sign() {
        //TODO
        return false;
    }
    
    /**
    * @generated
    */
    public Vector<Request> getRequests() {
        //TODO
        return null;
    }
    
    
}
