package dev.x4d.holidaysapi.core.pojo;

import java.time.LocalDate;

public class ComputedHoliday {
  public LocalDate fecha;
  public String festivo;

  public ComputedHoliday(LocalDate fecha, String festivo) {
    this.fecha = fecha;
    this.festivo = festivo;
  }
}
