package hackaton.nosavenogain.activity;

import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;

import hackaton.nosavenogain.R;
import hackaton.nosavenogain.adapter.ViewPagerAdapter;
import hackaton.nosavenogain.fragment.Ganhos;
import hackaton.nosavenogain.fragment.OndeReciclar;
import hackaton.nosavenogain.util.Utils;

public class Principal extends AppCompatActivity
{
    private Toolbar toolbar;
    private ViewPager pager;
    private TabLayout tabs;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        init();
    }

    private void init()
    {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setOffscreenPageLimit(2);
        setupViewPager();

        tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(pager);
    }

    private void setupViewPager()
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new Ganhos(), getResources().getString(R.string.tab_1));
        adapter.addFragment(new OndeReciclar(), getResources().getString(R.string.tab_2));

        pager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.principal_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.conta:
                dialog = new Dialog(Principal.this);
                dialog.setContentView(R.layout.dialog_conta);
                dialog.setTitle("Cadastro");
                dialog.getWindow()
                        .setLayout((int) (Utils.getScreenWidth(Principal.this) * .9), ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.show();
                break;

            case R.id.sobre:
                dialog = new Dialog(Principal.this);
                dialog.setContentView(R.layout.dialog_sobre);
                dialog.setTitle("Sobre o APP");
                dialog.show();
                break;

            case R.id.sair:
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
