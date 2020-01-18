package com.example.hangmanpro

import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game.*
import java.lang.StringBuilder


class GameActivity : AppCompatActivity() {
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        val sharedPref: SharedPreferences = getSharedPreferences("sharedprefs",0)
        val titleText: String = sharedPref.getString("ChallengerNickname",null)!! + "'s challenge"
        textDescription.text = sharedPref.getString("ChallengerDescription",null)
        var word = sharedPref.getString("ChallengerWord",null)
        word = word!!.toLowerCase().replace(" ","")
        var underscoredWord = ""
        var lives = 4
        var i = 0
        while(i<word!!.length){
            underscoredWord +="_"
            i+=1
            underscoredWord +=" "

        }

        wordToGuess.text = underscoredWord
        title = titleText

        A.setOnClickListener {
            var i = 0
            var checker = true
            if (lives == 0){
                finish()
                Toast.makeText(this, "You lost!", Toast.LENGTH_LONG).show()
            }


            while(i < word.length){
                if(word[i] == 'a'){
                    checker = false
                    underscoredWord = underscoredWord.replaceRange(i*2,i*2+1,"a")
                    println(underscoredWord)
                }
                i+=1
            }

            if ("_" !in underscoredWord){
                finish()
                Toast.makeText(this, "You won!", Toast.LENGTH_LONG).show()
            }
            if (checker == true){
                lives-=1
                A.text = "✗"
                A.setTextColor(Color.parseColor("#FF0000"))
            }else{
                A.text = "✓"
                A.setTextColor(Color.parseColor("#3DFF03"))
            }


            wordToGuess.text = underscoredWord
        }


        B.setOnClickListener {
            var i = 0
            var checker = true
            B.text = "x"
            if (lives == 0){
                finish()
                Toast.makeText(this, "You lost!", Toast.LENGTH_LONG).show()
            }


            while(i < word.length){
                if(word[i] == 'b'){
                    checker = false
                    underscoredWord = underscoredWord.replaceRange(i*2,i*2+1,"b")
                    println(underscoredWord)
                }
                i+=1
            }

            if ("_" !in underscoredWord){
                finish()
                Toast.makeText(this, "You won!", Toast.LENGTH_LONG).show()
            }
            if (checker == true){
                lives-=1
                B.text = "✗"
                B.setTextColor(Color.parseColor("#FF0000"))
            }else{
                B.text = "✓"
                B.setTextColor(Color.parseColor("#3DFF03"))
            }
            wordToGuess.text = underscoredWord
        }


        C.setOnClickListener {
            var i = 0
            var checker = true
            C.text = "x"
            if (lives == 0){
                finish()
                Toast.makeText(this, "You lost!", Toast.LENGTH_LONG).show()
            }


            while(i < word.length){
                if(word[i] == 'c'){
                    checker = false
                    underscoredWord = underscoredWord.replaceRange(i*2,i*2+1,"c")
                    println(underscoredWord)
                }
                i+=1
            }

            if ("_" !in underscoredWord){
                finish()
                Toast.makeText(this, "You won!", Toast.LENGTH_LONG).show()
            }
            if (checker == true){
                lives-=1
                C.text = "✗"
                C.setTextColor(Color.parseColor("#FF0000"))
            }else{
                C.text = "✓"
                C.setTextColor(Color.parseColor("#3DFF03"))
            }
            wordToGuess.text = underscoredWord
        }


        D.setOnClickListener {
            var i = 0
            var checker = true
            D.text = "x"
            if (lives == 0){
                finish()
                Toast.makeText(this, "You lost!", Toast.LENGTH_LONG).show()
            }


            while(i < word.length){
                if(word[i] == 'd'){
                    checker = false
                    underscoredWord = underscoredWord.replaceRange(i*2,i*2+1,"d")
                    println(underscoredWord)
                }
                i+=1
            }

            if ("_" !in underscoredWord){
                finish()
                Toast.makeText(this, "You won!", Toast.LENGTH_LONG).show()
            }
            if (checker == true){
                lives-=1
                D.text = "✗"
                D.setTextColor(Color.parseColor("#FF0000"))
            }else{
                D.text = "✓"
                D.setTextColor(Color.parseColor("#3DFF03"))
            }
            wordToGuess.text = underscoredWord
        }


