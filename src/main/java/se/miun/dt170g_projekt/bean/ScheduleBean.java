package se.miun.dt170g_projekt.bean;

import jakarta.ejb.Stateless;
import se.miun.dt170g_projekt.entities.Schedule;
import se.miun.dt170g_projekt.persistanceManager.Manager;

import java.util.List;

@Stateless
public class ScheduleBean {

    private Manager pm = null;
    public List<Schedule> getSchedules() {
//        TypedQuery<Schedule> ScheduleList = em.createQuery("SELECT s, e FROM Schedule s, Employee e WHERE s.empId = e.id", Schedule.class);
//        return ScheduleList.getResultList();
        return pm.getAll(Schedule.class);
    }

    // create
    public void create(Schedule schedule) {
//        em.persist(schedule);
//        return schedule;
        pm.create(schedule);
    }

    public Schedule getScheduleById(int id) {
//        TypedQuery<Schedule> schedule = em.createNamedQuery("schedule.selectById", Schedule.class);
//        schedule.setParameter("id", id);
//        return schedule.getSingleResult();
        return pm.getById(Schedule.class, id);
    }

    public Schedule getScheduleByEmployeeId(int employeeId) {
//        TypedQuery<Schedule> schedule = em.createNamedQuery("schedule.selectByEmployeeId", Schedule.class);
//        schedule.setParameter("employeeId", employeeId);
//        return schedule.getSingleResult();
        return pm.getByColumnName(Schedule.class, "EMP_ID", String.valueOf(employeeId));
    }

    public void updateScheduleByEmployeeId(int employeeId, Integer mon, Integer tue, Integer wed, Integer thu, Integer fri, Integer sat, Integer sun) {
//        TypedQuery<Schedule> ScheduleList = em.createNamedQuery("schedule.updateByEmployeeId", Schedule.class);
//        ScheduleList.setParameter("employeeId", employeeId);
//        ScheduleList.setParameter("mon", mon);
//        ScheduleList.setParameter("tue", tue);
//        ScheduleList.setParameter("wed", wed);
//        ScheduleList.setParameter("thu", thu);
//        ScheduleList.setParameter("fri", fri);
//        ScheduleList.setParameter("sat", sat);
//        ScheduleList.setParameter("sun", sun);
//        ScheduleList.executeUpdate();
        Schedule schedule = getScheduleByEmployeeId(employeeId);
        schedule.setMon(mon);
        schedule.setTue(tue);
        schedule.setWed(wed);
        schedule.setThu(thu);
        schedule.setFri(fri);
        schedule.setSat(sat);
        schedule.setSun(sun);
        pm.update(schedule);
    }

    public void deleteSchedule(int id) {
//        TypedQuery<Schedule> ScheduleList = em.createNamedQuery("schedule.removeById", Schedule.class);
//        ScheduleList.setParameter("id", id);
//        ScheduleList.executeUpdate();
        pm.delete(Schedule.class);
    }
}
