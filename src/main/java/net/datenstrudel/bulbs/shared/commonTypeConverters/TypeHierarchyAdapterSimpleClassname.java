package net.datenstrudel.bulbs.shared.commonTypeConverters;

import com.google.common.collect.ImmutableMap;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Thomas Wendzinski
 */
public class TypeHierarchyAdapterSimpleClassname 
        implements JsonDeserializer, JsonSerializer {

    //~ Member(s) //////////////////////////////////////////////////////////////
//    private final Class[] deserializableTypes;
    private final Map<Integer, Class> deserializableTypes;

    //~ Construction ///////////////////////////////////////////////////////////
    public TypeHierarchyAdapterSimpleClassname(Class... deserializableTypes) {
//        this.deserializableTypes = deserializableTypes;
        Map<Integer, Class> res = new HashMap<>(deserializableTypes.length);
        for (Class clazz : deserializableTypes) {
            res.put(clazz.getSimpleName().hashCode(), clazz);
        }
        this.deserializableTypes = ImmutableMap.copyOf(res);
    }

    //~ Method(s) //////////////////////////////////////////////////////////////
    @Override
    public JsonElement serialize(
            Object src, Type typeOfSrc, JsonSerializationContext context) {
        JsonElement res = context.serialize(src);
        res.getAsJsonObject().addProperty("type", src.getClass().getSimpleName());
        return res;
    }

    @Override
    public Object deserialize(
            JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final JsonObject src = json.getAsJsonObject();
        final String type = src.get("type").getAsString();
        final Class type2Deserialize = deserializableTypes.get(type.hashCode());
        if(type2Deserialize == null){
            throw new IllegalArgumentException(
                    "Sub type not registered for deserializatoim: " + type);
        }
        return context.deserialize(json, type2Deserialize);
    }
    //~ Private Artifact(s) ////////////////////////////////////////////////////

}
