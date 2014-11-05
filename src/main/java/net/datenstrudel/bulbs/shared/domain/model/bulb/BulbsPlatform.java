package net.datenstrudel.bulbs.shared.domain.model.bulb;

import java.io.Serializable;

/**
 *
 * @author Thomas Wendzinski
 */
public enum BulbsPlatform implements Serializable{
    
    _EMULATED,
    PHILIPS_HUE,
    ;

    public static final String allValues(){
        StringBuilder res = new StringBuilder();
        for(BulbsPlatform el : BulbsPlatform.values()){
            res.append(el.toString())
                .append("|");
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
    
}
