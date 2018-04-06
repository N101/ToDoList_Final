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
public class ToDoList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Model model = new Model();
        ViewController viewController = new ViewController(model);
        viewController.setVisible(true);
        
        // test code
//        model.add("Task 2", "Finish code", new Date());
//        model.add("Math HW", "5.11 handout all questions", new Date());
//        model.add("Test trial 1", "Test", new Date());
//        model.add("Test trial 2", "Test", new Date());
//        model.add("Tshould be moved to [3]", "Test", new Date());
//        
//        model.edit(2, "edited'", "has been editied", new Date());
//        model.remove(3);
        
//        System.out.println("Done");
    }
    
}
