package com.deny.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.*
import androidx.work.*
import com.deny.workmanager.MyWorker.Companion.KEY_TASK_OUTPUT
import com.deny.workmanager.MyWorkerB.Companion.KEY_TASK_OUTPUT2
import com.deny.workmanager.databinding.ActivityMainBinding
import com.deny.workmanager.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.java.KoinJavaComponent

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModel()
    private var count = ""
    private var director1 = ""
    private var director2 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setListener()
        setView()
    }

    private fun setView() {
        lifecycleScope.launch(Dispatchers.Main){
            viewModel.getMovies().observe(this@MainActivity, Observer {
                binding.textDirector1.text = it.elementAt(0).director
            })
            viewModel.getDirector().observe(this@MainActivity, Observer {
                binding.textDirector2.text = it.elementAt(1).director
            })
        }
    }

    private fun setListener() {

        /*val uploadWorkRequest =
            OneTimeWorkRequestBuilder<MyWorker>()
                .build()

        val uploadWorkRequestB =
            OneTimeWorkRequestBuilder<MyWorkerB>()
                .build()

        WorkManager
            .getInstance(this)
            .beginWith(uploadWorkRequest)
            .then(uploadWorkRequestB)
            .enqueue()*/

        binding.btnOneTime.setOnClickListener {

            /*WorkManager
                .getInstance()
                .getWorkInfoByIdLiveData(uploadWorkRequest.id)
                .observe(this, Observer {
                    if (it!=null){
                        if (it.state.isFinished){
                            var aux = it.outputData.getString(KEY_TASK_OUTPUT).toString()
                            Toast.makeText(
                                baseContext,
                                aux,
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                })*/
          lifecycleScope.launch {
              viewModel.getMovies().observe(this@MainActivity, Observer {
                  count += it.elementAt(0).director
                  Toast.makeText(baseContext, count.toString(), Toast.LENGTH_LONG).show()
              })
            }
        }
        binding.btnPeriodic.setOnClickListener {

            /*WorkManager
                .getInstance()
                .getWorkInfoByIdLiveData(uploadWorkRequestB.id)
                .observe(this, Observer {
                    if (it!=null){
                        if (it.state.isFinished){
                            var aux = it.outputData.getString(KEY_TASK_OUTPUT2).toString()
                            Toast.makeText(
                                baseContext,
                                aux,
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                })*/

            lifecycleScope.launch {
                viewModel.apply {
                    this.getDirector().observe(this@MainActivity, Observer {
                        count += it.elementAt(1).director
                        Toast.makeText(
                            baseContext,
                            count,
                            Toast.LENGTH_LONG
                        ).show()
                    })
                }
            }
        }
    }
}