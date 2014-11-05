package net.datenstrudel.bulbs.shared.domain.model.client.common;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Wraps a single value to be used as REST-Api body parameter
 * Created by Thomas Wendzinski.
 */
@ApiModel
public class DtoSingleValue {

    @NotNull
    @ApiModelProperty(required = true)
    private String value;

    private DtoSingleValue() {
    }
    public DtoSingleValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DtoSingleValue that = (DtoSingleValue) o;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;
        return true;
    }
    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
    @Override
    public String toString() {
        return "DtoSingleValue{" +
                "value='" + value + '\'' +
                '}';
    }
}