        E.setOnClickListener {
            var i = 0
            var checker = true
            E.text = "x"
            if (lives == 0){
                finish()
                Toast.makeText(this, "You lost!", Toast.LENGTH_LONG).show()
            }


            while(i < word.length){
                if(word[i] == 'e'){
                    checker = false
                    underscoredWord = underscoredWord.replaceRange(i*2,i*2+1,"e")
                    println(underscoredWord)
                }
                i+=1
            }

            if ("_" !in underscoredWord){
                finish()
                Toast.makeText(this, "You won!", Toast.LENGTH_LONG).show()
            }
            if (checker == true){
                lives-=1
                E.text = "✗"
                E.setTextColor(Color.parseColor("#FF0000"))
            }else{
                E.text = "✓"
                E.setTextColor(Color.parseColor("#3DFF03"))
            }
            wordToGuess.text = underscoredWord
        }

        F.setOnClickListener {
            var i = 0
            var checker = true
            F.text = "x"
            if (lives == 0){
                finish()
                Toast.makeText(this, "You lost!", Toast.LENGTH_LONG).show()
            }


            while(i < word.length){
                if(word[i] == 'f'){
                    checker = false
                    underscoredWord = underscoredWord.replaceRange(i*2,i*2+1,"f")
                    println(underscoredWord)
                }
                i+=1
            }

            if ("_" !in underscoredWord){
                finish()
                Toast.makeText(this, "You won!", Toast.LENGTH_LONG).show()
            }
            if (checker == true){
                lives-=1
                F.text = "✗"
                F.setTextColor(Color.parseColor("#FF0000"))
            }else{
                F.text = "✓"
                F.setTextColor(Color.parseColor("#3DFF03"))
            }
            wordToGuess.text = underscoredWord
        }


        G.setOnClickListener {
            var i = 0
            var checker = true
            G.text = "x"
            if (lives == 0){
                finish()
                Toast.makeText(this, "You lost!", Toast.LENGTH_LONG).show()
            }


            while(i < word.length){
                if(word[i] == 'g'){
                    checker = false
                    underscoredWord = underscoredWord.replaceRange(i*2,i*2+1,"g")
                    println(underscoredWord)
                }
                i+=1
            }

            if ("_" !in underscoredWord){
                finish()
                Toast.makeText(this, "You won!", Toast.LENGTH_LONG).show()
            }
            if (checker == true){
                lives-=1
                G.text = "✗"
                G.setTextColor(Color.parseColor("#FF0000"))
            }else{
                G.text = "✓"
                G.setTextColor(Color.parseColor("#3DFF03"))
            }
            wordToGuess.text = underscoredWord
        }


        H.setOnClickListener {
            var i = 0
            var checker = true
            H.text = "x"
            if (lives == 0){
                finish()
                Toast.makeText(this, "You lost!", Toast.LENGTH_LONG).show()
            }


            while(i < word.length){
                if(word[i] == 'h'){
                    checker = false
                    underscoredWord = underscoredWord.replaceRange(i*2,i*2+1,"h")
                    println(underscoredWord)
                }
                i+=1
            }

            if ("_" !in underscoredWord){
                finish()
                Toast.makeText(this, "You won!", Toast.LENGTH_LONG).show()
            }
            if (checker == true){
                lives-=1
                H.text = "✗"
                H.setTextColor(Color.parseColor("#FF0000"))
            }else{
                H.text = "✓"
                H.setTextColor(Color.parseColor("#3DFF03"))
            }
            wordToGuess.text = underscoredWord
        }


