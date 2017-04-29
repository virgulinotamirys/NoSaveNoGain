package hackaton.nosavenogain.util;

import android.app.Activity;
import android.graphics.Point;
import android.widget.EditText;

import hackaton.nosavenogain.R;

/**
 * Created by Tayse V. Ribeiro on 29/04/2017.
 */

public class Utils
{
    public static boolean validaCampo(EditText campo) {
        if (campo.getText().toString().trim().isEmpty()) {
            campo.setError(campo.getContext().getResources().getString(R.string.msg_valida_campo));
            return false;
        }
        return true;
    }

    public static int getScreenWidth(Activity activity) {
        Point size = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(size);
        return size.x;
    }
}
