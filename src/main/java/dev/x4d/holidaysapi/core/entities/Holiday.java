package dev.x4d.holidaysapi.core.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "holidays")
public class Holiday {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "holiday_id_seq")
  @GenericGenerator(name = "holiday_id_seq", strategy = "increment")
  private int id;

  @Column(name = "day", nullable = false)
  private int day;

  @Column(name = "month", nullable = false)
  private int month;

  @Column(name = "easter_day_offset", nullable = true)
  private int easterDayOffset;

  @Column(name = "name", nullable = false, length = 100)
  private String name;

  @ManyToOne
  @JoinColumn(name = "type_id", referencedColumnName = "id")
  private Type type;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getEasterDayOffset() {
    return easterDayOffset;
  }

  public void setEasterDayOffset(int easterDayOffset) {
    this.easterDayOffset = easterDayOffset;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }
}
