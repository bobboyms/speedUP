package br.com.speedup.dbengine.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
public class KeyModel {

    private Object value;

    public KeyModel(Object value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyModel keyModel = (KeyModel) o;
        return getValue().equals(keyModel.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
