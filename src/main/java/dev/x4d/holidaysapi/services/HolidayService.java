package dev.x4d.holidaysapi.services;

import dev.x4d.holidaysapi.core.entities.Holiday;
import dev.x4d.holidaysapi.core.interfaces.repositories.IHolidayRepository;
import dev.x4d.holidaysapi.core.interfaces.services.IHolidayService;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class HolidayService implements IHolidayService {
  private final IHolidayRepository holidayRepository;

  public HolidayService(IHolidayRepository holidayRepository) {
    this.holidayRepository = holidayRepository;
  }

  private LocalDate getEasterDate(int year) {
    int a = year % 19;
    int b = year % 4;
    int c = year % 7;
    int d = (19 * a + 24) % 30;

    int e = d + (2 * b + 4 * c + 6 * d + 5) % 7;

    // Se suman los `e` días a partir del 15 de marzo para obtener el domingo de ramas
    // luego se suman 7 días para obtener el domingo de pascua.
    return LocalDate.of(year, 3, 15).plusDays(e).plusDays(7);
  }

  private LocalDate getFixedHolidayDate(Holiday holiday, int year) {
    return LocalDate.of(year, holiday.getMonth(), holiday.getDay());
  }

  private LocalDate getLongWeekendHolidayDate(Holiday holiday, int year) {
    LocalDate holidayDate = LocalDate.of(year, holiday.getMonth(), holiday.getDay());


    while (holidayDate.getDayOfWeek() != DayOfWeek.MONDAY) {
      holidayDate = holidayDate.plusDays(1);
    }

    return holidayDate;
  }

  private LocalDate getEasterBasedHolidayDate(Holiday holiday, int year) {
    LocalDate easterDate = getEasterDate(year);
    LocalDate holidayDate = easterDate.plusDays(holiday.getEasterDayOffset());
    return holidayDate;
  }

  private LocalDate getLongWeekendEasterBasedHolidayDate(Holiday holiday, int year) {
    LocalDate easterHolidayDate = getEasterBasedHolidayDate(holiday, year);

    while (easterHolidayDate.getDayOfWeek() != DayOfWeek.MONDAY) {
      easterHolidayDate = easterHolidayDate.plusDays(1);
    }

    return easterHolidayDate;
  }

  @Override
  public List<Holiday> getHolidays() {
    return null;
  }


  @Override
  public List<LocalDate> computeHolidayDates(int year) {
    List<Holiday> holidays = holidayRepository.findAll();
    List<LocalDate> computedHolidays = new ArrayList<>();

    for (Holiday holiday : holidays) {
      switch (holiday.getType()) {
        case FIXED:
          computedHolidays.add(getFixedHolidayDate(holiday, year));
          break;
        case LONG_WEEKEND:
          computedHolidays.add(getLongWeekendHolidayDate(holiday, year));
          break;
        case EASTER_BASED:
          computedHolidays.add(getEasterBasedHolidayDate(holiday, year));
          break;
        case LONG_WEEKEND_EASTER_BASED:
          computedHolidays.add(getLongWeekendEasterBasedHolidayDate(holiday, year));
          break;
      }
    }

    return computedHolidays;
  }

  @Override
  public LocalDate parseDate(Integer year, Integer month, Integer day) throws DateTimeException {
    return LocalDate.of(year, month, day);
  }

  @Override
  public boolean isHoliday(LocalDate date) {
    List<LocalDate> computedHolidays = computeHolidayDates(date.getYear());

    for (LocalDate holidayDate : computedHolidays) {
      if (holidayDate.equals(date)) {
        return true;
      }
    }

    return false;
  }
}
