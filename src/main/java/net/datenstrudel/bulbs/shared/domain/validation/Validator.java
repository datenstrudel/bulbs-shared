package net.datenstrudel.bulbs.shared.domain.validation;

/**
 * Domain validator
 * @param <T> Specific handler for type of Object beeing validated
 * @author Thomas Wendzinski
 */
public abstract class Validator<T extends Validator.ValidationNotificationHandler> {
    
    //~ Member(s) //////////////////////////////////////////////////////////////
    private final T notificationHandler;

    //~ Construction ///////////////////////////////////////////////////////////
    public Validator(T notificationHandler) {
        super();
        assert(notificationHandler != null);
        this.notificationHandler = notificationHandler;
    }
    
    //~ Method(s) //////////////////////////////////////////////////////////////
    /**
     * @throws ValidationException in case a validation error occurs
     */
    public abstract void validateNew() throws ValidationException;
    /**
     * @throws ValidationException in case a validation error occurs
     */
    public abstract void validateExisting() throws ValidationException;
    
    public T notificationHandler(){
        return notificationHandler;
    }
    
    /**
     * Marker interface to be <b>refined</b> for specific members that shall be validatable.
     */
    public static interface ValidationNotificationHandler{}
    
    //~ Private Artifact(s) ////////////////////////////////////////////////////

}
