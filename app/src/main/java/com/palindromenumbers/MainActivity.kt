package com.palindromenumbers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_number.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (TextUtils.isEmpty(et_number.text))
            Toast.makeText(this, getString(R.string.please_enter_number), Toast.LENGTH_SHORT).show()
        else {
            if (getPalindromeNumbers(et_number.text.toString().toInt())) {
                tv_result.text = getString(R.string.entered_number_is_palindrome)
            } else
                tv_result.text = getString(R.string.entered_number_is_not_palindrome)
        }
    }

    private fun getPalindromeNumbers(number: Int): Boolean {
        var n = number
        var digit : Int
        var result = 0
        while (n != 0) {
            digit = n % 10
            n /= 10
            result = result * 10 + digit
        }
        return result == number
    }
}
