package dev.x4d.holidaysapi.core.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "types")
public class Type {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "type_id_seq")
  @GenericGenerator(name = "type_id_seq", strategy = "increment")
  @Column(name = "id")
  private int id;

  @Column(name = "type")
  @Enumerated(EnumType.STRING)
  private HolidayType type;

  protected Type() {
  }

  public Type(int id, HolidayType type) {
    this.id = id;
    this.type = type;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public HolidayType getType() {
    return type;
  }

  public void setType(HolidayType type) {
    this.type = type;
  }
}