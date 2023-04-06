package ro.unibuc.hello.data;

import org.springframework.data.annotation.Id;

public class PCComponentEntity {
    @Id
    public String id;
    public String name;
    public String description;
    public String category;

    public PCComponentEntity(String name, String description, String category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format("PCComponentEntity[name='%s', description='%s', category='%s']", id, name, description, category);
    }
}
