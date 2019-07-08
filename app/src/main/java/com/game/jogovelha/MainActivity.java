package com.game.jogovelha;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int turn; //0 - X | 1 - O
    private int[][] positions = new int [3][3];
    private int value1, value2, value3;

    private void cleanPositions() {
        turn = 0;

        positions[0][0] = 2;
        positions[0][1] = 2;
        positions[0][2] = 2;
        positions[1][0] = 2;
        positions[1][1] = 2;
        positions[1][2] = 2;
        positions[2][0] = 2;
        positions[2][1] = 2;
        positions[2][2] = 2;
    }

    public MainActivity() {
        cleanPositions();
    }

    private void markButton(int buttonNumber) {
        setPosition(buttonNumber);
        changeTurn();
    }

    private void setPosition(int buttonNumber) {
        int x, y, value;
        value = getValuePlay();
        x = getX(buttonNumber);
        y = getY(buttonNumber);
        positions[x][y] = value;
    }

    private int getX(int buttonNumber) {
        switch (buttonNumber) {
            case 1:
                return 0;
            case 2:
                return 0;
            case 3:
                return 0;
            case 4:
                return 1;
            case 5:
                return 1;
            case 6:
                return 1;
            case 7:
                return 2;
            case 8:
                return 2;
            case 9:
                return 2;
        }
        return 0;
    }

    private int getY(int buttonNumber) {
        switch (buttonNumber) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 0;
            case 5:
                return 1;
            case 6:
                return 2;
            case 7:
                return 0;
            case 8:
                return 1;
            case 9:
                return 2;
        }
        return 0;
    }


    private int getValuePlay() {
        return turn;
    }

    private String getTextPlay() {
        if (turn == 0) {
            return "X";
        }

        return "O";
    }

    private void changeTurn() {
        if (turn == 0) {
            turn = 1;
        } else {
            turn = 0;
        }
    }

    private void getCombination(int numberCombination) {


        switch (numberCombination) {
            case 0:
                value1 = 3;
                value2 = 3;
                value3 = 3;

                for (int i=0; i < 3; i++) {
                    for (int j=0; j < 3; j++) {
                        if (positions[i][j] == 2) {
                            value1 = 0;
                            value2 = 0;
                            value3 = 0;
                            break;
                        }
                    }
                    if (value1 == 0) {
                        break;
                    }
                }
                break;
            case 1:
                value1 = positions[0][0];
                value2 = positions[0][1];
                value3 = positions[0][2];
                break;
            case 2:
                value1 = positions[1][0];
                value2 = positions[1][1];
                value3 = positions[1][2];
                break;
            case 3:
                value1 = positions[2][0];
                value2 = positions[2][1];
                value3 = positions[2][2];
                break;
            case 4:
                value1 = positions[0][0];
                value2 = positions[1][0];
                value3 = positions[2][0];
                break;
            case 5:
                value1 = positions[0][1];
                value2 = positions[1][1];
                value3 = positions[2][1];
                break;
            case 6:
                value1 = positions[0][2];
                value2 = positions[1][2];
                value3 = positions[2][2];
                break;
            case 7:
                value1 = positions[0][0];
                value2 = positions[1][1];
                value3 = positions[2][2];
                break;
            case 8:
                value1 = positions[0][2];
                value2 = positions[1][1];
                value3 = positions[2][0];
                break;
        }
    }


    private int checkEndGame() {

        value1 = 0;
        value2 = 0;
        value3 = 0;

        getCombination(0);

        if (value1 == 3) {
            blockButtons(0);
            return 10;
        }

        value1 = 0;
        value2 = 0;
        value3 = 0;

        for (int i=1; i<=8; i++) {
            getCombination(i);
            if (value1 != 2 || value2 != 2 || value3 != 2) {
                if (value1 == value2 && value2 == value3) {
                    blockButtons(i);
                    return i;
                }
            }
        }

        return 0;
    }

    private void blockButtons(int numberCombination) {
        final Button newGame        = (Button) findViewById(R.id.newGame);
        final Button positionOne    = (Button) findViewById(R.id.positionOne);
        final Button positionTwo    = (Button) findViewById(R.id.positionTwo);
        final Button positionTree   = (Button) findViewById(R.id.positionTree);
        final Button positionFour   = (Button) findViewById(R.id.positionFour);
        final Button positionFive   = (Button) findViewById(R.id.positionFive);
        final Button positionSix    = (Button) findViewById(R.id.positionSix);
        final Button positionSeven  = (Button) findViewById(R.id.positionSeven);
        final Button positionEight  = (Button) findViewById(R.id.positionEight);
        final Button positionNine   = (Button) findViewById(R.id.positionNine);

        switch (numberCombination) {
            case 0:
                positionOne.setTextColor(Color.BLUE);
                positionTwo.setTextColor(Color.BLUE);
                positionTree.setTextColor(Color.BLUE);
                positionFour.setTextColor(Color.BLUE);
                positionFive.setTextColor(Color.BLUE);
                positionSix.setTextColor(Color.BLUE);
                positionSeven.setTextColor(Color.BLUE);
                positionEight.setTextColor(Color.BLUE);
                positionNine.setTextColor(Color.BLUE);
                break;

            case 1:
                positionOne.setTextColor(Color.RED);
                positionTwo.setTextColor(Color.RED);
                positionTree.setTextColor(Color.RED);
                break;
            case 2:
                positionFour.setTextColor(Color.RED);
                positionFive.setTextColor(Color.RED);
                positionSix.setTextColor(Color.RED);
                break;
            case 3:
                positionSeven.setTextColor(Color.RED);
                positionEight.setTextColor(Color.RED);
                positionNine.setTextColor(Color.RED);
                break;
            case 4:
                positionOne.setTextColor(Color.RED);
                positionFour.setTextColor(Color.RED);
                positionSeven.setTextColor(Color.RED);
                break;
            case 5:
                positionTwo.setTextColor(Color.RED);
                positionFive.setTextColor(Color.RED);
                positionEight.setTextColor(Color.RED);
                break;
            case 6:
                positionTree.setTextColor(Color.RED);
                positionSix.setTextColor(Color.RED);
                positionNine.setTextColor(Color.RED);
                break;
            case 7:
                positionOne.setTextColor(Color.RED);
                positionFive.setTextColor(Color.RED);
                positionNine.setTextColor(Color.RED);
                break;
            case 8:
                positionTree.setTextColor(Color.RED);
                positionFive.setTextColor(Color.RED);
                positionSeven.setTextColor(Color.RED);
                break;
        }

        positionOne.setEnabled(false);
        positionTwo.setEnabled(false);
        positionTree.setEnabled(false);
        positionFour.setEnabled(false);
        positionFive.setEnabled(false);
        positionSix.setEnabled(false);
        positionSeven.setEnabled(false);
        positionEight.setEnabled(false);
        positionNine.setEnabled(false);

        cleanPositions();

        newGame.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button newGame        = (Button) findViewById(R.id.newGame);
        final Button positionOne    = (Button) findViewById(R.id.positionOne);
        final Button positionTwo    = (Button) findViewById(R.id.positionTwo);
        final Button positionTree   = (Button) findViewById(R.id.positionTree);
        final Button positionFour   = (Button) findViewById(R.id.positionFour);
        final Button positionFive   = (Button) findViewById(R.id.positionFive);
        final Button positionSix    = (Button) findViewById(R.id.positionSix);
        final Button positionSeven  = (Button) findViewById(R.id.positionSeven);
        final Button positionEight  = (Button) findViewById(R.id.positionEight);
        final Button positionNine   = (Button) findViewById(R.id.positionNine);
        final TextView txtEndGame   = (TextView) findViewById(R.id.txtEndGame);

        positionOne.setEnabled(false);
        positionTwo.setEnabled(false);
        positionTree.setEnabled(false);
        positionFour.setEnabled(false);
        positionFive.setEnabled(false);
        positionSix.setEnabled(false);
        positionSeven.setEnabled(false);
        positionEight.setEnabled(false);
        positionNine.setEnabled(false);

        positionOne.setVisibility(View.INVISIBLE);
        positionTwo.setVisibility(View.INVISIBLE);
        positionTree.setVisibility(View.INVISIBLE);
        positionFour.setVisibility(View.INVISIBLE);
        positionFive.setVisibility(View.INVISIBLE);
        positionSix.setVisibility(View.INVISIBLE);
        positionSeven.setVisibility(View.INVISIBLE);
        positionEight.setVisibility(View.INVISIBLE);
        positionNine.setVisibility(View.INVISIBLE);

        newGame.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                positionOne.setText("");
                positionTwo.setText("");
                positionTree.setText("");
                positionFour.setText("");
                positionFive.setText("");
                positionSix.setText("");
                positionSeven.setText("");
                positionEight.setText("");
                positionNine.setText("");

                positionOne.setEnabled(true);
                positionTwo.setEnabled(true);
                positionTree.setEnabled(true);
                positionFour.setEnabled(true);
                positionFive.setEnabled(true);
                positionSix.setEnabled(true);
                positionSeven.setEnabled(true);
                positionEight.setEnabled(true);
                positionNine.setEnabled(true);

                positionOne.setVisibility(View.VISIBLE);
                positionTwo.setVisibility(View.VISIBLE);
                positionTree.setVisibility(View.VISIBLE);
                positionFour.setVisibility(View.VISIBLE);
                positionFive.setVisibility(View.VISIBLE);
                positionSix.setVisibility(View.VISIBLE);
                positionSeven.setVisibility(View.VISIBLE);
                positionEight.setVisibility(View.VISIBLE);
                positionNine.setVisibility(View.VISIBLE);

                positionOne.setTextColor(Color.BLACK);
                positionTwo.setTextColor(Color.BLACK);
                positionTree.setTextColor(Color.BLACK);
                positionFour.setTextColor(Color.BLACK);
                positionFive.setTextColor(Color.BLACK);
                positionSix.setTextColor(Color.BLACK);
                positionSeven.setTextColor(Color.BLACK);
                positionEight.setTextColor(Color.BLACK);
                positionNine.setTextColor(Color.BLACK);

                newGame.setVisibility(View.INVISIBLE);
                txtEndGame.setText("");
            }
        });

        positionOne.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (positionOne.getText().toString().isEmpty()) {
                    positionOne.setText(getTextPlay());
                    markButton(1);
                    int endGame;
                    endGame = checkEndGame();

                    if (endGame > 0) {
                        if (endGame == 10) {
                            txtEndGame.setText("DEU VELHA");
                        } else {
                            txtEndGame.setText("FIM DE JOGO");
                        }
                    }
                }
            }
        });

        positionTwo.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (positionTwo.getText().toString().isEmpty()) {
                    positionTwo.setText(getTextPlay());
                    markButton(2);
                    int endGame;
                    endGame = checkEndGame();

                    if (endGame > 0) {
                        if (endGame == 10) {
                            txtEndGame.setText("DEU VELHA");
                        } else {
                            txtEndGame.setText("FIM DE JOGO");
                        }
                    }
                }
            }
        });

        positionTree.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (positionTree.getText().toString().isEmpty()) {
                    positionTree.setText(getTextPlay());
                    markButton(3);
                    int endGame;
                    endGame = checkEndGame();

                    if (endGame > 0) {
                        if (endGame == 10) {
                            txtEndGame.setText("DEU VELHA");
                        } else {
                            txtEndGame.setText("FIM DE JOGO");
                        }
                    }
                }
            }
        });

        positionFour.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (positionFour.getText().toString().isEmpty()) {
                    positionFour.setText(getTextPlay());
                    markButton(4);
                    int endGame;
                    endGame = checkEndGame();

                    if (endGame > 0) {
                        if (endGame == 10) {
                            txtEndGame.setText("DEU VELHA");
                        } else {
                            txtEndGame.setText("FIM DE JOGO");
                        }
                    }
                }
            }
        });

        positionFive.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (positionFive.getText().toString().isEmpty()) {
                    positionFive.setText(getTextPlay());
                    markButton(5);
                    int endGame;
                    endGame = checkEndGame();

                    if (endGame > 0) {
                        if (endGame == 10) {
                            txtEndGame.setText("DEU VELHA");
                        } else {
                            txtEndGame.setText("FIM DE JOGO");
                        }
                    }
                }
            }
        });

        positionSix.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (positionSix.getText().toString().isEmpty()) {
                    positionSix.setText(getTextPlay());
                    markButton(6);
                    int endGame;
                    endGame = checkEndGame();

                    if (endGame > 0) {
                        if (endGame == 10) {
                            txtEndGame.setText("DEU VELHA");
                        } else {
                            txtEndGame.setText("FIM DE JOGO");
                        }
                    }
                }
            }
        });

        positionSeven.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (positionSeven.getText().toString().isEmpty()) {
                    positionSeven.setText(getTextPlay());
                    markButton(7);
                    int endGame;
                    endGame = checkEndGame();

                    if (endGame > 0) {
                        if (endGame == 10) {
                            txtEndGame.setText("DEU VELHA");
                        } else {
                            txtEndGame.setText("FIM DE JOGO");
                        }
                    }
                }
            }
        });

        positionEight.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (positionEight.getText().toString().isEmpty()) {
                    positionEight.setText(getTextPlay());
                    markButton(8);
                    int endGame;
                    endGame = checkEndGame();

                    if (endGame > 0) {
                        if (endGame == 10) {
                            txtEndGame.setText("DEU VELHA");
                        } else {
                            txtEndGame.setText("FIM DE JOGO");
                        }
                    }
                }
            }
        });

        positionNine.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (positionNine.getText().toString().isEmpty()) {
                    positionNine.setText(getTextPlay());
                    markButton(9);
                    int endGame;
                    endGame = checkEndGame();

                    if (endGame > 0) {
                        if (endGame == 10) {
                            txtEndGame.setText("DEU VELHA");
                        } else {
                            txtEndGame.setText("FIM DE JOGO");
                        }
                    }
                }
            }
        });

    }
}
