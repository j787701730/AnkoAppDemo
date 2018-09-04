package com.example.aoc.ankoappdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.net.URL

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    var ver = verticalLayout {
      var name = editText()
      button("点我") {
        onClick {
          //          toast("${name.text}")

          doAsync {
            //            var text1 = URL("https://www.zhengw.top/getbooks").readText()
//            toast("${text1}")
            Request().run()
//            Log.d(javaClass.simpleName, text1)
            uiThread {
//              longToast("123123")
            }
          }
        }
      }
    }


  }


  public class Request() {
    public fun run() {
      val str = URL("https://www.zhengw.top/getbooks").readText()
      Log.d(javaClass.simpleName, str)
    }
  }


  /*
  * public class Request(val url: String) {
    public fun run() {
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
    }
}*/
}
