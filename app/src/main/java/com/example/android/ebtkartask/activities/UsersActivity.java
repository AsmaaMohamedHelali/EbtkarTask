package com.example.android.ebtkartask.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.android.ebtkartask.R;
import com.example.android.ebtkartask.adapters.UsersAdapter;
import com.example.android.ebtkartask.utils.network.NetworkUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UsersActivity extends Activity {
    @BindView(R.id.rv_results)
    RecyclerView rvResults;
    @BindView(R.id.progressbar)
    ContentLoadingProgressBar loadingProgressBar;
    private UsersAdapter usersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        ButterKnife.bind(this);
        loadingProgressBar.setVisibility(View.VISIBLE);
        checkNetwork();
    }

    private void checkNetwork() {
        switch (NetworkUtil.getConnectivityStatus(this)) {
            case OFFLINE:
                loadingProgressBar.setVisibility(View.GONE);
                Toast.makeText(this, getString(R.string.offline), Toast.LENGTH_LONG).show();
                break;
            case WIFI_CONNECTED_WITHOUT_INTERNET:
                loadingProgressBar.setVisibility(View.GONE);
                Toast.makeText(this, getString(R.string.offline), Toast.LENGTH_LONG).show();
                break;
            case MOBILE_DATA_CONNECTED:
            case WIFI_CONNECTED_WITH_INTERNET:
                callUsersService();
                break;
        }
    }

    private void callUsersService() {
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvResults.setLayoutManager(layoutManager);

        /*
         * Use this setting to improve performance if you know that changes in content do not
         * change the child layout size in the RecyclerView
         */
        rvResults.setHasFixedSize(true);

        // COMPLETED (13) Pass in this as the ListItemClickListener to the GreenAdapter constructor
        /*
         * The GreenAdapter is responsible for displaying each item in the list.
         */
        usersAdapter = new UsersAdapter( this);
        rvResults.setAdapter(usersAdapter);
    }
}