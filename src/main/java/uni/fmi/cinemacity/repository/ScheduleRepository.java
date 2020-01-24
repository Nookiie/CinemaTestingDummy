package uni.fmi.cinemacity.repository;
import java.util.ArrayList;

import org.joda.time.DateTime;

import uni.fmi.cinemacity.model.Schedule;

public class ScheduleRepository {
	private ArrayList<Schedule> schedules = new ArrayList<Schedule>();

	
	public ScheduleRepository() {
		
	}
	
	public ArrayList<Schedule> getSchedules(){
		return schedules;
	}
	
	public Schedule getScheduleByID(int id) {
		return schedules.stream().filter(Schedule -> Schedule.getId() == id)
				.findFirst()
				.get();
	}
	
	public boolean existsScheduleByDate(DateTime dateTime) {
		return schedules.stream().anyMatch(Schedule -> Schedule.getDate() == dateTime);
	}
	
	public void addSchedule(Schedule Schedule) {
		schedules.add(Schedule);
	}
	
	public void addSchedule(String Schedulename, String password) {
		schedules.add(new Schedule());
	}
	
	public void removeSchedule(Schedule Schedule) {
		schedules.remove(Schedule);
	}
	
	public void removeScheduleByID(int id) {
		schedules.removeIf(Schedule -> Schedule.getId() == id);
	}
	
	public void updateSchedule(Schedule oldSchedule, Schedule newSchedule) {
		schedules.remove(oldSchedule);
		schedules.add(newSchedule);
	}
}
