package com.amerpestudio.eight_queens_puzzle_game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.content.Context;
import android.widget.Button;
import java.util.Arrays;
import android.widget.EditText;
import android.text.Editable;
import android.text.TextWatcher;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    static int finalArrayIndex = 0;
    static int solutionIndex = 0;
    int row = 8, col = 8;
    static int lives = 1;
    static int checktime = 0;
    static int queens = 0;
    static int queens2 = 0;
    static int lastrow = 0, lastcol = -1;
    ImageButton[][] buttons = new ImageButton[row][col];
    static int[] Queens = new int[8];
    static int[] preSetQueens = new int[8];
    static int[] FinalQueens = new int[8];
    static int[][] FinalSolutionArray = new int[100][8];
    static int[][] buttonImg = new int [8][8];
    static int[][] queenButtons = new int[8][8];
    static int[][] solArr;

    static Button giveUp;
    static EditText myTextBox;
    static TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         textView2 = (TextView) findViewById(R.id.textView2);
        giveUp = (Button) findViewById(R.id.button);

        lives = 1;
        for(int k = 0 ; k < 8; k++) {
            Queens[k] = -1;
            preSetQueens[k] = -1;
        }
        for(int cell = 0; cell < 100; cell++) {
            FinalSolutionArray[cell] = new int[]{-1, -1, -1, -1, -1, -1, -1, -1};
        }
        for(int k = 0 ; k < 8; k++)
            FinalQueens[k] = -1;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                queenButtons[i][j] = -1;
                if((i % 2 == 0) && (j % 2 == 0)) {
                    buttonImg[i][j] = 1;
                } else if ((i % 2 == 0) && (j % 2 != 0)) {
                    buttonImg[i][j] = 3;
                } else if ((i % 2 != 0) && (j % 2 == 0)) {
                    buttonImg[i][j] = 3;
                } else {
                    buttonImg[i][j] = 1;
                }
            }
        }

        buttons[0][0] = (ImageButton)findViewById(R.id.imageButton);
        buttons[0][1] = (ImageButton)findViewById(R.id.imageButton2);
        buttons[0][2] = (ImageButton)findViewById(R.id.imageButton3);
        buttons[0][3] = (ImageButton)findViewById(R.id.imageButton4);
        buttons[0][4] = (ImageButton)findViewById(R.id.imageButton5);
        buttons[0][5] = (ImageButton)findViewById(R.id.imageButton6);
        buttons[0][6] = (ImageButton)findViewById(R.id.imageButton7);
        buttons[0][7] = (ImageButton)findViewById(R.id.imageButton8);
        buttons[1][0] = (ImageButton)findViewById(R.id.imageButton9);
        buttons[1][1] = (ImageButton)findViewById(R.id.imageButton10);
        buttons[1][2] = (ImageButton)findViewById(R.id.imageButton11);
        buttons[1][3] = (ImageButton)findViewById(R.id.imageButton12);
        buttons[1][4] = (ImageButton)findViewById(R.id.imageButton13);
        buttons[1][5] = (ImageButton)findViewById(R.id.imageButton14);
        buttons[1][6] = (ImageButton)findViewById(R.id.imageButton15);
        buttons[1][7] = (ImageButton)findViewById(R.id.imageButton16);
        buttons[2][0] = (ImageButton)findViewById(R.id.imageButton17);
        buttons[2][1] = (ImageButton)findViewById(R.id.imageButton18);
        buttons[2][2] = (ImageButton)findViewById(R.id.imageButton19);
        buttons[2][3] = (ImageButton)findViewById(R.id.imageButton20);
        buttons[2][4] = (ImageButton)findViewById(R.id.imageButton21);
        buttons[2][5] = (ImageButton)findViewById(R.id.imageButton22);
        buttons[2][6] = (ImageButton)findViewById(R.id.imageButton23);
        buttons[2][7] = (ImageButton)findViewById(R.id.imageButton24);
        buttons[3][0] = (ImageButton)findViewById(R.id.imageButton25);
        buttons[3][1] = (ImageButton)findViewById(R.id.imageButton26);
        buttons[3][2] = (ImageButton)findViewById(R.id.imageButton27);
        buttons[3][3] = (ImageButton)findViewById(R.id.imageButton28);
        buttons[3][4] = (ImageButton)findViewById(R.id.imageButton29);
        buttons[3][5] = (ImageButton)findViewById(R.id.imageButton30);
        buttons[3][6] = (ImageButton)findViewById(R.id.imageButton31);
        buttons[3][7] = (ImageButton)findViewById(R.id.imageButton32);
        buttons[4][0] = (ImageButton)findViewById(R.id.imageButton33);
        buttons[4][1] = (ImageButton)findViewById(R.id.imageButton34);
        buttons[4][2] = (ImageButton)findViewById(R.id.imageButton35);
        buttons[4][3] = (ImageButton)findViewById(R.id.imageButton36);
        buttons[4][4] = (ImageButton)findViewById(R.id.imageButton37);
        buttons[4][5] = (ImageButton)findViewById(R.id.imageButton38);
        buttons[4][6] = (ImageButton)findViewById(R.id.imageButton39);
        buttons[4][7] = (ImageButton)findViewById(R.id.imageButton40);
        buttons[5][0] = (ImageButton)findViewById(R.id.imageButton41);
        buttons[5][1] = (ImageButton)findViewById(R.id.imageButton42);
        buttons[5][2] = (ImageButton)findViewById(R.id.imageButton43);
        buttons[5][3] = (ImageButton)findViewById(R.id.imageButton44);
        buttons[5][4] = (ImageButton)findViewById(R.id.imageButton45);
        buttons[5][5] = (ImageButton)findViewById(R.id.imageButton46);
        buttons[5][6] = (ImageButton)findViewById(R.id.imageButton47);
        buttons[5][7] = (ImageButton)findViewById(R.id.imageButton48);
        buttons[6][0] = (ImageButton)findViewById(R.id.imageButton49);
        buttons[6][1] = (ImageButton)findViewById(R.id.imageButton50);
        buttons[6][2] = (ImageButton)findViewById(R.id.imageButton51);
        buttons[6][3] = (ImageButton)findViewById(R.id.imageButton52);
        buttons[6][4] = (ImageButton)findViewById(R.id.imageButton53);
        buttons[6][5] = (ImageButton)findViewById(R.id.imageButton54);
        buttons[6][6] = (ImageButton)findViewById(R.id.imageButton55);
        buttons[6][7] = (ImageButton)findViewById(R.id.imageButton56);
        buttons[7][0] = (ImageButton)findViewById(R.id.imageButton57);
        buttons[7][1] = (ImageButton)findViewById(R.id.imageButton58);
        buttons[7][2] = (ImageButton)findViewById(R.id.imageButton59);
        buttons[7][3] = (ImageButton)findViewById(R.id.imageButton60);
        buttons[7][4] = (ImageButton)findViewById(R.id.imageButton61);
        buttons[7][5] = (ImageButton)findViewById(R.id.imageButton62);
        buttons[7][6] = (ImageButton)findViewById(R.id.imageButton63);
        buttons[7][7] = (ImageButton)findViewById(R.id.imageButton64);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public static boolean isSafePlace(int col,int Qi) {
        if(Queens[Qi] != col && Queens[Qi] != -1)
            return false;
        if(Queens[Qi] == col) {
            if(preSetQueens[Qi] != col) {
                Queens[Qi] = -1;
            } else {
                return true;
            }
        }

        for(int i = 0; i < 8; i++) {
            if(Queens[i] == -1)
                continue;
            if(Queens[i] == col)
                return false;
            if (Math.abs(Queens[i] - col) == Math.abs(i - Qi)) {
                return false;
            }
        }
        return true;
    }



    public void showPop(String s){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, s, duration);
        toast.show();

    }

    private static boolean isSame(int row, int col) {
        return Queens[row] == col;
    }

    private static void placeQueenOnBoard(int Qi, int[] board) {
        int n = board.length;
        //base case

        if (Qi == n) {// a valid configuration found.
            checktime++;
            if(checktime == 4) {
                System.out.println("check");
            }
            FinalQueens = Queens.clone();
            System.out.println("Queens" + Arrays.toString(FinalQueens));
            boolean flag = true;


            for(int k = 0; k < 100; k++) {
                if(Arrays.equals(FinalSolutionArray[k],FinalQueens) ) {
                    flag = false;
                }
            }
            if(flag) {
                if(solutionIndex < 92) {
                    FinalSolutionArray[solutionIndex] = FinalQueens.clone();
                }
                solutionIndex++;
            }

        } else {
            //try to put the ith Queen (Qi) in all of the columns
            for (int column = 0; column < n; column++) {

                if (isSafePlace(7 - column, Qi)) {
                    //System.out.println("pass");

                    if(preSetQueens[Qi] != (7 - column)) {
                        board[Qi] = 7 - column;
                    }

                  //  System.out.println("row" + Qi + " col" + board[Qi]);
                    //queens++;
                    //then place remaining queens.

                    placeQueenOnBoard(Qi + 1, board);
                    /**
                     * backtracking. It is not required in this as we only look previously
                     * placed queens in isSafePlace method and it doesnot care what values
                     * are available in next positions.*
                     */
                    if(preSetQueens[Qi] != (7 - column)) {
                        board[Qi] = -1;
                    }



                    //queens--;
                }
            }

        }
    }



    public void clear(View view) {
        queens = 0;
        queens2 = 0;
        lastrow = 0;
        for(int k = 0 ; k < 8; k++) {
            Queens[k] = -1;
            preSetQueens[k] = -1;
        }

        for(int k = 0 ; k < 8; k++)
            FinalQueens[k] = -1;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if((i % 2 == 0) && (j % 2 == 0)) {
                    buttonImg[i][j] = 1;
                    buttons[i][j].setBackgroundResource(R.drawable.pink);
                } else if ((i % 2 == 0) && (j % 2 != 0)) {
                    buttonImg[i][j] = 3;
                    buttons[i][j].setBackgroundResource(R.drawable.brown);
                } else if ((i % 2 != 0) && (j % 2 == 0)) {
                    buttonImg[i][j] = 3;
                    buttons[i][j].setBackgroundResource(R.drawable.brown);
                } else {
                    buttonImg[i][j] = 1;
                    buttons[i][j].setBackgroundResource(R.drawable.pink);
                }
            }
        }




    }
    public void onClick(final View view) {
        myTextBox = (EditText) findViewById(R.id.editText);
        myTextBox.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {



            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(myTextBox.getText().toString().equals("")) return;
                clear(view);
                if(!TextUtils.isDigitsOnly(myTextBox.getText())) return;

                int num = Integer.parseInt(myTextBox.getText().toString());
                System.out.println(num);
                int count3 = 0;
                for(int i = 0; i < solArr.length; i++) {
                    for(int j = 0; j < solArr[i].length;j++) {
                        if(solArr[i][j] == -1) {
                            count3++;
                            break;
                        }
                    }
                }
                if(num < 0 || num > (solArr.length - count3)) return;
                FinalQueens = solArr[num].clone();


                for(int i = 0; i < 8; i++) {
                    if(buttonImg[i][FinalQueens[i]] == 1) {
                        buttons[i][FinalQueens[i]].setBackgroundResource(R.drawable.pinkchess);
                        buttonImg[i][FinalQueens[i]] = 2;
                    }

                    if(buttonImg[i][FinalQueens[i]] ==
                            3) {
                        buttons[i][FinalQueens[i]].setBackgroundResource(R.drawable.brownchess);
                        buttonImg[i][FinalQueens[i]] = 4;
                    }
                }

                textView2.setText("Solution " + myTextBox.getText().toString());
                if(myTextBox.getText().toString().length() >= 2) {

                    myTextBox.setText("");
                }

            }
        });
        if(view.getId() == R.id.button3) {
            clear(view);
            int Qi = 0;
            for(int j = 0; j < 8;j++) {
                for (int i = 0; i < 8; i++) {
                    clear(view);
                    Queens[j] = i;
                    preSetQueens[j] = i;
                    placeQueenOnBoard(0, Queens);
                }
            }
            int count = 0;
            for(int h = 0 ; h < 100; h++) {
                boolean flag2 = true;
                for(int o = 0 ; o < FinalSolutionArray[h].length; o++) {
                    if(FinalSolutionArray[h][o] == -1) {
                        flag2 = false;
                    }
                }
                if(flag2) {
                    count++;
                }
                System.out.println(Arrays.toString(FinalSolutionArray[h]));

            }

            System.out.println(count);
            Button butt = (Button) findViewById(R.id.button3);
            butt.setEnabled(false);
            return;
        }
        if(view.getId() == R.id.button2) {
            clear(view);
            return;
        }

        if(view.getId() == R.id.button) {
            placeQueenOnBoard(lastrow,Queens);
            for(int j = 0;j < 8;j++) {
                System.out.println("+" + FinalQueens[j] +"+");
            }
            for(int i = 0; i < 8; i++) {
                if(FinalQueens[i] != -1) {
                    queens2++;
                }
            }
           int count2 = 0;
            int index = 0;
            solArr = new int[100][8];
            boolean flag = true;
            //for(int ele = 0; ele < 8; ele++) {
                for(int kl = 0; kl < FinalSolutionArray.length;kl++) {
                    for(int ele = 0; ele < 8; ele++) {
                        if (preSetQueens[ele] != -1) {
                            if (FinalSolutionArray[kl][ele] != preSetQueens[ele]) {
                                flag = false;
                            }
                        }
                    }
                    if(flag) {
                        count2++;
                        solArr[index] = FinalSolutionArray[kl].clone();
                        index++;
                    }
                    flag = true;
                }


           if(queens2 == 8 && count2 != 0) {
                showPop(count2 + " solutions");
                textView2 = (TextView) findViewById(R.id.textView2);
                textView2.setText(count2 + " solutions");

               for(int i = 0; i < 8; i++) {
                   if(buttonImg[i][FinalQueens[i]] == 1) {
                       buttons[i][FinalQueens[i]].setBackgroundResource(R.drawable.pinkchess);
                       buttonImg[i][FinalQueens[i]] = 2;
                   }
                   if(buttonImg[i][FinalQueens[i]] == 3) {
                       buttons[i][FinalQueens[i]].setBackgroundResource(R.drawable.brownchess);
                       buttonImg[i][FinalQueens[i]] = 4;
                   }
               }
           } else {
                showPop("No solution");
           }
            return;
        }
        ImageButton imgbutton  = (ImageButton) findViewById(view.getId());
        int position = Integer.parseInt(imgbutton.getTag().toString());
        int row = (position - 1) / 8;
        int col = (position - 1) % 8 ;
        for(int i = 0 ; i < 8; i++) {
            if(Queens[i] == -1) {
                lastrow = i;
                break;
            }
        }


        System.out.println("row: " + row + " column: " + col);

        if(isSafePlace(col,row)) {
            Queens[row] = col;
            queenButtons[row][col] = 1;
            preSetQueens[row] = col;
            queens++;
            if(queens == 8)
                showPop("You won!");
            if(buttonImg[row][col] == 1) {
                imgbutton.setBackgroundResource(R.drawable.pinkchess);
                buttonImg[row][col] = 2;
            } else if (buttonImg[row][col] == 2) {
                imgbutton.setBackgroundResource(R.drawable.pink);
                buttonImg[row][col] = 1;
            } else if (buttonImg[row][col] == 3) {
                imgbutton.setBackgroundResource(R.drawable.brownchess);
                buttonImg[row][col] = 4;
            }else  {
                imgbutton.setBackgroundResource(R.drawable.brown);
                buttonImg[row][col] = 3;
            }
        } else if(Queens[row] == col) {
            if (buttonImg[row][col] == 1) {
                imgbutton.setBackgroundResource(R.drawable.pinkchess);
                buttonImg[row][col] = 2;
            } else if (buttonImg[row][col] == 2) {
                imgbutton.setBackgroundResource(R.drawable.pink);
                buttonImg[row][col] = 1;
            } else if (buttonImg[row][col] == 3) {
                imgbutton.setBackgroundResource(R.drawable.brownchess);
                buttonImg[row][col] = 4;
            } else {
                imgbutton.setBackgroundResource(R.drawable.brown);
                buttonImg[row][col] = 3;
            }
            queens--;
            Queens[row] = -1;
            lives--;

            if(lives > 0) {
                showPop("You lost a life! " +lives + " left!");
            } else {

            }
        } else {
            lives--;
            if(lives > 0) {
                showPop("You lost a life! " +lives + " left!");
            } else {

            }
        }

    }
}

