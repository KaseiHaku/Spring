package kasei.spring.data.convert;

import java.beans.PropertyEditorSupport;

public class TelephonePropertyEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        return ((Telephone)super.getValue()).toString();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text.matches("^\\d+\\-\\d+$")) {
            String[] strs = text.split("-");
            setValue(new Telephone(strs[0], strs[1]));
        } else {
            throw new IllegalArgumentException();
        }
    }
}
