package pl.sii.ums.services.utils;

import java.util.ArrayList;
import java.util.List;

import pl.sii.ums.model.dto.TimeShitAnnotationDto;
import pl.sii.ums.model.dto.TimeShitCalendarDto;
import pl.sii.ums.model.dto.TimeShitDayDto;
import pl.sii.ums.model.dto.TimeShitDto;
import pl.sii.ums.model.dto.TimeShitWeekDto;

public class TimeShitPreparationService {

	private TimeShitCalendarDto calendar;
	
	private List<TimeShitWeekDto> weeks = new ArrayList<TimeShitWeekDto>();
	
	public TimeShitPreparationService(int daysInMonth, int firstDayInMonth) {
		this.calendar = new TimeShitCalendarDto(daysInMonth, firstDayInMonth, null);
		this.calendar.setCellNumber(getNumberOfTableCells(daysInMonth,firstDayInMonth));
		this.calendar = prepareTimeShitCalendar();
	}
	public TimeShitCalendarDto getCalendar() {
		if(this.calendar != null && isCalendarReady(this.calendar)) {
			return this.calendar;			
		}else return null;
	}
	public TimeShitCalendarDto addAnnotationToCalendar(TimeShitCalendarDto calendar, TimeShitDto days) {
		
		List<TimeShitAnnotationDto> annotations = null;
		
		if(isCalendarReady(calendar)) {
			for(int i = 0 ; i < calendar.getWeeks().size() ; i++) {
				for(int j = 0 ; j < calendar.getWeeks().get(i).getDays().length ; j++) {
					if(calendar.getWeeks().get(i).getDays()[j].getDayNumber() == days.getDay()) {
						if(calendar.getWeeks().get(i).getDays()[j].getAnnotations() == null) {
							annotations= new ArrayList<TimeShitAnnotationDto>();
						}else {
							annotations = calendar.getWeeks().get(i).getDays()[j].getAnnotations();
							annotations.add(new TimeShitAnnotationDto(days.getProject().getName(), days.getWorkedHours()));
						}
						calendar.getWeeks().get(i).getDays()[j].setAnnotations(annotations);
					}
				}
			}
		}
		return calendar;
	}
	
	public void showDaysFromCalendar() {
		
		for(int i = 0 ; i < calendar.getWeeks().size() ; i++)
			for(int j = 0 ; j < calendar.getWeeks().get(i).getDays().length ; j++) {
				System.out.print(calendar.getWeeks().get(i).getDays()[j].getDayNumber());
				System.out.print("   |   ");
				System.out.println(calendar.getWeeks().get(i).getDays()[j].getDayInWeek());
			}		
	}
	private TimeShitCalendarDto prepareTimeShitCalendar() {
		
		int dayInAWeek = 0;
		int dayNumber = 0;
		int nextMonthDayIterator = 0;
		int daysNumberBeforCurrentMonth = calendar.getFirstDayInMonth()-1;
		int weeksNumber = getWeeksNumber(calendar.getDaysInMonth(), calendar.getFirstDayInMonth());		
		boolean isCurrentMonth = true;
		
		for(int weeksIterator = 0 ; weeksIterator < weeksNumber ; weeksIterator++) {			

			TimeShitDayDto[] days = new TimeShitDayDto[7];		
			for(int daysIterator = 0 ; daysIterator < 7; daysIterator++) {
				dayNumber = (daysIterator+1)+((weeksIterator*7)) - daysNumberBeforCurrentMonth;				
				if(dayNumber < 1) {
					isCurrentMonth = false;
					dayNumber = 30+dayNumber;
					
				}else if(dayNumber > calendar.getDaysInMonth()) {
					isCurrentMonth = false;
					dayNumber = 1+nextMonthDayIterator++;
				}else isCurrentMonth = true;
				
				if(((daysIterator+1)%7) == 0) {
					dayInAWeek = 7;					
				}else dayInAWeek = ((daysIterator+1)%7);
				
				days[daysIterator] = new TimeShitDayDto(dayInAWeek, dayNumber, isCurrentMonth, null);
			}			
			weeks.add(new TimeShitWeekDto(0, weeksIterator+1, days));
		}
		calendar.setWeeks(weeks);
		return calendar;		
	}
	
	private int getNumberOfTableCells(int daysInMonth, int firstDayInMonth) {
	
		int weeks = 0;				
		weeks = getWeeksNumber(daysInMonth, firstDayInMonth);			
		return weeks * 7;
	}
	
	private int getWeeksNumber(int daysInMonth, int firstDayInMonth) {

		int weeks = 0;
		int weeksPart = 0;		
		
		weeks = (daysInMonth + (firstDayInMonth - 1)) / 7;
		weeksPart = (daysInMonth + (firstDayInMonth - 1)) % 7;
		
		if(weeksPart > 0) {
			weeks += 1;
		}		
		return weeks;
	}
	
	private boolean isCalendarReady(TimeShitCalendarDto calendar) {
		
		if(calendar.getCellNumber() > 30) {
			return true;
		} else return false;
	}
}
