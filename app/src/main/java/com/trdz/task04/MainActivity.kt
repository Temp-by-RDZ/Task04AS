package com.trdz.task04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.trdz.task04.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

	private var _binding: ActivityMainBinding? = null
	private val binding get() = _binding!!
	private val alpha = Data("Alpha", 1)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		_binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		initialize()
	}

	private fun initialize() {
		with(binding) {
			tName.text = alpha.name
			tCount.text = alpha.number.toString()
			bSave.setOnClickListener { tSave.text = Database.save(alpha) }
			bGen.setOnClickListener {
				try { alpha.counting(tCol.text.toString().toInt()); tCount.text = alpha.number.toString() }
				catch (Ignored: Exception) { }
			}
		}
	}

	override fun onSaveInstanceState(outState: Bundle) {
		outState.putCharSequence(KEY_NAME, binding.tName.text)
		outState.putCharSequence(KEY_NUMB, binding.tCount.text)
		outState.putCharSequence(KEY_SAVE, binding.tSave.text)
		super.onSaveInstanceState(outState)
	}

	override fun onRestoreInstanceState(savedInstanceState: Bundle) {
		super.onRestoreInstanceState(savedInstanceState)
		with(binding) {
			tName.text = savedInstanceState.getCharSequence(KEY_NAME)
			tCount.text = savedInstanceState.getCharSequence(KEY_NUMB)
			tSave.text = savedInstanceState.getCharSequence(KEY_SAVE)
		}
		alpha.number = binding.tCount.text.toString().toInt()
	}
}