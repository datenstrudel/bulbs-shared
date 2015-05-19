package net.datenstrudel.bulbs.shared.commonTypeConverters;

import com.google.gson.*;
import net.datenstrudel.bulbs.shared.domain.model.color.Color;
import net.datenstrudel.bulbs.shared.domain.model.color.ColorHSB;
import net.datenstrudel.bulbs.shared.domain.model.color.ColorRGB;
import net.datenstrudel.bulbs.shared.domain.model.color.ColorScheme;

import java.lang.reflect.Type;

/**
 *
 * @author Thomas Wendzinski
 */
@Deprecated
public class TypeHierarchyAdapterColor 
        implements JsonSerializer<Color>, JsonDeserializer<Color> {

    //~ Member(s) //////////////////////////////////////////////////////////////
    private static final String FIELD_NAME__TYPE = "colorScheme";
    //~ Construction ///////////////////////////////////////////////////////////
    //~ Method(s) //////////////////////////////////////////////////////////////
    @Override
    public JsonElement serialize(Color src, Type typeOfSrc,
            JsonSerializationContext context) {
        JsonElement res = context.serialize(src);
        res.getAsJsonObject().add(FIELD_NAME__TYPE, new JsonPrimitive(src.colorScheme().toString()));
        return res;
    }

    @Override
    public Color deserialize(JsonElement json, Type typeOfT,
            JsonDeserializationContext context) throws JsonParseException  {
        JsonObject jsonObject =  json.getAsJsonObject();
        String cs = jsonObject.get(FIELD_NAME__TYPE).getAsString();
        ColorScheme colorScheme = ColorScheme.valueOf(cs);
        Class<? extends Color> clazz;
        switch(colorScheme){
            case RGB:
                clazz = ColorRGB.class;
                break;
            case HSB:
                clazz = ColorHSB.class;
                break;
            default:
                throw new IllegalArgumentException("ColorScheme not supported: " + cs);
        }
        return context.deserialize(jsonObject, clazz);
    }
    //~ Private Artifact(s) ////////////////////////////////////////////////////

}
