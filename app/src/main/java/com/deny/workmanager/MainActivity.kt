package com.deny.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.*
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.deny.workmanager.MyWorker.Companion.KEY_TASK_OUTPUT
import com.deny.workmanager.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel
    private var count = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this).get()

        setListener()

    }

    private fun setListener() {
        binding.btnOneTime.setOnClickListener {
            lifecycleScope.launch {
                viewModel.apply {
                    this.getMovies().observe(this@MainActivity, Observer {
                        count += it.elementAt(0).director
                    })
                }
            }
        }
        binding.btnPeriodic.setOnClickListener {
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