package net.datenstrudel.bulbs.shared.commonTypeConverters;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Date;

/**
 *
 * @author Thomas Wendzinski
 */
public class TypeConverterDate implements 
        JsonSerializer<Date>, JsonDeserializer<Date>{

    //~ Member(s) //////////////////////////////////////////////////////////////
    
    //~ Construction ///////////////////////////////////////////////////////////
    //~ Method(s) //////////////////////////////////////////////////////////////
    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        if(src == null )return null;
        return context.serialize(src.getTime());
    }
    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if(json == null || JsonNull.INSTANCE == json)return null;
        return new Date(json.getAsLong());
        
    }
    
    //~ Private Artifact(s) ////////////////////////////////////////////////////
}
