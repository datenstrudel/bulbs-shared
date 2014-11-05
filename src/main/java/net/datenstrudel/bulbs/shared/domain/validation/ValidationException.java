package net.datenstrudel.bulbs.shared.domain.validation;

/**
 *
 * @author Thomas Wendzinski
 */
public class ValidationException extends IllegalArgumentException{


    //~ Member(s) //////////////////////////////////////////////////////////////
    //~ Construction ///////////////////////////////////////////////////////////
    //~ Method(s) //////////////////////////////////////////////////////////////
    public ValidationException() {
    }
    public ValidationException(String s) {
        super(s);
    }
    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
    //~ Private Artifact(s) ////////////////////////////////////////////////////

}
