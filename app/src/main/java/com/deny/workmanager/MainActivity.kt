package com.deny.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.deny.workmanager.MyWorker.Companion.KEY_TASK_OUTPUT
import com.deny.workmanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnOneTime.setOnClickListener {
            val uploadWorkRequest: WorkRequest =
                OneTimeWorkRequestBuilder<MyWorker>()
                    .build()
            WorkManager
                .getInstance(baseContext)
                .enqueue(uploadWorkRequest)

            /*WorkManager
                .getInstance(baseContext)
                .getWorkInfoByIdLiveData(uploadWorkRequest.id)
                .observe(this, Observer {
                    if (it!=null){
                        var aux = it.outputData.getString(MyWorker.KEY_TASK_OUTPUT).toString()

                        Toast.makeText(baseContext, aux, Toast.LENGTH_SHORT).show()
                    }
                })*/
        }
    }
}