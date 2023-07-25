package com.AutoTask.AutoTask.service;

import com.AutoTask.AutoTask.models.Days;
import com.AutoTask.AutoTask.models.Task;
import com.AutoTask.AutoTask.models.User;
import com.AutoTask.AutoTask.repository.DaysRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ScheduleServiceImplementation implements ScheduleService{


    @Autowired
    DaysRepository daysRepository;
    UserServiceImplementation userServiceImplementation = new UserServiceImplementation();

    /**
     * Method to assign a task to a resource
     * @param task the Task object to be assigned
     */
    /*public void assignTask(Task task){
        List<User> capablePeoples = userServiceImplementation.getCapableResources(task.getCategory());

        Days dayToBeAssigned;
        ArrayList<Days> multiplePossibleDays = new ArrayList<>();

        //For each loop to find all the best day, Will add to array if multiple of the same day are found
        for(User person : capablePeoples){
            Days tempDay;
            tempDay = daysRepository.findBestDay(person.getEmployeeId(), task.getTimeToComplete());

            /*
            if(dayToBeAssigned == null || tempDay.getDate() < dayToBeAssigned.getDate()){
                dayToBeAssigned = tempDay;
            }
            else(dayToBeAssigned.getDate() == tempDay.getDate()){
                multiplePossibleDays.add(tempDay);
            }
            */
            //Find the Resource with the lest number of skills

            //Assign to the worst resource
//        }                      Remove Comment
//    }                          Remove Comment

    /**
     * Method to alter the hours of a given day
     * @param theDay is the Days object that needs to be adjusted
     * @param hours available hours needs to be set too
     */
    public void changeHours(Days theDay, double hours){
        /*
        Days dayToBeChanged = daysRepository.findDay(theDay.getEmpId, theDay.getDate);
        dayToBeChanged.setHoursAvailable(hours);
        daysRepository.save(dayToBeChanged);
         */

        //Figuer out how to check for assigned tasks and if found call the reAssignTask method
    }

    /**
     * Method to reassign Task if hours are removed from a schedule
     * !!! Only to be used if schedule is manually adjusted forcing task out !!!
     * @param task the task to be reassigned
     * @param empId the empId that CANNOT be assigned this task
     */
    public void reAssignTask(Task task, int empId){
        List<User> capablePeoples = userServiceImplementation.getCapableResources(task.getCategory());

        //Removing the person who
        for(User person : capablePeoples){
            if(person.getEmployeeId() == empId){
                capablePeoples.remove(person);
            }
        }
    }
}
