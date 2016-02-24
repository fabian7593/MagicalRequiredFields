package com.frosquivel.magicalrequiredfields;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;
import java.util.Collections;
import java.util.List;

/**
 * Created by          Fabián Rosales Esquivel
 * Visit my web page   http://www.frosquivel.com
 * Visit my blog       http://www.frosquivel.com/blog
 * Created Date        on 2/15/16
 * This is an android library for made the required fields in a magical form.
 */
public class MagicalRequiredFields {

    /**
     * The constructor method for validate the required fields in this GUI components:
     * Edit text, TextView, Spinner, Switch, Toggle Button, and imageView, SeekBar, ProgressBar, RatingBar
     * @param views A list of views of this GUI components
     * @param validateMessage the mesagge to show  as an error in this components
     * @return a boolean, if is not have required fields empty, this return true, else this return false.
     */
    public static boolean MagicalRequiredFields(List<View> views, String validateMessage) {
        Collections.reverse(views);

        boolean passedValidation = true;

        if(views!=null) {
            if (views.size() > 0) {
                for (View view : views) {
                    passedValidation = validateErrorRegularViews(view, validateMessage);
                    passedValidation = validateErrorImBarViews(view);
                }
            }
        }

        return passedValidation;
    }

    /**
     * The constructor method for validate the required fields in this GUI components:
     * Edit text, TextView, Spinner, Switch, Toggle Button, and imageView, SeekBar, ProgressBar, RatingBar
     * ANd too the checkbox and radio Button.
     * @param views A list of views of this GUI components
     * @param listViews A list of list of views of checkbox group and radio button group
     * @param validateMessage the mesagge to show as an error in this components
     * @return a boolean, if is not have required fields empty, this return true, else this return false.
     */
    public static boolean MagicalRequiredFields(List<View> views, List<List<View>> listViews, String validateMessage) {
        Collections.reverse(views);

        boolean passedValidation = true;

        if(views!=null) {
            if (views.size() > 0) {
                for (View view : views) {
                    passedValidation = validateErrorRegularViews(view, validateMessage);
                    passedValidation = validateErrorImBarViews(view);
                }
            }
        }

        if(listViews!=null){
            if(listViews.size()>0){
                for (List<View> list : listViews) {
                    passedValidation = true;

                    if(list!=null) {
                        if (list.size() > 0) {
                            passedValidation = validateErrorRadioButton(list,validateMessage);
                            passedValidation = validateErrorCheckBox(list,validateMessage);
                        }
                    }

                }
            }
        }

        return passedValidation;
    }


    /**
     * This is a method to validate the required fields of
     * EditText, Spinner, Switch, ToggleButton
     * @param view A list of views of this GUI components
     * @param validateMessage the mesagge to show as an error in this components
     * @return a boolean, if is not have required fields empty, this return true, else this return false.
     */
    public static boolean validateErrorRegularViews(View view,String validateMessage){

        boolean passedValidation = true;
        if(view!=null) {
                if (view instanceof EditText) {
                    if (((EditText) view).getText().toString().trim().equals("")) {
                        ((EditText) view).setError(validateMessage);
                        passedValidation = false;
                    } else {
                        ((EditText) view).setError(null);
                    }
                } else if (view instanceof Spinner) {

                    if (((Spinner) view).getSelectedItemPosition() == 0) {
                        ((TextView) ((Spinner) view).getSelectedView()).setError(validateMessage);
                        passedValidation = false;
                    }
                } else if (view instanceof Switch) {

                    if (!((Switch) view).isChecked()) {
                        ((Switch) view).setError(validateMessage);
                        passedValidation = false;
                    }
                } else if (view instanceof ToggleButton) {

                    if (!((ToggleButton) view).isChecked()) {
                        ((ToggleButton) view).setError(validateMessage);
                        passedValidation = false;
                    }
                }
        }
     return passedValidation;
    }

    /**
     * This is a method to validate the required fields of
     * ImageView, SeekBar, ProgressBar, RatingBar
     * @param view A list of views of this GUI components
     * @return a boolean, if is not have required fields empty, this return true, else this return false.
     */
    public static boolean validateErrorImBarViews(View view) {
        boolean passedValidation = true;
        if(view!=null) {
            if (view instanceof ImageView) {

                if (((ImageView) view).getDrawable() == null) {
                    passedValidation = false;
                }
            } else if (view instanceof SeekBar) {

                if (((SeekBar) view).getProgress() == 0) {
                    passedValidation = false;
                }
            } else if (view instanceof ProgressBar) {

                if (((ProgressBar) view).getProgress() == 0) {
                    passedValidation = false;
                }
            } else if (view instanceof RatingBar) {

                if (((RatingBar) view).getProgress() == 0) {
                    passedValidation = false;
                }
            }
        }
        return passedValidation;
    }

    /**
     * This method validate the group of radio buttons
     * @param views Alist of radio buttons in the group of radio buttons
     * @param validateMessage the mesagge to show as an error in this components
     * @return a boolean, if is not have required fields empty, this return true, else this return false.
     */
    public static boolean validateErrorRadioButton(List<View> views, String validateMessage) {
        boolean passedValidation = true;
        int countChecked=0;
        View viewRadio=null;

        if(views!=null) {
            if(views.size() > 0) {
                for (View view : views) {
                    if (view instanceof RadioButton) {
                        if (((RadioButton) view).isChecked()) {
                            countChecked++;
                        }
                        viewRadio = view;
                    }
                }

                if (countChecked > 0) {
                    passedValidation = true;
                    ((RadioButton) viewRadio).setError(null);
                } else {
                    passedValidation = false;
                    ((RadioButton) viewRadio).setError(validateMessage);
                }
            }
        }

        return passedValidation;
    }


    /**
     * This method validate the group of checkbox
     * @param views A list of checkbox in the group of checkbox
     * @param validateMessage the mesagge to show as an error in this components
     * @return a boolean, if is not have required fields empty, this return true, else this return false.
     */
    public static boolean validateErrorCheckBox(List<View> views, String validateMessage) {
        boolean passedValidation = true;
        int countChecked=0;
        View viewCheckBox=null;

        if(views!=null) {
            if (views.size() > 0) {
                for (View view : views) {
                    if (view instanceof CheckBox) {
                        if (((CheckBox) view).isChecked()) {
                            countChecked++;
                        }
                        viewCheckBox = view;
                    }
                }

                if (countChecked > 0) {
                    passedValidation = true;
                    ((CheckBox) viewCheckBox).setError(null);
                } else {
                    passedValidation = false;
                    ((CheckBox) viewCheckBox).setError(validateMessage);
                }
            }
        }

        return passedValidation;
    }

}
