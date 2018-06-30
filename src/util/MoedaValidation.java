package util;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;

public class MoedaValidation {

	public static void monetaryField(final TextField textField) {
	        textField.setAlignment(Pos.CENTER_LEFT);
	        textField.lengthProperty().addListener(new ChangeListener<Number>() {
	            @Override
	            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
	                String value = textField.getText();
	                value = value.replaceAll("[^0-9]", "");
	                value = value.replaceAll("([0-9]{1})([0-9]{14})$", "$1$2");
	                value = value.replaceAll("([0-9]{1})([0-9]{11})$", "$1$2");
	                value = value.replaceAll("([0-9]{1})([0-9]{8})$", "$1$2");
	                value = value.replaceAll("([0-9]{1})([0-9]{5})$", "$1$2");
	                value = value.replaceAll("([0-9]{1})([0-9]{2})$", "$1.$2");
	                textField.setText(value);
	                //positionCaret(textField);

	                textField.textProperty().addListener(new ChangeListener<String>() {
	                    @Override
	                    public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
	                        if (newValue.length() > 17)
	                            textField.setText(oldValue);
	                    }
	                });
	            }
	        });

	        textField.focusedProperty().addListener(new ChangeListener<Boolean>() {
	            @Override
	            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean fieldChange) {
	                if (!fieldChange) {
	                    final int length = textField.getText().length();
	                    if (length > 0 && length < 3) {
	                        textField.setText(textField.getText() + "00");
	                    }
	                }
	            }
	        });
	    }
	private static void positionCaret(final TextField textField) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                // Posiciona o cursor sempre a direita.
                textField.positionCaret(textField.getText().length());
            }
        });
    }
}
