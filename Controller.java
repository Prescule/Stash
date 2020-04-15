import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {

	@FXML
	private Text ausgabe;
	private long num1 = 0;
	private long num2 = 0;
	private String operator = "";
	private boolean start = true;
	private Model model = new Model();
	private boolean stelle = true;
	private long x = 10;

	@FXML
	private void actionNumber(ActionEvent event) {
		if (start) {
			if (stelle) {
				String temp = ((Button) event.getSource()).getText();
				ausgabe.setText(temp);
				num1 = Long.parseLong(temp);
				check();
				stelle = false;
				return;
			}
			String temp = ((Button) event.getSource()).getText();
			num1 = (num1 * x) + Long.parseLong(temp);
			ausgabe.setText(String.valueOf(num1));
			check();
			return;
		}
		if (stelle) {
			String temp = ((Button) event.getSource()).getText();
			ausgabe.setText(temp);
			num2 = Long.parseLong(temp);
			check();
			stelle = false;
			return;
		}
		String temp = ((Button) event.getSource()).getText();
		num2 = (num2 * x) + Long.parseLong(temp);
		ausgabe.setText(String.valueOf(num2));
		check();
		return;
	}

	@FXML
	private void actionOperator(ActionEvent event) {
		String temp = ((Button) event.getSource()).getText();
		if ("=".equals(temp) | "+".equals(operator)) {
			ausgabe.setText(String.valueOf(model.calc(num1, num2, operator)));

			num1 = model.calc(num1, num2, operator);
			num2 = 0;
			start = false;
			stelle = true;
			x = 10;
			check();
			return;
		}
		operator = temp;
		start = false;
		stelle = true;
		check();
		return;

	}

	@FXML
	private void actionClear(ActionEvent event) {
		num1 = 0;
		num2 = 0;
		operator = "";
		start = true;
		stelle = true;
		x= 10;
		ausgabe.setText("0");
		return;
	}

	private void check() {
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(operator);

	}

}
