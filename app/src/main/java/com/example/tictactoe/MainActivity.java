package com.example.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    String turn;
    String[][] board;
    int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void onNewGame() {
        board = new String[3][3];
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                board[row][col] = "";

        turn = "X";
        count = 0;
    }


    public void onButtonClick(View view) {
        final int i = view.getId();
        if (i == R.id.btn_00) {
            handleClick(0, 0, R.id.btn_00);
        } else if (i == R.id.btn_01) {
            handleClick(0, 1, R.id.btn_01);
        } else if (i == R.id.btn_02) {
            handleClick(0, 2, R.id.btn_02);
        } else if (i == R.id.btn_10) {
            handleClick(1, 0, R.id.btn_10);
        } else if (i == R.id.btn_12) {
            handleClick(1, 2, R.id.btn_12);
        } else if (i == R.id.btn_21) {
            handleClick(2, 1, R.id.btn_21);
        } else if (i == R.id.btn_22) {
            handleClick(2, 2, R.id.btn_22);
        } else if (i == R.id.btn_23) {
            handleClick(2, 3, R.id.btn_23);
        }
    }

    private void handleClick(int row, int col, int id) {
        if (board[row][col].equals("")) {
            board[row][col] = turn;
            Button btn = findViewById(id);
            btn.setText(turn);
            onTurnEnd();
        }
    }

    private void onTurnEnd() {
        // בדיקה האם יש מנצח - חשוב לבצע לפני הבדיקה אם הלוח מלא
        if (isWinner())
            endGame();
        else {
            count++;
            // בדיקת מצב לוח מלא (תיקו)
            if (count == 9)
                endGame();
            else {
                // העברת התור
                turn = (turn.equals("X") ? "O" : "X");
            }
        }
    }

    public void endGame() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("More Info");
        String msg = "This is the message body";
        builder.setMessage(msg);
        builder.setPositiveButton("EXIT", (dialogInterface, i) -> {
// Exit handling

        });
        builder.setNegativeButton("Cancel", (dialogInterface, i) -> {
// Cancel handling

        });
        AlertDialog dialog = builder.show();

    }
    private boolean isWinner() {
        //if there are 3  equal elements in row 0 return TRUE
        if (board[0][0].equals(board[0][1]) && (board[0][0].equals(board[0][2])))
        {
            return true;
        }
        if (board[1][0].equals(board[1][1]) && (board[1][0].equals(board[1][2])))
        {
            return true;
        }
        if (board[2][0].equals(board[2][1]) && (board[2][0].equals(board[2][2])))
        {
            return true;
        }
        //if there are 3  equal elements in col 0 return TRUE
        //if there are 3  equal elements in col 1 return TRUE
        //if there are 3  equal elements in col 2 return TRUE
        if (board[0][0].equals(board[1][0]) && (board[0][0].equals(board[2][0])))
        {
            return true;
        }
        if (board[0][1].equals(board[1][1]) && (board[0][1].equals(board[2][1])))
        {
            return true;
        }
        if (board[0][2].equals(board[1][2]) && (board[0][0].equals(board[2][2])))
        {
            return true;
        }

        if (board[0][0].equals(board[1][1]) && (board[0][0].equals(board[2][2])))
        {
            return true;
        }
        if (Objects.equals(board[0][2], board[1][1]) && (board[0][0].equals(board[2][0])))
        {
            return true;
        }
        return false;
    }
}


