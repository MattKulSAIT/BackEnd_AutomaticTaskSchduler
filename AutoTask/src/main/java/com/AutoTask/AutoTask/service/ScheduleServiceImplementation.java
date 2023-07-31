package com.AutoTask.AutoTask.service;

import com.AutoTask.AutoTask.models.Days;
import com.AutoTask.AutoTask.models.Task;
import com.AutoTask.AutoTask.models.User;
import com.AutoTask.AutoTask.repository.DaysRepository;
import com.AutoTask.AutoTask.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImplementation implements ScheduleService{


    @Autowired
    DaysRepository daysRepository;

    @Autowired
    UserServiceImplementation userServiceImplementation;

    @Autowired
    TaskRepository taskRepository;

    /**
     * Method to assign a task to a resource
     * @param task the Task object to be assigned
     */
    public void assignTask(Task task){
        List<User> capablePeoples = userServiceImplementation.getCapableResources(task.getCategory());

        Days dayToBeAssigned = null;
        ArrayList<Days> multiplePossibleDays = new ArrayList<>();

        //For each loop to find all the best day, Will add to array if multiple of the same day are found
        for(User person : capablePeoples){
            Days tempDay;
            tempDay = daysRepository.findBestDay(person.getEmployeeId(), task.getTimeToComplete());


            if (dayToBeAssigned == null || tempDay.getId().getDate().compareTo(dayToBeAssigned.getId().getDate()) < 0) {
                dayToBeAssigned = tempDay;
            }
            else {
                multiplePossibleDays.add(tempDay);
            }
        }
        //Find the Resource with the lest number of skills
        if(multiplePossibleDays.size()>0){
            //Variables to check for least qualified employees
            int count = 5;
            int worstEmpId = 0;
            Days theBestPossibleDay = null;

            //Search threw all the days and find the lest qualified person
            for(Days someDay: multiplePossibleDays){

                Optional<User> optionalTempUser = userServiceImplementation.findById(someDay.getId().getEmployeeID());
                User tempUser = optionalTempUser.get();
                int tempCount = tempUser.getDataSkill() + tempUser.getDeskSkill() + tempUser.getMobileSkill() + tempUser.getNetSkill();

                //The person is less skilled than the current one
                if(tempCount < count){
                    worstEmpId = someDay.getId().getEmployeeID();
                    theBestPossibleDay = someDay;
                    count = tempCount;
                }
                //If the same then we could assign based on number of tasks but i don't want to
            }

            task.setEmpId(worstEmpId);
            theBestPossibleDay.setHoursAvailable(task.getTimeToComplete());
            daysRepository.save(theBestPossibleDay);
            task.setStatus(2);
            taskRepository.save(task);
        }
        else{
            task.setEmpId(dayToBeAssigned.getId().getEmployeeID());
            dayToBeAssigned.setHoursAvailable(task.getTimeToComplete());
            daysRepository.save(dayToBeAssigned);
            task.setStatus(2);
            taskRepository.save(task);
        }



    }

    /**
     * Method to find a specific day
     * @param date the Date of the day to find
     * @param empId unique id used to represent employee
     * @return the Days object
     */
    public Days findSelectedDay(Date date, int empId){
        //TODO implement this method
        Days theDay = null;
        //QUery to be used here can be found in the Robut
        return theDay;
    }
    /**
     * Method to alter the hours of a given day
     * @param theDay is the Days object that needs to be adjusted
     * @param hours available hours needs to be set too
     */
    public void changeHours(Days theDay, double hours){

        Days dayToBeChanged = daysRepository.findDay(theDay.getId().getEmployeeID(), (java.sql.Date)theDay.getId().getDate());
        dayToBeChanged.setHoursAvailable(hours);
        daysRepository.save(dayToBeChanged);


        //Figuer out how to check for assigned tasks and if found call the reAssignTask method (TotalTime < WorkTime)
    }

    /**
     * Method to reassign Task if hours are removed from a schedule
     * !!! Only to be used if schedule is manually adjusted forcing task out !!!
     * @param task the task to be reassigned
     * @param empId the empId that CANNOT be assigned this task
     */
    public void reAssignTask(Task task, int empId){
        List<User> capablePeoples = userServiceImplementation.getCapableResources(task.getCategory());

        Days dayToBeAssigned = null;
        ArrayList<Days> multiplePossibleDays = new ArrayList<>();
        //Removing the person who
        for(User person : capablePeoples){
            if(person.getEmployeeId() == empId){
                capablePeoples.remove(person);
            }
        }

        for(User person : capablePeoples){
            Days tempDay;
            tempDay = daysRepository.findBestDay(person.getEmployeeId(), task.getTimeToComplete());


            if (tempDay.getId().getDate().compareTo(dayToBeAssigned.getId().getDate()) < 0|| dayToBeAssigned == null) {
                dayToBeAssigned = tempDay;
            }
            else {
                multiplePossibleDays.add(tempDay);
            }
        }
        //Find the Resource with the lest number of skills
        if(multiplePossibleDays.size()>0){
            //Variables to check for least qualified employees
            int count = 5;
            int worstEmpId = 0;
            Days theBestPossibleDay = null;

            //Search threw all the days and find the lest qualified person
            for(Days someDay: multiplePossibleDays){

                Optional<User> optionalTempUser = userServiceImplementation.findById(someDay.getId().getEmployeeID());
                User tempUser = optionalTempUser.get();
                int tempCount = tempUser.getDataSkill() + tempUser.getDeskSkill() + tempUser.getMobileSkill() + tempUser.getNetSkill();

                //The person is less skilled than the current one
                if(tempCount < count){
                    worstEmpId = someDay.getId().getEmployeeID();
                    theBestPossibleDay = someDay;
                    count = tempCount;
                }
                //If the same then we could assign based on number of tasks but i don't want to
            }

            task.setEmpId(worstEmpId);
            theBestPossibleDay.setHoursAvailable(task.getTimeToComplete());
            daysRepository.save(theBestPossibleDay);
        }
        else{
            task.setEmpId(dayToBeAssigned.getId().getEmployeeID());
            dayToBeAssigned.setHoursAvailable(task.getTimeToComplete());
            daysRepository.save(dayToBeAssigned);
        }
    }

    /**
     * method for when a Admin assigns a task to a specifc resource
     * @param task the task to be reassigned
     * @param empId the id of the employee to get assigned the task
     */
    public void adminReAssign(Task task, int empId){
        //TODO need to implemnt this stuff
    }


    /**
     * Method to get all hours that can be assigned
     * @param empId the id of the Resource
     * @return the total number of hours avaible to assign tasks too
     */
    public double getAvaibleHours(int empId){
        return getTotalHours(empId) - getWorkHours(empId);
    }

    /**
     * Method to get all the hours that can be worked on the week
     * @param empId the id of the Resource
     * @return the total number of hours that the resource has of this week
     */
    public double getTotalHours(int empId){

        List<Days> allTheDays = daysRepository.getAllDays(empId);

        double totalHours = 0;
        for(Days day: allTheDays){
            totalHours += day.getSetHours();
        }

        return totalHours;
    }

    /**
     * Method to get all the hours the resource has to work this week
     * @param empId the id of the Resource
     * @return the total number of hours a resource is assigned to work
     */
    public double getWorkHours(int empId){

        List<Task> allTheTasks = taskRepository.findTaskByEmployeeId(empId);
        double workingHours = 0;

        for(Task task: allTheTasks){
            workingHours += task.getTimeToComplete();
        }

        return workingHours;
    }

    //Methods still needed
    //Populate Next week


}
