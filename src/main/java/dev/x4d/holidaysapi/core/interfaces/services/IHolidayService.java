package dev.x4d.holidaysapi.core.interfaces.services;

import dev.x4d.holidaysapi.core.entities.Holiday;

import java.util.Date;
import java.util.List;

public interface IHolidayService {
  // Nos devuelve la lista de todos los festivos que tenemos en la base de datos
  public List<Holiday> getHolidays();

  // Nos devuelve la lista de festivos de un año en concreto como objetos Date
  public List<Date> computeHolidayDates(int year);

  // Convierte una cadena de texto en una fecha, si no válida lanza una excepción
  public Date parseDate(String date) throws IllegalArgumentException;

  // Determina si una fecha es festivo
  public boolean isHoliday(Date date);
}
