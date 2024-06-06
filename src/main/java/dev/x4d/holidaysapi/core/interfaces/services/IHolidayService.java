package dev.x4d.holidaysapi.core.interfaces.services;

import dev.x4d.holidaysapi.core.pojo.ComputedHoliday;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;

// Usamos LocalDate en lugar de Date y Calendar para trabajar con fechas
// Ver: https://www.baeldung.com/java-8-date-time-intro

// Todas las fechas se asumen en la zona horaria de Colombia (UTC-5:00)
public interface IHolidayService {

  // Nos devuelve la lista de festivos de un año en concreto como objetos Date
  List<LocalDate> computeHolidayDates(int year);

  // Nos devuelve la lista de festivos de un año en concreto y sus nombres
  List<ComputedHoliday> computeHolidays(int year);

  // Convierte una cadena de texto en una fecha, si no válida lanza una excepción
  LocalDate parseDate(Integer year, Integer month, Integer day) throws DateTimeException;

  // Determina si una fecha es festivo
  boolean isHoliday(LocalDate date);
}
