package com.example.records;

// Celisha Daramy / 1340551 - Student Hall Application OOP


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

///**
// * Initialize method is used when runtime is in operation and when it is called from HelloApplication.java by using fxml-loader class
// */

/**
 * Defining HelloController.
 *
 * @FXML annotation defines several variables.
 */
public class HelloController implements Initializable {

//    /**ComoBox - appears list of choices for users to choose*/
    @FXML
    private ComboBox<String> select;

//    /**regDate,birthDate - allows user to pick dates*/
    @FXML
    private DatePicker regDate, birthDate;

//    /**name,addr,id,gender,na,age - text field that allows users' input*/
    @FXML
    private TextField name, addr, id, gender, na, age;

//    /**User can choose one of two options.*/
    @FXML
    private RadioButton r1, r2;

//    /**Two String types for student hall application*/
    public String[] type = {"Student", "Employee"};

//    /**Variables and Local date objects*/
    String Name, ID, Gender, Addr, NA, hallName;
    LocalDate reg, birth;

//    /**Defining variables - p = Person, payment = Payment and h = Hall*/
    Person p;
    Payment payment;
    Hall h;

    /**
     * Define saveButton method, when clicked button will save all values from user input.
     * Saves users input into variables.
     * Also saves value user input from date picker.
     */
    public void saveButton() {
        Name = name.getText();
        ID = id.getText();
        NA = na.getText();
        Gender = gender.getText();
        Addr = addr.getText();
        reg = regDate.getValue();
        if (r1.isSelected()) {
            hallName = r1.getText();
        } else if (r2.isSelected()) {
            hallName = r2.getText();
        }

//        /**
//         * Validates if age entered by the user is a valid integer. If wrong then the alert message will display.
//         */
        int ageInt;
        try {
            ageInt = Integer.parseInt(age.getText());
        } catch (NumberFormatException e) {
            showAlert("Age must be a valid integer.");
            return;
        }

//        /**If any of the fields is left empty then the alert message will display.*/
        if (Name.isEmpty() || ID.isEmpty() || NA.isEmpty() || Gender.isEmpty() || Addr.isEmpty() || reg == null || ageInt <= 0) {
            showAlert("Please fill in all required fields with valid input.");
            return;
        }

//        /**
//         * When student option is selected, new objects will be created from the classes and assign it to the variables from what the users' input.
//         */
        String selectedItem = select.getSelectionModel().getSelectedItem();
        if (selectedItem != null && selectedItem.equals("Student")) {
            p = new Student(Name, Gender, birth, ageInt, Addr, NA, reg, ID);
            h = new Hall(hallName);
            h.addResident(p);
            payment = new Payment("£589.00");

//            /** Show confirmation dialog, displays users' input to check*/
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Save");
            alert.setHeaderText(null);
            alert.setContentText("Please confirm that the following information is correct:\n\n" +
                    "Hall Name: " + hallName + "\n" +
                    "Payment: " + payment.getAmount() + "\n" +
                    "Person Type: Student\n\n" +
                    "Click OK to save all information provided.");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {

//                /**Save the data to student.txt file*/
                File studentFile = new File("student.txt");
                try (PrintWriter writer = new PrintWriter(new FileWriter(studentFile, true))) {
                    writer.println(p.toString() + " " + h.toString() + " " + p.toString());
                } catch (IOException e) {
                    showAlert("Failed to save student data to file.");
                }
            }
        }

//        /**Employee section, same format from previous coding.*/
        if (selectedItem != null && selectedItem.equals("Employee")) {
            p = new Employee(Name, Gender, birth, ageInt, Addr, NA, reg, ID);
            h = new Hall(hallName);
            h.addResident(p);
            payment = new Payment("£850.00");

//            /** Show confirmation dialog, displays users' input to check*/
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Save");
            alert.setHeaderText(null);
            alert.setContentText("Please confirm if the following information is correct:\n\n" +
                    "Hall Name: " + hallName + "\n" +
                    "Payment: " + payment.getAmount() + "\n" +
                    "Person Type: Employee\n\n" +
                    "Click OK to save all information provided.");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {

//                /**Save the data to employee.txt file*/
                File studentFile = new File("employee.txt");
                try (PrintWriter writer = new PrintWriter(new FileWriter(studentFile, true))) {
                    writer.println(p.toString() + h.toString() + p.toString());
                } catch (IOException e) {
                    showAlert("Failed to save student data to file.");
                }
            }
        }
    }

//    /**
//     * Display error message
//     */
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void viewButton() {
        String selectedItem = select.getSelectionModel().getSelectedItem();

//              /** Student section*/
        if (selectedItem != null && selectedItem.equals("Student")) {
            try {
//                /**View data from student.txt file*/
                BufferedReader reader = new BufferedReader(new FileReader("student.txt"));
                ObservableList<String> studentData = FXCollections.observableArrayList();
                String line;
                while ((line = reader.readLine()) != null) {
                    studentData.add(line);
                }
                reader.close();
//                /**
//                 * Display data in a list view.
//                 * Shows error alert if unable to read student data.
//                 * */
                ListView<String> listView = new ListView<>(studentData);
                listView.setPrefSize(500, 500);
                listView.setEditable(false);
                Stage stage = new Stage();
                stage.setScene(new Scene(listView));
                stage.show();
            } catch (IOException e) {
                showAlert("Failed to read student data from file.");
            }
        }
//        /**Employee section*/
        if (selectedItem != null && selectedItem.equals("Employee")) {
            try {
                // Read data from employee.txt file
                BufferedReader reader = new BufferedReader(new FileReader("employee.txt"));
                ObservableList<String> employeeData = FXCollections.observableArrayList();
                String line;
                while ((line = reader.readLine()) != null) {
                    employeeData.add(line);
                }
                reader.close();
//                /**
//                 * Display data in a list view.
//                 * Shows error alert if unable to read employee data.
//                 * */
                ListView<String> listView = new ListView<>(employeeData);
                listView.setPrefSize(500, 500);
                listView.setEditable(false);
                Stage stage = new Stage();
                stage.setScene(new Scene(listView));
                stage.show();
            } catch (IOException e) {
                showAlert("Failed to read employee data from file.");
            }
        }
    }


    /**
     * defines reset button, conformation if user wants to remove all information in the fields.
     */
    public void resetButton() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are you sure you want to reset all fields?");
        alert.setContentText("This action cannot be undone.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            name.setText("");
            addr.setText("");
            id.setText("");
            gender.setText("");
            na.setText("");
            age.setText("");
            regDate.setValue(null);
            birthDate.setValue(null);
        }
    }

    /**
     * The initialize method for the controller class to load the UI components
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        select.getItems().addAll(type);

        /**
         * Set the date picker (calendar) to allow dates after the year 1950
         */
        regDate.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate minDate = LocalDate.of(1950, 1, 1);
                setDisable(empty || date.compareTo(minDate) < 0);
            }
        });
        birthDate.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate minDate = LocalDate.of(1950, 1, 1);
                setDisable(empty || date.compareTo(minDate) < 0);
            }
        });
    }


}