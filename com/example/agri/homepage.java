package com.example.agri;

import android.content.Intent;
import android.graphics.Color;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class  homepage extends AppCompatActivity {
  DrawerLayout drawerLayout;
  NavigationView navigationView;
  ImageButton btn;
    GridLayout mainGrid;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
         drawerLayout = findViewById(R.id.drawerlayout);
         navigationView=findViewById(R.id.deview);
         mainGrid = (GridLayout) findViewById(R.id.mainGrid);

         auth=FirebaseAuth.getInstance();


         findViewById(R.id.imagemenu).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 drawerLayout.openDrawer(GravityCompat.START);
             }
         });
   navigationView.setItemIconTintList(null);
        //Set Event
        setSingleEvent(mainGrid);
        //setToggleEvent(mainGrid);
    }

    private void setToggleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Toast.makeText(homepage.this, "State : True", Toast.LENGTH_SHORT).show();

                    } else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(homepage.this, "State : False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.filtermenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch ((item.getItemId())){

            case R.id.gov:
                break;
            case R.id.log:
                logout();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        auth.signOut();

    }


    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                     if(finalI ==0)
                     {
                         Intent intent = new Intent(homepage.this,weather.class);
                         startActivity(intent);
                     }
                    else if(finalI ==1)
                    {
                        Intent intent = new Intent(homepage.this,calender.class);
                        startActivity(intent);
                    }
                    else if(finalI ==2)
                    {
                        Intent intent = new Intent(homepage.this,support.class);
                        startActivity(intent);
                    }
                     else if(finalI ==3)
                     {
                         Intent intent = new Intent(homepage.this,price.class);
                         startActivity(intent);
                     }
                     else if(finalI ==4)
                     {
                         Intent intent = new Intent(homepage.this,retail.class);
                         startActivity(intent);}
                     else if(finalI ==5)
                     {
                         Intent intent = new Intent(homepage.this,social.class);
                         startActivity(intent);
                     }
                     }



            });
        }
    }
}