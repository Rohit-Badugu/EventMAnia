package com.prodology.prodology;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;



public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Departments");

        getImage();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if(id==R.id.nav_home){
            Intent i=new Intent(this,StartActivity.class);
            startActivity(i);
        }else if(id==R.id.nav_dept){
            Intent i=new Intent(this,HomeActivity.class);
            startActivity(i);
        }
        else if(id==R.id.nav_system){
            Intent i=new Intent(this,SystemActivity.class);
            startActivity(i);

        }
        else if(id==R.id.nav_games){

            Intent i=new Intent(this,GameActivity.class);
            startActivity(i);
        }
        else if(id==R.id.nav_feedback){

            Intent i=new Intent(this,Feedback.class);
            startActivity(i);
        }
        else if(id==R.id.nav_contact){
            Intent i=new Intent(this,ContactActivity.class);
            startActivity(i);

        }
        else if(id==R.id.nav_devs){

            Intent i=new Intent(this,DeveloperActivity.class);
            startActivity(i);
        }

    /*    if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void getImage(){
        String comps = "https://udemy-images.udemy.com/course/750x422/159070_86f8_2.jpg";
        String it = "https://3c1703fe8d.site.internapcdn.net/newman/gfx/news/hires/2014/germansuperc.jpg";
        String tronix = "http://i.ebayimg.com/00/s/NTY2WDg0OQ==/z/p0sAAOSwNSxVPMSF/$_32.JPG?set_id=880000500F";
        String mech = "https://i.ytimg.com/vi/Bp4tGTNNi1I/maxresdefault.jpg";
        String prod = "http://machines.co.nz/wp-content/uploads/2014/03/113768.jpg";
        String civil = "http://www.becbgk.edu/department/civil/civil2.jpg";
        String text = "https://media.nilfisk-advance.com/images/textile/TEXTILE-(2)-cs-870x490-CLHNHM.jpg";


        final ImageView mImageView1 = (ImageView) findViewById(R.id.comps);
        final ImageView mImageView2= (ImageView) findViewById(R.id.it);
        final ImageView mImageView3 = (ImageView) findViewById(R.id.tronix);
        final ImageView mImageView4 = (ImageView) findViewById(R.id.mech);
        final ImageView mImageView5 = (ImageView) findViewById(R.id.prod);
        final ImageView mImageView6 = (ImageView) findViewById(R.id.civil);
        final ImageView mImageView7 = (ImageView) findViewById(R.id.textile);



        ImageRequest imgRequest1 = new ImageRequest(comps,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        mImageView1.setImageBitmap(response);
                    }
                }, 0, 0, ImageView.ScaleType.FIT_XY, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mImageView1.setBackgroundColor(Color.parseColor("#ff0000"));
                error.printStackTrace();
            }
        });

        Volley.newRequestQueue(this).add(imgRequest1);

        ImageRequest imgRequest2 = new ImageRequest(it,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        mImageView2.setImageBitmap(response);
                    }
                }, 0, 0, ImageView.ScaleType.FIT_XY, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mImageView2.setBackgroundColor(Color.parseColor("#ff0000"));
                error.printStackTrace();
            }
        });

        Volley.newRequestQueue(this).add(imgRequest2);

        ImageRequest imgRequest3 = new ImageRequest(tronix,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        mImageView3.setImageBitmap(response);
                    }
                }, 0, 0, ImageView.ScaleType.FIT_XY, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mImageView3.setBackgroundColor(Color.parseColor("#ff0000"));
                error.printStackTrace();
            }
        });

        Volley.newRequestQueue(this).add(imgRequest3);

        ImageRequest imgRequest4 = new ImageRequest(mech,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        mImageView4.setImageBitmap(response);
                    }
                }, 0, 0, ImageView.ScaleType.FIT_XY, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mImageView1.setBackgroundColor(Color.parseColor("#ff0000"));
                error.printStackTrace();
            }
        });

        Volley.newRequestQueue(this).add(imgRequest4);


        ImageRequest imgRequest5 = new ImageRequest(prod,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        mImageView5.setImageBitmap(response);
                    }
                }, 0, 0, ImageView.ScaleType.FIT_XY, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mImageView5.setBackgroundColor(Color.parseColor("#ff0000"));
                error.printStackTrace();
            }
        });

        Volley.newRequestQueue(this).add(imgRequest5);

        ImageRequest imgRequest6 = new ImageRequest(civil,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        mImageView6.setImageBitmap(response);
                    }
                }, 0, 0, ImageView.ScaleType.FIT_XY, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mImageView6.setBackgroundColor(Color.parseColor("#ff0000"));
                error.printStackTrace();
            }
        });

        Volley.newRequestQueue(this).add(imgRequest6);

        ImageRequest imgRequest7 = new ImageRequest(text,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        mImageView7.setImageBitmap(response);
                    }
                }, 0, 0, ImageView.ScaleType.FIT_XY, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mImageView7.setBackgroundColor(Color.parseColor("#ff0000"));
                error.printStackTrace();
            }
        });

        Volley.newRequestQueue(this).add(imgRequest7);




    }


}
