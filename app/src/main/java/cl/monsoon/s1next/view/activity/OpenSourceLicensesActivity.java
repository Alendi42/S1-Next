package cl.monsoon.s1next.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import cl.monsoon.s1next.R;
import cl.monsoon.s1next.settings.OpenSourceLicensesFragment;

/**
 * An Activity shows the libraries and files we use in our app.
 */
public final class OpenSourceLicensesActivity extends BaseActivity {

    public static void startOpenSourceLicensesActivity(Context context) {
        Intent intent = new Intent(context, OpenSourceLicensesActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_without_drawer);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().add(R.id.frame_layout,
                    new OpenSourceLicensesFragment()).commit();
        }
    }
}
