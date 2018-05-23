package adminDashBoard;

import dbUtil.dbConnection;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class dashBoardController implements Initializable {
    @FXML
    private Button btnLoad;
    @FXML
    private TableView<employee> employeeTable;
    //add column from SB
    @FXML
    private TableColumn<employee,String> idcolum;
    @FXML
    private TableColumn<employee,String> namecolum;
    @FXML
    private TableColumn<employee,String> positioncolum;
    @FXML
    private TableColumn<employee,String> emailcolum;
    @FXML
    private TableColumn<employee,String> salarycolum;

    private dbConnection db;
    private ObservableList<employee> data;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.db = new dbConnection();

    }

    @FXML
    private void loadEmployeeData(ActionEvent event){
        try {
            Connection conn = dbConnection.getConnection();
            this.data = FXCollections.observableArrayList();
            String sql = "select * from employee";
            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next()) {
                this.data.add(new employee(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.idcolum.setCellValueFactory(new PropertyValueFactory<employee, String>("id"));
        this.namecolum.setCellValueFactory(new PropertyValueFactory<employee,String>("name"));
        this.positioncolum.setCellValueFactory(new PropertyValueFactory<employee,String>("position"));
        this.emailcolum.setCellValueFactory(new PropertyValueFactory<employee, String>("email"));
        this.salarycolum.setCellValueFactory(new PropertyValueFactory<employee, String>("salary"));

        this.employeeTable.setItems(null);
        this.employeeTable.setItems(this.data);


    }



}//class