        I.setOnClickListener {
            var i = 0
            var checker = true
            I.text = "x"
            if (lives == 0){
                finish()
                Toast.makeText(this, "You lost!", Toast.LENGTH_LONG).show()
            }


            while(i < word.length){
                if(word[i] == 'i'){
                    checker = false
                    underscoredWord = underscoredWord.replaceRange(i*2,i*2+1,"i")
                    println(underscoredWord)
                }
                i+=1
            }

            if ("_" !in underscoredWord){
                finish()
                Toast.makeText(this, "You won!", Toast.LENGTH_LONG).show()
            }
            if (checker == true){
                lives-=1
                I.text = "✗"
                I.setTextColor(Color.parseColor("#FF0000"))
            }else{
                I.text = "✓"
                I.setTextColor(Color.parseColor("#3DFF03"))
            }
            wordToGuess.text = underscoredWord
        }


        J.setOnClickListener {
            var i = 0
            var checker = true
            J.text = "x"
            if (lives == 0){
                finish()
                Toast.makeText(this, "You lost!", Toast.LENGTH_LONG).show()
            }


            while(i < word.length){
                if(word[i] == 'j'){
                    checker = false
                    underscoredWord = underscoredWord.replaceRange(i*2,i*2+1,"j")
                    println(underscoredWord)
                }
                i+=1
            }

            if ("_" !in underscoredWord){
                finish()
                Toast.makeText(this, "You won!", Toast.LENGTH_LONG).show()
            }
            if (checker == true){
                lives-=1
                J.text = "✗"
                J.setTextColor(Color.parseColor("#FF0000"))
            }else{
                J.text = "✓"
                J.setTextColor(Color.parseColor("#3DFF03"))
            }
            wordToGuess.text = underscoredWord
        }


        K.setOnClickListener {
            var i = 0
            var checker = true
            K.text = "x"
            if (lives == 0){
                finish()
                Toast.makeText(this, "You lost!", Toast.LENGTH_LONG).show()
            }


            while(i < word.length){
                if(word[i] == 'k'){
                    checker = false
                    underscoredWord = underscoredWord.replaceRange(i*2,i*2+1,"k")
                    println(underscoredWord)
                }
                i+=1
            }

            if ("_" !in underscoredWord){
                finish()
                Toast.makeText(this, "You won!", Toast.LENGTH_LONG).show()
            }
            if (checker == true){
                lives-=1
                K.text = "✗"
                K.setTextColor(Color.parseColor("#FF0000"))
            }else{
                K.text = "✓"
                K.setTextColor(Color.parseColor("#3DFF03"))
            }
            wordToGuess.text = underscoredWord
        }


        L.setOnClickListener {
            var i = 0
            var checker = true
            L.text = "x"
            if (lives == 0){
                finish()
                Toast.makeText(this, "You lost!", Toast.LENGTH_LONG).show()
            }


            while(i < word.length){
                if(word[i] == 'l'){
                    checker = false
                    underscoredWord = underscoredWord.replaceRange(i*2,i*2+1,"l")
                    println(underscoredWord)
                }
                i+=1
            }

            if ("_" !in underscoredWord){
                finish()
                Toast.makeText(this, "You won!", Toast.LENGTH_LONG).show()
            }
            if (checker == true){
                lives-=1
                L.text = "✗"
                L.setTextColor(Color.parseColor("#FF0000"))
            }else{
                L.text = "✓"
                L.setTextColor(Color.parseColor("#3DFF03"))
            }
            wordToGuess.text = underscoredWord
        }


        M.setOnClickListener {
            var i = 0
            var checker = true
            M.text = "x"
            if (lives == 0){
                finish()
                Toast.makeText(this, "You lost!", Toast.LENGTH_LONG).show()
            }


            while(i < word.length){
                if(word[i] == 'm'){
                    checker = false
                    underscoredWord = underscoredWord.replaceRange(i*2,i*2+1,"m")
                    println(underscoredWord)
                }
                i+=1
            }

            if ("_" !in underscoredWord){
                finish()
                Toast.makeText(this, "You won!", Toast.LENGTH_LONG).show()
            }
            if (checker == true){
                lives-=1
                M.text = "✗"
                M.setTextColor(Color.parseColor("#FF0000"))
            }else{
                M.text = "✓"
                M.setTextColor(Color.parseColor("#3DFF03"))
            }
            wordToGuess.text = underscoredWord
        }


