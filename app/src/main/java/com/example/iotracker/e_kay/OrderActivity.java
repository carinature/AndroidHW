package com.example.iotracker.e_kay;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    private static final String BAD = "BAD";    //TODO - remove, for debug
//        Log.d(BAD, "111111111");

//    private RecyclerView mRecyclerView;
//    private RecyclerView.Adapter mAdapter;
//    private RecyclerView.LayoutManager mLayoutManager;

    private String[] values =
            new String[]{"Nexus 5", "Samsung Galaxy S", "Nokia Lumia", "BlackBerry", "Xiomi MI6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
//        Log.d(BAD, "111111111");

//        Toolbar toolbar = (Toolbar) findViewById(R.id.order_toolbar);
//        setSupportActionBar(toolbar);
//        try {
//            getSupportActionBar().setTitle("Order Information");
////            getSupportActionBar().setLogo(R.drawable.ic_launcher);
////            getSupportActionBar().setDisplayUseLogoEnabled(true);
////            getSupportActionBar().setIcon(R.drawable.ic_launcher);
////            getSupportActionBar().setDisplayShowHomeEnabled(true);
//        } catch (Exception e) {
//            Log.d(BAD, "didn't find the toolbar...?");
//            e.printStackTrace();
//        }

        /*  retrieve the name of the user   */
        Intent intent = getIntent();
        String welcome_name = "Welcome " +
                intent.getStringExtra(MainActivity.EXTRA_MESSAGE_NAME) + ".";

        /*  make the info retrieved visible in the screen    */
        TextView textViewName = (TextView) findViewById(R.id.welcome_text);
//        textViewName.setTextSize(40);
        textViewName.setText(welcome_name);

        ListView listView = (ListView) findViewById(R.id.order_list_view);
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, R.layout.checked_text_item, values);
        listView.setAdapter(arrayAdapter);

        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ((CheckedTextView) view).setChecked(true);
            }
        });

    }

    public void orderButtonClicked(View view){

        ListView listView = (ListView) findViewById(R.id.order_list_view);
//        CheckedTextView checkedTextView = (CheckedTextView) findViewById(R.id.checked_text_view);

        int checkedItemIndex = listView.getCheckedItemPosition();
//        Log.d(BAD, String.valueOf(checkedItemIndex));
        DialogInterface.OnClickListener onClickListenerYes = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ListView listView = (ListView) findViewById(R.id.order_list_view);
                            int checkedItemIndex = listView.getCheckedItemPosition();
                            String deviseName = values[checkedItemIndex];
                            Toast.makeText(getApplicationContext(),
                                    deviseName + " order sent!",
                                    Toast.LENGTH_SHORT)
                                    .show();
                        }
                    };
        DialogInterface.OnClickListener onClickListenerNo = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        };
        if (-1 < checkedItemIndex){
            String deviseName = values[checkedItemIndex];
            new AlertDialog.Builder(this)
                    //header
                    .setTitle("E-Kay")
                    .setMessage("Approve order for: " + deviseName + "?")
                    .setPositiveButton("YES", onClickListenerYes)
                    .setNegativeButton("No", onClickListenerNo)
                    .show();
        }

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

}
        /*
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new RecyclerAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);


//        // specify an adapter (see also next example)
//        String[] myDataset = {"KAKA", "PIPI", "NANA", "LALA"};
//        mAdapter = new RecyclerAdapter(myDataset);
//        mRecyclerView.setAdapter(mAdapter);
        */

//          listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//          @Override
//          public void onItemClick(AdapterView<?> adapterView,View view,int position,long id){
////                Toast.makeText(getApplicationContext(),
////                        ((CheckedTextView)view).getText() + " clicked, item No. " + position,
////                        Toast.LENGTH_SHORT)
////                        .show();
//        ((CheckedTextView)view).setChecked(true);
//        }
//        });

//    @Override
//    public void onBackPressed() {
//        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
//                .setMessage("Are you sure?")
//                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Intent intent = new Intent(Intent.ACTION_MAIN);
//                        intent.addCategory(Intent.CATEGORY_HOME);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        startActivity(intent);
//                        finish();
//                    }
//                }).setNegativeButton("no", null).show();
//    }