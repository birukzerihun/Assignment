

package HomeWork1;


import HomeWork1.Selection;
import HomeWork1.dbconnectionclass;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import static javafx.scene.text.Font.font;
import static javafx.scene.text.Font.font;
import static javafx.scene.text.Font.font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.swing.JOptionPane;


public class Main extends Application {
private TableView table = new TableView<>();
private ObservableList<ObservableList> data;

public Text ut =new Text("SID");
public Text pt =new Text("studID");
public Text fn =new Text("Firstname");
public Text ln =new Text("Lasatname");
public Text sec =new Text("Section");
public Text dep =new Text("Department");
public TextField sidField= new TextField();
public TextField studidField= new TextField();
public TextField firstNameField= new TextField();
public TextField lastNameField= new TextField();
public TextField sectionField= new TextField();
public TextField departmentField= new TextField();


Button insert = new Button("insert");
Button update = new Button("update");
Button view = new Button("view");
   // private Paint table;
    public void start(Stage primaryStage) {
         insert.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              dbconnectionclass ne = new dbconnectionclass();
              Connection con; 
         
                String sql = "Insert into dept_tb1 (SID, studId, Firstname, Lastname,Section, Department ) Values (?,?,?,?,?,?)";
                String ut = sidField.getText();
                String pt = studidField.getText();
                String fn = firstNameField.getText();
                String ln = lastNameField.getText();
                String sec = sectionField.getText();
                String dep = departmentField.getText();
                try {
                 con = ne.connMethod();
                    PreparedStatement pre;
                    try {
                        
                        pre = con.prepareStatement(sql);
                        pre.setString(1, ut);
                        pre.setString(2, pt);
                        pre.setString(3, fn);
                        pre.setString(4, ln);
                        pre.setString(5, sec);
                        pre.setString(6, dep);
                        int i = pre.executeUpdate();
                        if (i == 1) {

                            //AlertDialog.("info","Data Inserted succsecfully");
                            JOptionPane.showMessageDialog(null,"Data Inserted ");
                        }

                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }


                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
  
update.setOnAction(new EventHandler<ActionEvent>() {


@Override
            public void handle(ActionEvent event) 
            { dbconnectionclass ne = new dbconnectionclass();
                Connection con;
     
                try
                {
               
                    con=ne.connMethod();
                    String Aman="aman";
                    String txx="biruk";
           String sql = "UPDATE dept_tb1 SET Firstname='"+txx+"' WHERE Firstname='"+Aman+"'";
 
PreparedStatement statement = con.prepareStatement(sql);

             statement.executeUpdate();
              JOptionPane.showMessageDialog(null,"The Data Is Updated successfully!");
            }
                catch(Exception ex)
                {
                  JOptionPane.showMessageDialog(null,ex.getMessage());  
                }
        }
        });

view.setOnAction(new EventHandler<ActionEvent>() {
 private ObservableList<ObservableList> data;
// private TableView table;
            @Override
            public void handle(ActionEvent event) 
            {
             
        dbconnectionclass ne = new dbconnectionclass();
        Connection con;
        ResultSet rs;
        data = FXCollections.observableArrayList();
        try {


         
            con = ne.connMethod();
                String SQL = "SELECT * from dept_tb1";
                rs = con.createStatement().executeQuery(SQL);
                for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>,
                        ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));

                table.getColumns().addAll(col);
             

            }


            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                row.add(rs.getString(i));
                }
             
                data.add(row);

            }


            table.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
           JOptionPane.showMessageDialog(null,"Error ");
        }
            }
});

   
        
   GridPane root = new GridPane();
   VBox vbox = new VBox();
  
       root.add(ut,0,1);
     root.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));

       root.add(sidField,1,1);
    root.add(pt,0,2);
     root.add(studidField,1,2);
      root.add(fn,0,3);
      root.add(firstNameField,1,3);
      root.add(ln,3,3);
      root.add(lastNameField,4,3);
      root.add(sec,3,2);
      root.add(sectionField,4,2);
      root.add(dep,3,1);
       root.add(departmentField,4,1);
       root.add(insert,0,7);
      root.add(update,1,7);
     root.add(view,2,7);
      root.add(table,3,0);
   
     
       
             Scene scene = new Scene(root, 800, 650);
 
   
        primaryStage.setTitle("Registration Form");
        primaryStage.setScene(scene);
       
        primaryStage.show();
        Label label =new Label();
           
    } 
         
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        launch(args);
        dbconnectionclass ne = new dbconnectionclass();
          Selection nn=new Selection();
      Connection conn=nn.connMethod();
   
        
    
}
}