        N.setOnClickListener {
            var i = 0
            var checker = true
            N.text = "x"
            if (lives == 0){
                finish()
                Toast.makeText(this, "You lost!", Toast.LENGTH_LONG).show()
            }


            while(i < word.length){
                if(word[i] == 'n'){
                    checker = false
                    underscoredWord = underscoredWord.replaceRange(i*2,i*2+1,"n")
                    println(underscoredWord)
                }
                i+=1
            }

            if ("_" !in underscoredWord){
                finish()
                Toast.makeText(this, "You won!", Toast.LENGTH_LONG).show()
            }
            if (checker == true){
                lives-=1
                N.text = "✗"
                N.setTextColor(Color.parseColor("#FF0000"))
            }else{
                N.text = "✓"
                N.setTextColor(Color.parseColor("#3DFF03"))
            }
            wordToGuess.text = underscoredWord
        }


        O.setOnClickListener {
            var i = 0
            var checker = true
            O.text = "x"
            if (lives == 0){
                finish()
                Toast.makeText(this, "You lost!", Toast.LENGTH_LONG).show()
            }


            while(i < word.length){
                if(word[i] == 'o'){
                    checker = false
                    underscoredWord = underscoredWord.replaceRange(i*2,i*2+1,"o")
                    println(underscoredWord)
                }
                i+=1
            }

            if ("_" !in underscoredWord){
                finish()
                Toast.makeText(this, "You won!", Toast.LENGTH_LONG).show()
            }
            if (checker == true){
                lives-=1
                O.text = "✗"
                O.setTextColor(Color.parseColor("#FF0000"))
            }else{
                O.text = "✓"
                O.setTextColor(Color.parseColor("#3DFF03"))
            }
            wordToGuess.text = underscoredWord
        }


        P.setOnClickListener {
            var i = 0
            var checker = true
            P.text = "x"
            if (lives == 0){
                finish()
                Toast.makeText(this, "You lost!", Toast.LENGTH_LONG).show()
            }


            while(i < word.length){
                if(word[i] == 'p'){
                    checker = false
                    underscoredWord = underscoredWord.replaceRange(i*2,i*2+1,"p")
                    println(underscoredWord)
                }
                i+=1
            }

            if ("_" !in underscoredWord){
                finish()
                Toast.makeText(this, "You won!", Toast.LENGTH_LONG).show()
            }
            if (checker == true){
                lives-=1
                P.text = "✗"
                P.setTextColor(Color.parseColor("#FF0000"))
            }else{
                P.text = "✓"
                P.setTextColor(Color.parseColor("#3DFF03"))
            }
            wordToGuess.text = underscoredWord
        }


        Q.setOnClickListener {
            var i = 0
            var checker = true
            Q.text = "x"
            if (lives == 0){
                finish()
                Toast.makeText(this, "You lost!", Toast.LENGTH_LONG).show()
            }


            while(i < word.length){
                if(word[i] == 'q'){
                    checker = false
                    underscoredWord = underscoredWord.replaceRange(i*2,i*2+1,"q")
                    println(underscoredWord)
                }
                i+=1
            }

            if ("_" !in underscoredWord){
                finish()
                Toast.makeText(this, "You won!", Toast.LENGTH_LONG).show()
            }
            if (checker == true){
                lives-=1
                Q.text = "✗"
                Q.setTextColor(Color.parseColor("#FF0000"))
            }else{
                Q.text = "✓"
                Q.setTextColor(Color.parseColor("#3DFF03"))
            }
            wordToGuess.text = underscoredWord
        }


