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

  @Column(name = "day")
  private Integer day;

  @Column(name = "month")
  private Integer month;

  @Column(name = "easter_day_offset")
  private Integer easterDayOffset;

  @Column(name = "name", nullable = false, length = 100)
  private String name;

  @ManyToOne
  @JoinColumn(name = "id_type", nullable = false, referencedColumnName = "id")
  private Type type;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getDay() {
    return day;
  }

  public void setDay(Integer day) {
    this.day = day;
  }

  public Integer getMonth() {
    return month;
  }

  public void setMonth(Integer month) {
    this.month = month;
  }

  public Integer getEasterDayOffset() {
    return easterDayOffset;
  }

  public void setEasterDayOffset(Integer easterDayOffset) {
    this.easterDayOffset = easterDayOffset;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public HolidayType getType() {
    return type.getType();
  }

  public void setType(Type type) {
    this.type = type;
  }
}
