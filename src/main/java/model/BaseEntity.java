package model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

@MappedSuperclass
@Access(AccessType.FIELD)
public class BaseEntity {
    public static final int START_SEQ = 1000;

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = START_SEQ)

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    // PROPERTY access for id due to bug: https://hibernate.atlassian.net/browse/HHH-3718
    @Access(value = AccessType.PROPERTY)
    private Integer id;
    private String uuid;
    @Column(name = "description", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String name;

    public BaseEntity() {
    }

    public BaseEntity(String name) {
        this.name = name;
    }

    public BaseEntity(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