        notR.setOnClickListener {
            var i = 0
            var checker = true
            notR.text = "x"
            if (lives == 0){
                finish()
                Toast.makeText(this, "You lost!", Toast.LENGTH_LONG).show()
            }


            while(i < word.length){
                if(word[i] == 'r'){
                    checker = false
                    underscoredWord = underscoredWord.replaceRange(i*2,i*2+1,"r")
                    println(underscoredWord)
                }
                i+=1
            }

            if ("_" !in underscoredWord){
                finish()
                Toast.makeText(this, "You won!", Toast.LENGTH_LONG).show()
            }
            if (checker == true){
                lives-=1
                notR.text = "✗"
                notR.setTextColor(Color.parseColor("#FF0000"))
            }else{
                notR.text = "✓"
                notR.setTextColor(Color.parseColor("#3DFF03"))
            }
            wordToGuess.text = underscoredWord
        }


        S.setOnClickListener {
            var i = 0
            var checker = true
            S.text = "x"
            if (lives == 0){
                finish()
                Toast.makeText(this, "You lost!", Toast.LENGTH_LONG).show()
            }


            while(i < word.length){
                if(word[i] == 's'){
                    checker = false
                    underscoredWord = underscoredWord.replaceRange(i*2,i*2+1,"s")
                    println(underscoredWord)
                }
                i+=1
            }

            if ("_" !in underscoredWord){
                finish()
                Toast.makeText(this, "You won!", Toast.LENGTH_LONG).show()
            }
            if (checker == true){
                lives-=1
                S.text = "✗"
                S.setTextColor(Color.parseColor("#FF0000"))
            }else{
                S.text = "✓"
                S.setTextColor(Color.parseColor("#3DFF03"))
            }
            wordToGuess.text = underscoredWord
        }


        T.setOnClickListener {
            var i = 0
            var checker = true
            T.text = "x"
            if (lives == 0){
                finish()
                Toast.makeText(this, "You lost!", Toast.LENGTH_LONG).show()
            }


            while(i < word.length){
                if(word[i] == 't'){
                    checker = false
                    underscoredWord = underscoredWord.replaceRange(i*2,i*2+1,"t")
                    println(underscoredWord)
                }
                i+=1
            }

            if ("_" !in underscoredWord){
                finish()
                Toast.makeText(this, "You won!", Toast.LENGTH_LONG).show()
            }
            if (checker == true){
                lives-=1
                T.text = "✗"
                T.setTextColor(Color.parseColor("#FF0000"))
            }else{
                T.text = "✓"
                T.setTextColor(Color.parseColor("#3DFF03"))
            }
            wordToGuess.text = underscoredWord
        }

        U.setOnClickListener {
            var i = 0
            var checker = true
            U.text = "x"
            if (lives == 0){
                finish()
                Toast.makeText(this, "You lost!", Toast.LENGTH_LONG).show()
            }


            while(i < word.length){
                if(word[i] == 'u'){
                    checker = false
                    underscoredWord = underscoredWord.replaceRange(i*2,i*2+1,"u")
                    println(underscoredWord)
                }
                i+=1
            }

            if ("_" !in underscoredWord){
                finish()
                Toast.makeText(this, "You won!", Toast.LENGTH_LONG).show()
            }
            if (checker == true){
                lives-=1
                U.text = "✗"
                U.setTextColor(Color.parseColor("#FF0000"))
            }else{
                U.text = "✓"
                U.setTextColor(Color.parseColor("#3DFF03"))
            }
            wordToGuess.text = underscoredWord
        }


        V.setOnClickListener {
            var i = 0
            var checker = true
            V.text = "x"
            if (lives == 0){
                finish()
                Toast.makeText(this, "You lost!", Toast.LENGTH_LONG).show()
            }


            while(i < word.length){
                if(word[i] == 'v'){
                    checker = false
                    underscoredWord = underscoredWord.replaceRange(i*2,i*2+1,"v")
                    println(underscoredWord)
                }
                i+=1
            }

            if ("_" !in underscoredWord){
                finish()
                Toast.makeText(this, "You won!", Toast.LENGTH_LONG).show()
            }
            if (checker == true){
                lives-=1
                V.text = "✗"
                V.setTextColor(Color.parseColor("#FF0000"))
            }else{
                V.text = "✓"
                V.setTextColor(Color.parseColor("#3DFF03"))
            }
            wordToGuess.text = underscoredWord
        }


