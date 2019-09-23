//package pl.sii.ums.services.converter.impl;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Calendar;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import pl.sii.ums.model.dto.TimeShitAnnotationDto;
//import pl.sii.ums.model.dto.TimeShitCalendarDto;
//import pl.sii.ums.model.dto.TimeShitDayDto;
//import pl.sii.ums.model.repository.entity.TimeShit;
//import pl.sii.ums.model.repository.entity.TimeShitMonth;
//import pl.sii.ums.services.converter.ITimeShitCalendarConverter;
//import pl.sii.ums.services.db.impl.ProjectServiceImpl;
//import pl.sii.ums.services.db.impl.TimeShitMonthServiceImpl;
//import pl.sii.ums.services.utils.MonthUtil;
//import pl.sii.ums.services.utils.TimeShitPreparationService;
//
//@Service
//public class TimeShitCalendarConverter implements ITimeShitCalendarConverter {
//
//	@Autowired
//	private TimeShitMonthServiceImpl timeShitMonthService;
//
//	@Autowired
//	private ProjectServiceImpl projectServiceImpl;
//	
//	@Override
//	public TimeShitCalendarDto convertFromEntity(int yearNr, TimeShitMonth month) {
//		
//		int monthNr = MonthUtil.getMonthNumberFromName(month.getPeriod());		
//		LocalDate date = LocalDate.of(yearNr, monthNr, 1);
//		Month monthTmp = Month.of(monthNr);
//
//		TimeShitPreparationService calendarService = new TimeShitPreparationService(monthTmp.length(isLeapYear(yearNr)),date.getDayOfWeek().getValue());
//		TimeShitCalendarDto calendar = calendarService.getCalendar();
//		
//		if(month != null) {		
//			for(int indexWeeks = 0 ; indexWeeks < calendar.getWeeks().size() ; indexWeeks++) {
//				for(int indexDays = 0; indexDays < calendar.getWeeks().get(indexWeeks).getDays().length ; indexDays++) {
//					
//					List<TimeShitAnnotationDto> annotations = new ArrayList<TimeShitAnnotationDto>();
//					for(int indexAnnotations = 0; indexAnnotations < month.getTimeShit().size() ; indexAnnotations++) {
//						if(month.getTimeShit().get(indexAnnotations).getDay() == calendar.getWeeks().get(indexWeeks).getDays()[indexDays].getDayNumber()
//								&& calendar.getWeeks().get(indexWeeks).getDays()[indexDays].isCurrentMonth()) {
//	
//							annotations.add(new TimeShitAnnotationDto(
//													month.getTimeShit().get(indexAnnotations).getProject().getName() , 
//													month.getTimeShit().get(indexAnnotations).getWorkedHours()));						
//						}
//					}
//					calendar.getWeeks().get(indexWeeks).getDays()[indexDays].setAnnotations(annotations);
//				}
//			}
//		}
//		return calendar;
//	}
//
//	@Override
//	public TimeShitMonth convertFromDto(int monthNr, TimeShitCalendarDto calendar) {
//
//		TimeShitMonth monthEntity = new TimeShitMonth();		
//		Optional<TimeShitMonth> timeShitMonth = timeShitMonthService.findByPeriod(MonthUtil.getMonthNameFromNumber(monthNr));
//		monthEntity = timeShitMonth.get();
//		
//		List<TimeShit> timeShitEntity = new ArrayList<TimeShit>();	
//		Stream<TimeShitDayDto> stream = calendar.getWeeks().stream().flatMap(e -> Arrays.stream(e.getDays()));
//		List<TimeShitDayDto> list = (List<TimeShitDayDto>) stream
//															.filter(e -> e.isCurrentMonth())
//															.distinct()
//															.collect(Collectors.toList());		
//		for(int index = 0 ; index < list.size() ; index++) {		
//			if(list.get(index).getAnnotations() != null && list.get(index).getAnnotations().size() > 0) {
//				for(int indexAnnotations = 0 ; indexAnnotations < list.get(index).getAnnotations().size() ; indexAnnotations++) {
//					TimeShit entity = new TimeShit();
//					entity.setDay(list.get(index).getDayNumber());
//					entity.setWorkedHours(list.get(index).getAnnotations().get(indexAnnotations).getHours());
//					entity.setProject(projectServiceImpl.findById((long) 1).get());
//					entity.setTimeShitMonth(monthEntity);
//					timeShitEntity.add(entity);
//				}
//			}
//		}
//		
//		if(monthEntity.getTimeShit() == null || monthEntity.getTimeShit().size() == 0) {
//			System.out.println("Object ADDED");
//			monthEntity.setTimeShit(timeShitEntity);
//		} else {
//			for(int i = 0 ; i < monthEntity.getTimeShit().size() ; i++) {
//				monthEntity.getTimeShit().add(timeShitEntity.get(i));
//				System.out.println("ITEM ADDED");
//			}
//		}		
//
//		System.out.println("MONTH ENTITY ANNOTATION SIEZE :" + monthEntity.getTimeShit().size());
//		return monthEntity;
//	}
//
//	public static boolean isLeapYear(int year) {
//		Calendar cal = Calendar.getInstance();
//		cal.set(Calendar.YEAR, year);
//		return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
//	}
//}
