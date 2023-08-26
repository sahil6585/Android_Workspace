package com.example.datepicker_timepicker

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import com.example.datepicker_timepicker.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    companion object
    {
        lateinit var t1:TextView

        lateinit var t2:TextView

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        t1=findViewById(R.id.i1)
        t2=findViewById(R.id.i2)


        binding.b1.setOnClickListener(this)
        binding.b2.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {

        if (p0==binding.b1)
        {
            var dp=DatePickerEx()
            dp.show(supportFragmentManager,"")
        }
        if (p0==binding.b2)
        {
            var dp=TimePickerEx()
            dp.show(supportFragmentManager,"")
        }
    }
}
class DatePickerEx:DialogFragment(), DatePickerDialog.OnDateSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var calendar=Calendar.getInstance()
        var day = calendar.get(Calendar.DAY_OF_MONTH)
        var month = calendar.get(Calendar.MONTH)
        var year = calendar.get(Calendar.YEAR)
        return DatePickerDialog(requireActivity(),this,year,month,day)

    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        (MainActivity).t1.setText("$p3-$p2-$p1")
    }


}

class TimePickerEx:DialogFragment(), TimePickerDialog.OnTimeSetListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var calendar = Calendar.getInstance()
        var hour = calendar.get(Calendar.HOUR_OF_DAY)
        var minute = calendar.get(Calendar.MINUTE)
        return TimePickerDialog(requireActivity(),this,hour,minute,true)
    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        (MainActivity).t2.setText("$p1 - $p2")
    }

}
