package dev.x4d.holidaysapi.controllers;

import dev.x4d.holidaysapi.core.interfaces.services.IHolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.DateTimeException;
import java.time.LocalDate;

@RestController
@RequestMapping("/festivos")
@CrossOrigin(origins = "http://localhost:4200", methods = RequestMethod.GET)
public class HolidaysController {
  private final IHolidayService holidayService;

  public HolidaysController(@Autowired IHolidayService holidayService) {
    this.holidayService = holidayService;
  }

  @RequestMapping(value = "/verificar/{year}/{month}/{day}", method = RequestMethod.GET)
  public String verify(@PathVariable Integer year, @PathVariable Integer month, @PathVariable Integer day) {
    try {
      LocalDate parsedDate = holidayService.parseDate(year, month, day);
      return holidayService.isHoliday(parsedDate) ? "Es festivo" : "No es festivo";
    } catch (DateTimeException e) {
      return "Fecha no valida";
    }
  }

  @RequestMapping(value = "/obtener/{year}", method = RequestMethod.GET)
  public Object verify(@PathVariable Integer year) {
    return holidayService.computeHolidays(year);
  }
}
