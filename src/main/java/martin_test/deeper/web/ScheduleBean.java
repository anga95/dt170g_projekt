package martin_test.deeper.web;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import martin_test.deeper.entities.Schedule;
import martin_test.deeper.entities.Shift;

import java.util.List;

@Named
@RequestScoped
public class ScheduleBean {
    @PersistenceContext(unitName = "default")
    EntityManager em;

    public List<Schedule> getSchedule() {
        TypedQuery<Schedule> ScheduleList = em.createQuery("SELECT s, e FROM Schedule s, Employee e WHERE s.empId = e.id", Schedule.class);
        return ScheduleList.getResultList();
    }

    // create
    public Schedule create(Schedule schedule) {
        em.persist(schedule);
        return schedule;
    }

    public Schedule getScheduleById(int id) {
        TypedQuery<Schedule> schedule = em.createNamedQuery("schedule.selectById", Schedule.class);
        schedule.setParameter("id", id);
        return schedule.getSingleResult();
    }

    public Schedule getScheduleByEmployeeId(int employeeId) {
        TypedQuery<Schedule> schedule = em.createNamedQuery("schedule.selectByEmployeeId", Schedule.class);
        schedule.setParameter("employeeId", employeeId);
        return schedule.getSingleResult();
    }

    public void updateScheduleByEmployeeId(int employeeId, Integer mon, Integer tue, Integer wed, Integer thu, Integer fri, Integer sat, Integer sun) {
        TypedQuery<Schedule> ScheduleList = em.createNamedQuery("schedule.updateByEmployeeId", Schedule.class);
        ScheduleList.setParameter("employeeId", employeeId);
        ScheduleList.setParameter("mon", mon);
        ScheduleList.setParameter("tue", tue);
        ScheduleList.setParameter("wed", wed);
        ScheduleList.setParameter("thu", thu);
        ScheduleList.setParameter("fri", fri);
        ScheduleList.setParameter("sat", sat);
        ScheduleList.setParameter("sun", sun);
        ScheduleList.executeUpdate();
    }

    public void deleteSchedule(int id) {
        TypedQuery<Schedule> ScheduleList = em.createNamedQuery("schedule.removeById", Schedule.class);
        ScheduleList.setParameter("id", id);
        ScheduleList.executeUpdate();
    }
}