        W.setOnClickListener {
            var i = 0
            var checker = true
            W.text = "x"
            if (lives == 0){
                finish()
                Toast.makeText(this, "You lost!", Toast.LENGTH_LONG).show()
            }


            while(i < word.length){
                if(word[i] == 'w'){
                    checker = false
                    underscoredWord = underscoredWord.replaceRange(i*2,i*2+1,"w")
                    println(underscoredWord)
                }
                i+=1
            }

            if ("_" !in underscoredWord){
                finish()
                Toast.makeText(this, "You won!", Toast.LENGTH_LONG).show()
            }
            if (checker == true){
                lives-=1
                W.text = "✗"
                W.setTextColor(Color.parseColor("#FF0000"))
            }else{
                W.text = "✓"
                W.setTextColor(Color.parseColor("#3DFF03"))
            }
            wordToGuess.text = underscoredWord
        }


        X.setOnClickListener {
            var i = 0
            var checker = true
            X.text = "x"
            if (lives == 0){
                finish()
                Toast.makeText(this, "You lost!", Toast.LENGTH_LONG).show()
            }


            while(i < word.length){
                if(word[i] == 'x'){
                    checker = false
                    underscoredWord = underscoredWord.replaceRange(i*2,i*2+1,"x")
                    println(underscoredWord)
                }
                i+=1
            }

            if ("_" !in underscoredWord){
                finish()
                Toast.makeText(this, "You won!", Toast.LENGTH_LONG).show()
            }
            if (checker == true){
                lives-=1
                X.text = "✗"
                X.setTextColor(Color.parseColor("#FF0000"))
            }else{
                X.text = "✓"
                X.setTextColor(Color.parseColor("#3DFF03"))
            }
            wordToGuess.text = underscoredWord
        }


        Y.setOnClickListener {
            var i = 0
            var checker = true
            Y.text = "x"
            if (lives == 0){
                finish()
                Toast.makeText(this, "You lost!", Toast.LENGTH_LONG).show()
            }


            while(i < word.length){
                if(word[i] == 'y'){
                    checker = false
                    underscoredWord = underscoredWord.replaceRange(i*2,i*2+1,"y")
                    println(underscoredWord)
                }
                i+=1
            }

            if ("_" !in underscoredWord){
                finish()
                Toast.makeText(this, "You won!", Toast.LENGTH_LONG).show()
            }
            if (checker == true){
                lives-=1
                Y.text = "✗"
                Y.setTextColor(Color.parseColor("#FF0000"))
            }else{
                Y.text = "✓"
                Y.setTextColor(Color.parseColor("#3DFF03"))
            }
            wordToGuess.text = underscoredWord
        }


        Z.setOnClickListener {
            var i = 0
            var checker = true
            Z.text = "x"
            if (lives == 0){
                finish()
                Toast.makeText(this, "You lost!", Toast.LENGTH_LONG).show()
            }


            while(i < word.length){
                if(word[i] == 'z'){
                    checker = false
                    underscoredWord = underscoredWord.replaceRange(i*2,i*2+1,"z")
                    println(underscoredWord)
                }
                i+=1
            }

            if ("_" !in underscoredWord){
                finish()
                Toast.makeText(this, "You won!", Toast.LENGTH_LONG).show()
            }
            if (checker == true){
                lives-=1
                Z.text = "✗"
                Z.setTextColor(Color.parseColor("#FF0000"))
            }else{
                Z.text = "✓"
                Z.setTextColor(Color.parseColor("#3DFF03"))
            }
            wordToGuess.text = underscoredWord
        }


        

    }
}
