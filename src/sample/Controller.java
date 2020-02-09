package sample;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
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
        employeeListView.getSelectionModel().getSelectedItemProperty().addListener((
                ObservableValue < ? extends Worker> ov, Worker old_val, Worker new_val)->
                {
                    Worker selectedItem = employeeListView.getTypeSelector().getSelectedItem();

                    firstNameTexField.setText(((Employee)selectedItem).firstName);
                    lastNameTextField.setText(((Employee)selectedItem).lastName);
                    isActiveCheckBox.setSelected(((Employee)selectedItem).isActive);

                }
                );
        //To add new employees to the list
        ObservableList<Employee> items = employeeListView.getItems();
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        employee1.firstName = "Robert";
        employee1.lastName = "Smith";
        employee2.firstName = "Lisa";
        employee2.lastName = "Smith";

        items.add(employee1);
        items.add(employee2);

        for (int i = 0, i < 10, i++){
            Employee employee = new Employee();
            employee.firstName = "Generic";
            employee.lastName = "Employee" + " " + i;
            employee.hire();
            items.add(employee);

        }

        //To add new staff to the list
        Staff staff1 = new Staff();
        staff1.firstName = "StaffPerson";
        staff1.lastName = "GoodWorker";

        Faculty faculty1 = new Faculty();
        facutly.firstName = "FacultyPerson";
        faculty.lastName = "TerribleWorker";

        items.add(staff1);
        items.add(faculty1);

    }
}
