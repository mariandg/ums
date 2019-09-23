//package pl.sii.ums.controller;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import pl.sii.ums.model.dto.TimeShitAnnotationDto;
//import pl.sii.ums.model.dto.TimeShitCalendarDto;
//import pl.sii.ums.model.repository.entity.TimeShitMonth;
//import pl.sii.ums.services.converter.impl.TimeShitCalendarConverter;
//import pl.sii.ums.services.db.impl.TimeShitMonthServiceImpl;
//import pl.sii.ums.services.utils.MonthUtil;
//import pl.sii.ums.services.utils.TimeShitPreparationService;
//
//@RestController
//public class TimeShitController {
//	
//	@Autowired
//	private TimeShitCalendarConverter timeShitCalendarConverter;
//	
//	private TimeShitPreparationService timeShitPreparationService;
//	
//	private TimeShitCalendarDto timeShitCalendarDto;
//		
//	private int monthNr = 0;
//	
//	@Autowired
//	private TimeShitMonthServiceImpl timeShitMonthService;
//	
//    ObjectMapper mapper = new ObjectMapper();
//	
//	@RequestMapping("/timeshitcalendar/year/{yearNr}/month/{monthNr}")
//	public String getTimeShitForYearAndMonth(@PathVariable int yearNr, @PathVariable int monthNr) {
//		
//		this.monthNr = monthNr;
//		
//		String jsonString = "";
//		Optional<TimeShitMonth> timeShitMonth = timeShitMonthService.findByPeriod(MonthUtil.getMonthNameFromNumber(monthNr));
//		if(timeShitMonth.isPresent()) {
//			//TimeShitMonth timeShitMonthEntity = timeShitMonth.get();
//			timeShitCalendarDto =  timeShitCalendarConverter.convertFromEntity(yearNr, timeShitMonth.get());
//		}else {
//			LocalDate date = LocalDate.of(yearNr, monthNr, 1);
//			Month monthTmp = Month.of(monthNr);
//			timeShitPreparationService = new TimeShitPreparationService(monthTmp.length(TimeShitCalendarConverter.isLeapYear(yearNr)),date.getDayOfWeek().getValue());
//			timeShitCalendarDto = timeShitPreparationService.getCalendar();
//		}
//		try {
//			jsonString = mapper.writeValueAsString(timeShitCalendarDto);
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
//		return jsonString;		
//	}
//	 @PostMapping(path = "/timeshitcalendar/add/adnotation")
//	 @ResponseStatus(value = HttpStatus.OK)
//	 public void addAddnotation(@RequestParam(required = true)  String weekNumber,@RequestParam(required = true)  String dayInWeekNumber, @RequestParam(required = true)  String projectId, @RequestParam(required = true)  String workedHours) {
//
//		System.out.println("weekNumber : "+weekNumber);
//		System.out.println("dayInWeekNumber : "+dayInWeekNumber);
//		System.out.println("projectId : "+projectId);
//		System.out.println("workedHours : "+workedHours);
//
//		
//		if(timeShitCalendarDto.getWeeks().get((int)Integer.valueOf(weekNumber)).getDays()[(int)Integer.valueOf(dayInWeekNumber)-1].getAnnotations() != null) {
//			System.out.println("IFFFF");
//			timeShitCalendarDto.getWeeks().get((int)Integer.valueOf(weekNumber)).getDays()[(int)Integer.valueOf(dayInWeekNumber)-1].getAnnotations().add(new TimeShitAnnotationDto("Project A", Integer.valueOf(workedHours)));//new TimeShitAnnotationDto(projectId, workedHours)
//			timeShitMonthService.save(timeShitCalendarConverter.convertFromDto(this.monthNr, timeShitCalendarDto));
//		} else {
//			System.out.println("ELSE");
//			List<TimeShitAnnotationDto> annotations = new ArrayList<TimeShitAnnotationDto>();
//			annotations.add(new TimeShitAnnotationDto("Project B", Integer.valueOf(workedHours)));
//			timeShitCalendarDto.getWeeks().get((int)Integer.valueOf(weekNumber)).getDays()[(int)Integer.valueOf(dayInWeekNumber)-1].setAnnotations(annotations);
//			timeShitMonthService.save(timeShitCalendarConverter.convertFromDto(this.monthNr, timeShitCalendarDto));
//		}
//	 }
//}
