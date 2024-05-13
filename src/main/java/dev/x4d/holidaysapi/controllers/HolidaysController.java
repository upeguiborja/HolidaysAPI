package dev.x4d.holidaysapi.controllers;

import dev.x4d.holidaysapi.core.interfaces.services.IHolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DateTimeException;
import java.time.LocalDate;

@RestController
@RequestMapping("/festivos")
public class HolidaysController {
  private IHolidayService holidayService;

  public HolidaysController(@Autowired IHolidayService holidayService) {
    this.holidayService = holidayService;
  }

  @RequestMapping("/verificar/{year}/{month}/{day}")
  public String verify(@PathVariable Integer year, @PathVariable Integer month, @PathVariable Integer day) {
    try {
      LocalDate parsedDate = holidayService.parseDate(year, month, day);
      return holidayService.isHoliday(parsedDate) ? "Es festivo" : "No es festivo";
    } catch (DateTimeException e) {
      return "Fecha no valida";
    }
  }
}
