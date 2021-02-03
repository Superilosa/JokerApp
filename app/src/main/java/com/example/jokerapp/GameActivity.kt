package com.example.jokerapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class GameActivity : AppCompatActivity() {

    var c1 = 0
    var c2 = 0
    var c3 = 0
    var w1 = 0
    var w2 = 0
    var w3 = 0

    var xishti: Int? = null
    var moshla: Boolean? = null
    var gaormageba: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        init()
    }

    private fun init() {
        val player1 = intent.extras?.getString("player1", "პირველი მოთამაშე")
        val player2 = intent.extras?.getString("player2", "მეორე მოთამაშე")
        val player3 = intent.extras?.getString("player3", "მესამე მოთამაშე")
        val player4 = intent.extras?.getString("player4", "მეოთხე მოთამაშე")
        xishti = intent.extras?.getInt("xishti", 200)
        moshla = intent.extras?.getBoolean("moshla", false)
        gaormageba = intent.extras?.getBoolean("gaormageba", false)

        name1.text = player1
        name2.text = player2
        name3.text = player3
        name4.text = player4

        cInput(1, r1p1c, 1)
    }

    //ცხადების ფუნქცია//////////////////////////////////////////////////////////
    private fun cInput(round: Int, c: TextView, n: Int) {
        w1 = 0
        w2 = 0
        w3 = 0
        c.setBackgroundColor(resources.getColor(R.color.green))

        var ramden = -1
        if (n == 4) {
            ramden = round - c1 - c2 - c3
        }

        for (i in 0..round) {
            if (i == ramden) {
                continue
            }
            when (i) {
                0 -> activateButtonC(round, c, xishtiButton, n)
                1 -> activateButtonC(round, c, button1, n)
                2 -> activateButtonC(round, c, button2, n)
                3 -> activateButtonC(round, c, button3, n)
                4 -> activateButtonC(round, c, button4, n)
                5 -> activateButtonC(round, c, button5, n)
                6 -> activateButtonC(round, c, button6, n)
                7 -> activateButtonC(round, c, button7, n)
                8 -> activateButtonC(round, c, button8, n)
                9 -> activateButtonC(round, c, button9, n)
            }
        }
    }

    private fun activateButtonC(round: Int, c: TextView, button: Button, n: Int) {
        button.setBackgroundColor(resources.getColor(R.color.green))
        button.isClickable = true
        button.setOnClickListener {
            c.text = button.text.toString()
            c.setBackgroundColor(resources.getColor(R.color.transparent))
            inputStop()
            if (n != 4) {
                giveValueC(n, c)
            }
            callNext(round, c)
        }
    }

    //წაღების ფუნქცია//////////////////////////////////////////////
    private fun wInput(round: Int, w: TextView, c: TextView, n: Int) {
        c1 = 0
        c2 = 0
        c3 = 0
        w.setBackgroundColor(resources.getColor(R.color.green))

        val darcha = round - w1 - w2 - w3
        for (i in 0..darcha) {
            if (n == 4 && i in 0..(darcha - 1)) {
                continue
            }
            when (i) {
                0 -> activateButtonW(round, w, c, xishtiButton, n)
                1 -> activateButtonW(round, w, c, button1, n)
                2 -> activateButtonW(round, w, c, button2, n)
                3 -> activateButtonW(round, w, c, button3, n)
                4 -> activateButtonW(round, w, c, button4, n)
                5 -> activateButtonW(round, w, c, button5, n)
                6 -> activateButtonW(round, w, c, button6, n)
                7 -> activateButtonW(round, w, c, button7, n)
                8 -> activateButtonW(round, w, c, button8, n)
                9 -> activateButtonW(round, w, c, button9, n)
            }
        }
    }

    private fun activateButtonW(round: Int, w: TextView, c: TextView, button: Button, n: Int) {
        button.setBackgroundColor(resources.getColor(R.color.green))
        button.isClickable = true
        button.setOnClickListener {
            if (c.text.toString() == button.text.toString()) {
                if (button.text.toString() == "-") {
                    w.text = "50"
                } else if (button.text.toString().toInt() == round) {
                    w.text = (round * 100).toString()
                } else {
                    w.text = (50 + button.text.toString().toInt() * 50).toString()
                }
            } else {
                if (button.text.toString() == "-") {
                    w.text = (xishti?.times((-1))).toString()
                } else {
                    w.text = ((button.text.toString().toInt()) * 10).toString()
                }
            }
            w.hint = button.text.toString()
            w.setBackgroundColor(resources.getColor(R.color.transparent))
            inputStop()
            if (n != 4) {
                giveValueW(n, w)
            }
            callNext(round, w)
        }
    }

    //ღილაკების გაუქმება
    private fun inputStop() {
        xishtiButton.isClickable = false
        xishtiButton.setBackgroundColor(resources.getColor(R.color.gray))
        button1.isClickable = false
        button1.setBackgroundColor(resources.getColor(R.color.gray))
        button2.isClickable = false
        button2.setBackgroundColor(resources.getColor(R.color.gray))
        button3.isClickable = false
        button3.setBackgroundColor(resources.getColor(R.color.gray))
        button4.isClickable = false
        button4.setBackgroundColor(resources.getColor(R.color.gray))
        button5.isClickable = false
        button5.setBackgroundColor(resources.getColor(R.color.gray))
        button6.isClickable = false
        button6.setBackgroundColor(resources.getColor(R.color.gray))
        button7.isClickable = false
        button7.setBackgroundColor(resources.getColor(R.color.gray))
        button8.isClickable = false
        button8.setBackgroundColor(resources.getColor(R.color.gray))
        button9.isClickable = false
        button9.setBackgroundColor(resources.getColor(R.color.gray))
    }

    //შემდეგ ფუნქციაზე გადასვლა
    private fun callNext(round: Int, view: TextView) {
        when (view) {
            r1p1c -> cInput(round, r1p2c, 2)
            r1p2c -> cInput(round, r1p3c, 3)
            r1p3c -> cInput(round, r1p4c, 4)
            r1p4c -> wInput(round, r1p1w, r1p1c, 1)
            r1p1w -> wInput(round, r1p2w, r1p2c, 2)
            r1p2w -> wInput(round, r1p3w, r1p3c, 3)
            r1p3w -> wInput(round, r1p4w, r1p4c, 4)
            r1p4w -> cInput(round + 1, r2p2c, 1)
            r2p2c -> cInput(round, r2p3c, 2)
            r2p3c -> cInput(round, r2p4c, 3)
            r2p4c -> cInput(round, r2p1c, 4)
            r2p1c -> wInput(round, r2p2w, r2p2c, 1)
            r2p2w -> wInput(round, r2p3w, r2p3c, 2)
            r2p3w -> wInput(round, r2p4w, r2p4c, 3)
            r2p4w -> wInput(round, r2p1w, r2p1c, 4)
            r2p1w -> cInput(round + 1, r3p3c, 1)
            r3p3c -> cInput(round, r3p4c, 2)
            r3p4c -> cInput(round, r3p1c, 3)
            r3p1c -> cInput(round, r3p2c, 4)
            r3p2c -> wInput(round, r3p3w, r3p3c, 1)
            r3p3w -> wInput(round, r3p4w, r3p4c, 2)
            r3p4w -> wInput(round, r3p1w, r3p1c, 3)
            r3p1w -> wInput(round, r3p2w, r3p2c, 4)
            r3p2w -> cInput(round + 1, r4p4c, 1)
            r4p4c -> cInput(round, r4p1c, 2)
            r4p1c -> cInput(round, r4p2c, 3)
            r4p2c -> cInput(round, r4p3c, 4)
            r4p3c -> wInput(round, r4p4w, r4p4c, 1)
            r4p4w -> wInput(round, r4p1w, r4p1c, 2)
            r4p1w -> wInput(round, r4p2w, r4p2c, 3)
            r4p2w -> wInput(round, r4p3w, r4p3c, 4)
            r4p3w -> cInput(round + 1, r5p1c, 1)
            r5p1c -> cInput(round, r5p2c, 2)
            r5p2c -> cInput(round, r5p3c, 3)
            r5p3c -> cInput(round, r5p4c, 4)
            r5p4c -> wInput(round, r5p1w, r5p1c, 1)
            r5p1w -> wInput(round, r5p2w, r5p2c, 2)
            r5p2w -> wInput(round, r5p3w, r5p3c, 3)
            r5p3w -> wInput(round, r5p4w, r5p4c, 4)
            r5p4w -> cInput(round + 1, r6p2c, 1)
            r6p2c -> cInput(round, r6p3c, 2)
            r6p3c -> cInput(round, r6p4c, 3)
            r6p4c -> cInput(round, r6p1c, 4)
            r6p1c -> wInput(round, r6p2w, r6p2c, 1)
            r6p2w -> wInput(round, r6p3w, r6p3c, 2)
            r6p3w -> wInput(round, r6p4w, r6p4c, 3)
            r6p4w -> wInput(round, r6p1w, r6p1c, 4)
            r6p1w -> cInput(round + 1, r7p3c, 1)
            r7p3c -> cInput(round, r7p4c, 2)
            r7p4c -> cInput(round, r7p1c, 3)
            r7p1c -> cInput(round, r7p2c, 4)
            r7p2c -> wInput(round, r7p3w, r7p3c, 1)
            r7p3w -> wInput(round, r7p4w, r7p4c, 2)
            r7p4w -> wInput(round, r7p1w, r7p1c, 3)
            r7p1w -> wInput(round, r7p2w, r7p2c, 4)
            r7p2w -> cInput(round + 1, r8p4c, 1)
            r8p4c -> cInput(round, r8p1c, 2)
            r8p1c -> cInput(round, r8p2c, 3)
            r8p2c -> cInput(round, r8p3c, 4)
            r8p3c -> wInput(round, r8p4w, r8p4c, 1)
            r8p4w -> wInput(round, r8p1w, r8p1c, 2)
            r8p1w -> wInput(round, r8p2w, r8p2c, 3)
            r8p2w -> wInput(round, r8p3w, r8p3c, 4)
            r8p3w -> {
                gamotvla(1)
                cInput(round + 1, r9p1c, 1)
            }
            r9p1c -> cInput(round, r9p2c, 2)
            r9p2c -> cInput(round, r9p3c, 3)
            r9p3c -> cInput(round, r9p4c, 4)
            r9p4c -> wInput(round, r9p1w, r9p1c, 1)
            r9p1w -> wInput(round, r9p2w, r9p2c, 2)
            r9p2w -> wInput(round, r9p3w, r9p3c, 3)
            r9p3w -> wInput(round, r9p4w, r9p4c, 4)
            r9p4w -> cInput(round, r10p2c, 1)
            r10p2c -> cInput(round, r10p3c, 2)
            r10p3c -> cInput(round, r10p4c, 3)
            r10p4c -> cInput(round, r10p1c, 4)
            r10p1c -> wInput(round, r10p2w, r10p2c, 1)
            r10p2w -> wInput(round, r10p3w, r10p3c, 2)
            r10p3w -> wInput(round, r10p4w, r10p4c, 3)
            r10p4w -> wInput(round, r10p1w, r10p1c, 4)
            r10p1w -> cInput(round, r11p3c, 1)
            r11p3c -> cInput(round, r11p4c, 2)
            r11p4c -> cInput(round, r11p1c, 3)
            r11p1c -> cInput(round, r11p2c, 4)
            r11p2c -> wInput(round, r11p3w, r11p3c, 1)
            r11p3w -> wInput(round, r11p4w, r11p4c, 2)
            r11p4w -> wInput(round, r11p1w, r11p1c, 3)
            r11p1w -> wInput(round, r11p2w, r11p2c, 4)
            r11p2w -> cInput(round, r12p4c, 1)
            r12p4c -> cInput(round, r12p1c, 2)
            r12p1c -> cInput(round, r12p2c, 3)
            r12p2c -> cInput(round, r12p3c, 4)
            r12p3c -> wInput(round, r12p4w, r12p4c, 1)
            r12p4w -> wInput(round, r12p1w, r12p1c, 2)
            r12p1w -> wInput(round, r12p2w, r12p2c, 3)
            r12p2w -> wInput(round, r12p3w, r12p3c, 4)
            r12p3w -> {
                gamotvla(2)
                cInput(round - 1, r13p1c, 1)
            }
            r13p1c -> cInput(round, r13p2c, 2)
            r13p2c -> cInput(round, r13p3c, 3)
            r13p3c -> cInput(round, r13p4c, 4)
            r13p4c -> wInput(round, r13p1w, r13p1c, 1)
            r13p1w -> wInput(round, r13p2w, r13p2c, 2)
            r13p2w -> wInput(round, r13p3w, r13p3c, 3)
            r13p3w -> wInput(round, r13p4w, r13p4c, 4)
            r13p4w -> cInput(round - 1, r14p2c, 1)
            r14p2c -> cInput(round, r14p3c, 2)
            r14p3c -> cInput(round, r14p4c, 3)
            r14p4c -> cInput(round, r14p1c, 4)
            r14p1c -> wInput(round, r14p2w, r14p2c, 1)
            r14p2w -> wInput(round, r14p3w, r14p3c, 2)
            r14p3w -> wInput(round, r14p4w, r14p4c, 3)
            r14p4w -> wInput(round, r14p1w, r14p1c, 4)
            r14p1w -> cInput(round - 1, r15p3c, 1)
            r15p3c -> cInput(round, r15p4c, 2)
            r15p4c -> cInput(round, r15p1c, 3)
            r15p1c -> cInput(round, r15p2c, 4)
            r15p2c -> wInput(round, r15p3w, r15p3c, 1)
            r15p3w -> wInput(round, r15p4w, r15p4c, 2)
            r15p4w -> wInput(round, r15p1w, r15p1c, 3)
            r15p1w -> wInput(round, r15p2w, r15p2c, 4)
            r15p2w -> cInput(round - 1, r16p4c, 1)
            r16p4c -> cInput(round, r16p1c, 2)
            r16p1c -> cInput(round, r16p2c, 3)
            r16p2c -> cInput(round, r16p3c, 4)
            r16p3c -> wInput(round, r16p4w, r16p4c, 1)
            r16p4w -> wInput(round, r16p1w, r16p1c, 2)
            r16p1w -> wInput(round, r16p2w, r16p2c, 3)
            r16p2w -> wInput(round, r16p3w, r16p3c, 4)
            r16p3w -> cInput(round - 1, r17p1c, 1)
            r17p1c -> cInput(round, r17p2c, 2)
            r17p2c -> cInput(round, r17p3c, 3)
            r17p3c -> cInput(round, r17p4c, 4)
            r17p4c -> wInput(round, r17p1w, r17p1c, 1)
            r17p1w -> wInput(round, r17p2w, r17p2c, 2)
            r17p2w -> wInput(round, r17p3w, r17p3c, 3)
            r17p3w -> wInput(round, r17p4w, r17p4c, 4)
            r17p4w -> cInput(round - 1, r18p2c, 1)
            r18p2c -> cInput(round, r18p3c, 2)
            r18p3c -> cInput(round, r18p4c, 3)
            r18p4c -> cInput(round, r18p1c, 4)
            r18p1c -> wInput(round, r18p2w, r18p2c, 1)
            r18p2w -> wInput(round, r18p3w, r18p3c, 2)
            r18p3w -> wInput(round, r18p4w, r18p4c, 3)
            r18p4w -> wInput(round, r18p1w, r18p1c, 4)
            r18p1w -> cInput(round - 1, r19p3c, 1)
            r19p3c -> cInput(round, r19p4c, 2)
            r19p4c -> cInput(round, r19p1c, 3)
            r19p1c -> cInput(round, r19p2c, 4)
            r19p2c -> wInput(round, r19p3w, r19p3c, 1)
            r19p3w -> wInput(round, r19p4w, r19p4c, 2)
            r19p4w -> wInput(round, r19p1w, r19p1c, 3)
            r19p1w -> wInput(round, r19p2w, r19p2c, 4)
            r19p2w -> cInput(round - 1, r20p4c, 1)
            r20p4c -> cInput(round, r20p1c, 2)
            r20p1c -> cInput(round, r20p2c, 3)
            r20p2c -> cInput(round, r20p3c, 4)
            r20p3c -> wInput(round, r20p4w, r20p4c, 1)
            r20p4w -> wInput(round, r20p1w, r20p1c, 2)
            r20p1w -> wInput(round, r20p2w, r20p2c, 3)
            r20p2w -> wInput(round, r20p3w, r20p3c, 4)
            r20p3w -> {
                gamotvla(3)
                cInput(9, r21p1c, 1)
            }
            r21p1c -> cInput(round, r21p2c, 2)
            r21p2c -> cInput(round, r21p3c, 3)
            r21p3c -> cInput(round, r21p4c, 4)
            r21p4c -> wInput(round, r21p1w, r21p1c, 1)
            r21p1w -> wInput(round, r21p2w, r21p2c, 2)
            r21p2w -> wInput(round, r21p3w, r21p3c, 3)
            r21p3w -> wInput(round, r21p4w, r21p4c, 4)
            r21p4w -> cInput(round, r22p2c, 1)
            r22p2c -> cInput(round, r22p3c, 2)
            r22p3c -> cInput(round, r22p4c, 3)
            r22p4c -> cInput(round, r22p1c, 4)
            r22p1c -> wInput(round, r22p2w, r22p2c, 1)
            r22p2w -> wInput(round, r22p3w, r22p3c, 2)
            r22p3w -> wInput(round, r22p4w, r22p4c, 3)
            r22p4w -> wInput(round, r22p1w, r22p1c, 4)
            r22p1w -> cInput(round, r23p3c, 1)
            r23p3c -> cInput(round, r23p4c, 2)
            r23p4c -> cInput(round, r23p1c, 3)
            r23p1c -> cInput(round, r23p2c, 4)
            r23p2c -> wInput(round, r23p3w, r23p3c, 1)
            r23p3w -> wInput(round, r23p4w, r23p4c, 2)
            r23p4w -> wInput(round, r23p1w, r23p1c, 3)
            r23p1w -> wInput(round, r23p2w, r23p2c, 4)
            r23p2w -> cInput(round, r24p4c, 1)
            r24p4c -> cInput(round, r24p1c, 2)
            r24p1c -> cInput(round, r24p2c, 3)
            r24p2c -> cInput(round, r24p3c, 4)
            r24p3c -> wInput(round, r24p4w, r24p4c, 1)
            r24p4w -> wInput(round, r24p1w, r24p1c, 2)
            r24p1w -> wInput(round, r24p2w, r24p2c, 3)
            r24p2w -> wInput(round, r24p3w, r24p3c, 4)
            r24p3w -> {
                gamotvla(4)
                results()
            }
        }
    }

    //მინიჭების ფუნქციები
    private fun giveValueC(n: Int, c: TextView) {
        if (c.text.toString() != "-") {
            when (n) {
                1 -> c1 = c.text.toString().toInt()
                2 -> c2 = c.text.toString().toInt()
                3 -> c3 = c.text.toString().toInt()
            }
        }
    }

    private fun giveValueW(n: Int, w: TextView) {
        if (w.hint.toString() != "-") {
            when (n) {
                1 -> w1 = w.hint.toString().toInt()
                2 -> w2 = w.hint.toString().toInt()
                3 -> w3 = w.hint.toString().toInt()
            }
        }
    }

    //გამოთვლის ფუნქცია
    private fun gamotvla(pulka: Int) {
        var player1P = false
        var player2P = false
        var player3P = false
        var player4P = false
        //პირველი პულკა////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (pulka == 1) {
            //პრემიები//////////////////////////////////////////////////////////////////////////
            //პრემიების დადგენა
            prem1p1.text = "0"
            prem1p2.text = "0"
            prem1p3.text = "0"
            prem1p4.text = "0"
            if (waigo(r1p1w) && waigo(r2p1w) && waigo(r3p1w) && waigo(r4p1w) && waigo(r5p1w) && waigo(r6p1w) && waigo(r7p1w) && waigo(r8p1w)) {
                player1P = true
            }
            if (waigo(r1p2w) && waigo(r2p2w) && waigo(r3p2w) && waigo(r4p2w) && waigo(r5p2w) && waigo(r6p2w) && waigo(r7p2w) && waigo(r8p2w)) {
                player2P = true
            }
            if (waigo(r1p3w) && waigo(r2p3w) && waigo(r3p3w) && waigo(r4p3w) && waigo(r5p3w) && waigo(r6p3w) && waigo(r7p3w) && waigo(r8p3w)) {
                player3P = true
            }
            if (waigo(r1p4w) && waigo(r2p4w) && waigo(r3p4w) && waigo(r4p4w) && waigo(r5p4w) && waigo(r6p4w) && waigo(r7p4w) && waigo(r8p4w)) {
                player4P = true
            }
            //პრემიის გამოთვლა
            if (player1P || player2P || player3P || player4P) {
                val player1M = maxOf(r1p1w.text.toString().toInt(), r2p1w.text.toString().toInt(), r3p1w.text.toString().toInt(), r4p1w.text.toString().toInt(), r5p1w.text.toString().toInt(), r6p1w.text.toString().toInt(), r7p1w.text.toString().toInt(), r8p1w.text.toString().toInt())
                val player2M = maxOf(r1p2w.text.toString().toInt(), r2p2w.text.toString().toInt(), r3p2w.text.toString().toInt(), r4p2w.text.toString().toInt(), r5p2w.text.toString().toInt(), r6p2w.text.toString().toInt(), r7p2w.text.toString().toInt(), r8p2w.text.toString().toInt())
                val player3M = maxOf(r1p3w.text.toString().toInt(), r2p3w.text.toString().toInt(), r3p3w.text.toString().toInt(), r4p3w.text.toString().toInt(), r5p3w.text.toString().toInt(), r6p3w.text.toString().toInt(), r7p3w.text.toString().toInt(), r8p3w.text.toString().toInt())
                val player4M = maxOf(r1p4w.text.toString().toInt(), r2p4w.text.toString().toInt(), r3p4w.text.toString().toInt(), r4p4w.text.toString().toInt(), r5p4w.text.toString().toInt(), r6p4w.text.toString().toInt(), r7p4w.text.toString().toInt(), r8p4w.text.toString().toInt())
                premiebi(prem1p1, prem1p2, prem1p3, prem1p4, player1P, player2P, player3P, player4P, player1M, player2M, player3M, player4M)
            }
            ///////////გამოთვლა////////////////////////////////////////////////////////////
            j1p1.text = ((r1p1w.text.toString().toFloat() + r2p1w.text.toString().toFloat() + r3p1w.text.toString().toFloat() + r4p1w.text.toString().toFloat() + r5p1w.text.toString().toFloat() + r6p1w.text.toString().toFloat() + r7p1w.text.toString().toFloat() + r8p1w.text.toString().toFloat() + prem1p1.text.toString().toFloat()) / 100.0).toString()
            j1p2.text = ((r1p2w.text.toString().toFloat() + r2p2w.text.toString().toFloat() + r3p2w.text.toString().toFloat() + r4p2w.text.toString().toFloat() + r5p2w.text.toString().toFloat() + r6p2w.text.toString().toFloat() + r7p2w.text.toString().toFloat() + r8p2w.text.toString().toFloat() + prem1p2.text.toString().toFloat()) / 100.0).toString()
            j1p3.text = ((r1p3w.text.toString().toFloat() + r2p3w.text.toString().toFloat() + r3p3w.text.toString().toFloat() + r4p3w.text.toString().toFloat() + r5p3w.text.toString().toFloat() + r6p3w.text.toString().toFloat() + r7p3w.text.toString().toFloat() + r8p3w.text.toString().toFloat() + prem1p3.text.toString().toFloat()) / 100.0).toString()
            j1p4.text = ((r1p4w.text.toString().toFloat() + r2p4w.text.toString().toFloat() + r3p4w.text.toString().toFloat() + r4p4w.text.toString().toFloat() + r5p4w.text.toString().toFloat() + r6p4w.text.toString().toFloat() + r7p4w.text.toString().toFloat() + r8p4w.text.toString().toFloat() + prem1p4.text.toString().toFloat()) / 100.0).toString()
        } else if (pulka == 2) {
            //მეორე პულკა///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            // პრემიები//////////////////////////////////
            prem2p1.text = "0"
            prem2p2.text = "0"
            prem2p3.text = "0"
            prem2p4.text = "0"
            if (waigo(r9p1w) && waigo(r10p1w) && waigo(r11p1w) && waigo(r12p1w)) {
                player1P = true
            }
            if (waigo(r9p2w) && waigo(r10p2w) && waigo(r11p2w) && waigo(r12p2w)) {
                player2P = true
            }
            if (waigo(r9p3w) && waigo(r10p3w) && waigo(r11p3w) && waigo(r12p3w)) {
                player3P = true
            }
            if (waigo(r9p4w) && waigo(r10p4w) && waigo(r11p4w) && waigo(r12p4w)) {
                player4P = true
            }
            //პრემიის გამოთვლა
            if (player1P || player2P || player3P || player4P) {
                val player1M = maxOf(r9p1w.text.toString().toInt(), r10p1w.text.toString().toInt(), r11p1w.text.toString().toInt(), r12p1w.text.toString().toInt())
                val player2M = maxOf(r9p2w.text.toString().toInt(), r10p2w.text.toString().toInt(), r11p2w.text.toString().toInt(), r12p2w.text.toString().toInt())
                val player3M = maxOf(r9p3w.text.toString().toInt(), r10p3w.text.toString().toInt(), r11p3w.text.toString().toInt(), r12p3w.text.toString().toInt())
                val player4M = maxOf(r9p4w.text.toString().toInt(), r10p4w.text.toString().toInt(), r11p4w.text.toString().toInt(), r12p4w.text.toString().toInt())
                premiebi(prem2p1, prem2p2, prem2p3, prem2p4, player1P, player2P, player3P, player4P, player1M, player2M, player3M, player4M)
            }
            //გამოთვლა///////////////////////////////////////////////////////////
            t2p1.text = ((r9p1w.text.toString().toFloat() + r10p1w.text.toString().toFloat() + r11p1w.text.toString().toFloat() + r12p1w.text.toString().toFloat() + prem2p1.text.toString().toFloat()) / 100.0).toString()
            t2p2.text = ((r9p2w.text.toString().toFloat() + r10p2w.text.toString().toFloat() + r11p2w.text.toString().toFloat() + r12p2w.text.toString().toFloat() + prem2p2.text.toString().toFloat()) / 100.0).toString()
            t2p3.text = ((r9p3w.text.toString().toFloat() + r10p3w.text.toString().toFloat() + r11p3w.text.toString().toFloat() + r12p3w.text.toString().toFloat() + prem2p3.text.toString().toFloat()) / 100.0).toString()
            t2p4.text = ((r9p4w.text.toString().toFloat() + r10p4w.text.toString().toFloat() + r11p4w.text.toString().toFloat() + r12p4w.text.toString().toFloat() + prem2p4.text.toString().toFloat()) / 100.0).toString()
            j2p1.text = (t2p1.text.toString().toFloat() + j1p1.text.toString().toFloat()).toString()
            j2p2.text = (t2p2.text.toString().toFloat() + j1p2.text.toString().toFloat()).toString()
            j2p3.text = (t2p3.text.toString().toFloat() + j1p3.text.toString().toFloat()).toString()
            j2p4.text = (t2p4.text.toString().toFloat() + j1p4.text.toString().toFloat()).toString()
        }else if (pulka == 3) {
            //მესამე პულკა//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //პრემიები////////////////////////////////
            prem3p1.text = "0"
            prem3p2.text = "0"
            prem3p3.text = "0"
            prem3p4.text = "0"
            if (waigo(r13p1w) && waigo(r14p1w) && waigo(r15p1w) && waigo(r16p1w) && waigo(r17p1w) && waigo(r18p1w) && waigo(r19p1w) && waigo(r20p1w)){
                player1P = true
            }
            if (waigo(r13p2w) && waigo(r14p2w) && waigo(r15p2w) && waigo(r16p2w) && waigo(r17p2w) && waigo(r18p2w) && waigo(r19p2w) && waigo(r20p2w)){
                player2P = true
            }
            if (waigo(r13p3w) && waigo(r14p3w) && waigo(r15p3w) && waigo(r16p3w) && waigo(r17p3w) && waigo(r18p3w) && waigo(r19p3w) && waigo(r20p3w)){
                player3P = true
            }
            if (waigo(r13p4w) && waigo(r14p4w) && waigo(r15p4w) && waigo(r16p4w) && waigo(r17p4w) && waigo(r18p4w) && waigo(r19p4w) && waigo(r20p4w)){
                player4P = true
            }
            //პრემიის გამოთვლა
            if (player1P || player2P || player3P || player4P) {
                val player1M = maxOf(r13p1w.text.toString().toInt(), r14p1w.text.toString().toInt(), r15p1w.text.toString().toInt(), r16p1w.text.toString().toInt(), r17p1w.text.toString().toInt(), r18p1w.text.toString().toInt(), r19p1w.text.toString().toInt(), r20p1w.text.toString().toInt())
                val player2M = maxOf(r13p2w.text.toString().toInt(), r14p2w.text.toString().toInt(), r15p2w.text.toString().toInt(), r16p2w.text.toString().toInt(), r17p2w.text.toString().toInt(), r18p2w.text.toString().toInt(), r19p2w.text.toString().toInt(), r20p2w.text.toString().toInt())
                val player3M = maxOf(r13p3w.text.toString().toInt(), r14p3w.text.toString().toInt(), r15p3w.text.toString().toInt(), r16p3w.text.toString().toInt(), r17p3w.text.toString().toInt(), r18p3w.text.toString().toInt(), r19p3w.text.toString().toInt(), r20p3w.text.toString().toInt())
                val player4M = maxOf(r13p4w.text.toString().toInt(), r14p4w.text.toString().toInt(), r15p4w.text.toString().toInt(), r16p4w.text.toString().toInt(), r17p4w.text.toString().toInt(), r18p4w.text.toString().toInt(), r19p4w.text.toString().toInt(), r20p4w.text.toString().toInt())
                premiebi(prem3p1, prem3p2, prem3p3, prem3p4, player1P, player2P, player3P, player4P, player1M, player2M, player3M, player4M)
            }
            //გამოთვლა////////////////////////////////////////////////////
            t3p1.text = ((r13p1w.text.toString().toFloat() + r14p1w.text.toString().toFloat() + r15p1w.text.toString().toFloat() + r16p1w.text.toString().toFloat() + r17p1w.text.toString().toFloat() + r18p1w.text.toString().toFloat() + r19p1w.text.toString().toFloat() + r20p1w.text.toString().toFloat() + prem3p1.text.toString().toFloat())/100.0).toString()
            t3p2.text = ((r13p2w.text.toString().toFloat() + r14p2w.text.toString().toFloat() + r15p2w.text.toString().toFloat() + r16p2w.text.toString().toFloat() + r17p2w.text.toString().toFloat() + r18p2w.text.toString().toFloat() + r19p2w.text.toString().toFloat() + r20p2w.text.toString().toFloat() + prem3p2.text.toString().toFloat())/100.0).toString()
            t3p3.text = ((r13p3w.text.toString().toFloat() + r14p3w.text.toString().toFloat() + r15p3w.text.toString().toFloat() + r16p3w.text.toString().toFloat() + r17p3w.text.toString().toFloat() + r18p3w.text.toString().toFloat() + r19p3w.text.toString().toFloat() + r20p3w.text.toString().toFloat() + prem3p3.text.toString().toFloat())/100.0).toString()
            t3p4.text = ((r13p4w.text.toString().toFloat() + r14p4w.text.toString().toFloat() + r15p4w.text.toString().toFloat() + r16p4w.text.toString().toFloat() + r17p4w.text.toString().toFloat() + r18p4w.text.toString().toFloat() + r19p4w.text.toString().toFloat() + r20p4w.text.toString().toFloat() + prem3p4.text.toString().toFloat())/100.0).toString()
            j3p1.text = (t3p1.text.toString().toFloat() + j2p1.text.toString().toFloat()).toString()
            j3p2.text = (t3p2.text.toString().toFloat() + j2p2.text.toString().toFloat()).toString()
            j3p3.text = (t3p3.text.toString().toFloat() + j2p3.text.toString().toFloat()).toString()
            j3p4.text = (t3p4.text.toString().toFloat() + j2p4.text.toString().toFloat()).toString()
        }else if (pulka == 4){
            //მეოთხე პულკა/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //პრემიები////////////////////////////
            prem4p1.text = "0"
            prem4p2.text = "0"
            prem4p3.text = "0"
            prem4p4.text = "0"
            if (waigo(r21p1w) && waigo(r22p1w) && waigo(r23p1w) && waigo(r24p1w)){
                player1P = true
            }
            if (waigo(r21p2w) && waigo(r22p2w) && waigo(r23p2w) && waigo(r24p2w)){
                player2P = true
            }
            if (waigo(r21p3w) && waigo(r22p3w) && waigo(r23p3w) && waigo(r24p3w)){
                player3P = true
            }
            if (waigo(r21p4w) && waigo(r22p4w) && waigo(r23p4w) && waigo(r24p4w)){
                player4P = true
            }
            //პრემიის გამოთვლა
            if (player1P || player2P || player3P || player4P) {
                val player1M = maxOf(r21p1w.text.toString().toInt(), r22p1w.text.toString().toInt(), r23p1w.text.toString().toInt(), r24p1w.text.toString().toInt())
                val player2M = maxOf(r21p2w.text.toString().toInt(), r22p2w.text.toString().toInt(), r23p2w.text.toString().toInt(), r24p2w.text.toString().toInt())
                val player3M = maxOf(r21p3w.text.toString().toInt(), r22p3w.text.toString().toInt(), r23p3w.text.toString().toInt(), r24p3w.text.toString().toInt())
                val player4M = maxOf(r21p4w.text.toString().toInt(), r22p4w.text.toString().toInt(), r23p4w.text.toString().toInt(), r24p4w.text.toString().toInt())
                premiebi(prem4p1, prem4p2, prem4p3, prem4p4, player1P, player2P, player3P, player4P, player1M, player2M, player3M, player4M)
            }
            //გამოთვლა////////////////////////////////////////////////////
            t4p1.text = ((r21p1w.text.toString().toFloat() + r22p1w.text.toString().toFloat() + r23p1w.text.toString().toFloat() + r24p1w.text.toString().toInt() + prem4p1.text.toString().toFloat())/100.0).toString()
            t4p2.text = ((r21p2w.text.toString().toFloat() + r22p2w.text.toString().toFloat() + r23p2w.text.toString().toFloat() + r24p2w.text.toString().toInt() + prem4p2.text.toString().toFloat())/100.0).toString()
            t4p3.text = ((r21p3w.text.toString().toFloat() + r22p3w.text.toString().toFloat() + r23p3w.text.toString().toFloat() + r24p3w.text.toString().toInt() + prem4p3.text.toString().toFloat())/100.0).toString()
            t4p4.text = ((r21p4w.text.toString().toFloat() + r22p4w.text.toString().toFloat() + r23p4w.text.toString().toFloat() + r24p4w.text.toString().toInt() + prem4p4.text.toString().toFloat())/100.0).toString()
            j4p1.text = (t4p1.text.toString().toFloat() + j3p1.text.toString().toFloat()).toString()
            j4p2.text = (t4p2.text.toString().toFloat() + j3p2.text.toString().toFloat()).toString()
            j4p3.text = (t4p3.text.toString().toFloat() + j3p3.text.toString().toFloat()).toString()
            j4p4.text = (t4p4.text.toString().toFloat() + j3p4.text.toString().toFloat()).toString()
        }

    }

    //პრემიების დაწერის ფუნქცია
    private fun premiebi(view1: TextView, view2: TextView, view3: TextView, view4: TextView, p1: Boolean, p2: Boolean, p3: Boolean, p4: Boolean, m1: Int, m2: Int, m3: Int, m4: Int) {
        if (moshla == true) {
            if (!p1) {
                view1.text = (view1.text.toString().toInt() - m1).toString()
            }
            if (!p2) {
                view2.text = (view2.text.toString().toInt() - m2).toString()
            }
            if (!p3) {
                view3.text = (view3.text.toString().toInt() - m3).toString()
            }
            if (!p4) {
                view4.text = (view4.text.toString().toInt() - m4).toString()
            }
        }
        if (gaormageba == true) {
            if (p1) {
                view1.text = (view1.text.toString().toInt() + m1).toString()
            }
            if (p2) {
                view2.text = (view2.text.toString().toInt() + m2).toString()
            }
            if (p3) {
                view3.text = (view3.text.toString().toInt() + m3).toString()
            }
            if (p4) {
                view4.text = (view4.text.toString().toInt() + m4).toString()
            }
        }
    }

    //ამოწმებს წაიღო თუ არა უჯრაში მოთამაშემ ნათქვამი
    private fun waigo(w: TextView): Boolean {
        if (w.text.toString().toInt() >= 100 || (w.text.toString().toInt() == 50 && w.hint.toString() == "-")) {
            return true
        }
        return false
    }

    //გადასვლა შედეგების გვერდზე
    private fun results(){
        numberRow1.isVisible = false
        numberRow2.isVisible = false
        resultsButton.isVisible = true

        resultsButton.setOnClickListener {
            val intent = Intent(this, ResultsActivity::class.java)
            intent.putExtra("player1", name1.text.toString())
            intent.putExtra("player2", name2.text.toString())
            intent.putExtra("player3", name3.text.toString())
            intent.putExtra("player4", name4.text.toString())
            intent.putExtra("result1", j4p1.text.toString())
            intent.putExtra("result2", j4p2.text.toString())
            intent.putExtra("result3", j4p3.text.toString())
            intent.putExtra("result4", j4p4.text.toString())
            startActivity(intent)
        }
    }
}