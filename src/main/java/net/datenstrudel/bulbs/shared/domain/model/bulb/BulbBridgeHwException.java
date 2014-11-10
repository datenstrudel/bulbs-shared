package net.datenstrudel.bulbs.shared.domain.model.bulb;

/**
 * Thrown for any case there was a problem interacting with underlying hardware interface(s).
 * This includes errors returned by hardware as well es errors that occur on communication attempts
 * with hardware (e.g. network problems).
 */
public class BulbBridgeHwException extends Exception {

    private Integer statusCode;
    private String body;
    
    public BulbBridgeHwException(String message) {
        super(message);
    }
    public BulbBridgeHwException(String message, Throwable cause) {
        super(message, cause);
    }
    public BulbBridgeHwException(Throwable cause) {
        super(cause);
    }
	public BulbBridgeHwException(){

	}

    public BulbBridgeHwException(int statusCode, String statusMessage, String body) {
        super(statusMessage);
        this.statusCode = statusCode;
        this.body = body;
    }

    public Integer getStatusCode() {
        return statusCode;
    }
    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "BulbBridgeHwException{" 
                + "statusCode=" + statusCode 
                + "message=" + getMessage()
                + ", body=" + body + '}';
    }
    
}