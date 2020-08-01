package com.example.thinkerlab;

import android.animation.ArgbEvaluator;
import android.app.Activity;
import android.app.NotificationChannel;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.database.DataSetObserver;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBar actionBar;
     private FirebaseAuth firebaseAuth;
      CardView sc,maths,eng,tech;
      GoogleSignInClient mGoogleSignInClient;
    private static final String TAG="HomePage";
    private ArrayList<String>title=new ArrayList<>();
    private ArrayList<String>desc=new ArrayList<>();
    private ArrayList<Integer>img=new ArrayList<>();
    private Context context;
      ViewPager viewPager;
      Homeadapter adapter;
      List<homehelper> models;
      Integer[] colors=null;
      ArgbEvaluator argbEvaluator=new ArgbEvaluator();
     // private Switch myswitch;
    RecyclerView recyclerView;

    //private AppBarConfiguration mAppBarConfiguration;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       /* if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.darktheme);
        } else {
            setTheme(R.style.AppTheme);
        }*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        imageBitmaps();
        //rv=findViewById(R.id.rv);
        //Featured_Recycler();
       /* models=new ArrayList<>();
        models.add(new homehelper(R.drawable.ph,"Phone Pe","Flat 50% off on PhonePe transactions"));
        models.add(new homehelper(R.drawable.ph,"Phone Pe","Flat 50% off on PhonePe transactions"));
        models.add(new homehelper(R.drawable.ph,"Phone Pe","Flat 50% off on PhonePe transactions"));
        models.add(new homehelper(R.drawable.ph,"Phone Pe","Flat 50% off on PhonePe transactions"));
        models.add(new homehelper(R.drawable.ph,"Phone Pe","Flat 50% off on PhonePe transactions"));
        models.add(new homehelper(R.drawable.ph,"Phone Pe","Flat 50% off on PhonePe transactions"));
        adapter=new Homeadapter(models,this);
        viewPager=(ViewPager)findViewById(R.id.rv);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);
        Integer[] colors_temp={getResources().getColor(R.color.color1),getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),getResources().getColor(R.color.color4)};
        colors=colors_temp;
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position<(adapter.getCount()-1)&&position<(colors.length-1)){
                    viewPager.setBackgroundColor((Integer)argbEvaluator.evaluate(positionOffset,colors[position],colors[position+1]));
                }
                else
                {
                    viewPager.setBackgroundColor(colors[colors.length-1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });*/



        GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                // .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient=GoogleSignIn.getClient(this,gso);
        GoogleSignInAccount account= GoogleSignIn.getLastSignedInAccount(this);
        if(account!=null)
        {
            String pN=account.getDisplayName();
            String pGN=account.getGivenName();
            String pFN=account.getFamilyName();
            String pE=account.getEmail();
            String pI=account.getId();
            //String p=account.getPhotoUrl();
            Toast.makeText(HomePage.this,pN+pE,Toast.LENGTH_SHORT).show();
        }

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        firebaseAuth=FirebaseAuth.getInstance();
        toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        sc=findViewById(R.id.Science);
        maths=findViewById(R.id.Maths);
        eng=findViewById(R.id.Engg);
        tech=findViewById(R.id.Tech);

       // myswitch=(Switch)findViewById(R.id.myswitch);
        /*if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES)
        {
            myswitch.setChecked(true);
        }*/
       // myswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                               // @Override
                                              //  public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                  //  if (isChecked) {
                                                       // getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                                                        //restartApp();
                                                 //   } else {
                                                       // getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                                                        //restartApp();
                                                   // }
                                               // }
                                           // });''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
        sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i = new Intent(HomePage.this, Science.class);
                startActivity(i);
            }
        });
        maths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  i = new Intent(HomePage.this, Maths.class);
                startActivity(i);
            }
        });
        eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this, Engineering.class);
                startActivity(i);

            }
        });
        tech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this, Technology.class);
                startActivity(i);
            }
        });
        navigationView.setCheckedItem(R.id.nav_home);


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
       // mAppBarConfiguration = new AppBarConfiguration.Builder(
              //  R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
              //  .setDrawerLayout(drawerLayout)
               // .build();
        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
       // NavigationUI.setupWithNavController(navigationView, navController);
    }

   /* private void Featured_Recycler() {
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<homehelper> fl=new ArrayList<>();
        fl.add(new homehelper(R.drawable.ph,"Phone Pe","Flat 50% off on PhonePe transactions"));
        fl.add(new homehelper(R.drawable.ph,"Phone Pe","Flat 50% off on PhonePe transactions"));
        fl.add(new homehelper(R.drawable.ph,"Phone Pe","Flat 50% off on PhonePe transactions"));
        fl.add(new homehelper(R.drawable.ph,"Phone Pe","Flat 50% off on PhonePe transactions"));
        fl.add(new homehelper(R.drawable.ph,"Phone Pe","Flat 50% off on PhonePe transactions"));
        fl.add(new homehelper(R.drawable.ph,"Phone Pe","Flat 50% off on PhonePe transactions"));
        adapter=new Homeadapter(fl);
        rv.setAdapter(adapter);
    }*/
  private void imageBitmaps()
   {
       Log.d(TAG,"onCreateViewHolder: called.");
       img.add(R.drawable.ph);
       title.add("PhonePe");
       desc.add("Flat 50% off on PhonePe transactions");

       img.add(R.drawable.ph);
       title.add("PhonePe");
       desc.add("Flat 50% off on PhonePe transactions");

       img.add(R.drawable.ph);
       title.add("PhonePe");
       desc.add("Flat 50% off on PhonePe transactions");

       img.add(R.drawable.ph);
       title.add("PhonePe");
       desc.add("Flat 50% off on PhonePe transactions");

       img.add(R.drawable.ph);
       title.add("PhonePe");
       desc.add("Flat 50% off on PhonePe transactions");

       img.add(R.drawable.ph);
       title.add("PhonePe");
       desc.add("Flat 50% off on PhonePe transactions");

       img.add(R.drawable.ph);
       title.add("PhonePe");
       desc.add("Flat 50% off on PhonePe transactions");

       img.add(R.drawable.ph);
       title.add("PhonePe");
       desc.add("Flat 50% off on PhonePe transactions");

       img.add(R.drawable.ph);
       title.add("PhonePe");
       desc.add("Flat 50% off on PhonePe transactions");

       img.add(R.drawable.ph);
       title.add("PhonePe");
       desc.add("Flat 50% off on PhonePe transactions");

       img.add(R.drawable.ph);
       title.add("PhonePe");
       desc.add("Flat 50% off on PhonePe transactions");

       img.add(R.drawable.ph);
       title.add("PhonePe");
       desc.add("Flat 50% off on PhonePe transactions");
       initRecyclerView();
   }
   private void initRecyclerView()
   {
       recyclerView=findViewById(R.id.rv);
       recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
       //final LinearLayoutManager layoutManager=new LinearLayoutManager(HomePage.this,LinearLayoutManager.HORIZONTAL,false);
       Homeadapter homeadapter=new Homeadapter(this,title,desc,img);

       recyclerView.setAdapter(homeadapter);

      // RecyclerView recyclerView=findViewById(R.id.rv);

       //Homeadapter homeadapter=new Homeadapter(this,title,desc,img);

   }

    public void restartApp()
    {
        Intent i= new Intent(getApplicationContext(),HomePage.class);
        startActivity(i);
        finish();
    }
    private  void signOut(){
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(HomePage.this,"Signed Out Successfully!",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
    }






    public void onBackPressed()
    {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.share)
        {
            ApplicationInfo api=getApplicationContext().getApplicationInfo();
            String s=api.sourceDir;
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("application/vnd.android.package-archive");
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(s)));
            startActivity(Intent.createChooser(intent,"Share Via"));
        }
        return true;
    }
    // @Override
   // public boolean onSupportNavigateUp() {
       // NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
       // return NavigationUI.navigateUp(navController, mAppBarConfiguration)
              //  || super.onSupportNavigateUp();
  //  }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.nav_home:
                break;
            case R.id.nav_Science:
                startActivity(new Intent(HomePage.this,Science.class));
                break;
            case R.id.nav_Mathematics:
                startActivity(new Intent(HomePage.this,Maths.class));
                break;
            case R.id.nav_Engineering:
                startActivity(new Intent(HomePage.this,Engineering.class));
                break;
            case R.id.nav_Technology:
                startActivity(new Intent(HomePage.this,Technology.class));
                break;
            case R.id.nav_Profile:
                startActivity(new Intent(HomePage.this,Profile.class));
                break;
            case R.id.nav_Teach_with_us:
                startActivity(new Intent(HomePage.this,TeachWithUs.class));
                break;
            case R.id.nav_Linkedin:
                Intent i= new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.linkedin.com/company/thinker-lab"));
                startActivity(i);
            case R.id.nav_Insta:
                Intent iii= new Intent(Intent.ACTION_VIEW);
                iii.setData(Uri.parse("http://www.instagram.com/thinker_lab_kolkata"));
                startActivity(iii);
                break;
            case R.id.nav_FB:
                Intent ii= new Intent(Intent.ACTION_VIEW);
                ii.setData(Uri.parse("http://www.facebook.com/thinkerlabkolkata"));
                startActivity(ii);
                break;
            case R.id.nav_Log_out:
                signOut();
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(HomePage.this,LoginActivity.class));
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return  true;
    }


}
