/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;
import java.util.Date;

/**
 *
 * @author noahkiefer
 */
public class Model {
    int taskCounter = 0;
    Task[] tasks = new Task[100];
    FileHelper helper = new FileHelper();
    
    Model(){
        // Constructor
        // Need to parse strings from helper
        String lines[] = helper.readTasks();
        
        // loop through each line and create a new task out of it 
        for(int i =0; i < lines.length; i++) {
            // Create the ith new task
            tasks[i] = new Task();
            // split the line where the # is
            String taskLine[] = lines[i].split("#");
            //use the first part to set new title and the second part to set new description  
            tasks[i].setTitle(taskLine[0]);
            tasks[i].setDescription(taskLine[1]);
            // tasks[i].setDueDate(taskLine[2]);
            
        }
        // tasks = helper.readTasks();
        taskCounter = lines.length;
    }
    void add(String title, String description, Date dueDate){
        // add a new Task
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);

        
        // add new task to the tasks array
        tasks[taskCounter] = task;
        taskCounter++;
        
        // Need to save tasks to file
        helper.writeTasks(getTasks());
    } 
    void remove(int index){
        // SL Comp Sci level ...
        
        for(int i = index; i < taskCounter; i++){
            // assigning in Comp Sci goes from right to left so in this case: tasks[i+1] will be assigned into tasks[i]
            tasks[i] = tasks[i+1];
        }
        
        taskCounter -= 1;
        
        helper.writeTasks(getTasks());
    }
    void edit(int index, String title, String description, Date dueDate){
        // Update the information of the taks at index
        tasks[index].setDescription(description);
        tasks[index].setTitle(title);

        
        helper.writeTasks(getTasks());
    }
    
    String[] getTasks() {
        // Create a new string array
        String[] tmpTasks = new String[taskCounter];
        //Loop through the tasks and add a string represntation of each one to the new array
        for (int i = 0; i < taskCounter; i++) {
        // Assign a string representation if the ith task to the ith element of tmpTasks
        tmpTasks[i] = tasks[i].toString();
    }
        //return the array 
        return tmpTasks;
        
    }
    
    String[] getTaskValues(int index) {
        String[] values = new String[2];
        values[0] = tasks[index].getTitle();
        values[1] = tasks[index].getDescription();
     //   values[2] = tasks[index].getDueDate();
        return values;
    }
}
