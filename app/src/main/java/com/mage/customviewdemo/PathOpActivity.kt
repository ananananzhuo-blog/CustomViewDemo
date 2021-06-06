package com.mage.customviewdemo

import android.graphics.Color
import android.graphics.Path
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.mage.customviewdemo.view.PathOpView

class PathOpActivity : AppCompatActivity() {
    var pathView: PathOpView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_path_op)
        val seekbar = findViewById<SeekBar>(R.id.seekbar)
         pathView = findViewById<PathOpView>(R.id.pathopview)
        seekbar.max = 100
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            seekbar.min = 30
        }
        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                pathView?.setRadius(3 * progress / 100f)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
        findViewById<Button>(R.id.btn_selectOps).setOnClickListener {
            showPop()
        }
    }

    val datas = listOf<Path.Op>(
        Path.Op.DIFFERENCE,
        Path.Op.INTERSECT,
        Path.Op.REVERSE_DIFFERENCE,
        Path.Op.UNION,
        Path.Op.XOR
    )

    private fun showPop() {
        var pop = ListPopupWindow(this)
        pop.setAdapter(
            ArrayAdapter<Path.Op>(
                this,
                R.layout.item,
                R.id.tv_item,
                datas
            )
        )
        pop.width = resources.displayMetrics.widthPixels
//        pop.height = 300
        pop.setBackgroundDrawable(ColorDrawable(Color.WHITE))
        pop.anchorView = findViewById(R.id.btn_selectOps)
        pop.setOnItemClickListener { parent, view, position, id ->
            pathView?.ops=datas[position]
            pop.dismiss()
        }
        pop.show()
    }

}