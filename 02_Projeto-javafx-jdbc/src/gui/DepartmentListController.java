package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import db.DbIntegrityException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable, DataChangeListener  {
	
	// DECLARAÇÃO
	private DepartmentService service;
	
	private ObservableList<Department> obsList;
	
	@FXML
	private TableView<Department> tableViewDepartment;

	@FXML
	private TableColumn<Department, Integer> tableColumnId;

	@FXML
	private TableColumn<Department, String> tableColumnName;
	
	@FXML
	private TableColumn<Department, Department> tableColumnEDIT;
	
	@FXML
	private TableColumn<Department, Department> tableColumnREMOVE;

	@FXML
	private Button btNew;

	// METODOS
	@FXML
	public void onBtNewAction(ActionEvent event) {
		// Pega a tela na qual esta 
		Stage parentStage = Utils.currentStage(event);
		// Cria uma nova tela apartir da chamada da função
		Department obj = new Department();
		createDialogForm(obj, "/gui/DepartmentForm.fxml", parentStage);
	}
	
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}
	
	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}
		List<Department> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewDepartment.setItems(obsList);
		initEditButtons();
		initRemoveButtons();
	}
	
	// Carregar a janela para preencher o Department
	private void createDialogForm(Department obj, String absoluteName, Stage parentStage) {
		try {
			// Carregar a view
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();
			
			// Carregar o controller e passar o dados do Department para a nova tela
			DepartmentFormController controller = loader.getController();
			controller.setDepartment(obj);
			controller.setDepartmentService(new DepartmentService());
			controller.subscribeDataChangeListener(this);
			controller.updateFormData();

			// Instanciar um novo stage, pis vai ser uma janela na frente do outro
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Entre com os Dados do Department");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);	// A tela não pode ser redimensonada
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL); // Trava a janela, enquanto não fechar a janela atual não pode acessar outra janela
			dialogStage.showAndWait();
		}
		catch (IOException e) {
			e.printStackTrace();
			Alerts.showAlert("IO Exception", "Erro no carregamento da view", e.getMessage(), AlertType.ERROR);
		}
	}
	
	@Override
	public void onDataChanged() {
		updateTableView();
	}
	
	private void initEditButtons() {
		tableColumnEDIT.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnEDIT.setCellFactory(param -> new TableCell<Department, Department>() {
			private final Button button = new Button("Editar");

			@Override
			protected void updateItem(Department obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(
						event -> createDialogForm(obj, "/gui/DepartmentForm.fxml", Utils.currentStage(event)));
			}
		});
	}
	
	private void initRemoveButtons() {
		tableColumnREMOVE.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnREMOVE.setCellFactory(param -> new TableCell<Department, Department>() {
			private final Button button = new Button("Deletar");

			@Override
			protected void updateItem(Department obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(event -> removeEntity(obj));
			}
		});
	}

	private void removeEntity(Department obj) {
		Optional<ButtonType> result = Alerts.showConfirmation("Confirmação", "Tem certeza que deseja deletar?");

		if (result.get() == ButtonType.OK) {
			if (service == null) {
				throw new IllegalStateException("Service was null");
			}
			try {
				service.remove(obj);
				updateTableView();
			}
			catch (DbIntegrityException e) {
				Alerts.showAlert("Error removing object", null, e.getMessage(), AlertType.ERROR);
			}
		}
	}

	// INICIALIZAÇÃO
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes() {
		// Inicializar as colunas Id e Name
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));

		// Fazer com que a tabela acompanhe o tamanho da tela principal
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
	}

}
