package project;
//piazza.com cst 242 spring 2016 - office 304
import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import javafx.stage.Stage;
@SuppressWarnings("serial")
public class ScccDataBase extends Application
{

	@Override
	public void start(Stage primaryStage)
	{
		
		primaryStage.setTitle("Suffolk County Community College Database");
		
		GridPane database = new GridPane();
		database.setHgap(8);
		database.setVgap(8);
		database.setPadding(new Insets(20,20,20,20));
		
		GridPane fullTime = new GridPane();
		fullTime.setHgap(8);
		fullTime.setVgap(8);
		fullTime.setPadding(new Insets(20,20,20,20));
		
		
		
		//c0
		Button searchBtn = new Button("Search");
		TextField searchField = new TextField();
		database.add(searchBtn, 0, 0);
		database.add(searchField, 1, 0); //(C,R),(c2,r2)
		
		//c1
		Label lbl = new Label("Update ID:");
		TextField field2 = new TextField();
		database.add(lbl, 0, 1);
		database.add(field2, 1, 1); //(C,R),(c2,r2)
 		
		//c2
		ToggleGroup group = new ToggleGroup();
		/*
		 * private RadioButton fullTimeStudent
		 * private ToggleGroup personType
		 * personType = new ToggleGroup();
		 * fullTimeStudent.setToggleGroup(personType);
		 * fullTimeStudent.setUserData("Full Time Student")
		 * 
		 */
		RadioButton fullTimeStudentBtn = new RadioButton("Full Time Student");
		RadioButton partTimeStudentBtn = new RadioButton("Part Time Student");
		RadioButton fullTimeFacultyBtn = new RadioButton("Full Time Faculty");
		RadioButton adjunctFacultyBtn = new RadioButton("Adjunct Student");
		fullTimeStudentBtn.setToggleGroup(group);
		partTimeStudentBtn.setToggleGroup(group);
		fullTimeFacultyBtn.setToggleGroup(group);
		adjunctFacultyBtn.setToggleGroup(group);
		database.add(fullTimeStudentBtn,0,2);
		database.add(partTimeStudentBtn,1,2);
		database.add(fullTimeFacultyBtn,2,2);
		database.add(adjunctFacultyBtn,3,2);
		
		fullTimeStudentBtn.setSelected(true);
		fullTimeStudentBtn.setVisible(true);
		
		//c3
		Label nameLbl = new Label("Name:");
		TextField nameField = new TextField();
		database.add(nameLbl, 0, 3);
		database.add(nameField, 1, 3); //(C,R),(c2,r2)
		
		Label idLbl = new Label("ID:");
		TextField idField = new TextField();
		database.add(idLbl, 2, 3);
		database.add(idField, 3, 3);
		
		//c4
		
		Label phoneNumLbl = new Label("Phone Number:");
		TextField  phoneNumField = new TextField();
		phoneNumField.setPromptText("###-###-####");
		database.add(phoneNumLbl, 0, 4);
		database.add(phoneNumField, 1, 4); //(C,R),(c2,r2)
		
		Label addressLbl = new Label("Address:");
		TextField addressField = new TextField();
		database.add(addressLbl, 2, 4);
		database.add(addressField, 3, 4);
		
		//c5
		
		Label cityLbl = new Label("City:");
		TextField  cityField = new TextField();
		database.add(cityLbl, 0, 5);
		database.add(cityField, 1, 5); //(C,R),(c2,r2)
		
		Label stateLbl = new Label("State:");
		ComboBox<String> stateBox = new ComboBox<String>();
		stateBox.getItems().addAll("AL Alabama","AK Alaska","AZ Arizona","AR Arkansas","CA California"
				,"CO Colorado","CT Connecticut","DE Delaware","DC District of Columbia","FL Florida"
				,"GA Georgia","HI Hawaii","ID Idaho","IL Illinois","IN Indiana","IA Iowa","KS Kansas","KY Kentucky"
				,"LA Louisiana","ME Maine","MD Maryland","MA Massachusetts","MI Michigan","MN Minnesota","MS Mississippi"
				,"MO Missouri","MT Montana","NE Nebraska","NV Nevada","NH New Hampshire","NJ New Jersey"
				,"NM New Mexico","NY New York","NC North Carolina","ND North Dakota","OH Ohio","OK Oklahoma","OR Oregon"
				,"PA Pennsylvania","RI Rhode Island","SC South Carolina","SD South Dakota"
				,"TN Tennessee","TX Texas","UT Utah","VT Vermont","VA Virginia","WA Washington"
				,"WV West Virginia","WI Wisconsin","WY Wyoming");

		database.add(stateLbl, 2, 5);
		database.add(stateBox, 3, 5);
		
		//c6
		
		Label zipLbl = new Label("Zip Code:");
		TextField zipField = new TextField();
		database.add(zipLbl, 0, 6);
		database.add(zipField, 1, 6); //(C,R),(c2,r2)
		
		Label campusLbl = new Label("Campus:");
		ComboBox<String> campusBox = new ComboBox<String>();
		campusBox.getItems().addAll("Ammerman","Brentwood","Riverhead");
		database.add(campusLbl, 2, 6);
		database.add(campusBox, 3, 6);
		
		//c7
		
		Label majorLbl = new Label("Major:");
		TextField majorField = new TextField();
		database.add(majorLbl, 0, 7);
		database.add(majorField, 1, 7); //(C,R),(c2,r2)
		
		Label gpaLbl = new Label("GPA:");
		TextField gpaField = new TextField();
		database.add(gpaLbl, 2, 7);
		database.add(gpaField, 3, 7);
		
		//c8
		
		Label creditLbl = new Label("Credits:");
		TextField creditField = new TextField();
		database.add(creditLbl, 0, 8);
		database.add(creditField, 1, 8); //(C,R),(c2,r2)
		
		Label tuitionLbl = new Label("Tuition:");
		TextField tuitionField = new TextField();
		tuitionField.setDisable(true);
		database.add(tuitionLbl, 2, 8);
		database.add(tuitionField, 3, 8);
		
		//c9
		
		Label rankLbl = new Label("Rank:");
		TextField rankField = new TextField();
		database.add(rankLbl, 0, 7);
		database.add(rankField, 1, 7);
		
		Label salaryLbl = new Label("Salary:");
		TextField salaryField = new TextField();
		database.add(salaryLbl, 2, 7);
		database.add(salaryField, 3, 7);
		//c10

		Button saveBtn = new Button("Save");
		Button updateBtn = new Button("Update");
		database.add(saveBtn, 0, 10);
		database.add(updateBtn, 1, 10); //(C,R),(c2,r2)
		
		Button deleteBtn = new Button("Delete");
		Button exitBtn = new Button("Exit");
		database.add(deleteBtn, 2, 10);
		database.add(exitBtn, 3, 10); 	
	
		setFullTimeStudentView(majorField, majorLbl, gpaField, gpaLbl, tuitionField, tuitionLbl, fullTimeStudentBtn, salaryField, salaryLbl,
				creditField, creditLbl,rankField, rankLbl);
		
		//Actions
		
		fullTimeStudentBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event)
			{
				setFullTimeStudentView(majorField, majorLbl, gpaField, gpaLbl, tuitionField, tuitionLbl, fullTimeStudentBtn, salaryField, salaryLbl,
						creditField, creditLbl,rankField, rankLbl);
			}
		});
		
		partTimeStudentBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event)
			{
				setPartTimeStudentView(majorField, majorLbl, gpaField, gpaLbl, creditField, creditLbl, tuitionField, tuitionLbl, 
						 partTimeStudentBtn, salaryField, salaryLbl, rankField, rankLbl);
			}
		});
		
		fullTimeFacultyBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event)
			{
				setFullTimeFacultyView(rankField, rankLbl, salaryField, salaryLbl, fullTimeFacultyBtn, creditField, creditLbl, tuitionField, tuitionLbl, majorField,  majorLbl, gpaField, gpaLbl);
			}
		});
		
		adjunctFacultyBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event)
			{
				setAdjunctFacultyView(rankField, rankLbl, salaryField, salaryLbl, creditField, creditLbl , adjunctFacultyBtn,
						majorField, majorLbl, gpaField, gpaLbl, tuitionField, tuitionLbl);
			}
		});
		
		exitBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event)
			{
				Platform.exit();
			}
		});
		
		saveBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event)
			{
				try {
					saveData(nameField, idField, phoneNumField, addressField, cityField, stateBox, zipField,
							campusBox, majorField, gpaField, creditField,  rankField, fullTimeStudentBtn, 
							partTimeStudentBtn,fullTimeFacultyBtn,adjunctFacultyBtn, salaryField);
				} catch (NumberFormatException | IncorrectDataEntry e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				clearFields( nameField,  idField,  phoneNumField, addressField, 
						 majorField,  gpaField,   tuitionField,
						 cityField, stateBox,  zipField, campusBox
						,  salaryField,   creditField,   rankField, searchField);
				
			}
			
		});				
		
		searchBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event)
			{
					
				searchData( searchField,  nameField,  idField,  group,  phoneNumField, 
						 addressField,  cityField,  stateBox,  zipField, 
						 campusBox,  majorField,  majorLbl,  gpaLbl,  tuitionLbl,
						 salaryLbl,  creditLbl,  rankLbl,  gpaField,  creditField, 
						 rankField,  fullTimeStudentBtn, 
						 partTimeStudentBtn,  fullTimeFacultyBtn, 
						 adjunctFacultyBtn,  salaryField,  tuitionField);
				
			}
		});
		
		
		deleteBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event)
			{
				clearFields( nameField,  idField,  phoneNumField, addressField, 
						 majorField,  gpaField,   tuitionField,
						 cityField, stateBox,  zipField, campusBox
						,  salaryField,   creditField,   rankField, searchField);
				
		
			}
		});
		
		/*
		final Menu menu1 = new Menu("File");
		final Menu menu2 = new Menu("Options");
		final Menu menu3 = new Menu("Help");
		 
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(menu1, menu2, menu3);
		database.add(menuBar, 0, 0);
		*/
		Scene scene = new Scene(database, 600,400);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
		
	public static void main(String[] args) 
	{
		Application.launch(args);
	}
	
	//Save Method
	
	ProjectData data = new ProjectData();
	
	
	private void saveData(TextField nameField, TextField idField, TextField phoneNumField, 
			TextField addressField, TextField cityField, ComboBox<String> stateBox, TextField zipField, 
			ComboBox<String> campusBox, TextField majorField, TextField gpaField, 
			TextField creditField, TextField rankField, RadioButton fullTimeStudent, 
			RadioButton partTimeStudentBtn, RadioButton fullTimeFacultyBtn, RadioButton adjuctFacultyBtn, TextField salaryField) throws NumberFormatException, IncorrectDataEntry
	{
		
		//Full time student view
		if(fullTimeStudent.isSelected())
		{
			
			FullTime student = new FullTime(nameField.getText(), phoneNumField.getText(),Integer.parseInt(idField.getText()), 
					addressField.getText(), cityField.getText(), Integer.parseInt(zipField.getText()),campusBox.getValue(),
					stateBox.getValue(),  majorField.getText(), Double.parseDouble(gpaField.getText()), 0);
			
				data.getStudentList().add(student);
				data.saveArrayDataToBinaryFile(data);
		
			
		}
				
		else if(partTimeStudentBtn.isSelected())
		{
			
			PartTime partStudent = new PartTime(nameField.getText(), phoneNumField.getText(),Integer.parseInt(idField.getText()),
					addressField.getText(),	cityField.getText(), campusBox.getValue(),Integer.parseInt(zipField.getText()),
					stateBox.getValue(),  majorField.getText(),  Double.parseDouble(gpaField.getText()), 0,
					 Double.parseDouble((creditField).getText()));
			
			data.getStudentList().add(partStudent);
			data.saveArrayDataToBinaryFile(data);
			
		}
		else if(fullTimeFacultyBtn.isSelected())
		{
			FullTimeFalculty faculty = new FullTimeFalculty(nameField.getText(), phoneNumField.getText(),Integer.parseInt(idField.getText()),
			addressField.getText(), cityField.getText(), stateBox.getValue(), Integer.parseInt(zipField.getText()),
			campusBox.getValue(),rankField.getText() , Double.parseDouble(salaryField.getText()));
			
			data.getFacultyList().add(faculty);
			data.saveArrayDataToBinaryFile(data);
			
		}
		
		else if(adjuctFacultyBtn.isSelected())
		{
		
			AdjunctFalculty adjunct = new AdjunctFalculty(nameField.getText(), phoneNumField.getText(), Integer.parseInt(idField.getText()), 
			addressField.getText(),	cityField.getText(), stateBox.getValue(), Integer.parseInt(zipField.getText()),
			campusBox.getValue(), rankField.getText(), Double.parseDouble(salaryField.getText()),Double.parseDouble(creditField.getText()) );
		
			data.getFacultyList().add(adjunct);
			data.saveArrayDataToBinaryFile(data);
		
		}
			}
	
	//Search Method
	
	private void searchData(TextField searchField, TextField nameField, TextField idField, ToggleGroup group, TextField phoneNumField, 
			TextField addressField, TextField cityField, ComboBox<String> stateBox, TextField zipField, 
			ComboBox<String> campusBox, TextField majorField, Label majorLbl, Label gpaLbl, Label tuitionLbl,
			Label salaryLbl, Label creditLbl, Label rankLbl, TextField gpaField, TextField creditField, 
			TextField rankField, RadioButton fullTimeStudentBtn, 
			RadioButton partTimeStudentBtn, RadioButton fullTimeFacultyBtn, 
			RadioButton adjunctFacultyBtn, TextField salaryField, TextField tuitionField)
	{
		
		int id = Integer.parseInt(searchField.getText());
		Person person = data.searchArray(id, data);
		/*FullTime fullTimeStudent = (FullTime) data.searchArray(id, data);
		PartTime partTimeStudent = (PartTime) data.searchArray(id, data);
		FullTimeFalculty fullTimeFac = (FullTimeFalculty)  data.searchArray(id, data);
		AdjunctFalculty adjFac = (AdjunctFalculty)  data.searchArray(id, data);
		*/
		//setFullTimeStudentView(majorField, majorLbl, gpaField, gpaLbl, tuitionField, tuitionLbl, fullTimeStudentBtn, salaryField, salaryLbl,
		//			creditField, creditLbl,rankField, rankLbl);
			if(person instanceof FullTime)
			{
				data.loadBinaryDataToArrays(data);
			nameField.setText(person.getName());
			idField.setText(String.valueOf(person.getId()));
			phoneNumField.setText(person.getPhoneNum());
			addressField.setText(person.getAddress());
			cityField.setText(person.getCity());
			stateBox.setValue((String) person.getState());	
			zipField.setText(String.valueOf(person.getZip()));
			campusBox.setValue((String) person.getCampus());	
			majorField.setText(((FullTime) person).getMajor());
			gpaField.setText(String.valueOf(((FullTime)person).getGpa()));	
			}
			
			
			else if(person instanceof PartTime)			
			{
			
				
				data.loadBinaryDataToArrays(data);
				nameField.setText(person.getName());
				idField.setText(String.valueOf(person.getId()));
				phoneNumField.setText(person.getPhoneNum());
				addressField.setText(person.getAddress());
				cityField.setText(person.getCity());
				stateBox.setValue((String) person.getState());	
				zipField.setText(String.valueOf(person.getZip()));
				campusBox.setValue((String) person.getCampus());	
				majorField.setText(((PartTime) person).getMajor());
				gpaField.setText(String.valueOf(((PartTime)person).getGpa()));	
				creditField.setText(String.valueOf(((PartTime)person).getCredits()));
				
			}
			
			else if(person instanceof FullTimeFalculty)
			{
			
				data.loadBinaryDataToArrays(data);
				nameField.setText(person.getName());
				idField.setText(String.valueOf(person.getId()));
				phoneNumField.setText(person.getPhoneNum());
				addressField.setText(person.getAddress());
				cityField.setText(person.getCity());
				stateBox.setValue((String) person.getState());	
				zipField.setText(String.valueOf(person.getZip()));
				campusBox.setValue((String) person.getCampus());	
				rankField.setText(String.valueOf(((FullTimeFalculty)person).getRank()));
				salaryField.setText(String.valueOf(((FullTimeFalculty)person).getSalary()));
			}
			
			else if(person instanceof AdjunctFalculty)
			{
			
				data.loadBinaryDataToArrays(data);
				nameField.setText(person.getName());
				idField.setText(String.valueOf(person.getId()));
				phoneNumField.setText(person.getPhoneNum());
				addressField.setText(person.getAddress());
				cityField.setText(person.getCity());
				stateBox.setValue((String) person.getState());	
				zipField.setText(String.valueOf(person.getZip()));
				campusBox.setValue((String) person.getCampus());	
				rankField.setText(String.valueOf(((AdjunctFalculty)person).getRank()));
				salaryField.setText(String.valueOf(((AdjunctFalculty)person).getSalary()));
				creditField.setText(String.valueOf(((AdjunctFalculty)person).getCredits()));
			}
		
		
	}	
		
		
		/*
	
	//setPartTimeStudentView();
		else if(partTimeStudent.equals(person))
				{
					setPartTimeStudentView(majorField, majorLbl, gpaField, gpaLbl, creditField, creditLbl, tuitionField, tuitionLbl, 
							 partTimeStudentBtn, salaryField, salaryLbl, rankField, rankLbl);
					data.loadBinaryDataToArrays(data);
					nameField.setText(partTimeStudent.getName());
					idField.setText(String.valueOf(partTimeStudent.getId()));
					phoneNumField.setText(partTimeStudent.getPhoneNum());
					addressField.setText(partTimeStudent.getAddress());
					cityField.setText(partTimeStudent.getCity());
					stateBox.setValue((String) partTimeStudent.getState());	
					zipField.setText(String.valueOf(partTimeStudent.getZip()));
					campusBox.setValue((String) partTimeStudent.getCampus());	
					majorField.setText(partTimeStudent.getMajor());
					gpaField.setText(String.valueOf(partTimeStudent.getGpa()));
					creditField.setText(String.valueOf(partTimeStudent.getCredits()));
					
				}
		
	
	if(id == person.getId())
		{
			group.selectedToggleProperty();
			new ChangeListener<Toggle>()
			{
				@Override
				public void changed(ObservableValue<? extends Toggle> arg0, 
						Toggle arg1, Toggle arg2) 
				{
					if(group.getSelectedToggle() != null)
						switch(group.getSelectedToggle().getUserData().toString())
						{
						case "Full Time Student":
							setFullTimeStudentView( majorField, null ,  gpaField, null,  tuitionField , 
									null ,  fullTimeStudentBtn,  salaryField, null,  
									creditField, null,  rankField,null);
							break;
						}
				}
			};
		group.selectedToggleProperty();
		new ChangeListener<Toggle>()
		{
			@Override
			public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle arg2) 
			{
				if(group.getSelectedToggle() != null)
					switch(group.getSelectedToggle().getUserData().toString())
					{
					case "Full Time Student":
						setFullTimeStudentView();
						break;
					}
			}
		}

	
			
		
			fullTimeStudent.setSelected(true);
			//setFullTimeStudentView();
			data.loadBinaryDataToArrays(data);
			nameField.setText(person.getName());
			idField.setText(String.valueOf(person.getId()));
			phoneNumField.setText(person.getPhoneNum());
			addressField.setText(person.getAddress());
			cityField.setText(person.getCity());
			Label majorLbl, TextField tuitionField, Label tuitionLbl, Label salaryField, Label creditLbl, Label rankLbl 
			stateBox.setButtonCell(person.getState());
		
		ComboBox stateBox, TextField zipField, 
			//ComboBox campusBox, TextField majorField, TextField gpaField*/
	
	
	/*
	private void checkId()
	{
		if(data.getStudentList())
		{
			
		}
		
	}
	*/
	
	//Views
	
	private void setFullTimeStudentView(TextField majorField, Label majorLbl , TextField gpaField, Label gpaLbl, TextField tuitionField , 
			Label tuitionLbl , RadioButton fullTimeStudentBtn, TextField salaryField, Label salaryLbl, TextField creditField, Label creditLbl, TextField rankField,
			Label rankLbl)
	{
		fullTimeStudentBtn.setSelected(true);
		fullTimeStudentBtn.setVisible(true);
		
		salaryField.setVisible(false);
		salaryLbl.setVisible(false);
		creditField.setVisible(false);
		creditLbl.setVisible(false);
		rankField.setVisible(false);
		rankLbl.setVisible(false);
		
		majorField.setVisible(true);
		majorLbl.setVisible(true);
		gpaField.setVisible(true);
		gpaLbl.setVisible(true);
		tuitionField.setVisible(true);
		tuitionLbl.setVisible(true);
		
		
		
	}
	
	private void setPartTimeStudentView(TextField majorField, Label majorLbl , TextField gpaField, Label gpaLbl, TextField creditField, 
			Label creditLbl ,TextField tuitionField , Label tuitionLbl ,
			RadioButton partTimeStudentBtn, TextField salaryField, Label salaryLbl, TextField rankField,
			Label rankLbl)
	{
		
		partTimeStudentBtn.setSelected(true);
		partTimeStudentBtn.setVisible(true);
		
		salaryField.setVisible(false);
		salaryLbl.setVisible(false);
		rankField.setVisible(false);
		rankLbl.setVisible(false);
		
		majorField.setVisible(true);
		majorLbl.setVisible(true);
		gpaField.setVisible(true);
		gpaLbl.setVisible(true);
		creditField.setVisible(true);
		creditLbl.setVisible(true);
		tuitionField.setVisible(true);
		tuitionLbl.setVisible(true);
		
		
	}
	
	private void setFullTimeFacultyView(TextField rankField, Label rankLbl, TextField salaryField, Label salaryLbl, RadioButton fullTimeFacultyBtn,
			TextField creditField, 
			Label creditLbl ,TextField tuitionField , Label tuitionLbl, TextField majorField, Label majorLbl, TextField gpaField, Label gpaLbl)
	{
		
		fullTimeFacultyBtn.setSelected(true);
		fullTimeFacultyBtn.setVisible(true);
		
		creditField.setVisible(false);
		creditLbl.setVisible(false);
		majorField.setVisible(false);
		majorLbl.setVisible(false);
		gpaField.setVisible(false);
		gpaLbl.setVisible(false);
		tuitionField.setVisible(false);
		tuitionLbl.setVisible(false);
		rankField.setVisible(true);
		rankLbl.setVisible(true);
		salaryField.setVisible(true);
		salaryLbl.setVisible(true);
		
		
	}
	
	private void setAdjunctFacultyView(TextField rankField, Label rankLbl, TextField salaryField, Label salaryLbl, 
			TextField creditField, Label creditLbl, RadioButton adjunctFacultyBtn,  TextField majorField, Label majorLbl, TextField gpaField, Label gpaLbl, TextField tuitionField , Label tuitionLbl)
	{
		
		adjunctFacultyBtn.setSelected(true);
		adjunctFacultyBtn.setVisible(true);
		
		majorField.setVisible(false);
		majorLbl.setVisible(false);
		gpaField.setVisible(false);
		gpaLbl.setVisible(false);
		tuitionField.setVisible(false);
		tuitionLbl.setVisible(false);
		
		creditField.setVisible(true);
		creditLbl.setVisible(true);
		rankField.setVisible(true);
		rankLbl.setVisible(true);
		salaryField.setVisible(true);
		salaryLbl.setVisible(true);
		
		
	}
	
	public void clearFields(TextField nameField, TextField idField, TextField phoneNumField,TextField addressField, 
			TextField majorField, TextField gpaField,  TextField tuitionField,
			TextField cityField, ComboBox<String> stateBox, TextField zipField, ComboBox<String> campusBox
			, TextField salaryField,  TextField creditField,  TextField rankField, TextField searchField)
	{
		nameField.clear();
		idField.clear();
		phoneNumField.clear();
		addressField.clear();
		cityField.clear();
		stateBox.getSelectionModel().clearSelection();
		zipField.clear();
		campusBox.getSelectionModel().clearSelection();
		majorField.clear();
		gpaField.clear();
		creditField.clear();
		rankField.clear();
		salaryField.clear();
		searchField.clear();
	}
	
	
	
}

/*
	
	Final Rectangle rect = new Rectangle(100, 50);
	final ToggleGroup group = new ToggleGroup();
	group.selectToggleProperty().addListener(new ChangeListener<Toggle>(){
		public void chenged(ObservableValue<? extends Toggle> ov			
		Toggle toggle, Toggle new_Toggle}
		{
			if(new_Toggle == null)
				rect.setFill(Color.WHITE);
			else
				(Color)group.getSelectedTiggle().getUserData()
			};
			}
		
	}
	
	
	
	
	
	
 */	
	
	
	
	
	







