package tn.esprit.salmen.searchview_recyclerview_filter;

import android.app.ListActivity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.salmen.searchview_recyclerview_filter.adapters.CalorieAdapter;
import tn.esprit.salmen.searchview_recyclerview_filter.models.Calorie;
import tn.esprit.salmen.searchview_recyclerview_filter.utils.CalorieContent;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvCalories;
    LinearLayoutManager layoutManager;
    CalorieAdapter adapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCalories = (RecyclerView) findViewById(R.id.rv_calories);
        rvCalories.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvCalories.setLayoutManager(layoutManager);

        adapter = new CalorieAdapter(CalorieContent.getCalories(), MainActivity.this);
        rvCalories.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchfile, menu);

        final MenuItem myActionMenuItem = menu.findItem(R.id.search);
        searchView = (SearchView) myActionMenuItem.getActionView();
        changeSearchViewTextColor(searchView);
        ((EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text)).setHintTextColor(getResources().getColor(R.color.white));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!searchView.isIconified()) {
                    searchView.setIconified(true);
                }
                myActionMenuItem.collapseActionView();

                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                final List<Calorie> filterModeList = filter(CalorieContent.getCalories(), newText);
                adapter.setFilter(filterModeList);
                return true;
            }
        });
        return true;
    }

    private List<Calorie> filter(List<Calorie> cl, String query) {
        query=query.toLowerCase();
        final List<Calorie> filterModeList = new ArrayList<>();
        for (Calorie model : cl) {
            final String text = model.getName().toLowerCase();
            if (text.startsWith(query)) {
                filterModeList.add(model);
            }
        }
        return filterModeList;
    }

    private void changeSearchViewTextColor(View view) {
        if (view != null) {
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(Color.WHITE);
                return;
            }
            else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    changeSearchViewTextColor(viewGroup.getChildAt(i));
                }
            }
        }
    }
}
