package sample;

//import com.sun.corba.se.spi.orbutil.threadpool.Work;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    //Instance variables to add new person to list:
    @FXML
    private ListView <Employee> employeeListView;
    @FXML
    private TextField firstNameTexField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private CheckBox isActiveCheckBox;



    @Override
    public void initialize(URL location, ResourceBundle resources){
        employeeListView.getSelectionModel().selectedItemProperty().addListener((
                ObservableValue < ? extends Worker> ov, Worker old_val, Worker new_val)->
                {
                    //returns selected employee object:
                    Worker selectedItem = employeeListView.getSelectionModel().getSelectedItem();

                    firstNameTexField.setText(((Employee)selectedItem).firstName);
                    lastNameTextField.setText(((Employee)selectedItem).lastName);
                    isActiveCheckBox.setSelected(((Employee)selectedItem).isActive);


                }
                );
        //Manual way to create new employees:
        ObservableList<Employee> items = employeeListView.getItems();
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        Employee employee3 = new Employee();
        employee1.firstName = "Robert";
        employee1.lastName = "Smith";
        employee2.firstName = "Lisa";
        employee2.lastName = "Smith";
        employee3.firstName = "Lance";
        employee3.lastName = "Brown";

        //Adds created employees to the employeeListView:
        items.add(employee1);
        items.add(employee2);
        items.add(employee3);

        /*for (int i = 0, i < 10, i++){
            Employee employee = new Employee();
            employee.firstName = "Generic";
            employee.lastName = "Employee" + " " + i;
            employee.hire();
            items.add(employee);

        }*/

        //To add new staff to the list:
        Staff staff1 = new Staff();
        Staff staff2 = new Staff();
        Staff staff3 = new Staff();
        staff1.firstName = "Damon";
        staff1.lastName = "Richards";
        staff2.firstName = "Bob";
        staff2.lastName = "Wright";
        staff3.firstName = "John";
        staff3.lastName = "Sanders";

        Faculty faculty1 = new Faculty();
        Faculty faculty2 = new Faculty();
        Faculty faculty3 = new Faculty();
        faculty1.firstName = "Jeff";
        faculty1.lastName = "Gold";
        faculty2.firstName = "Jessica";
        faculty2.lastName = "Lopez";
        faculty3.firstName = "Albert";
        faculty3.lastName = "Green";

        items.add(staff1);
        items.add(staff2);
        items.add(staff3);

        items.add(faculty1);
        items.add(faculty2);
        items.add(faculty3);

    }

    //Adds new "user entered" employees to the list:
    public void addButtonClicked(){
        //Takes first and last name entered:
        Employee newEmployee = new Employee (firstNameTexField.getText(), lastNameTextField.getText());

        //Adds first and last names to employee list:
        employeeListView.getItems().add(newEmployee);

    }

    //Clears any input currently in the text fields:
    public void clearButtonClicked(){

    }

    //Deletes employee selected by user:
    public void deleteButtonClicked(){

    }
}
