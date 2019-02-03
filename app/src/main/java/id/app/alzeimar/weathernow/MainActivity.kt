package id.app.alzeimar.weathernow

import android.Manifest
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Point
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.content.ContextCompat
import android.support.v7.widget.Toolbar
import android.view.Display
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import id.app.alzeimar.weathernow.FragmentVP.BaseFragment
import id.app.alzeimar.weathernow.Fragments.DailyFragment
import id.app.alzeimar.weathernow.Fragments.ForecastFragment
import id.app.alzeimar.weathernow.Fragments.HomeFragment
import id.app.alzeimar.weathernow.MainVP.MainActivityVP
import id.app.alzeimar.weathernow.MainVP.MainActvityPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_toolbar.*

class MainActivity : AppCompatActivity(),MainActivityVP.View {

    override fun setColor(statusColor: Int) {

        val status:Window = getWindow()
        status.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        status.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        status.statusBarColor = ContextCompat.getColor(applicationContext,R.color.home)
    }

    override fun setFragment(fragment: BaseFragment) {
        fragment.atachPresenter(presenter)
        supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.enter_from_left,R.anim.exit_to_right,R.anim.enter_from_right,R.anim.exit_to_left).replace(R.id.content_fragment,fragment).commit()
    }

    private lateinit var presenter:MainActvityPresenter

    private val mOnNavigationItemSelectedListener = object : BottomNavigationView.OnNavigationItemSelectedListener{
        override fun onNavigationItemSelected(p0: MenuItem): Boolean {
            when(p0.itemId){
                R.id.weather_now->{
                    presenter.addFragment(HomeFragment())
                    //toolbar.setBackgroundColor(Color.parseColor("#37AAE1"))
                    presenter.addColor(R.color.home)
                    return true
                }
                R.id.suggest_petani->{
                    presenter.addFragment(DailyFragment())
                    //toolbar.setBackgroundColor(Color.parseColor("#37AAE1"))
                    //supportActionBar!!.title = "Tanaman"
                    presenter.addColor(R.color.home)
                    return true
                }
                R.id.daily_weather->{
                    presenter.addFragment(ForecastFragment())
                    //toolbar.setBackgroundColor(Color.parseColor("#37AAE1"))
                    //supportActionBar!!.title = "Tanaman"
                    return true
                }

            }
            return false
        }

    }
    private val LOCATION_PERMS = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
    lateinit var toolbar:Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestPermissions(LOCATION_PERMS, 1340)
        init()

        presenter = MainActvityPresenter(this)
        bottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        presenter.addFragment(HomeFragment())
    }

    fun init(){
//        toolbar = findViewById(R.id.toolbar_custom)
//        toolbar.setBackgroundColor(Color.parseColor("#37AAE1"))
//        setSupportActionBar(toolbar)
    }

    fun setImage(){
        val display:Display = windowManager.defaultDisplay
        val point:Point = Point()
        display.getSize(point)
        var bmp:Bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources,R.drawable.bg_home),point.x,point.y,true)

    }
}
