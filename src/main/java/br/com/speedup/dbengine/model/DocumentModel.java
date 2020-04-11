package br.com.speedup.dbengine.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
public class DocumentModel {

    private KeyModel key;

    private List<KeyModel> keyModels;

    public DocumentModel(KeyModel key) {
        this.key = key;
        this.keyModels = new ArrayList<>();
    }

    public DocumentModel(KeyModel key, List<KeyModel> keyModels) {
        this.key = key;
        this.keyModels = keyModels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentModel that = (DocumentModel) o;
        return getKey().equals(that.getKey());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey());
    }
}
